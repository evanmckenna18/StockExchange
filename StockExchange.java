/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
public class StockExchange {
  
  public StockExchange(){
    
    Map<Stock, String> map = new HashMap<Stock, String>();
    
  }
  
  
  //======================================================================================================================================
  
  public String getQuote(String symbol){
    
    //finds the Stock with the symbol and produces a quote for it
    //Format: Name(Symbol) Price: (price)  hi: (price)  lo: (price)  vol: 0
    
    if(map.containsKey(symbol) == true){
     
      for(String symbol2 : map.keySet()){
       
        
        
      }
      
    }
    
  }
  
  
  //======================================================================================================================================
  
  public void listStock(String symbol, String name, double price){
    
    //create a HashMap and put newStock on it
   
    Map<Stock, String> map = new HashMap<Stock, String>();
    
    map.put(newStock, symbol);    
    
    
  }
  
  //======================================================================================================================================
  
  public void placeOrder(TradeOrder order){
    
    stock.placeOrder(order);
    
  }
  
}
