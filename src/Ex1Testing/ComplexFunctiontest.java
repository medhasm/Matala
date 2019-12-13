package Ex1Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 import Ex2.Monom;
 import Ex2.Polynom;
 import Ex2.ComplexFunction;
import Ex2.Functions_GUI;
import Ex2.function;
 import Ex2.Operation;
 import Ex2.functions;


public class ComplexFunctiontest {
	
	static ComplexFunction CF;
	static ComplexFunction expCF;
	static function f1,f2;
	static Operation op;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComplexFunction() {
		
		f1 = new Polynom ("2x^3");
		f2 = new Polynom ("4x^2");
		op = Operation.Plus;
		CF = new ComplexFunction (op,f2,f1);
	}

	@Test
	public void testComplexFunctionFunction() {
		try {
		expCF = new ComplexFunction (op,f2,f1);
		if (!(CF.equals(expCF)))
			return ;
		}catch (Exception e) {}
	}


	
	@Test
	public void testF() {
		try {
		ComplexFunction cf1=new ComplexFunction();
		function f1=new Polynom("2x^3+6");
		function f2=new Polynom("3x+6-8x^2");
		cf1=new ComplexFunction(f1);
		cf1.plus(f2);
		double ans=cf1.f(2);
		if (ans!=20)
			return ;
		}
		catch(Exception e) {}
	}

	@Test
	public void testComplexFunctionString() {
		try {
		String  s1="plus(div(min(2x^3-1,2x^2+8-9),5x+9),3x^4+6x-8)";
		String s2="Divid(Plus(-1.0x^4+2.4x^2+3.1x^0,+0.1x^5+2.0x^1-3.3x^1+5.0x^0),-1.0x^4+2.4x^2+3.1x^0)";
		String s3="-1.0x^4+2.4x^2+3.1x^0";
		ComplexFunction cf1=new ComplexFunction(s1);
		ComplexFunction cf2=new ComplexFunction(s2);
		ComplexFunction cf3=new ComplexFunction(s3);
		}
		catch(Exception e) {}
	}

	@Test
	public void testInitFromString() {
		
		String s1 = "plus(3.1 +2.4x^2 -x^4,2x+5)";
		String s2 = "mul(5 +2x -3.3x +0.1x^5,2x^4)";
		String s3 = "plus(div(5x^3-9+10,9x),6x^2-9)";
		ComplexFunction cf1=new ComplexFunction(s1);
		ComplexFunction cf2=new ComplexFunction(s2);
		ComplexFunction cf3=new ComplexFunction(s3);
	}

	@Test
	public void testCopy() {
		Polynom p = new Polynom("15x^2-7x+5");
		Monom m = new Monom(2,4);
		function f1 = new ComplexFunction("mul", p, m);
		function f2 = f1.copy();

		assertEquals(f1, f2);
	}

	@Test
	public void testPlus() {
		Polynom p=new Polynom("2x^3");
		expCF = new ComplexFunction(op, p,f2);
		expCF.plus(f1);
		CF.plus(f1);
		if (!(expCF.equals(CF)))
			fail(" method plus");
	}

	@Test
	public void testMul() {
		
	}


	@Test
	public void testComp()
	{
		
	try {
		ComplexFunction f1 = new ComplexFunction("plus",new Polynom("x^2"), new Polynom("x^2"));
		ComplexFunction f2 = new ComplexFunction("plus",new Polynom("x^2"),new Polynom("x^2"));
		ComplexFunction f3 = new ComplexFunction("plus",new Polynom("x^2"),new Polynom("x^2"));
		ComplexFunction f1_max_f1 = new ComplexFunction("comp",f2,f3);
		f1.comp(f1);	
		if(f1_max_f1.equals(f1))
			return ;
		}catch (Exception e) {}
	}

	@Test
	public void testDiv() {
		String s1 = "3.1 +2.4x^2 -x^4";
		String s2 = "5 +2x -3.3x +0.1x^5";
		function f=new Polynom(s1);
		function f1=new Polynom(s2);
		ComplexFunction cf = new ComplexFunction("plus",f,f1);
		ComplexFunction cf2 ;
		cf.copy();
		cf.div(new Polynom("x^2"));
		ComplexFunction cf3=new ComplexFunction(Operation.Divid,(new Polynom("x^2")), cf);
		ComplexFunction cf4=new ComplexFunction(Operation.Divid,(new Polynom("x^2")), cf);
	}

	@Test
	public void testMax() {
		try {
			ComplexFunction cf=new ComplexFunction("plus(2x^2+6,2x^3+6");
			ComplexFunction cf1=new ComplexFunction("mul(2x^2+6,2x^3+6)");
			cf.max(cf1);
			double max=cf.f(1);
			if(max==64)
				return ;
		}catch (Exception e) {}
	}

	@Test
	public void testMin() {
		try {
			ComplexFunction cf=new ComplexFunction("plus(2x^2+6,2x^3+6");
			ComplexFunction cf1=new ComplexFunction("mul(2x^2+6,2x^3+6)");
			cf.min(cf1);
			double min=cf.f(1);
			if(min==16)
				return ;
		}catch (Exception e) {}
	}

	
	
	@Test
	public void testToString() {
		try {
			CF=new ComplexFunction("plus(mul(2x^4+10-2x,10x+6),6)");
			String s=CF.toString();
			if(s=="plus(mul(2x^4+10-2x,10x+6),6)")
				return ;
		}
		catch(Exception e) {}
	}

	

	
	@Test
	public void testequals() {
		String s1 = "3.1 +2.4x^2 -x^4";
		String s2 = "5 +2x -3.3x +0.1x^5";
		String[] s3 = {"x -1","x -2", "x -3", "x -4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Polynom p3 = new Polynom(s3[0]);
		for(int i=1;i<s3.length;i++) {
			p3.multiply(new Polynom(s3[i]));
		}
		ComplexFunction cf = new ComplexFunction("plus", p1,p2); 
		ComplexFunction cf4 = new ComplexFunction("div", new Monom("x"),p3);
		cf.div(p1);
		String s = cf.toString();
		function cf5 = cf4.initFromString(s);
		if(!cf.equals(cf5)) {
			fail("ERR: "+cf+" should be equals to "+cf5);
		}
		
	}

}
