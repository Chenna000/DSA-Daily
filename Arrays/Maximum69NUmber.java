class Solution {
    public int maximum69Number(int num) {

        String n = Integer.toString(num);
        int idx = n.indexOf('6');
        if (idx != -1) {
            char[] ch = n.toCharArray();
            ch[idx] = '9';
            return Integer.parseInt(new String(ch));
        } else {
            return num;
        }

    }
}
