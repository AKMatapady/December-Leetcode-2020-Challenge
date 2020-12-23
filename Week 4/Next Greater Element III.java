class Solution {
    public int nextGreaterElement(int n) {
        
        //assuming n is a positive number
        if( n < 12)
            return -1;
        
        String rep = String.valueOf(n);
        int len = rep.length();
        StringBuilder sb = new StringBuilder(rep);
        
        //Integer[] arr = new Integer[len];
        
        int pre = Integer.valueOf(sb.charAt(len-1)+"");
        int i = len-2;
        for(; i >= 0; i--)
        {
            int curr = Integer.valueOf(sb.charAt(i)+"");
            if(curr < pre)
                break;
            pre = curr;
        }
        
        if(i < 0)
            return -1;
        
        int j = -1, min = Integer.MAX_VALUE;
        pre = Integer.valueOf(sb.charAt(i)+"");
        for(int k = i+1; k < len; k++)
        {
            int curr = Integer.valueOf(sb.charAt(k)+"");
            if(curr <= min && curr > pre)
            {
                min = curr;
                j = k;
            }
        }
        
        //System.out.println(i + " " + j);
        
        char ch = sb.charAt(j);
        sb.replace(j, j+1, sb.charAt(i)+"");
        sb.replace(i, i+1, ch+"");
        //long x = Long.valueOf(sb.toString());
        String sub = sb.substring(i+1);
        
        //System.out.println(sb.toString() + " " + sub);
        
        StringBuilder sub2 = new StringBuilder(sub);
        sb.replace(i+1, len, sub2.reverse().toString());
        long x = Long.valueOf(sb.toString());
        // if(x2 < x)
        //     x = x2;
        int ans = (int)x;
        if(ans < x)
            return -1;
        return ans;
    }
}