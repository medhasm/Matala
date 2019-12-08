
package Ex1;

import java.util.Comparator;
import java.util.StringTokenizer;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}
	public Monom(double a, int b){
		this.set_coefficient1(a);
		this.set_power1(b);
	}
	public Monom() {
		this._coefficient=0.0;
		this._power=0;
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
		
	}
	
	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}
	public double f(double x) {
		double ans=0;
		double p = this.get_power();
		if(this._power==0) {
			ans = this.get_coefficient()*1;
		}else {
		ans = this.get_coefficient()*Math.pow(x, p);
		}
		return ans;
	} 
	public boolean isZero() {return this.get_coefficient() == 0;}
	// ***************** add your code below **********************
	public Monom(String s) {
		if(s.length()==0) {
			throw new RuntimeException("ERR String is empty ");
		}
		String t1="";
		String t2="";
		int C=0;
		int x;
		for(int i=0;i<= s.length()-1;i++) {
			x=(int) s.charAt(i);
			if( (48<=x && x<=57) || s.charAt(i)=='x' || s.charAt(i)=='^' || s.charAt(i)==' '||
					s.charAt(i)=='+' || s.charAt(i)=='-'||s.charAt(i)=='*' ||  s.charAt(i)=='.' ) {
		/*	if(s.charAt(i)=='-' || s.charAt(i)=='+' ) {
				C=i;
			}
			*/
				
				if(!s.contains("x")&& !s.isEmpty()) {
					this._power=0;
					t1=s.substring(0, s.length());
					this._coefficient=Double.parseDouble(t1);
				}
			if(s.charAt(i)=='x') {
				if(i-C==1) {
					if(s.charAt(C)=='-') {
						this._coefficient=-1.0;
					}else if(s.charAt(C)=='+') 
						{this._coefficient=1.0;
						}else {
							t1=t1+s.substring(C, i);
							this._coefficient=Double.parseDouble(t1);
						}
				}else if(i-C==0){
					this._coefficient=1.0;
				}
					else{
				t1=t1+s.substring(C, i);
				this._coefficient=Double.parseDouble(t1);
				}
		}
			}		else {
				throw new RuntimeException("ERR the string couldnot contain char else than + - number x and ^: "+s.charAt(i));	
			}
			
			
				if(s.contains("^")) {
					for(int j=0;j<=s.length()-1;j++) {
				if(s.charAt(j)=='^' ) {
					t2=s.substring(j+1, s.length());
					this._power=Integer.parseInt(t2);
					
				}
					
				}
				}else {
					if(!s.contains("x")) {
						this._power=0;
					}else {
					this._power=1;
					}
				}
			   }
			 
	    	}
		
	
		
		
	
	public void add(Monom m) {
		if(this._power!=m._power)
		{throw new RuntimeException("ERR the power of Monom should be equal: "+this._power+ +m._power);}
		else {
			(this._coefficient)+=m._coefficient;
			}
	}
	
	public void multipy(Monom d) {
		if(d!=Monom.ZERO) {
		this._coefficient=this._coefficient*d.get_coefficient();
		}this._power=this._power+d.get_power() ;
		
	}
	public String toString() {
		String ans = "";
		ans=ans+Double.toString(get_coefficient())+'x'+'^'+Integer.toString(get_power());
		return ans;
	}
	// you may (always) add other methods.

	//****************** Private Methods and Data *****************
	public void set_coefficient1(double a){
		set_coefficient(a);
	}

	private void set_coefficient(double a){
		this._coefficient = a;
	}
	public void set_power1(int p) {
		set_power(p);
		
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private double _coefficient; 
	private int _power;
	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public function copy() {
		// TODO Auto-generated method stub
		Monom M=new Monom(this.get_coefficient(),this.get_power());
		
		return M;
	}
	
	
}
