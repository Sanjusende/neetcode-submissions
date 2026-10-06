class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        // Har token ko one-by-one check karo
        for (String token : tokens) {

            // Agar token number hai
            if (!token.equals("+") &&
                !token.equals("-") &&
                !token.equals("*") &&
                !token.equals("/")) {

                // String number ko int me convert karke push karo
                stack.push(Integer.parseInt(token));
            }

            // Agar token operator hai
            else {

                // Pehla number = right operand
                int a = stack.pop();

                // Doosra number = left operand
                int b = stack.pop();

                int result = 0;

                if (token.equals("+")) {
                    result = b + a;
                }

                else if (token.equals("-")) {
                    result = b - a;
                }

                else if (token.equals("*")) {
                    result = b * a;
                }

                else if (token.equals("/")) {
                    result = b / a;
                }

                // Result ko wapas Stack me daalo
                stack.push(result);
            }
        }

        // Final answer Stack ke top par hoga
        return stack.pop();
    }
}