
import java.util.*;

public class PriceData implements Subject {

	private ArrayList observers;
	private Map<String,Double> pMap;
	
	public PriceData() {
		observers = new ArrayList();
	}
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0)
			observers.remove(i);
	}
	
	public void notifyObservers() {
		for(int i =0; i< observers.size();i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(pMap);
		}
	}
	
	public int getObserverAmt() {
		return observers.size();
	}
	
	public void setPrices(Map<String,Double> pMap) {
		this.pMap=pMap;
		notifyObservers();
	}

}
