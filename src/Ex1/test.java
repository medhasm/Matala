package Ex1;
import Ex1.ComplexFunction;
public class test {
	public static void main(String[] args) {
		/**String s1 = " +x";
		String s2 = "5 +2x -3.3x +0.1x^5";
		String[] s3 = {"x +3","x -2", "x-4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Polynom p3 = new Polynom(s3[0]);
		ComplexFunction cf3 = new ComplexFunction(p3);
		for(int i=1;i<s3.length;i++) {
			cf3.mul(new Polynom(s3[i]));
		}
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		System.out.println("p3: "+p3);
		ComplexFunction cf = new ComplexFunction("plus", p1,p2);
		//System.out.println("cf: "+cf);
		ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x+1"),cf3);
		System.out.println("cf4: "+cf4);
		cf4.plus(new Monom("2"));
		cf.div(p1);
		function cf5 = cf4.initFromString(s1);
		function cf6 = cf4.initFromString(s2);
		System.out.println("cf4: "+ cf4);
		System.out.println("cf6: "+ cf6);
	/*	function cfcopy = cf4.copy();
		System.out.println("copy: "+cfcopy.toString());
		cf4.div(new Monom("-x"));
		System.out.println(cfcopy);
		System.out.println(cf4);*/
		/**function right = cf4.right();
		function left= cf4.left();
		System.out.println("1: "+right);
		System.out.println("2: "+left);
		System.out.println( cf4.getOp());
		ComplexFunction a = new ComplexFunction("plus", new Polynom("x"),new Polynom("x^2"));
		ComplexFunction b = new ComplexFunction(new Polynom("x^2"));
		boolean c=a.equals(b);
		System.out.println(c);*/
		function f=new Polynom("2x");
		System.out.println(f);
		ComplexFunction cf=new ComplexFunction(f);
		System.out.println(cf);
				
	}

}
