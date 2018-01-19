
public class ComplexNum {

	double real;
	double imaginary;
	
	public ComplexNum() {	//default constructor
		real = 0;
		imaginary = 0;
	}
	public ComplexNum(double myreal, double myimaginary) {		//fill constructor
		real = myreal;
		imaginary = myimaginary;
	}
	public ComplexNum(String ri) {		//string constructor
		int bl = 0, bp = 0;
	       if (ri.substring(0, 1).equals("-")) {
	           bp = 1;
	       }
	       for (int i = 0; i < ri.length(); i++) {
	           if (ri.substring(i, i+1).equals("+")) {
	               if (ri.substring(++i, i+1).equals("-")) {
	                   real = Double.parseDouble(ri.substring(bp, bl));
	                   imaginary = Double.parseDouble(ri.substring(++i, ri.length() - 1));
	                   imaginary *= -1;
	               }
	               else {
	                   real = Double.parseDouble(ri.substring(bp, bl));
	                   imaginary = Double.parseDouble(ri.substring(i, ri.length() - 1));
	               }
	               if (bp == 1) {
	                   real *= -1;
	               }
	               break;
	           }
	           else if (ri.substring(i, i+1).equals("-") && i != 0) {
	               if (ri.substring(++i, i+1).equals("-")) {
	                   real = Double.parseDouble(ri.substring(bp, bl));
	                   imaginary = Double.parseDouble(ri.substring(++i, ri.length() - 1));
	               }
	               else {
	                   real = Double.parseDouble(ri.substring(bp, bl));
	                   imaginary = Double.parseDouble(ri.substring(i, ri.length() - 1));
	                   imaginary *= -1;
	               }
	               if (bp == 1) {
	                   real *= -1;
	               }
	               break;
	           }
	           bl++;
	       }
	}
	
	public void setreal(double r) {
		real = r;
	}
	public void setimaginary(double i) {
		imaginary = i;
	}
	public double getreal() {
		return real;
	}
	public double getimaginary() {
		return imaginary;
	}
	
	public ComplexNum addNum(ComplexNum num) {		//adds two complex numbers
		return new ComplexNum((real + num.real),(imaginary + num.imaginary));
	}
	public ComplexNum subtractNum(ComplexNum num) {	//subtracts two complex numbers
		return new ComplexNum((real - num.real),(imaginary - num.imaginary));
	}
	public ComplexNum multiplyNum(ComplexNum num) {	//multiplies two complex numbers
		double tempReal;
		double tempImag;
		
		tempReal = num.real * real;
		tempReal = tempReal - (imaginary * num.imaginary);
		tempImag = (imaginary * num.real) + (num.imaginary * real);
		
		return new ComplexNum(tempReal, tempImag);
	}
	public ComplexNum divideNum(ComplexNum num) {
		ComplexNum Result = new ComplexNum();
	       Result.setreal(Round(((real * num.getreal()) + (imaginary * num.getimaginary())) / (Math.pow(num.getreal(), 2) + Math.pow(num.getimaginary(), 2))));
	       Result.setimaginary(Round(((num.getreal() * imaginary) - (real * num.getimaginary())) / (Math.pow(num.getreal(), 2) + Math.pow(num.getimaginary(), 2))));
	       return Result;
	}
	public ComplexNum powers(double n) {
	   ComplexNum Temp = this;
	   for (int i = 0; i < n - 1; i++) {
	       Temp = Temp.multiplyNum(this);
	   }
	   return Temp;
	}
	public ComplexNum roots() {
		double r,i;
	       i = r = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
	       r = (r + real) / 2;
	       r = Math.round(Math.sqrt(r) * 100.0) / 100.0;
	       i -= real;
	       i /= 2;
	       i = Math.round(Math.sqrt(i) * 100.0)/100.0;
	       if (imaginary < 0) {
	           i *= -1;
	       }
	       return new ComplexNum(Round(r),Round(i));
	}
	private double Round(double d) {
		return Math.round(d * 100.0) / 100.0;
	}
	public String toString() {
		String Output = "";
		System.out.println(imaginary);
		if (real != 0) {
		    Output += real;
		    if (imaginary >= 0) {
		        Output += "+";
		    }
		}
		if (imaginary != -1 && imaginary != 1 && imaginary != 0) {
		   Output += imaginary;
		}
		if (imaginary != 0) {
		   Output += "i";
		}
		return Output;
	}
}
