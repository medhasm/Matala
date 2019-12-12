package Ex2Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Ex1Testing.ComplexFunction;
import Ex1Testing.Exception;
import Ex1Testing.Functions_GUI;
import Ex1Testing.IOException;
import Ex1Testing.Iterator;
import Ex1Testing.Monom;
import Ex1Testing.Polynom;
import Ex1Testing.Range;
import Ex1Testing.String;
import Ex1Testing.function;
import Ex1Testing.functions;

public class FunctionsGUI_Test {


	public static void main(String[] a) {

	functions data = FunctionsFactory();

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
	@Test
	public void testInitFromFile() {
		functions ans =new Functions_GUI();
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

	}
	

	@Test
	public void testSaveToFile() {
		functions ans = new Functions_GUI();
		functions _data = new Functions_GUI();
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

	}
	}

	@Test
	public void testDrawFunctionsIntIntRangeRangeInt() {
		Functions_GUI ans = new Functions_GUI();
ans.add(new Polynom("3x^2"));

		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,15);
		ans.drawFunctions(w,h,rx,ry,res);
	}

	@Test
	public void testDrawFunctionsString() {
		Functions_GUI ans = new Functions_GUI();
ans.add(new Polynom("4x^2+3"));

ans.drawFunctions("GUI_params.txt");
	}





	public static functions FunctionsFactory() {
		functions ans = new Functions_GUI();

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
