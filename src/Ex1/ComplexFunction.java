package Ex1;

public class ComplexFunction implements complex_function {
function left;
function right;
Operation P;
 public ComplexFunction() {
	// TODO Auto-generated constructor stub
	this.right=null;
	this.left=null;

}
 public ComplexFunction(Operation P,function f1,function f2) {
this.P=P;
this.left=f1;
this.right=f2;
 }
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		
		
		switch (this.P) {
		case Plus:
			
			if (this.left instanceof Polynom || this.left instanceof Polynom_able) {
				if(this.right instanceof Monom) {
					
					Polynom_able PO=(Polynom_able) this.left;
					Monom m= (Monom) this.right;
					PO.add(m);
					
				}
	if(this.right instanceof Polynom || this.right instanceof Polynom_able) {
					
					Polynom_able PO=(Polynom_able) this.left;
					Polynom_able m= (Polynom_able) this.right;
					PO.add(m);
					
				}
			}
			if(this.left instanceof Monom) {
				if (this.right instanceof Polynom || this.right instanceof Polynom_able) {
					Polynom_able PO=(Polynom_able) this.right;
					Monom m= (Monom) this.left;
					PO.add(m);
				}
				if(this.right instanceof Monom) {
					Monom m=(Monom) this.left;
					Monom n=(Monom) this.right;
					m.add(n);
				}
			}
			break;

		default:
			break;
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
