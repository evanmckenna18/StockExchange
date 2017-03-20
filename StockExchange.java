/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
public class StockExchange {
  
  public StockExchange(){
    
  }
  
  
  //======================================================================================================================================
  
  public String getQuote(String symbol){
    
  }
  
  
  //======================================================================================================================================
  
  public void listStock(String symbol, String name, double price){
    
    //create a HashMap and put newStock on it
   
    Map<Stock, String> map = new HashMap<Stock, String>();
    
    Stock newStock = new Stock(symbol, name, price);
    
    map.put(newStock, symbol);    
    
    
  }
  
  //======================================================================================================================================
  
  public void placeOrder(TradeOrder order){
    
    stock.placeOrder(order);
    
  }
  
}
