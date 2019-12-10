package Ex1;
import java.util.AbstractList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;



import  java.util.Map;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	 public ArrayList<Monom> poly1 = new ArrayList<Monom>();
	 public LinkedList<Monom> poly2 = new LinkedList<Monom>();
	
	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {
this.poly2=new LinkedList<>();
this.poly2.add(new Monom("0"));
	}
	/**
	 * init a Polynom from a String such as:
	 *  {"x", "3+1.4X^3-34x", "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s) {
		s=s.replace(" ", "");
	
		List<Character> c= new ArrayList<Character>();
	for (int i = 0; i <s.length() ; i++){
			if((s.charAt(i)=='+')||s.charAt(i)=='-'){
				c.add(s.charAt(i));
			}
		}

		StringTokenizer str = new StringTokenizer(s,"+-");
		Iterator<Character> it= c.iterator();

		String is=""; 
		char b;
		if(str.countTokens()==c.size()) {/// then the first arithmetic is minus
			b = it.next();
			is=b+str.nextToken();
			Monom m= new Monom(is);
			this.poly2.add(m);
			
			
		}
		else {

			is=str.nextToken();
			Monom m= new Monom(is);
			this.poly2.add(m);
			
			
		}
		while(str.hasMoreTokens()){
			b = it.next();
			is=b+str.nextToken();
			Monom m= new Monom(is);
			this.poly2.add(m);
		
			
		}
		poly2.sort(Monom._Comp);
		
		
	}
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		double v=0.000000;
		
		for (int i=0;i<this.poly2.size();i++) {
			
			v=v+(poly2.get(i).f(x));
		
			}
	  return v;
	}

	@Override
	public void add(Polynom_able p1) {
		
			Iterator<Monom> itr=p1.iteretor();
			Monom M=new Monom();
			int mp;
			boolean flag=true;
			while(itr.hasNext()) {
				
            M=itr.next();
		mp=M.get_power();
	
		for(int j=0; j<this.poly2.size();j++) {
			if(mp==this.poly2.get(j).get_power()) {
			poly2.get(j).add(M);
				flag=false;
			}
		
		  }
		if(flag){
			poly2.add(M);
				
		}
		
		
		
			}
			poly2.sort(Monom._Comp);
	

	
	}

	@Override
	public void add(Monom m1) {
		// TODO Auto-generated method stub
		if(m1!=Monom.ZERO) {

		boolean flag=true;
		double Z;
		for(int i=0;i < this.poly2.size();i++) {
			if(poly2.get(i).get_power()==m1.get_power()) {
				
				poly2.get(i).add(m1);
				flag=false;
				return;
			}
		}
			if(flag) {
				int x=poly2.size();
				poly2.add(m1);
				
			
				
			}
			poly2.sort(Monom._Comp);
		
		}
	}
	

	@Override
	public void substract(Polynom_able p1) {
		// TODO Auto-generated method stub
		double cofft=0.0;
		int mp=0;
		boolean flag=true;
		Iterator<Monom> itr=p1.iteretor(); 
		Monom m=new Monom();
		while(itr.hasNext()) {
			m=itr.next();
		for(int i=0;i<poly2.size();i++) {
			
				mp=m.get_power();
				if(mp==poly2.get(i).get_power()) {
					if(m.get_coefficient()<0) {
						cofft=(poly2.get(i).get_coefficient())+((m.get_coefficient())*(-1));
						flag = false;
						poly2.get(i).set_coefficient1(cofft);
					}else {
						
					
					cofft=poly2.get(i).get_coefficient()-(m.get_coefficient());
					flag=false;
					poly2.get(i).set_coefficient1(cofft);
							
					}
			
				}
				
			}
		if(flag) {
			m.set_coefficient1( m.get_coefficient()*(-1));
			poly2.add(m);
		} 
		poly2.sort(Monom._Comp);
		
		}

		}
		
		
	

	@Override
	public void multiply(Polynom_able p1) {
		// TODO Auto-generated method stub
		
			Polynom N1=(Polynom) this.copy();
			poly2=new LinkedList<>();
		Polynom P=new Polynom();
			Iterator<Monom> itr;
		Monom m=new Monom();
		Monom R=new Monom();
		for(int i=0;i<N1.poly2.size();i++) {
			itr=p1.iteretor();
			
			while(itr.hasNext()) {
				R=new Monom(N1.poly2.get(i));
				m=itr.next();
				R.multipy(m);
				poly2.add(new Monom(R));		
						}
		}
		
		
	}
	

	@Override
	public boolean equals(Object p1) {
		// TODO Auto-generated method stub-able
		if (p1==null || !(p1  instanceof Polynom_able )) {return false;}
		int mp=0;
		double np=0.0000000;
		boolean flag=false;
		Polynom_able P= (Polynom_able) p1;
		Iterator<Monom> itr=P.iteretor();
		Monom m=new Monom();
		while(itr.hasNext()) {
			m=itr.next();
			if(m.isZero() && itr.hasNext()) {
				m=itr.next();
			}
			
			mp=m.get_power();
			np=m.get_coefficient();
			for(int i=0;i<poly2.size();i++) {
				if(mp==poly2.get(i).get_power()) {
					if( (np - (Monom.EPSILON)) <=poly2.get(i).get_coefficient() && poly2.get(i).get_coefficient() <= ( np + (Monom.EPSILON)) ) { //svevat epsilon
						flag=true;
					}
				}
			}
					if(!flag) {
					return false;	
				}			
					
		}
		
	
		return true;
		
		
	
	
	
	}

	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		boolean flag=true;
		for( int i=0;i<poly2.size();i++) {
			if(poly2.get(i).get_coefficient()!=0) {
				return flag=false;
			}
			
		}
		return flag;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		
		if((this.f(x0)*this.f(x1)>0)) {
			throw new RuntimeException("ERR there is no x match "+(this.f(x0)*this.f(x1)));
		}
			double fx=0.0;
			while(x0<=x1) {
				fx=this.f(x0);
				if(Math.abs(fx)<eps){ return x0;}

				x0=x0+Monom.EPSILON;
			}
		
		return 0;
		
	}

	@Override
	public Polynom_able copy() {
		// TODO Auto-generated method stub
	Polynom P=new Polynom();
	for(int i=0;i<this.poly2.size();i++) {
		Monom m=new Monom(poly2.get(i));
		P.add(m);
			
		}
	
		
		return P;
	}

	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub
		Polynom_able P=new Polynom();
		Iterator<Monom> itr=P.iteretor();
		Monom m=new Monom();
		double x=0.0;
		int y=0;
		for(int i=0;i<this.poly2.size();i++) {
			if(this.poly2.get(i).get_power()==0) {
				P.add(Monom.ZERO);
			}else {
			x=this.poly2.get(i).get_coefficient()*this.poly2.get(i).get_power();
			y=this.poly2.get(i).get_power()-1;
			m=new Monom(x,y);
	P.add(m);
	
		}
		}
		
		return P;
	}
	public String toString() {
		String ans = "";
		
		for(int i=0;i<this.poly2.size();i++) {
			if(this.poly2.get(i).get_coefficient()>=0) {
		ans=ans+'+'+this.poly2.get(i).toString();
			}else {
				ans=ans+this.poly2.get(i).toString();
			}
		}
		return ans;
		
	}

	@Override
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		
		double area=0.0;
	
		if(x0<x1) {
		
		while(x0<x1) {
			if(this.f(x0)<0) {
				x0=x0+eps;
			}else {
			area+=this.f(x0)*eps;
			
		
			x0=x0+eps;
			}
		}
	
		}else	{throw new RuntimeException("ERR wrong intput ");}
		
		return area;
		
	}

	@Override
	public Iterator<Monom> iteretor() {
		// TODO Auto-generated method stub
		return this.poly2.iterator();
	}
	@Override
	public void multiply(Monom m1) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.poly2.size();i++) {
			this.poly2.get(i).multipy(m1);
		}
	
		
		
	}
	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return new Polynom(s);
	}
	
}
