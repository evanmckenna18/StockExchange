/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
import java.text.DecimalFormat;
import java.util.PriorityQueue;

public class Stock {
  public static java.text.DecimalFormat money;
  private String symbol,name;
  private double price, high, low, last;
  private volume;
  PriorityQueue buy;
  PriorityQueue sell;
  
  
  public listStock(String symbol, String name, double Price){
    this.symbol = symbol;
    this.name = name;
    this.price = price;
    high = price;
    low = price;
    last = price;
    volume = 0;
    buy = new PriorityQueue(100, new PriceComparator(false));
    sell = new PriorityQueue(100, new PriceComparator());
    
    
  }
  
  public String getQuote(){
    String str = name + " (" + symbol + ")\n" + "Price: " + money.format(last) + " High: " + high + " Low: " + low;
    
  }
  
  public void placeOrder(TradeOrder order){
     String str = "New order:  ";
    if (order.isSell()) {
      str = str + "Sell ";
    } else {
      str = str + "Buy ";
    }
    str = str + this.stockSymbol + " ";
   
    str = str + " (" + this.companyName + ")\n";

    str = str + order.getShares() + " shares";
    if (order.isMarket()) {
      str = str + " at market ";
    } else {
      str = str + " at  " + money.format(order.getPrice());
    }
    order.getTrader().receiveMessage(str);
    if (order.isSell()) {
      this.sellOrders.add(order);
    } else {
      this.buyOrders.add(order);
    }
  }
  executeOrders();
    
  private void executeOrders(){
    while (!(this.buyOrders.isEmpty()) || (!this.sellOrders.isEmpty()))
    {
      TradeOrder sell = (TradeOrder)sellOrders.peek();
      TradeOrder buy = (TradeOrder)buyOrders.peek();
      if ((sell.isLimit()) && (buy.isLimit()) && (sell.getPrice() > buy.getPrice())) {
        break;
      }
      double price;
      if ((sell.isMarket()) && (buy.isMarket()))
      {
        price = this.lastPrice;
      }
        else if ((sell.isMarket()) && (buy.isLimit()))
        {
          price = buy.getPrice();
        }
        else
        {
          price = sell.getPrice();
          }
        }
      }
   int shares = Math.min(buy.getShares(), sell.getShares());
      
      sell.subtractShares(shares);
      buy.subtractShares(shares);
      
      String str = shares + " " + this.stockSymbol + " at " + money.format(price) + " amt " + money.format(price * shares);
      
      buy.getTrader().receiveMessage("You bought: " + str);
      sell.getTrader().receiveMessage("You sold: " + str);
      if (buy.getShares() == 0) {
        this.buyOrders.remove();
      }
      if (sell.getShares() == 0) {
        this.sellOrders.remove();
      }
      this.volume += shares;
      if (price < this.loPrice) {
        this.loPrice = price;
      }
      if (price > this.hiPrice) {
        this.hiPrice = price;
      }
      this.lastPrice = price;
    }
  
  }
    
}
