package recursion;

public class subStringLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SubStringHelper("kincenvizh");
	}
	public static void SubStringHelper(String str) {
		int count=0;
		String res="";
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<str.length();j++) {
				res=str.substring(i, j);
				System.out.println(res);
				count++;
			}
		}
		System.out.println(count);
		
	}
}
