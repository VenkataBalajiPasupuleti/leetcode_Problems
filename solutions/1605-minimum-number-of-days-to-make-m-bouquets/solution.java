class Solution {
    public static boolean isPossible(int[] bloomDay,int day,int m,int k){
        int count=0;
        int bouquets=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                count++;
                if(count==k){
                    bouquets++;
                    count=0;
                }
            }else{
                count=0;
            }
        }
        return bouquets>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int required=bloomDay.length;
        if(required<m*k) return -1;
        int minDay=Integer.MAX_VALUE;
        int maxDay=Integer.MIN_VALUE;
        for(int bloom:bloomDay){
            minDay=Math.min(minDay,bloom);
            maxDay=Math.max(maxDay,bloom);
        }

        int low=minDay,high=maxDay;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(bloomDay, mid, m, k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
