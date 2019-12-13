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
		expCF = new ComplexFunction (op,f2,f1);
		if (!(CF.equals(expCF)))
			fail("Equals method returns false for functions that are equals");
	}


	@Test
	public void testComplexFunctionStringFunctionFunction() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testF() {
		ComplexFunction f1=new ComplexFunction();
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testComplexFunctionString() {
				
		fail("Not yet implemented"); // TODO
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
		ComplexFunction cf1=new ComplexFunction("plus(2x,2x)");
		ComplexFunction cf2=new ComplexFunction("mul(4x,1)");
		cf1.plus(cf2);
		//cf1.p
		
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
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testMin() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testComp() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testLeft() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRight() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetOp() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testMain() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	public void testequals() {
		ComplexFunction cf1=new ComplexFunction("plus(2x,2x)");
		ComplexFunction cf2=new ComplexFunction("mul(4x,1)");
	}

}
