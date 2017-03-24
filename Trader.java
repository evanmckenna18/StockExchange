/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own.  Signed: Tanner Hess
 * @author Hesst
 * Date of Completion: 3/24/17
 * Assignment: Stock Exchange Group Project - Trader
 * Attribution: Include group members or helpers that assisted you in completing your work. (Required)
 * Rebecca Michaud, Tanner Hess, Evan McKenna
 * General Description: trader class to be used in the project Safe Trade
 * calles brokerage's methods and makes them more accesable to other classes
 */
import java.util.LinkedList;

public class Trader implements Comparable<Trader>
{
//declare fields
  private Brokerage brokerage;
  private String username;
  private String password;
  private TraderWindow window;
  private LinkedList<String> mailbox;

//=============================================================================================================================

/*
basic constructor for a trader. affiliated with an inputted brokerage 
has a username and a password
*/
  public Trader(Brokerage brokerage, String name, String password)
  {
    this.brokerage = brokerage;
    this.username = name;
    this.password = password;
    this.mailbox = new LinkedList();
  }
  
 //=============================================================================================================================

/**
*returns the screen name for this trader
**/
  public String getName()
  {
    return username;
  }
  
  //=============================================================================================================================

/**
*returns the password for this trader
**/
  public String getPassword()
  {
    return password;
  }
  
  //=============================================================================================================================

/**
*compares this trader to another trader by comparing their screen names case blind
* parameters: other - reference to the other trader being compared
* returns: the result of the comparison 
**/
  public int compareTo(Trader other)
  {
    return username.compareToIgnoreCase(other.getName());
  }
  
  //=============================================================================================================================

/**
*Indicates whether some other trader is "equal to" this one, based on comparing their screen names case blind. 
*This method will throw a ClassCastException if other is not an instance of Trader.
* parameters: other- the reference to the other object being compared
* returns: true if the trader's screen name is the same as the other trader's screen name, false otherwise
**/
  public boolean equals(Object other)
  {
    return username.equalsIgnoreCase(((Trader)other).getName());
  }
  
  //=============================================================================================================================
 
 /**
 *Creates a new TraderWindow for this trader and saves a reference to it in myWindow. 
 * Removes and displays all the messages, if any, from this trader's mailbox by calling myWindow.show(msg) for each message.
 **/
  public void openWindow()
  {
    window = new TraderWindow(this);
    while (!this.mailbox.isEmpty()) {
      window.showMessage(mailbox.remove());
    }
  }
  
  //=============================================================================================================================

  /**
  *returns true if this trader has any messages in its mailbox
  * returns- true if the trader has messages, false otherwise
  **/
  public boolean hasMessages()
  {
    return !this.mailbox.isEmpty();
  }
  
  //=============================================================================================================================
 
  /**
  *Adds msg to this trader's mailbox and displays all messages.
  * If this trader is logged in (myWindow is not null) removes and shows all the messages in the mailbox by calling myWindow.showMessage(msg) 
  * for each msg in the mailbox.
  * parameters: msg- a message to be added to this trader's mailbox
  **/
  public void receiveMessage(String msg)
  {
    this.mailbox.add(msg);
    if (window != null) {
      while (!this.mailbox.isEmpty()) {
        window.showMessage(mailbox.remove());
      }
    }
  }

  //=============================================================================================================================
 
 /**
  *requests a quote for a given stock symbol by calling brokerage's getQuote
  * parameters: symbol- a stock symbol for which a quote is requested
  **/
  public void getQuote(String symbol)
  {
    brokerage.getQuote(symbol, this);
  }

  //=============================================================================================================================
  
  /**
  *places a given order with the brokerage by calling brokerage's placeOrder
  *parameters: order- a trading order to be placed
  **/
  public void placeOrder(TradeOrder order)
  {
    brokerage.placeOrder(order);
  }

  //=============================================================================================================================
  
  /**
  *Logs out this trader. Calls brokerage's logout for this trader. 
  *Sets myWindow to null (this method is called from a TraderWindow's window listener when the "close window" button is clicked).
  **/
  public void quit()
  {
    window = null;
    brokerage.logout(this);
  }
}
