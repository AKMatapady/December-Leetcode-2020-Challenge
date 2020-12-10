class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr == null || arr.length < 3)
            return false;
        
        //only decreasing
        if(arr[1] <= arr[0])
            return false;
        
        boolean peak = false;
        
        for(int i = 2; i < arr.length; i++)
        {
            if(!peak)
            {
                if(arr[i] == arr[i-1])
                    return false;
                if(arr[i] < arr[i-1])
                    peak = true;
            }
            else
            {
                if(arr[i] >= arr[i-1])
                    return false;
            }
        }
        
        //only increasing
        if(!peak)
            return false;
        
        return true;
    }
}