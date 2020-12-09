class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap();
        int ans = 0;
        for(int i = 0; i < time.length; i++)
        {
            //get complement count
            ans += map.getOrDefault((60-(time[i]%60))% 60, 0);
            
            //update the hashMap
            map.put(time[i] % 60, map.getOrDefault(time[i]%60, 0)+1);
        }
        //another method commented below
//         //int ans = 0;
//         for(int key: map.keySet())
//         {            
//             int val = map.get(key);
//             //System.out.println("start --> " + key + " " + val);
//             if(key == 0 || key == 30)
//             {
//                 ans += (val*(val-1))/2;
//                 //System.out.println(key + " " + val + " " + ans);
//             }
//             else if(key < 30)
//             {
//                 int comp = map.getOrDefault((60-key)%60, 0);
//                 ans += (val * comp);
//                 //System.out.println(key + " " + val + " " + ans + " " + comp);
//             }
            
//         }
        return ans;
    }
}