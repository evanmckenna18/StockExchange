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

  public Brokerage(StockExchange exchange)
  {
    this.traders = new TreeMap();
    this.loggedTraders = new TreeSet();
    this.exchange = exchange;
  }

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

  public void logout(Trader trader)
  {
    this.loggedTraders.remove(trader);
  }

  public void getQuote(String symbol, Trader trader)
  {
    trader.receiveMessage(this.exchange.getQuote(symbol));
  }

  public void placeOrder(TradeOrder order)
  {
    this.exchange.placeOrder(order);
  }
}
