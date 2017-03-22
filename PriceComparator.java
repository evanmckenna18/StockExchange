/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
java.util.Comparator<TradeOrder>;

public class PriceComparator implements Comparator<TradeOrder>{
  private boolean ascendingFlag;
  
  PriceComparator(){
    ascendingFlag = true;
  }
  
  PriceComparator(boolean asc){
    ascendingFlag = asc;
  }
  public int compare(TradeOrder order1, TradeOrder order2){
  }
}
