package Practice;


class demo1{
	int x;
	String y;
	demo1(int x,String y){
		this.x=x;
		this.y=y;
	}
	
	public void foo1() {
		System.out.println(this.x);
		System.out.println(this.y);
	}
}

class demo2 extends demo1{

	demo2(int x, String y) {
		super(x+10, y);
		this.x=x;
		this.y=y;
		// TODO Auto-generated constructor stub
	}
	
	public void foo2() {
		System.out.println("child "+this.x);
		super.foo1();
	}
	
	
}

public class Inheritance {
	
	public static void main(String[] args) {
		demo2 obj=new demo2(10,"abc");
		obj.foo2();
		
	}

}
