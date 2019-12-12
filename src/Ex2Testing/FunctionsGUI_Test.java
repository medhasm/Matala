package Ex2Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Ex1Testing.ComplexFunction;
import Ex1Testing.Functions_GUI;
import Ex1Testing.IOException;
import Ex1Testing.Monom;
import Ex1Testing.Polynom;

public class FunctionsGUI_Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testClear() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testContains() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testContainsAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRetainAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSize() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToArray() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToArrayTArray() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testInitFromFile() {
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

	}
	

	@Test
	public void testSaveToFile() {
		Functions_GUI ans = new Functions_GUI();
		Functions_GUI _data = new Functions_GUI();
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

	@Test
	public void testGet() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testMain() {
		fail("Not yet implemented"); // TODO
	}

}
