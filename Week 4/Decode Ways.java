class Solution {   
    
    public int numDecodings(String s) {
        int ans = 0;
        
        if(s == null || s.length() < 0)
            return ans;
        
        int j = 0;
        
        while(j < s.length() && s.charAt(j) == '0')
            j++;
        if(j > 0)
            return ans;
        
        char prev = s.charAt(s.length()-1);
        if(prev > '0')
            ans = 1;
        int curr = ans, pre = 1;
        for(int i = s.length()-2; i >= 0; i--)
        {
            if(s.charAt(i) > '0')
            {
                ans = curr;
                if(s.charAt(i) == '1' || (s.charAt(i) == '2' && prev < '7'))
                {
                    ans += pre;
                }
                pre = curr;
                curr = ans;
            }
            else
            {
                if(prev == '0')
                    return 0;
                pre = curr;
                curr = 0;
            }
            
            
            prev = s.charAt(i);
        }
        
        return ans;
    }
}