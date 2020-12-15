class Solution {
    
    private boolean isPalindrome(int start, int end)
    {
        for(int i = 0; i < ((end-start+1)/2); i++)
        {
            if(s.charAt(start + i) != s.charAt(end-i))
                return false;
        }
        return true;
    }
    
    List<List<String>> ans;
    String s;
    
    private void dfs(List<String> curr, int start)
    {
        if(start >= s.length())
        {
            ans.add(new ArrayList<String>(curr));
            return;
        }
        
        for(int i = start; i < s.length(); i++)
        {
            if(isPalindrome(start, i))
            {
                curr.add(s.substring(start, i+1));
                dfs(curr, i+1);
                curr.remove(curr.size()-1);
            }
        }
        
    }
    
    public List<List<String>> partition(String s) {
        
        ans = new ArrayList<List<String>>();
        
        if(s == null || s.length() < 1)
            return ans;
        
        this.s = s;
        
        dfs(new ArrayList<String>(), 0);
        
        return ans;
    }
}