package Ex1;


//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test
import java.io.IOException;
>>>>>>> 6e97fa72fc5f40f55cc0e03299e51cf7faa5b386

import Ex1.ComplexFunction;
import Ex1.Functions_GUI;
import Ex1.Monom;
import Ex1.Polynom;
import Ex1.Range;
import Ex1.function;
/**
 * Partial JUnit + main test for the GUI_Functions class, expected output from the main:
 * 0) java.awt.Color[r=0,g=0,b=255]  f(x)= plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0)
1) java.awt.Color[r=0,g=255,b=255]  f(x)= plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)
2) java.awt.Color[r=255,g=0,b=255]  f(x)= div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)
3) java.awt.Color[r=255,g=200,b=0]  f(x)= -1.0x^4 +2.4x^2 +3.1
4) java.awt.Color[r=255,g=0,b=0]  f(x)= +0.1x^5 -1.2999999999999998x +5.0
5) java.awt.Color[r=0,g=255,b=0]  f(x)= max(max(max(max(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)
6) java.awt.Color[r=255,g=175,b=175]  f(x)= min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)

 * @author boaz_benmoshe
 *
 */
class test {
	
	public static void main(String[] a) {
		Functions_GUI data = FunctionsFactory();

		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,15);
		data.drawFunctions(w,h,rx,ry,res);
		
		/**String file = "function_file.txt";
		String file2 = "function_file2.txt";
		try {
			data.saveToFile(file);
			Functions_GUI data2 = new Functions_GUI();
			data2.initFromFile(file);
			data.saveToFile(file2);
		}
		catch(Exception e) {e.printStackTrace();}
		
		String JSON_param_file = "GUI_params.txt";
		data.drawFunctions(JSON_param_file);*/
	}
	/**private Functions_GUI _data=null;
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}

<<<<<<< HEAD
	@BeforeEach
	void setUp() throws Exception {
		_data = FunctionsFactory();
	}

	//@Test
	void testFunctions_GUI() {
	//	fail("Not yet implemented");
	}
=======
		Functions_GUI ans =new Functions_GUI();
		ans.add(new Polynom("3x^5+7"));
		ans.add(new ComplexFunction("Plus",new Polynom ("4x^5+3"),new Monom("24x")));
		ans.add(new Polynom("x^5+x^4+x^3+x^2+x"));
		Functions_GUI data1 =new Functions_GUI();
		try {
			ans.saveToFile("C:\\Users\\Medhat\\Desktop\\FuGUITst\\FuGUI.txt");
			data1.initFromFile("C:\\Users\\Medhat\\Desktop\\FuGUITst\\FuGUI.txt");
			System.out.println(ans.toString());
			System.out.println(data1.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
>>>>>>> 6e97fa72fc5f40f55cc0e03299e51cf7faa5b386

	//@Test
	void testInitFromFile() {
	//	fail("Not yet implemented");
	}

	//@Test
	void testSaveToFile() {
	//	fail("Not yet implemented");
	}
<<<<<<< HEAD

	//@Test
	void testDrawFunctions() {
		//_data.drawFunctions();
	//	fail("Not yet implemented");
	}
=======
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
			System.out.println("Max:"+max);
			System.out.println( "Min:"+min);
			System.out.println(ans.size());
			for(int i=1;i<ans.size();i++) {
				max.max(ans.get(i));
				min.min(ans.get(i));
				System.out.println("Interation "+i+ "-Max:"+max);
				System.out.println( "Interation "+i+ "-Min:"+min);
			}
			
			ans.add(max);
			ans.add(min);
			System.out.println(ans.size());
			return ans;
		}
	
	
>>>>>>> 6e97fa72fc5f40f55cc0e03299e51cf7faa5b386

	@Test
	void testDrawFunctionsIntIntRangeRangeInt() {
		_data.drawFunctions();
		//fail("Not yet implemented");
	}*/
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
		
		ComplexFunction cf = new ComplexFunction("plus", p1,p2);
		ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x +1"),cf3);
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
