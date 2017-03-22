/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
public class TradeOrder {
  private String trader, symbol;
  private boolean buyOrder, marketOrder;
  private int numShares;
  private double price;
  
  public TradeOrder(Trader trader, String symbol,boolean buyOrder, boolean marketOrder, int numShares, double price){
    this.trader = trader;
    this.symbol = symbol;
    this.buyOrder = buyOrder;
    this.marketOrder = marketOrder;
    this.numShares = numShares;
    this.price = price;
  }
  
  public Trader getTrader(){
    return trader;
  }
    public double getPrice(){
    return price;
  }
  public String getSymbol(){
    return symbol;
  }
  public boolean isBuy(){
    return buyOrder;
  }
  public boolean isSell(){
    return !buyOrder;
  }
  public boolean isMarket(){
    return marketOrder;
  }
  public boolean isLimit(){
    return !marketOrder;
  }
  public int getShares(){
    return numShares;
  }
  public void subtractShares(int shares){
    if(shares > getShares()){
     throw new IllegalArgumentException("You don't have that many shares");
    }
    else{
      numShares = getShares() - shares;
    }
  }
    
}
