package Ex1;


public class ComplexFunction implements complex_function {
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
	//String s=fix_op(OP.toString());
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
 private String fix_op(String s)
 {
	 if (s.equals("plus"))
		 return "Plus";
	 if(s.equals("times"))
		 return "Times";
	 if(s.equals("divid"))
		 return "Divid";
	 if(s.equals("none"))
	 	return "None";
	 if(s.equals("min"))
		 return "Min";
	 if(s.equals("max"))
		 return "Max";
	 if (s.equals("comp")) 
		 return "Comp";
	 if(s.equals("error"))
		 return "Error";
	 return this.P.toString();
	
 }
 public ComplexFunction(String s,function f1,function f2)
 {
	 //	String a=fix_op(s);
		switch (s) {
		case "Plus":
			P=Operation.Plus;
			break;
		case "Times":
			P=Operation.Times;
			break;
		case "Divid":
			P=Operation.Divid;
			break;
		case "Max":
			P=Operation.Max;
			break;
		case "Min":
			P=Operation.Min;
			break;
		case "Comp":
			P=Operation.Comp;
			break;
		case "None":
			throw new RuntimeException( "ERR: operation can't be None");
		default:
			throw new RuntimeException("ERR:  you entered iligal Operatin got");	
		}
		left=f1;
		right=f2;
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
			throw new RuntimeException("ERR:  you entered iligal Operatin got");
		default:
			throw new RuntimeException("ERR:  you entered iligal Operatin got");
		}	
	}
	public ComplexFunction(String s)
	{
		ComplexFunction cf =new ComplexFunction();
		cf.initFromString(s);
		this.left=cf.left.copy();
		this.right=cf.right.copy();
		this.P=cf.P;
	}
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		s=s.replace(" ","");
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
			
			
		if(this.left.toString().equals("0.0")) {
			this.left=f1;
		this.P=Operation.Plus;
	}
		else
			if(this.right.toString().equals("0.0")){
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
			
		
		if(this.left.toString().equals("0.0")) {
			this.left=f1;
		this.P=Operation.Times;
	}
		else
			if(this.right.toString().equals("0.0")){
				this.right=f1;
				this.P=Operation.Times;
		}
		}else {
			ComplexFunction cf=new ComplexFunction(this.P,this.left,this.right);
			this.left=cf;
			this.right=f1;
			this.P=Operation.Times;
			}
	
	}
	
	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		if(f1.toString().equals("0.0"))
			throw new RuntimeException("ERR: YOU CAN'T DIVID BY ZERO!!");
		if(f1.toString().equals("1.0"))
			return ;
		
		
			if(right.toString().equals("0.0")&&P.toString().equals("None")){
				right=f1;
				this.P=Operation.Divid;
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
		if(this.P==Operation.None) {
		
			
				if(this.right.toString().equals("0.0")){
					this.right=f1;
					this.P=Operation.Max;
			}
		}
				else {
				ComplexFunction cf=new ComplexFunction(this.P,left, right);
				left=cf;
				right=f1;
				P=Operation.Max;
				}	
				
		}
		

	
	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		if (f1==null) {
			return ;
		}
		if(this.P==Operation.None) {
			
			
			if(this.right.toString().equals("0.0")){
				this.right=f1;
				this.P=Operation.Min;
		}
	}
			else {
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
