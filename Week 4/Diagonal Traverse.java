class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return new int[0];
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int[] ans = new int[r*c];
        
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> set = new HashSet();
        q.add(0);
        set.add(0);
        ans[0] = matrix[0][0];
        int z = 1;
        boolean left = false;
        int[][] cart = {{1, 0}, {0, 1}};
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> sub = new ArrayList();
            for(int i = 0; i < size; i++)
            {
                int x = q.poll();
                int r1 = x/c;
                int c1 = x%c;
                for(int[] o: cart)
                {
                    if(r1+o[0] < r && c1+o[1] < c && !set.contains((r1+o[0])*c+(c1+o[1])))
                    {
                        q.add((r1+o[0])*c+(c1+o[1]));
                        set.add((r1+o[0])*c+(c1+o[1]));
                        sub.add(matrix[r1+o[0]][c1+o[1]]);
                    }
                }
            }
            if(left)
            {
                for(int w = 0; w < sub.size(); w++)
                {
                    ans[z++] = sub.get(w);
                }
            }
            else
            {
                for(int w = sub.size()-1; w >= 0; w--)
                {
                    ans[z++] = sub.get(w);
                }
            }
            left = !left;
        }
        
        return ans;
    }
}