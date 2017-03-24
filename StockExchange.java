import java.util.HashMap;
import java.util.Map;

/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */

/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own.  Signed: Rebecca Michaud
 * @author Michaudr
 * Date of Completion: 3/24/17
 * Assignment: Stock Exchange Group Project - StockExchange
 * 				Eclipse
 * 
 * Attribution: Include group members or helpers that assisted you in completing your work. (Required)
 * Rebecca Michaud, Tanner Hess, Evan McKenna
 *
 * General Description:   Include purpose of the code, special uses of this code,  list of accomplished features.
 *
 * Works with the StockExchange class to list stocks, get quotes, and place orders.
 *
 **/


 

public class StockExchange {
  
   Map<String, Stock> map;
  
  public StockExchange(){
    
   map = new HashMap(1000);
    
  }
  
  
  //======================================================================================================================================
  
  /**
   * Gets the quote from a stock within the map in the class 
   * Returns the quote from the stock who's symbol is given
   **/
  
  public String getQuote(String symbol){
    
    String ret = "";
    
    if(map.containsKey(symbol) == true){
        Stock stockRet = map.get(symbol);  //??
          
        ret = stockRet.getQuote();
    }
      


       return ret;
       
  }
  
  
  //======================================================================================================================================
  
  /**
  * Adds a new stock to the map
  **/
  
  public void listStock(String symbol, String name, double price){
    
    //create a HashMap and put newStock on it
    
    Stock newStock = new Stock(symbol, name, price);
    
    map.put(symbol, newStock);
    
    
  }
  
  //======================================================================================================================================
  
  /**
  * places a stock order in the stock from the symbol given in the TradeOrder
  **/
  
  public void placeOrder(TradeOrder order){
    
    String stockSymbol = order.getSymbol();
    
    map.get(stockSymbol).placeOrder(order);
    
    //check if it's a buy or sell order?
    
    
  }
  
}
