class Solution {
    public int longestPalindrome(String s) {
        int[] count=new int[128];
        for(char ch:s.toCharArray()){
            count[ch]++;
        }
        int length=0;
        boolean hasOdd=false;
        for(int frequency:count){
            length+=(frequency/2)*2;
            if(frequency%2==1){
                hasOdd=true;
            }
        }

        if(hasOdd){
            length+=1;
        }
        return length;

    }
}
