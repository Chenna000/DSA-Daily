class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        // int r = (int)(Math.log10(n)/Math.log10(4))%4;
        // double s = (Math.log10(n)/Math.log10(4))%4;
        // return r==s?true:false;

        // bu recursion
        return n%4==0 && isPowerOfFour(n/4);
    }
}
