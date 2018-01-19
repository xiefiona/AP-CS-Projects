public class AmmortTable {
    double myPurchasePrice;
    double myDownPayment;
    double myMonthlyPayment;

    public AmmortTable(){
        myPurchasePrice = myDownPayment = myMonthlyPayment = 0;
    }
    public AmmortTable(double price){
        myPurchasePrice = price;

        //down payment is 10% of price
        myDownPayment = ((int)(10 * price))/100;         //rounds to the hundredth

        //monthly payment is 5% of the remaining money
        myMonthlyPayment = ((int)(5 * (price - myDownPayment)))/100;   //rounds to the hundredth
    }

    public void setMyPurchasePrice(double price){
        myPurchasePrice = price;
    }
    public void setMyDownPayment(double downPayment){
        myDownPayment = downPayment;
    }
    public void setMyMonthlyPayment(double monthlyPayment){
        myMonthlyPayment = monthlyPayment;
    }

    public double getMyPurchasePrice(){
        return myPurchasePrice;
    }
    public double getMyDownPayment(){
        return myDownPayment;
    }
    public double getMyMonthlyPayment(){
        return myMonthlyPayment;
    }

    public String toString(){
        int myMonth = 0;
        double myTotalBalance;
        double myInterest;
        double myPrincipal;
        double myPayment = myMonthlyPayment;
        double myRemainingBalance = myPurchasePrice - myDownPayment;
        String output = "";
        System.out.println("| Month | Total Balance | Interest | Principal   | Payment   | Remaining $   |");

        while(myPayment == myMonthlyPayment){
            myMonth++;
            myTotalBalance = myRemainingBalance;
            myInterest = myTotalBalance/100;
            myPrincipal = myPayment - myInterest;
            myRemainingBalance -= myPrincipal;

            if (myPayment > myTotalBalance){
                myPrincipal = myTotalBalance;
                myPayment = myPrincipal + myInterest;
                myRemainingBalance = 0;
            }

            System.out.printf("| %-5d | $%,12.2f | $%7.2f | $%10.2f | $%8.2f | $%12.2f |%n", myMonth, myTotalBalance, myInterest, myPrincipal, myPayment, myRemainingBalance);
            output += String.format("| %-5d | $%,12.2f | $%7.2f | $%10.2f | $%8.2f | $%12.2f |%n", myMonth, myTotalBalance, myInterest, myPrincipal, myPayment, myRemainingBalance);

        }
        return output;
    }
}