import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


class Main {

	private static Map<String, Integer> stats = new HashMap<>();
	private static String[] window = new String[3]; 
	private static long counter = 0;

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
		int position = 0;
		
		if (0 <= counter && counter < window.length) {
			position = (int) counter;
		} else {
			position = (int) counter % window.length;
			
			String keyToReplace = window[position];
			
			Integer occOfReplacement = stats.get(keyToReplace);
			if (occOfReplacement !=null) {
				if(occOfReplacement.intValue() == 1) {
					stats.remove(keyToReplace);
				}else {
					stats.put(keyToReplace,occOfReplacement-1);
				}
			}
			
		}
		
		window[position] = item;
		
		Integer occOfNew = stats.get(item);

		if (occOfNew == null) {
			stats.put(item, 1);
		} else {
			stats.put(item, occOfNew + 1);
		}
		
		if(counter <= Long.MAX_VALUE-1) {
			counter++;
		}else {
			counter=0;
			position=0;
		}

		
	}

}
