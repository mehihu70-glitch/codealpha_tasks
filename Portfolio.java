import java.util.*;

public class Portfolio {
    private Map<String,Integer> holdings = new HashMap<>();

    public void buy(String symbol,int qty){
        holdings.put(symbol, holdings.getOrDefault(symbol,0)+qty);
    }

    public void sell(String symbol,int qty){
        if(!holdings.containsKey(symbol)) return;
        int left = holdings.get(symbol)-qty;
        if(left<=0) holdings.remove(symbol);
        else holdings.put(symbol,left);
    }

    public void display(){
        System.out.println("\nPortfolio:");
        if(holdings.isEmpty()){
            System.out.println("No Stocks Owned.");
            return;
        }
        for(String s: holdings.keySet()){
            System.out.println(s+" : "+holdings.get(s)+" shares");
        }
    }
}
