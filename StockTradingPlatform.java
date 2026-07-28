import java.util.*;

public class StockTradingPlatform{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        Stock[] market={
            new Stock("TCS",3500),
            new Stock("INFY",1600),
            new Stock("RELIANCE",2800),
            new Stock("HDFC",1800),
            new Stock("ITC",450)
        };

        User user=new User(100000);

        while(true){
            System.out.println("\n==== STOCK TRADING PLATFORM ====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Balance");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int ch=sc.nextInt();

            switch(ch){
                case 1:
                    for(int i=0;i<market.length;i++)
                        System.out.println((i+1)+". "+market[i].getSymbol()+" - ₹"+market[i].getPrice());
                    break;
                case 2:
                    System.out.print("Enter Stock Number: ");
                    int b=sc.nextInt()-1;
                    System.out.print("Quantity: ");
                    int q=sc.nextInt();
                    if(user.buyStock(market[b],q))
                        System.out.println("Stock Purchased!");
                    else
                        System.out.println("Insufficient Balance!");
                    break;
                case 3:
                    System.out.print("Enter Stock Number: ");
                    int s=sc.nextInt()-1;
                    System.out.print("Quantity: ");
                    int sq=sc.nextInt();
                    user.sellStock(market[s],sq);
                    System.out.println("Stock Sold!");
                    break;
                case 4:
                    user.getPortfolio().display();
                    break;
                case 5:
                    System.out.println("Balance: ₹"+user.getBalance());
                    break;
                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
