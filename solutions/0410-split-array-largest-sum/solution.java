class Solution {
    public int countSubArraySum(int[] nums,int maxSum){
        int partitions=1;
        int subArraySum=0;
        for(int num:nums){
            if(subArraySum+num<=maxSum){
                subArraySum+=num;
            }else{
                partitions++;
                subArraySum=num;
            }
        }
        return partitions;
    }
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).max().getAsInt();
        int high=Arrays.stream(nums).sum();
        while(low<=high){
            int mid=(low+high)/2;
            int largestSubArraySum=countSubArraySum(nums,mid);
            if(largestSubArraySum>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
