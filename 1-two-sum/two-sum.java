class Solution {
    public int[] twoSum(int[] nums, int target) {
        //duplicate array to maintain original index
        int aux[]=Arrays.copyOf(nums,nums.length);//array elements are copying one by one in aux array
        //int[]aux =nums;//copy of address
        Arrays.sort(nums);//N logN
        int left=0;
        int right=nums.length-1;
        int firstValue=-1;
        int secondValue=-1;
        while(left<=right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                firstValue=nums[left];
                secondValue=nums[right];
                break;

            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }

        }
        int firstIndex=-1;
        int secondIndex=-1;
        for(int i=0;i<aux.length;i++){
            if(firstIndex==-1 && aux[i]==firstValue){
                firstIndex=i;
            }
            else if(secondIndex==-1 && aux[i]==secondValue){
                secondIndex=i;
            }
        }
        return new int[] {firstIndex,secondIndex};
    }
}