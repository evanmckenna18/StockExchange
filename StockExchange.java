import java.util.HashMap;
import java.util.Map;

/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */


public class StockExchange {
  
   Map<String, Stock> map;
  
  public StockExchange(){
    
   map = new HashMap(1000);
    
  }
  
  
  //======================================================================================================================================
  
  public String getQuote(String symbol){
    
    String ret = "";
    //finds the Stock with the symbol and produces a quote for it
    //Format: Name(Symbol) Price: (price)  hi: (price)  lo: (price)  vol: 0
    
    if(map.containsKey(symbol) == true){
        Stock stockRet = map.get(symbol);  //??
          
        ret = stockRet.getQuote();
    }
      


       return ret;
       
  }
  
  
  //======================================================================================================================================
  
  public void listStock(String symbol, String name, double price){
    
    //create a HashMap and put newStock on it
    
    Stock newStock = new Stock(symbol, name, price);
    
    map.put(symbol, newStock);
    
    
  }
  
  //======================================================================================================================================
  
  public void placeOrder(TradeOrder order){
    
    String stockSymbol = order.getSymbol();
    
    map.get(stockSymbol).placeOrder(order);
    
    //check if it's a buy or sell order?
    
    
  }
  
}
