import java.util.LinkedList;

public class Trader implements Comparable<Trader>
{
  private Brokerage brokerage;
  private String username;
  private String password;
  private TraderWindow window;
  private LinkedList<String> mailbox;

  public Trader(Brokerage brokerage, String name, String password)
  {
    this.brokerage = brokerage;
    this.username = name;
    this.password = password;
    this.mailbox = new LinkedList();
  }

  public String getName()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public int compareTo(Trader other)
  {
    return username.compareToIgnoreCase(other.getName());
  }

  public boolean equals(Object other)
  {
    return username.equalsIgnoreCase(((Trader)other).getName());
  }

  public void openWindow()
  {
    window = new TraderWindow(this);
    while (!this.mailbox.isEmpty()) {
      window.showMessage(mailbox.remove());
    }
  }

  public boolean hasMessages()
  {
    return !this.mailbox.isEmpty();
  }

  public void receiveMessage(String msg)
  {
    this.mailbox.add(msg);
    if (window != null) {
      while (!this.mailbox.isEmpty()) {
        window.showMessage(mailbox.remove());
      }
    }
  }

  public void getQuote(String symbol)
  {
    brokerage.getQuote(symbol, this);
  }

  public void placeOrder(TradeOrder order)
  {
    brokerage.placeOrder(order);
  }

  public void quit()
  {
    window = null;
    brokerage.logout(this);
  }
}
