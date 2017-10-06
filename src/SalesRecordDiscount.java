import java.util.Scanner;

public class SalesRecordDiscount {
    /*
    * Jerilyn Mensah
    * October 6 2017
    * This application will allow the user to enter details to produce a sales record
    * and prompt whether they would like to continue.
    * */

    public static void main (String[]args){
        int customerNum;
        double salesAmt, tax=0.00, total, subtotal;
        double discountAmt = 0;
        String name, taxCode;
        String displayDetails;
        String answer = null;
        String applyDiscount;


        Scanner scan = new Scanner(System.in);

        do{

            // Prompt the user to enter Customer ID

            System.out.println("Customer ID:");
            customerNum = scan.nextInt();
            scan.nextLine();

            // Prompt the user to enter a Customer name

            System.out.println("Customer Name:");
            name = scan.nextLine();

            // Prompt the user to enter Sales Amount

            System.out.println("Sales Amount:");
            salesAmt = scan.nextDouble();


            // Prompt the user to enter a Tax Code

            System.out.println("Tax Code:");
            taxCode = scan.next();
            if(!taxCode.equalsIgnoreCase("NRM") && !taxCode.equalsIgnoreCase("NPF") &&!taxCode.equalsIgnoreCase("BIZ")){
                System.out.println("Invalid Entry. Please choose 'NRM', 'NPF' or 'BIZ'");
                taxCode = scan.next();
            }
            scan.nextLine();

            // Find the Subtotal and Total Amount Due

            switch (taxCode.toUpperCase())
            {
                case "NRM": tax = 0.06;
                    break;
                case "NPF": tax = 0.00;
                    break;
                case "BIZ": tax = 0.045;
                    break;
            }

            subtotal = salesAmt * tax;
            total = subtotal + salesAmt;

            System.out.println("Customer ID:" + customerNum);
            System.out.println("Customer Name:" + name);
            System.out.println("Sales Amount: $" + salesAmt);
            System.out.println("Discount: " + discountAmt);
            System.out.println("Tax Code:" + taxCode.toUpperCase());
            System.out.println("Total Amount Due: $" + total);

            System.out.println("Do you want to enter another record?(Y/N)");
            answer=scan.nextLine();
            if(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")){
                System.out.println("Invalid Entry. Please choose Y or N.");
                answer=scan.nextLine();
            }
            if(answer.equalsIgnoreCase("n")){
                System.out.println("Thank you!");
            }

            scan.nextLine();
            System.out.println("");
        }while(!answer.equalsIgnoreCase("n"));
    }

        //Apply discount as needed, over 5000 = 3%, over 10000 = 2%, over 15000 = 1%
    public static double applyDiscount(double salesAmt) {
        if (salesAmt <= 5000) {
            System.out.println("No discount");
            return salesAmt;
        } else if ((salesAmt > 5000) && (salesAmt <= 10000)) {
            System.out.println("1% Discount");
            return salesAmt * (0.97);
        } else if ((salesAmt > 10000) && (salesAmt <= 15000)) {
            System.out.println(" 2% Discount");
            return salesAmt * (0.98);
        } else {
            System.out.println(" 3% Discount");
            return salesAmt * (0.99);
        }

        // Display details of sales record

    }public static void displayDetails(int customerNum, String name, double salesAmt, double discountAmt, String taxCode, double total)

    {
        System.out.println("Customer ID:" + customerNum + "Customer Name:" + name + "Sales Amount: $" + salesAmt +
                "Discount:" + discountAmt + "Tax Code:" + taxCode.toUpperCase() + "Total Amount Due: $" + total);
    }



}

