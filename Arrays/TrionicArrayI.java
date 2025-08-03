class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n<4){
            return false;
        }
        boolean [] left_inc = new boolean[n];
        
        boolean[] right_inc = new boolean[n];

        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                // left_inc[i]=true;
                 left_inc[i] = left_inc[i - 1] || i == 1;
            }            
        }
        // for(boolean b:left_inc){
        //     System.out.print(b+"\t");
        // }
        //         System.out.println();

        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                right_inc[i] = right_inc[i + 1] || i == n - 2;
                // right_inc[i-1]=true;
            }
        }
        //  for(boolean b:right_inc){
        //     System.out.print(b+"\t");
        // }

            for(int p=1;p<n-2;p++){
                if(!left_inc[p])continue;

                int q=p+1;

                while(q<n-1 && nums[q]<nums[q-1]){
                    if(right_inc[q]){
                        return true;
                    }
                    q++;
                }
            }
        return false;
        // return true;
        
    }
}
