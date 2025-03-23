// Time Complexity :O(N)
// Space Complexity : (N)
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;

        Stack<Integer> st = new Stack<>();
        for(String token : tokens){
            
            switch(token){
                case "+":
                st.push(st.pop() + st.pop());
                break;

                case "-":
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
                break;

                case "*":
                st.push(st.pop() * st.pop());
                break;

                case "/":
                 a = st.pop();
                 b = st.pop();
                st.push(b/a);
                break;

                default:
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
        
    }
}
