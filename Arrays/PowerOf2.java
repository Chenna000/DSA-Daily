class Solution {
    public boolean isPowerOfTwo(int n) {
        // int r = (int)(Math.log10(n)/Math.log10(2))%2;
        // double s = (double)(Math.log10(n)/Math.log10(2))%2;
        // if(r==s){
        //     return true;
        // }
        
        // return false;
        if(n==0 || n==Integer.MIN_VALUE)return false;
        
        // return true;
        int s= n&(n-1);
        if(s!=0){
            return false;
        }
        return true;
    }
}
