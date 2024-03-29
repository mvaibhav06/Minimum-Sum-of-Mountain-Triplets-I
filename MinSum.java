public class MinSum {
    public static int minimumSum(int[] nums) {
        int sum = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]<nums[j] && nums[j]>nums[k]){
                        int a = nums[i]+nums[j]+nums[k];
                        if(a < sum){
                            sum = a;
                        }
                    }
                }
            }
        }
        return sum==Integer.MAX_VALUE ? -1:sum;
    }

    public static int minimumSum1(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int ai = i;
        int bj = j;
        int a = nums[i++];
        int b = nums[j--];

        while(i < j){
            if(nums[i]<a){
                a = nums[i];
                ai = i;
            }
            i++;
        }
        while(i < j){
            if(nums[j]<b){
                b = nums[j];
                bj = j;
            }
            j--;
        }
        int c = Integer.MAX_VALUE;
        for(int k=ai+1; k<bj; k++){
            if(nums[k]<c){
                c = nums[k];
            }
        }
        return c==Integer.MAX_VALUE ? -1:a+b+c;
    }

    public static void main(String[] args) {
        int[] nums = {6,5,4,3,4,5};
        System.out.println(minimumSum1(nums));
    }
}
