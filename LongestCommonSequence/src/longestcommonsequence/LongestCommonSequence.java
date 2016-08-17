package longestcommonsequence;

/**
 *
 * @author Scott Mackenzie
 */

public class LongestCommonSequence {
    
    public static void main(String[] args) {
        
        String prot_1 = "ABC";
        String prot_2 = "ASJHFSJHFBKJGSKDGJKSDKJSHKSJK";
               
        System.out.println(longestCommon(prot_1, prot_2));
                
    }
    
    public static String longestCommon(String prot1, String prot2) {
        
        int[][] length = new int[prot1.length()+1][prot2.length()+1];
        
        for(int i = 0; i < prot1.length(); i++) {
            for(int j = 0; j < prot2.length(); j++) {
                if(prot1.charAt(i) == prot2.charAt(j)) {
                    length[i+1][j+1] = length[i][j] + 1;
                } else {
                    length[i+1][j+1] = Math.max(length[i+1][j],length[i][j+1]);
                }
            }
        }
        
        StringBuilder output = new StringBuilder();
        
        for(int i = prot1.length(), j = prot2.length(); i != 0 && j !=0; ) {
            if(length[i][j] == length[i-1][j]) {
                i--;
            }
            else if(length[i][j] == length[i][j-1]) {
                j--;
            } else {
                assert prot1.charAt(i-1) == prot2.charAt(j-1);
                output.append(prot1.charAt(i-1));
                i--;
                j--;
            }
        }     
        return output.reverse().toString();            
    } 
}
    
    
    
    
    

