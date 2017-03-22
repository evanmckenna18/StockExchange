/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
package TradeStuff;

import java.util.LinkedList;
import GeneralStuff.Brokerage;

public class Trader implements Comparable<Trader>{
               
               private String name;
               private String password;
               private Brokerage broker;
               private TraderWindow window;
               private LinkedList<String> mailbox;

               public Trader(Brokerage brokerage, String n, String pw){
                              name = n;
                              password = pw;
                              broker = brokerage;
                              mailbox = new LinkedList<>();
                              window = new TraderWindow(this);
               }
               
               @Override
               public int compareTo(Trader other) {
                              int diff = this.getName().compareToIgnoreCase(other.getName());
                              if(diff != 0){
                                             return diff;
                              }
                              else{
                                             return 0;
                              }
               }
               
               public boolean equals(Object other){
                              if(other!=null){
                                             return name.equals(((Trader)other).getName());
                              }
                              else
                                             return false;
               }
               
               public String getName(){
                              return name;
               }
               
               public String getPassword(){
                              return password;
               }
               
               public void getQuote(String symbol){
                              broker.getQuote(symbol,this);
               }
               
               public boolean hasMessages(){
                              return !mailbox.isEmpty();
               }
               
               public void openWindow(){
                              TraderWindow newWindow = new TraderWindow(this);
                              newWindow.showMessage(mailbox.remove());
               }
               
               public void placeOrder(TradeOrder order){
                              this.placeOrder(order);
               }
               
               public void quit(){
                              broker.logout(this);
                              window = null;
               }
               
               public void receiveMessage(String msg){
                              mailbox.add(msg);
                              
                              if (window != null) {
                                             while (!mailbox.isEmpty()) {
                                                            window.showMessage(mailbox.remove());
                                             }
                              }
               }
               

}
