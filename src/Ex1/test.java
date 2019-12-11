package Ex1;
import Ex1.ComplexFunction;
public class test {
	public static void main(String[] args) {

	
		Functions_GUI data = FunctionsFactory();
		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,15);
		data.drawFunctions(w,h,rx,ry,res);
		
			

		String s1 = " +x";
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
		function cfcopy = cf4.copy();
		System.out.println("copy: "+cfcopy.toString());
		cf4.div(new Monom("-x"));
		System.out.println(cfcopy);
		System.out.println(cf4);
		/**function right = cf4.right();
		function left= cf4.left();
		System.out.println("1: "+right);
		System.out.println("2: "+left);
		System.out.println( cf4.getOp());
		ComplexFunction a = new ComplexFunction("plus", new Polynom("x"),new Polynom("x^2"));
		ComplexFunction b = new ComplexFunction(new Polynom("x^2"));
		boolean c=a.equals(b);
		System.out.println(c);*/
		//function f=new Polynom("2x");
		//System.out.println(f);

		//ComplexFunction f1=new ComplexFunction(f);
		//System.out.println(f1);
		//ComplexFunction cf=new ComplexFunction();
		//ComplexFunction f1=(ComplexFunction) cf.initFromString("Plus(2x,x)");
		//System.out.println(f1);

		ComplexFunction cf1=new ComplexFunction();
		System.out.println(cf1);
		ComplexFunction df=(ComplexFunction) cf1.initFromString("Plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0)");
		System.out.println(df);
		

				

	}
		public static Functions_GUI FunctionsFactory() {
			Functions_GUI ans = new Functions_GUI();
			String s1 = "3.1 +2.4x^2 -x^4";
			String s2 = "5 +2x -3.3x +0.1x^5";
			String[] s3 = {"x +3","x -2", "x -4"};
			Polynom p1 = new Polynom(s1);
			Polynom p2 = new Polynom(s2);
			Polynom p3 = new Polynom(s3[0]);
			ComplexFunction cf3 = new ComplexFunction(p3);
			for(int i=1;i<s3.length;i++) {
				cf3.mul(new Polynom(s3[i]));
			}
			
			ComplexFunction cf = new ComplexFunction("Plus", p1,p2);
			ComplexFunction cf4 = new ComplexFunction("Divid", new Polynom("x +1"),cf3);
			cf4.plus(new Monom("2"));
			ans.add(cf.copy());
			ans.add(cf4.copy());
			cf.div(p1);
			ans.add(cf.copy());
			String s = cf.toString();
			function cf5 = cf4.initFromString(s1);
			function cf6 = cf4.initFromString(s2);
			ans.add(cf5.copy());
			ans.add(cf6.copy());
			ComplexFunction max = new ComplexFunction(ans.get(0).copy());
			ComplexFunction min = new ComplexFunction(ans.get(0).copy());
			for(int i=1;i<ans.size();i++) {
				max.max(ans.get(i));
				min.min(ans.get(i));
			}
			ans.add(max);
			ans.add(min);
			
			return ans;
		}
	


}