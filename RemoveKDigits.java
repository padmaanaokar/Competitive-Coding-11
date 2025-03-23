// Time Complexity :O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(k==0) return num;
        if(n==k || n<k) return "0";
        
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            if(st.isEmpty()){
                st.push(c);
                continue;
            }

            if(!st.isEmpty() && k > 0 && st.peek() > c ){
                while(!st.isEmpty() && st.peek() > c && k > 0 ){
                    st.pop();
                    k--;
                }
            }
            
            st.push(c);
            
        }

        for(int i=0;i<k;i++){ // edge case if k is not used
            st.pop();
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

       while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);

        return sb.toString();
        
    }
}

//0200
