

import java.util.Map;

public class PricesDisplay implements Observer, DisplayElement {

	private PriceData pricedata;
	Map<String,Double> pMap;
	String ID;
	String[] stocks;
	int displayNum;
	
	public PricesDisplay(String ID,PriceData pricedata) {
		this.ID=ID;
		this.pricedata=pricedata;
		pricedata.registerObserver(this);
		this.displayNum = pricedata.getObserverAmt();
	}
	
	public void setStocks(String[] stocks) {
		this.stocks=stocks;
	}
	@Override
	public void display() {
		System.out.print("\n Portfolio #"+ID);
		for(int i =0; i<stocks.length;i++) {
			System.out.printf(", "+stocks[i]+" = %4.2f", pMap.get(stocks[i]));
		}
		if(displayNum>1)
			System.out.println();
	}

	@Override
	public void update(Map<String, Double> pMap) {
		// TODO Auto-generated method stub
		this.pMap=pMap;
		display();
	}
	

}
