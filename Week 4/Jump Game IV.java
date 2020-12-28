class Solution {
    
    public int minJumps(int[] arr) {
        if(arr == null || arr.length < 2)
            return 0;
        if(arr.length == 2)
            return 1;        
        if(arr[0] == arr[arr.length-1])
            return 1;
        
        //integer -> all nodes with this integer
        HashMap<Integer, List<Integer>> map = new HashMap();
        
        for(int i = 0; i < arr.length; i++)
        {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<Integer>());
            list.add(i);
            map.put(arr[i], list);
            //map.computeIfAbsent(arr[i], x -> new LinkedList<Integer>()).add(i);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        int ans = 0;
        Set<Integer> done = new HashSet();
        done.add(0);
        while(!q.isEmpty())
        {
            int size = q.size();
            ans++;
            for(int i = 0; i < size; i++)
            {
                int node = q.poll();
                List<Integer> neigh = map.getOrDefault(arr[node], new ArrayList<Integer>());
                for(int n: neigh)
                {
                    if(!done.contains(n))
                    {
                        if(n == arr.length-1)
                            return ans;
                        // if(n.val == arr[arr.length-1])
                        //     return ans+1;
                        done.add(n);
                        q.add(n);
                    }
                }
                
                //was getting TLE without the below statement
                map.get(arr[node]).clear();
                
                if(node > 0 && !done.contains(node-1))
                {
                    int n = (node-1);
                    if(n == arr.length-1)
                        return ans;
                    done.add(n);
                    q.add(n);
                }
                if(node < arr.length-1 && !done.contains(node+1))
                {
                    int n = (node+1);
                    if(n == arr.length-1)
                        return ans;
                    done.add(n);
                    q.add(n);
                }
            }
        }
        return -1;
    }
}