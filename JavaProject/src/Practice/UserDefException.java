package Practice;


class Myexcp extends Exception{
	public Myexcp(String msg) {
		super(msg);
	}
}


public class UserDefException {
	public static void main(String[] args) throws Myexcp {
		int i=0;
		int k=10;
		if(i==0) {
			throw new Myexcp("denominator is zero");
		}
		else {
			System.out.println(k/i);
		}
	}
	
	

}
