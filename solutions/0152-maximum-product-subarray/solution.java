class Solution {
    public int maxProduct(int[] nums) {
        int currentMax=nums[0];
        int maxProduct=nums[0];
        int currentMin=nums[0];
        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            if(num<0){
                int temp=currentMin;
                currentMin=currentMax;
                currentMax=temp;
            }
            currentMax=Math.max(num,num*currentMax);
            currentMin=Math.min(num,num*currentMin);
            maxProduct=Math.max(currentMax,maxProduct);
        }
        return maxProduct;
    }
}
