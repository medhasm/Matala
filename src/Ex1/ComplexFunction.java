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
	 this.left=f1;
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
 public ComplexFunction(String s,function f1,function f2) {
		switch (s) {
		case "Plus":
			P=P.Plus;
			break;
		case "Times":
			P=P.Times;
			break;
		case "Divid":
			P=P.Divid;
			break;
		case "Max":
			P=P.Max;
			break;
		case "Min":
			P=P.Min;
			break;
		case "Comp":
			P=P.Comp;
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
		left=cf.left;
		right=cf.right;
		P=cf.P;
	}
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		s=s.replace(" ", "");
		int git;
		ComplexFunction cf=new ComplexFunction();
		
		function f1,f2;
	
		char c=',';
			if(s.contains(",")) {
				git=this.GIO(s);
				f1=cf.initFromString(s.substring(s.indexOf('(')+1, git));
				f2=cf.initFromString(s.substring(git+1 ,s.length()));
				if(s.equals(",(")||s.equals("),")) {
					if(s.equals(",(")) {
						throw new RuntimeException("Err:left function cant be null"); 			
						}else {
							f2=new Polynom("0");
					}
				}
				 cf=new ComplexFunction(s.substring(0, s.indexOf('(')),f1,f2);
			}
		
		return cf;
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
		if(f1.toString().equals("0.0"))
			return ;
		if(left.toString().equals("0")&&P.toString().equals("None"))
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
	}
	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub
		if(f1.toString().equals("1.0"))
			return ;
		if(this.left.toString().equals("0")&&this.P.toString().equals("None"))
			this.left=new ComplexFunction(f1.toString());
		else

			if(this.right.toString().equals("0.0")&&this.P.toString().equals("None")){
				this.right=f1;
		}
		else {
			ComplexFunction cf=new ComplexFunction(this.P,this.left,this.right);
			this.left=cf;
			this.right=f1;
			}
		P=Operation.Times;
	}
	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		if(f1.toString().equals("0.0"))
			throw new RuntimeException("ERR: YOU CAN'T DIVID BY ZERO!!");
		if(f1.toString().equals("1.0"))
			return ;
		if(left.toString().equals("0")&&P.toString().equals("None"))
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
		P=Operation.Divid;
	}
	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub
		if (f1==null) {
			return ;
		}
		this.left=new ComplexFunction(this.P,this.left,this.right);
		this.right=f1;
		this.P=P.Max;
	}
	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		if (f1==null) {
			return ;
		}
		this.left=new ComplexFunction(this.P,this.left,this.right);
		this.right=f1;
		this.P=P.Min;
	}
	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub
		if (f1==null) {
			return ;
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
	public String tostring()
	{
		return "2";//P.toString()+"("+left.toString()+","+right.toString()+")";
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
	
}
