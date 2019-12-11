package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ex1.Monom;

class MonomJunitTest {
	Monom m ,d ,e;
	@BeforeEach
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
    	 if(f!=36) {
    		 System.out.println("f failed  ");
    		 System.out.println("expected:36 ");
    		 System.out.println("actual: " +f);
    	 }
     }
     @Test 
     void testisZero() {
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
    	 if(m.get_coefficient()!=8 || m.get_power()!=2) {
    		 System.out.println("add fail");
    		 System.out.println("expected:8x^2");
    		 System.out.println("actual:"+m);
    	 }
    	 }
     @Test
     void addException(){
    	 try {
    		 m=new Monom(3,2);
        	 d=new Monom(5,3);
    		 m.add(d);
    		 fail("add didnt throw exception ");
    	 }catch (Exception e) {}
     }
     @Test
     void multiply() {
    	 System.out.println("multiply Test:");
    	 m=new Monom(3,2);
    	 d=new Monom(2,4);
    	 m.multipy(d);
    	 if(m.get_coefficient()!=6 || m.get_power()!=6) {
    		 System.out.println("multiply fail");
    		 System.out.println("expected:6x^6");
    		 System.out.println("actual:"+m);
    	 }
     }


}
