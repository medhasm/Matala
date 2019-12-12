package Ex2;

import Ex2.ComplexFunction;
import Ex2.Operation;
import Ex2.Polynom;
import Ex2.complex_function;
import Ex2.function;

public  class ComplexFunction implements complex_function {
private function left;
private function right;
private Operation P;

 public ComplexFunction() {
	// TODO Auto-generated constructor stub
	this.right=new Polynom("0");
	this.left=new Polynom("0");
	this.P=Operation.None;
}
 public ComplexFunction(function f1)
 {
	 this.left=f1.copy();
	 this.right=new Polynom("0");
	 this.P=Operation.None;
 }
 public ComplexFunction(Operation OP,function f1,function f2) {
	switch (OP) {
	case Plus:
		P=P.Plus;
		break;
	case Times:
		P=P.Times;
		break;
	case Divid:
		P=P.Divid;
		break;
	case Max:
		P=P.Max;
		break;
	case Min:
		P=P.Min;
		break;
	case Comp:
		P=P.Comp;
		break;
	case None:
		throw new RuntimeException( "ERR: operation can't be None");
	default:
		throw new RuntimeException("ERR:  you entered iligal Operatin. got"+OP);
		
	}
	this.left=f1;
	this.right=f2;
 }
 private Operation fix_op(String s)
 {
	 switch (s) {
	 case "plus":
		 return Operation.Plus;
	case "times":
		 return Operation.Times;
	case "div":
		return Operation.Divid;
	case "divid":
		 return Operation.Divid;
	case "none":
	 	return Operation.None;
	case "min":
		 return Operation.Min;
	case "max":
		 return Operation.Max;
	case "comp": 
		 return Operation.Comp;
	case "error":
		 return Operation.Error; 
	case "Plus":
			return Operation.Plus;
	case "Times":
			return Operation.Times;
	case "Divid":
			return Operation.Divid;
	case "Max":
			return Operation.Max;
	case "Min":
			return Operation.Min;
	case "Comp":
			return Operation.Comp;
	case "None":
			return Operation.None;
	default:
		throw new RuntimeException("ERR:  you entered iligal Operatin. got");
	 }

 }
 public ComplexFunction(String s,function f1,function f2)
 {
	 Operation op=fix_op(s);
		if(op==Operation.None)
			throw new RuntimeException( "ERR: operation can't be None");
		left=f1;
		right=f2;
		P=op;
	 }
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		switch (this.P) {
		case Plus:
			return left.f(x)+right.f(x);		
		case Times:
			return left.f(x)*right.f(x);
		case Divid:
			try {
			     return left.f(x)/right.f(x);
			}
			catch (Exception e)
			{
				System.out.println("ER: f2(x) =0");
			}
		case Max:
			if(left.f(x)>=right.f(x)) return left.f(x);
			else return right.f(x);
		case Min:	
			if(left.f(x)<=right.f(x)) return left.f(x);
			else return right.f(x);
		case Comp:
			return left.f(right.f(x));
		case None:
			if(right==null) return left.f(x);
		case Error:
			throw new RuntimeException("ERR:  YOUR OPERATION IS ERROR");
		default:
			throw new RuntimeException("ERR:  you entered iligal Operatin got");
		}	
	}
	public ComplexFunction(String s)
	{
		ComplexFunction cf =new ComplexFunction();
		cf=(ComplexFunction) cf.initFromString(s);
		this.left=cf.left.copy();
		this.right=cf.right.copy();
		this.P=cf.P;
	}
	public function initFromString(String s) {
		// TODO Auto-generated method stub
<<<<<<< HEAD:src/Ex1/ComplexFunction.java
		 s=s.replaceAll(" ","");
=======

		s=s.replaceAll(" ","");
>>>>>>> c4a96887ae73f82d3755a5f21ebf3b6461d5661f:src/Ex2/ComplexFunction.java

		int git;
		ComplexFunction cf=new ComplexFunction();
		function f1,f2;
		char c=',';
			if(s.contains(",")) {
				git=this.GIO(s);
				f1=cf.initFromString(s.substring(s.indexOf('(')+1, git));
				f2=cf.initFromString(s.substring(git+1 ,s.length()-1));
				if(s.equals(",(")||s.equals("),")) {
					if(s.equals(",(")) {
						throw new RuntimeException("Err:left function cant be null"); 			
						}else {
							f2=new Polynom("0");
					}
				}
				return cf=new ComplexFunction(s.substring(0, s.indexOf('(')),f1,f2);
			}
			
		
		return new Polynom(s);
	}
	@Override
	public function copy() {
		// TODO Auto-generated method stub
		ComplexFunction cf=new ComplexFunction(this.P,this.left,this.right);
		return cf;
	}

	@Override
	public void plus(function f1) {
		// TODO Auto-generated method stub
		if(this.P==Operation.None) {
			
			
		if(this.left.toString().equals("+0.0x^0")) {
			this.left=f1;
		this.P=Operation.Plus;
		}
		else
			if(this.right.toString().equals("+0.0x^0")){
				this.right=f1;
				this.P=Operation.Plus;
		}
		}else {
			ComplexFunction cf=new ComplexFunction(this.P,this.left,this.right);
			this.left=cf;
			this.right=f1;
			this.P=Operation.Plus;
			}
	/*
		if(f1.toString().equals("0.0"))
			return ;
		if(left.toString().equals("0.0")&&P.toString().equals("None"))
			left=new ComplexFunction(f1.toString());
		else
		if(right.toString().equals("0.0")&&P.toString().equals("None")){
				right=f1;
		}
		else {
			ComplexFunction cf=new ComplexFunction(this.P,left, right);
			left=cf;
			right=f1;
			}
		P=Operation.Plus;
		*/
	}
	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub
		
		if(this.P==Operation.None) {
			
		
		if(this.left.toString().equals("+0.0x^0"))
		{
			this.left=f1;
		this.P=Operation.Times;
		}
		else
			if(right==null)
			{
				right=f1;
				P=Operation.Times;
			}
			if(this.right.toString().equals("+0.0x^0")) 
			{

				this.right=f1;
				this.P=Operation.Times;
			}
		}
		else 
		{
			ComplexFunction cf=new ComplexFunction(this.P,this.left,this.right);
			this.left=cf;
			this.right=f1;
			this.P=Operation.Times;
		}
	}
	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		if(f1.toString().equals("+0.0x^0"))
			throw new RuntimeException("ERR: YOU CAN'T DIVID BY ZERO!!");
		if(this.P==Operation.None) {
		
			if(right==new Polynom("0")){
				right=f1;
				this.P=Operation.Divid;
		}
		}
		else {
			ComplexFunction cf=new ComplexFunction(this.P,left, right);
			left=cf;
			right=f1;
			P=Operation.Divid;
			}
		
	}
	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub
		if (f1==null) {
			return ;
		}

		if(this.P==Operation.None) 
		{
<<<<<<< HEAD:src/Ex1/ComplexFunction.java
				if(this.right.toString().equals("+0.0x^0"))				
				{					
=======
				if(this.right.toString().equals("+0.0x^0"))
				{
>>>>>>> c4a96887ae73f82d3755a5f21ebf3b6461d5661f:src/Ex2/ComplexFunction.java

					this.right=f1;
					this.P=Operation.Max;
					}
		}
		else 
		{
			ComplexFunction cf=new ComplexFunction(this.P,left, right);
			left=cf;
			right=f1;
			P=Operation.Max;
		}	
				
		}
				
	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		if (f1==null) 
		{
			return ;
		}
		if(this.P==Operation.None) 
		{
<<<<<<< HEAD:src/Ex1/ComplexFunction.java

			
			




			if(this.right.toString().equals("+0.0x^0"))
			{
=======
			if(this.right.toString().equals("+0.0x^0"))
			{

>>>>>>> c4a96887ae73f82d3755a5f21ebf3b6461d5661f:src/Ex2/ComplexFunction.java
				this.right=f1;
				this.P=Operation.Min;
		}
	}
			else 
			{
			ComplexFunction cf=new ComplexFunction(this.P,left, right);
			left=cf;
			right=f1;
			P=Operation.Min;
			}	
	}
	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub
		if (f1==null) {
			return ;
		}
		if(this.P==Operation.None) {
			throw new RuntimeException("ERR: cant comp to None Operation ");
		}
		this.left=new ComplexFunction(this.P,this.left,this.right);
		this.right=f1;
		this.P=P.Comp;
	
		
	}

	@Override
	public function left() {
		// TODO Auto-generated method stub
		if(this.left==null) {
			throw new RuntimeException("ERR the left function can't be null : "+this.left);
		}
		return this.left;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return this.right;
	}

	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		return this.P;
	}

		@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.P.toString()+"("+this.left+"," +this.right+")";
	}

	/**
	 * 
	 */
	private int GIO(String s) { // get the index of the char ',' that is in the middle of the complex function
		int c1 = 0, c2=0;
		for(int i=0;i<=s.length()-1;i++) {
			if (s.charAt(i)=='('||s.charAt(i)==')') {
				if(s.charAt(i)=='(') c1+=1;
				else c2+=1;
				
			}
			if(s.charAt(i)==',') {
				if((c1-1)==c2) {
					return i;
				}
			}
		
		}
		return 0;
	}
	public boolean equals(Object obj) {
		String this_func=this.toString();
		String obj_func=obj.toString();
		this_func.replaceAll(" ", "");
		obj_func.replaceAll(" ", "");
		if(this_func.length()!=obj_func.length())
			return false;
		if (obj instanceof ComplexFunction)
		{
			
			for(int i=0;i<20;i++)
			{
				if(Math.abs(((ComplexFunction) obj).f(i)-this.f(i))>0.000001)
					return false;		
			}
		}
		if( obj instanceof function)
		{
			for(int i=0;i<20;i++)
				if(Math.abs(((function) obj).f(i)-this.f(i))>0.000001)
					return false;
		}
		return true;
	}
	/**@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (this.P.toString()+"("+this.left.toString()+"," +this.right.toString()+")");
		
	}*/
	/**@Override
	public String tostring() {
		// TODO Auto-generated method stub
		return (this.P.toString()+"("+this.left.toString()+"," +this.right.toString()+")");
	}*/

}
