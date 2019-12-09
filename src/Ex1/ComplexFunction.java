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
		return null;
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
		
	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public function left() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return null;
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
