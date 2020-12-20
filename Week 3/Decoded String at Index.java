class Solution {
    public String decodeAtIndex(String S, int K) {
//         StringBuilder sb = new StringBuilder();
//         if(K < 1)
//             return sb.toString();
//         if(K == 1)
//             return new String(S.charAt(0)+"");
        
//         //int c = 0;
//         for(char ch: S.toCharArray())
//         {
//             if(ch >= '2' && ch <= '9')
//             {
//                 String sub = sb.toString();
//                 int x = ch-'0';
//                 while(x > 1)
//                 {
//                     x--;
//                     sb.append(sub);
//                 }
//             }
//             else
//             {
//                 sb.append(ch+"");
//             }
//             if(sb.length() >= K)
//                 break;
//         }
//         //System.out.println(sb.toString());
//         return new String(sb.charAt(K-1)+"");
        
	//int i = 0;
        long size = 0;
        
        //while(i < S.length() && size < K)
        for(int i = 0; i < S.length(); i++)
        {
            char ch = S.charAt(i);
            //i++;
            if(ch >= '2' && ch <= '9')
                size *= (ch - '0');
            else
                size++;
        }
        
        //while(i > 0)
        for(int i = S.length()-1; i >= 0 && size > 0; i--)
        {
            //i--;
            
            char ch = S.charAt(i);
            if(ch > '1' && ch <= '9')
            {
                size /= (ch-'0');
                K %= size;
            }
            else
            {
                if(K % size == 0)
                    return new String(ch+"");
                size--;
            }
        }
        return new String();
    }
}