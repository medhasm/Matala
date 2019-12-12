
package Ex1Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ex1.Monom;

class MonomJunitTest {
	Monom m ,d ,e;
	@Before
	void init()
	{
		  m=new Monom();
		  d=new Monom();
		  e= new Monom();
	}
     @Test
     void testderivative() {
    	 
    	 System.out.println("derivative Test:");
    	  m=new Monom(3,2);
    	  d =new Monom(m.derivative());
    	  e=new Monom(6,1);
    	 
    	 if(d.get_coefficient()!=e.get_coefficient() || d.get_power()!=e.get_power()) {
    		 System.out.println("derivative fail");
    		 
    	 }
    	 
     }
     @Test
     void testfunction() {
    	 System.out.println("function test:");
    	 m=new Monom(4,2);
    	 double f;
    	 f=m.f(3);
    	 /*
    	 if(f!=36) {
    		 System.out.println("f failed  ");
    		 System.out.println("expected:36 ");
    		 System.out.println("actual: " +f);*/
    	 assertEquals(f,36,"f method fail");
    	 
     }
     @Test 
     void testisZero() {
    	 System.out.println("isZeroTest:");
    	 m=new Monom(0,4);
    	 if(!m.isZero()) {
    		 System.out.println("isZero Failed");
    		 
    	 }
     }
     @Test
     void testadd () {
    	 System.out.println("test add:");
    	 m=new Monom(3,2);
    	 d=new Monom(5,2);
    	 m.add(d);
    	 Monom X=new Monom(8,2);
    	 if(!m.equals(X)) {
    		 System.out.println("add fail");
    		 System.out.println("expected:"+X);
    		 System.out.println("actual:"+m);
    	 }
    	 }
     @Test
     void addException(){
    	 System.out.println("test addexception:");
    	 System.out.println("add Exception:");
    	 try {
    		 m=new Monom(3,2);
        	 d=new Monom(5,3);
    		 m.add(d);
    		 fail("add didnt throw exception ");
    	 }catch (Exception e) { }
     }
     @Test
     void multiply() {
    	 System.out.println("test multipy:");
    
    	 m=new Monom(3,2);
    	 d=new Monom(2,3);
    	 m.multipy(d);
    	 e=new Monom(6,5);
    	 assertNotSame(e.toString() ,m.toString(),"multiply method of monom failed");
    	 }
     @Test
     void toStringtest() {
    	 System.out.println("test tostring:");
    	 m=new Monom(3,2);
    	 assertNotSame("3.0x^2",m.toString(),"Strings not equals");
     }
     @Test
     void setPowerException() {
    	 System.out.println("test setpower exception:");
    	 try {
    	 m.set_power1(-1);
    	 fail("didnt throw exception to negatiove power");
    	 }catch(RuntimeException e) {
     }
     }
     @Test
     void setcofftest() {
    	 System.out.println("test setcoefficient:");
    	 m.set_coefficient1(3);
    	 assertEquals((double)3,m.get_coefficient(),"set coefficient failed");
     }
     @Test
     void setpowertest() {
    	 System.out.println("test setpower n:");
    	 m.set_power1(3);
    	 assertEquals(3,m.get_power(),"set coefficient failed");
     }
     @Test
     void initFromStringtest() {
    	 System.out.println("test initFromString:");
    	 m= (Monom) m.initFromString("3x^2");
    	 d=new Monom(3,2);
    	 assertNotSame(d.toString(),m.toString(),"initfromstring failed");
     }
     @Test
     void copyTest() {
    	 System.out.println("test copy");
    	 m=new Monom(3,2);
    	 d=(Monom) m.copy();
    	 e=new Monom(3,2);
    	
    	 assertNotSame(e.toString(),d.toString(),"copy method failed");
     }
     @Test
     void EqualTest() {
    	 System.out.println("equaltest:");
    	 m=new Monom(3,2);
    	 e=new Monom(3,2);
    	 if(!m.equals(e)) {
    		 System.out.println("equals method failed");
    	 }
     }
}


