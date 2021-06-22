import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


class Main {

	private static Map<String, Integer> stats = new HashMap<>();
	private static String[] window = new String[3]; 
	private static BigInteger counter = BigInteger.ZERO;

	public static void main(String[] args) {

		Main main = new Main();

	
		main.add("A");
		main.print();
		main.add("B");
		main.print();
		main.add("B");
		main.print();
		main.add("C");
		main.print();
		main.add("A");
		main.print();

	
/*	
		main.add("A");
		main.print();
		main.add("A");
		main.print();
		main.add("B");
		main.print();
		main.add("A");
		main.print();
		main.add("A");
		main.print();
		main.add("C");
		main.print();
*/
		
/*		
		main.add("A");
		main.print();
		main.add("B");
		main.print();
		main.add("C");
		main.print();
		main.add("A");
		main.print();
		main.add("B");
		main.print();
		main.add("C");
		main.print();
		main.add("B");
		main.print();
		main.add("B");
		main.print();
		main.add("B");
		main.print();
*/
	
/*		
		main.add("B");
		main.print();
		main.add("B");
		main.print();
		main.add("B");
		main.print();
		main.add("B");
		main.print();
		main.add("B");
		main.print();
		main.add("B");
		main.print();
		main.add("B");
		main.print();
		main.add("C");
		main.print();
		main.add("B");
		main.print();
		main.add("D");
		main.print();
		main.add("K");
		main.print();
*/	
	}

	public void print() {

		Map<String, Integer> sortedMapReverseOrder = stats.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(sortedMapReverseOrder);
	}


	private static void add(String item) {
		BigInteger position = BigInteger.ZERO;
		
		if (0 <= counter.intValue() && counter.intValue() < window.length) { //the very first iteration over window length
			position = counter;
		} else {									   //all the other iterations over window length
			position = BigInteger.valueOf(counter.intValue() % window.length);
			
			//update statistics
			String keyToReplace = window[position.intValue()];
			Integer occOfReplacement = stats.get(keyToReplace);
			if (occOfReplacement != null) {  		  
				if(occOfReplacement.intValue() == 1) {//we had a single occurrence of this key
					stats.remove(keyToReplace);
				}else {								  //that key has already occurred more than once
					stats.put(keyToReplace,occOfReplacement-1);
				}
			}
		}
		
		window[position.intValue()] = item;
		
		//updated statistics
		Integer occOfNew = stats.get(item);
		if (occOfNew == null) { //seeing this key first time
			stats.put(item, 1);
		} else {				//rest of the occurrences of this key
			stats.put(item, occOfNew + 1);
		}
		

		counter = counter.add(BigInteger.ONE);
	

		
	}

}
