import java.text.DecimalFormat;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("#0.00");

        //Constants
        final int TIP_MAXIMUM = 50;
        final double TIP_PERCENTAGE = .15;

        //Worker Variables
        double total = 0;
        System.out.print("Please enter bill amount to calculate your tip, or 0 if finished: ");
        double billAmount = input.nextDouble();
        double greedFee;
        double tipAmount;
        if(billAmount == 0)
        {
            System.out.println("Slow day, huh?");
            return;
        }
        while(billAmount != 0)
        {
            tipAmount = billAmount * TIP_PERCENTAGE;
            total += tipAmount;
            System.out.println("You entered $" + billAmount + " giving you a tip of $" + moneyFormat.format(tipAmount));
            System.out.println("Your current total in tips is $" + moneyFormat.format(total));
            System.out.print("Please enter bill amount to calculate your tip, or 0 if finished: ");
            billAmount = input.nextDouble();
        }
        input.close();
        if(total > TIP_MAXIMUM)
        {
            greedFee = total - TIP_MAXIMUM;
            System.out.println("You've exceeded your tip limit for the day, $" + moneyFormat.format(greedFee) + " went to the restaurant owner.");
            System.out.println("You made $" + TIP_MAXIMUM + " in tips today.");
        }
        else
            System.out.println("You made $" + moneyFormat.format(total) + " in tips today.");
    }
}
