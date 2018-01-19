
public class Emp {
	//information about each student
	String firstname;
	String lastname;
	double hours;		//hours worked
	double rate;			//rate per hour
	double localtax;
	double federaltax;
	int idnum;			//id number
	int numdep;			//number of dependents
	int age;
	double grosspay;		//grosspay
	
	//Default Constructor
	public Emp() {
		firstname="";
		lastname="";
		hours=0;
		rate=0;
		idnum=0;
		numdep=0;
		grosspay=0;
	}
	
	//Sets the variables
	public void setFirstname(String myfirstname) {
		firstname = myfirstname;
	}
	public void setLastname(String mylastname) {
		lastname = mylastname;
	}
	public void setHours(double myhours) {
		hours = myhours;
	}
	public void setRate(double myrate) {
		rate = myrate;
	}
	public void setIDnum(int myidnum) {
		idnum = myidnum;
	}
	public void setNumdep(int mydep) {
		numdep = mydep;
	}
	public void setAge(int myage) {
		age = myage;
	}
	
	//Gets variables
	public String getfirstname() {
		return firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public double gethours() {
		return hours;
	}
	public double getrate() {
		return rate;
	}
	public int getidnum() {
		return idnum;
	}
	public int getnumdep() {
		return numdep;
	}
	public int getage() {
		return age;
	}
	
	//finds grosspay
	public void setGrosspay() {
		if (hours>40) {
			grosspay = (rate * 40) + (rate * (1.5 * (40-hours)) );
		} else {
			grosspay = rate * hours;
		}
	}
	//finds the local tax
	public void setLocaltax() {
		localtax = grosspay * .114;
	}
	//finds the federal tax
	public void setFederaltax() {
		double number;	//how much money you make a year
		number = grosspay * 52;
		
		if (number < 9325) {
			federaltax = number * .25;
		} 
		
		else if(number < 37950) {
			number -= 932.5;
			if (number > 9325) {
				number -= 9325;
				federaltax = number * .15;
				federaltax += 932.5;
			} else {
				federaltax = number + 932.5;
			}
		} 
		
		else if(number < 91900) {
			number -= 5226.25;
			if (number > 37950) {
				number -= 37950;
				federaltax = number * .25;
				federaltax += 5226.25;
			} else {
				federaltax = number + 5226.25;
			}
			
		} else if(number < 191650) {
			number -= 18713.75;
			if (number > 91900) {
				number -= 91900;
				federaltax = number * .28;
				federaltax += 18713.75;
			} else {
				federaltax = number + 18713.75;
			}
			
		} else if(number < 416700) {
			number -= 46643.75;
			if (number > 191650) {
				number -= 191650;
				federaltax = number * .33;
				federaltax += 46643.75;
			} else {
				federaltax = number + 46643.75;
			}
			
		} else if(number < 418400) {
			number -= 120910.25;
			if (number > 416700) {
				number -= 416700;
				federaltax = number * .35;
				federaltax += 120910.25;
			} else {
				federaltax = number + 120910.25;
			}
			
		} else {
			number -= 121505.25;
			if (number > 418400) {
				number -= 418400;
				federaltax = number * .396;
				federaltax += 121505.25;
			} else {
				federaltax = number + 121505.25;
			}
			
		}
	}
	
	//to string
	public String toString() {
		String str;
		str= "\n"+ "Name: "+ lastname + ", " + firstname + "  " + "Hours: " + hours + "  " +
		"Rate: " + rate + "  " + "ID number: " + idnum + "  " + "Grosspay: " + grosspay + "  " +
		"Number of dependents: " + numdep + "  " + "Local tax: " + localtax + "Federal tax: " + federaltax + "Age: " + age;
		System.out.println(str);
		return str;
	}
}
