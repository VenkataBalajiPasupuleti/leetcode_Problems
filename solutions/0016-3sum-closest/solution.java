class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;

        long closestSum = (long) nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                long sum = (long) nums[i] + nums[left] + nums[right];

                if (Math.abs((long) target - sum) <
                    Math.abs((long) target - closestSum)) {

                    closestSum = sum;
                }

                if (sum == target) {
                    return target;
                }
                else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return (int) closestSum;
    }
}
