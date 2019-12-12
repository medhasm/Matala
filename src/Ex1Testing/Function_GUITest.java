package Ex1Testing;
<<<<<<< HEAD:src/Ex1Testing/Function_GUITest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

=======
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.IOException;
import java.util.Iterator;
import java.util.function.Function;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
>>>>>>> 6e97fa72fc5f40f55cc0e03299e51cf7faa5b386:src/Ex1Testing/Functions_GUITest.java
import Ex1.ComplexFunction;
import Ex1.Functions_GUI;
import Ex1.Monom;
import Ex1.Operation;
import Ex1.Polynom;
import Ex1.Range;
import Ex1.function;
import Ex1.functions;
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
class Functions_GUITest {
	public static void main(String[] a) {
<<<<<<< HEAD:src/Ex1Testing/Function_GUITest.java
	Functions_GUI data = FunctionsFactory();
=======
		functions data = FunctionsFactory();
>>>>>>> 6e97fa72fc5f40f55cc0e03299e51cf7faa5b386:src/Ex1Testing/Functions_GUITest.java
		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,15);
		data.drawFunctions(w,h,rx,ry,res);
		String file = "function_file.txt";
		String file2 = "function_file2.txt";
		try {
			data.saveToFile(file);
			Functions_GUI data2 = new Functions_GUI();
			data2.initFromFile(file);
			data.saveToFile(file2);
		}
		catch(Exception e) {e.printStackTrace();}
		
		String JSON_param_file = "GUI_params.txt";
		data.drawFunctions(JSON_param_file);
	}
	
	private functions _data=null;
	/*
@BeforeAll
static void setUpBeforeClass() throws Exception {
}
*/

	@BeforeEach
	void setUp() throws Exception {
	//	_data = FunctionsFactory();
	}

	//@Test
	void testFunctions_GUI() {
<<<<<<< HEAD:src/Ex1Testing/Function_GUITest.java
		//fail("Not yet implemented");
	}

	//@Test
	void testInitFromFile() {
	//	fail("Not yet implemented");
=======
		Functions_GUI ans =new Functions_GUI();
		ans.add(new Polynom("3x^5+7"));
		ans.add(new ComplexFunction("Plus",new Polynom ("4x^5+3"),new Monom("24x")));
		ans.add(new Polynom("x^5+x^4+x^3+x^2+x"));
		
	}

	@Test
	void testInitFromFile()  {
		Functions_GUI ans =new Functions_GUI();
		ans.add(new Polynom("3x^5+7"));
		ans.add(new ComplexFunction("Plus",new Polynom ("4x^5+3"),new Monom("24x")));
		ans.add(new Polynom("x^5+x^4+x^3+x^2+x"));
		
		try {
			ans.saveToFile("function.txt");
		_data.initFromFile("function.txt");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(ans.toString(),_data.toString());
		
		
>>>>>>> 6e97fa72fc5f40f55cc0e03299e51cf7faa5b386:src/Ex1Testing/Functions_GUITest.java
	}

	//@Test
	void testSaveToFile() {
<<<<<<< HEAD:src/Ex1Testing/Function_GUITest.java
	//	fail("Not yet implemented");
=======
		Functions_GUI ans = new Functions_GUI();
		
		ans.add(new Polynom("-4x^5+ 5x^6+5"));
		ans.add(new ComplexFunction("Divid(Times(x^2,x),4)"));
		ans.add(new Monom("3x^7"));
		try {
			ans.saveToFile("function.txt");
			_data.initFromFile("function.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals(_data.toString(), ans.toString());
>>>>>>> 6e97fa72fc5f40f55cc0e03299e51cf7faa5b386:src/Ex1Testing/Functions_GUITest.java
	}

	//@Test
	void testDrawFunctions() {
<<<<<<< HEAD:src/Ex1Testing/Function_GUITest.java
		//_data.drawFunctions();
	//	fail("Not yet implemented");
=======
		_data.drawFunctions();
		
>>>>>>> 6e97fa72fc5f40f55cc0e03299e51cf7faa5b386:src/Ex1Testing/Functions_GUITest.java
	}
*/
	@Test
	void testDrawFunctionsIntIntRangeRangeInt() {
<<<<<<< HEAD:src/Ex1Testing/Function_GUITest.java
		//_data.drawFunctions();
		//fail("Not yet implemented");
	}
	public static Functions_GUI FunctionsFactory() {
		Functions_GUI ans = new Functions_GUI();
=======
		
		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,15);
		_data.drawFunctions(w,h,rx,ry,res);
		
		
	}
	
	public static functions FunctionsFactory() {
		functions ans = new Functions_GUI();
>>>>>>> 6e97fa72fc5f40f55cc0e03299e51cf7faa5b386:src/Ex1Testing/Functions_GUITest.java
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
		
		ComplexFunction cf = new ComplexFunction(Operation.Plus, p1,p2);
		ComplexFunction cf4 = new ComplexFunction(Operation.Divid, new Polynom("x +1"),cf3);
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
		Iterator<function> iter = ans.iterator();
		function f = iter.next();
		ComplexFunction max = new ComplexFunction(f);
		ComplexFunction min = new ComplexFunction(f);
		while(iter.hasNext()) {
			f = iter.next();
			max.max(f);
			min.min(f);
		}
		ans.add(max);
		ans.add(min);		
		return ans;
	}
}