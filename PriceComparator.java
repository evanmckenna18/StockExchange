/**
 * Created by EvanMcKenna18 on 3/17/2017.
 */
java.util.Comparator<TradeOrder>;

public class PriceComparator implements Comparator<TradeOrder>{
  private boolean ascending;
  
  PriceComparator(){
    ascending = true;
  }
  
  PriceComparator(boolean asc){
    ascending = asc;
  }
  
  public int compare(TradeOrder order1, TradeOrder order2){
    if ( order1.isMarket() && order2.isMarket()){
      return 0;
    }
    if ( order1.isMarket() && order2.isLimit()){
      return -1;
    }
    if ( order1.isLimit() && order2.isMarket()){
      return 1;
    }
    else{
      if ( ascending == true ){
        return (int)( ( order1.getPrice() - order2.getPrice() ) * 100 );
      }
      else {
        return (int)( ( order2.getPrice() - order1.getPrice() ) * 100 );
      }
    }
  }
}
