package Ex1;


public class ComplexFunction implements complex_function {
private function left;
private function right;
private Operation P;

 public ComplexFunction() {
	// TODO Auto-generated constructor stub
	this.right=new Polynom("0");
	this.left=null;
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
		throw new RuntimeException( "ERR: operation can't be None"+null);
	default:
		throw new RuntimeException("ERR:  you entered iligal Operatin. got"+OP);
		
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
		}
		return 0;
	}

	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return null;
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
		if (f1==null) {
			return ;
		}
		this.left=new ComplexFunction(this.P,this.left,this.right);
		this.right=f1;
		this.P=P.Plus;
	}

	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub
		if (f1==null) {
			return ;
		}
		this.left=new ComplexFunction(this.P,this.left,this.right);
		this.right=f1;
		this.P=P.Times;
		
	}
	

	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		if (f1==null) {
			return ;
		}
		this.left=new ComplexFunction(this.P,this.left,this.right);
		this.right=f1;
		this.P=P.Divid;
		
	
	
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
			throw new RuntimeException("ERR the left function can't be nuull : "+this.left);
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

	/**
	 * 
	 */
	

}
