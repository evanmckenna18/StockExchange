/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
import java.text.DecimalFormat;
import java.util.PriorityQueue;

public class Stock {
  public static java.text.DecimalFormat money = new DecimalFormat("$0,000,000,000.00");
  private String symbol,name;
  private double price, high, low, last;
  private int volume;
  private PriorityQueue<TradeOrder> buy;
  private PriorityQueue<TradeOrder> sell;
  
  
  
  public Stock(String symbol, String name, double price){
    this.symbol = symbol;
    this.name = name;
    this.price = price;
    high = price;
    low = price;
    last = price;
    volume = 0;
    buy = new PriorityQueue(1000,new PriceComparator(false));
    sell = new PriorityQueue(1000,new PriceComparator());
    
    
  }
  
  public String getQuote(){
    String str = name + " (" + symbol + ")\n" + "Price: " + money.format(last) + " High: " + high + " Low: " + low + " Ask: " + sell.peek() + " Size: "
      + sell.size() + " Bid: " + buy.peek() + " Size: " + buy.size();
    
  }
  
  public void placeOrder(TradeOrder order){
     String str = "New order:  ";
    if (order.isSell()) {
      str = str + "Sell ";
    } else {
      str = str + "Buy ";
    }
    str = str + this.symbol +  "(" + this.name + ")\n";
    
    str = str + order.getShares() + " shares";
    if (order.isMarket()) {
      str = str + " at market ";
    } else {
      str = str + " at  " + money.format(order.getPrice());
    }
    order.getTrader().receiveMessage(str);
    if (order.isSell()) {
      this.sell.add(order);
    } else {
      this.buy.add(order);
    }
    executeOrders();
  }
  
    
  private void executeOrders(){
    while (!(this.buyOrders.isEmpty()) || (!this.sellOrders.isEmpty()))
    {
      TradeOrder s = (TradeOrder)sellOrders.peek();
      TradeOrder b = (TradeOrder)buyOrders.peek();
      if ((s.isLimit()) && (b.isLimit()) && (s.getPrice() > b.getPrice())) {
        break;
      }
      double price;
      if ((s.isMarket()) && (b.isMarket()))
      {
        price = this.lastPrice;
      }
        else if ((s.isMarket()) && (b.isLimit()))
        {
          price = b.getPrice();
        }
        else
        {
          price = s.getPrice();
          }
        }
      }
   int shares = Math.min(b.getShares(), s.getShares());
      
      s.subtractShares(shares);
      b.subtractShares(shares);
      
      String str = shares + " shares of " + this.stockSymbol + " at " + money.format(price) + " for " + money.format(price * shares) + " in total";
      
      b.getTrader().receiveMessage("You bought: " + str);
      s.getTrader().receiveMessage("You sold: " + str);
      if (b.getShares() == 0) {
        this.buy.remove();
      }
      if (s.getShares() == 0) {
        this.sell.remove();
      }
      this.volume += shares;
      if (price < this.low) {
        this.low = price;
      }
      if (price > this.high) {
        this.high = price;
      }
      this.last = price;
    }
  
  }
    
}
