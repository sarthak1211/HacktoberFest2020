package recursion;

public class keypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String[] permutationOfString(String input){
		// Write your code here
        if(input.length()==0){
            String[] r={""};
            return r;
                
        }
		char cc=input.charAt(0);
        String ros=input.substring(1);
        
        String[] recRes=permutationOfString(ros);
        String[] myRes=new String[ros.length()*ros.length()];
        
        for(int i=0;i<recRes.length;i++){
            for(int j=0;j<recRes[i].length();j++){
                myRes[i]= input.substring(0,i)+cc+ input.substring(i);
            }
            
        }
        return myRes;
	}
	
}
