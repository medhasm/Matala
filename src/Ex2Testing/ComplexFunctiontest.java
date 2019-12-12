package Ex2Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

<<<<<<< HEAD:src/Ex1Testing/ComplexFunctiontest.java
import Ex1.ComplexFunction;
import Ex1.Polynom;
import Ex1.Monom;
import Ex1.Polynom_able;
import Ex1.complex_function;
import Ex1.function;
import Ex1.Operation;

public class ComplexFunctiontest {

=======
public class ComplexFunctiontest {
>>>>>>> c4a96887ae73f82d3755a5f21ebf3b6461d5661f:src/Ex2Testing/ComplexFunctiontest.java

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
<<<<<<< HEAD:src/Ex1Testing/ComplexFunctiontest.java
	public void testComplexFunction() 
	{
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
=======
	public void testComplexFunction() {
>>>>>>> c4a96887ae73f82d3755a5f21ebf3b6461d5661f:src/Ex2Testing/ComplexFunctiontest.java
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testComplexFunctionFunction() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testComplexFunctionOperationFunctionFunction() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testComplexFunctionStringFunctionFunction() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testF() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testComplexFunctionString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testInitFromString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCopy() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testPlus() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testMul() {
		fail("Not yet implemented"); // TODO
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

	public static void main(String[] args) {

	}
}


}

