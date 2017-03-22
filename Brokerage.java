/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
public class Brokerage implements Login {
  
  Map<String, String> map = new TreeMap<String, String>();
  
  public Brokerage(StockExchange exchange){
    
  }
  
  
  //===============================================================================================================================
  
  public int addUser(String name, String password){
    
    map.put(name, password);
    
    if(map.containsKey(name) == true){
      
      return -3;
      
    } else if(name.length() < 4 || name.length() > 10){
      
      return -1;
      
    } else if(password.length() < 2 || password.length() > 10){
      
      return -2;
      
    } else {
      
      map.put(name, password);
      return 0;
      
    }
    
  }
  
  //===============================================================================================================================
  
  public void getQuote(String symbol, Trader trader){
    
  }
 
  //===============================================================================================================================
  
  public int login(Trader trader){
    
  }
  
  //===============================================================================================================================
  
  public void placeOrder(TradeOrder order){
    
  }
 

  //===============================================================================================================================

 public void logout(Trader trader){
   
   
   
}
