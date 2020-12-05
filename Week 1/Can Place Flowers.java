class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        if(n < 1)
            return true;
        
        if(flowerbed == null || flowerbed.length < 1)
            return false;
        
        int i = 0;
        boolean prev = false;
        
        while(i < flowerbed.length)
        {
            //System.out.println("first -> " + i + " " + prev + " n -> " + n);
            if(flowerbed[i] == 1)
            {
                prev = true;
            }
            else if(!prev)
            {
                if( i < flowerbed.length-1)
                {
                    if(flowerbed[i+1] != 1)
                    {
                        prev = true;
                        n--;
                    }
                }
                else
                {
                    prev = true;
                    n--;
                }
            }
            else
                prev = false;
            
            //System.out.println("last -> " + i + " " + prev + " " + n);
            
            if(n < 1)
                return true;
            i++;
        }
        
        return false;
    }
}