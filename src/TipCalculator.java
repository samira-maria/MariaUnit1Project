import java.util.Scanner;
import java.util.ArrayList;

public class TipCalculator {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator!");

        System.out.print("How many people are in your group: ");
        int peopleInGroup = scan.nextInt();

        System.out.print("What's the tip percentage? (0-100): ");
        int tipPercentage = scan.nextInt();

        double cost = 0.00;
        double itemCost = 0.00;
        int numOfItems = 0;
        final double END = -1.00;

        ArrayList<String> items = new ArrayList<>();
        while (itemCost != END){
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            itemCost = scan.nextDouble();
            if (itemCost != END) {
                cost += itemCost;
                System.out.print("Enter the item: ");
                scan.nextLine();
                String item = scan.nextLine();
                items.add(item);
            }
        }

        double totalTip = Math.round(cost * (tipPercentage / 100.00) * 100) /100.00;
        double totalBillWithTip = Math.round((totalTip + cost)*100.00)/100.00;
        double perPeronBeforeTip = Math.round((cost/peopleInGroup)*100.00)/100.00;
        double tipPerPerson = Math.round((totalTip/peopleInGroup)*100.00)/100.00;
        double totalCostPerPerson = Math.round((tipPerPerson + perPeronBeforeTip)*100.00)/100.00;

        System.out.println("------------------------------");
        System.out.println("Total bill before tip: $" + cost);
        System.out.println("Total percentage: " + tipPercentage + "%");
        System.out.println("Total tip: $" + totalTip);
        System.out.println("Total bill with tip: $" + totalBillWithTip);
        System.out.println("Per person cost before tip: $" + perPeronBeforeTip);
        System.out.println("Tip per person: $" + tipPerPerson);
        System.out.println("Total cost per person: $" + totalCostPerPerson);
        System.out.println("------------------------------");
        System.out.println("Items ordered:");

        for (String item : items) {
            System.out.println(item);
        }

        System.out.print("How much money did you give?: $");
        double moneyGiven = scan.nextDouble();
        moneyGiven = Math.round(moneyGiven/ 100.00) * 100.00;

        double change = Math.round((totalBillWithTip - moneyGiven)/100.00)*100.00 ;
        System.out.println("Change: $" + change);

        double changePerPerson= Math.round((change/peopleInGroup)/100.00)*100.00;
        System.out.println("If you want to split the change each person will receive: $" + changePerPerson);
    }
}