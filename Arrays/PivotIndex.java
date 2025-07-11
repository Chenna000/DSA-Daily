public class PivotIndex{
    public static void main(String[] args) {
        int [] nums ={1,7,3,6,5,6};
        int [] prefixSum =new int[nums.length];
        int [] rightSum = new int[nums.length];
        prefixSum[0]=nums[0];
        rightSum[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            rightSum[i]+= rightSum[i+1]+nums[i];
        }
        for(int i:prefixSum){
            System.out.print(i+"\t");
        }
        System.out.println();
        for(int i:rightSum){
            System.out.print(i+"\t");
        }
        for(int i=0;i<nums.length;i++){
            if(prefixSum[i]==rightSum[i]){
                System.out.print("pivot is:"+i);
                return;
            }
        }
    }
}