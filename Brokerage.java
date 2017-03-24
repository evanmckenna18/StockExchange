
/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own.  Signed: Rebecca Michaud
 * @author Michaudr
 * Date of Completion: 3/24/17
 * Assignment: Stock Exchange Group Project - Brokerage
 * 				Eclipse
 * 
 * Attribution: Include group members or helpers that assisted you in completing your work. (Required)
 * Rebecca Michaud, Tanner Hess, Evan McKenna
 *
 * General Description:   Include purpose of the code, special uses of this code,  list of accomplished features.
 *
 * Works with the login/logout process taken from Login, then gets orders and quotes
 *
 */

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Brokerage
        implements Login
{
  private Map<String, Trader> traders;
  private Set<Trader> loggedTraders;
  private StockExchange exchange;

  //=============================================================================================================================

  public Brokerage(StockExchange exchange)
  {
    this.traders = new TreeMap();
    this.loggedTraders = new TreeSet();
    this.exchange = exchange;
  }
  
  //=============================================================================================================================
  
  /**
  * addUser adds a username and login to the map of users
  * return - Returns a value based on how addUser works:
  * 0 if it all works
  *-1 if the username is the wrong length
  *-2 if the password is the wrong length
  *-3 if the trader is already a user in the Map
  **/

  public int addUser(String name, String password)
  {
    int len = name.length();
    if ((len < 4) || (len > 10)) {
      return -1;
    }
    len = password.length();
    if ((len < 2) || (len > 10)) {
      return -2;
    }
    if (this.traders.containsKey(name)) {
      return -3;
    }
    Trader trader = new Trader(this, name, password);
    this.traders.put(name, trader);
    return 0;
  }
  
  //=============================================================================================================================

/**
* Logs a user into the brokerage system.
* Returns an int based on the error codes:
* 0 - everything is successful
*-1 - Trader username is not in the system
*-2 - Username isn't correct
*-3 -  the user is already logged in
**/

  public int login(String name, String password)
  {
    Trader trader = (Trader)this.traders.get(name);
    if (trader == null) {
      return -1;
    }
    String storedPassword = trader.getPassword();
    if (!storedPassword.equals(password)) {
      return -2;
    }
    if (this.loggedTraders.contains(trader)) {
      return -3;
    }
    if (!trader.hasMessages()) {
      trader.receiveMessage("Welcome to SafeTrade!");
    }
    trader.openWindow();

    this.loggedTraders.add(trader);
    return 0;
  }
  
  //=============================================================================================================================

  /**
  *Takes the user/trader in question out of the map, then gives them the message that they are logged out.
  **/

  public void logout(Trader trader)
  {
    this.loggedTraders.remove(trader);
  }

  public void getQuote(String symbol, Trader trader)
  {
    trader.receiveMessage(this.exchange.getQuote(symbol));
  }
  
  //=============================================================================================================================

 /**
 *Places an order in the StockExchange program
 **/

  public void placeOrder(TradeOrder order)
  {
    this.exchange.placeOrder(order);
  }
}
