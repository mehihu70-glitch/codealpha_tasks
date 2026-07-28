public class User {
    private double balance;
    private Portfolio portfolio;

    public User(double balance){
        this.balance = balance;
        this.portfolio = new Portfolio();
    }

    public double getBalance(){ return balance; }
    public Portfolio getPortfolio(){ return portfolio; }

    public boolean buyStock(Stock stock,int qty){
        double cost = stock.getPrice()*qty;
        if(cost>balance) return false;
        balance -= cost;
        portfolio.buy(stock.getSymbol(),qty);
        return true;
    }

    public void sellStock(Stock stock,int qty){
        portfolio.sell(stock.getSymbol(),qty);
        balance += stock.getPrice()*qty;
    }
}
