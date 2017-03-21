/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
public class Stock {
  public static java.text.DecimalFormat money;
  private String symbol,name;
  private double price, high, low, last;
  private volume;
  PriorityQueue buy;
  PriceComparator
  PriorityQueue sell;
  
  
  public Stock(String symbol, String name, double Price){
    this.symbol = symbol;
    this.name = name;
    this.price = price;
    high = price;
    low = price;
    last = price;
    volume = 0;
    
  }
  
  public String getQuote(){
    
  }
  
  public void placeOrder(TradeOrder order){
    
  }
    
}
