import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Query6 {
	public static String Query6(Iterable<FlightRecord> input) {
		Map<String, Integer> flights = new TreeMap<>();
		int max = 0;
		String result = "";

		//this query is to find which pair of states had the most flights in between them and return in a-z order

		for (FlightRecord cid : input) {
			String origin = cid.ORIGIN_STATE_ABR;
			String dest = cid.DEST_STATE_ABR;
			//load data

			String state; //to concatenate in a-z order
			if(origin.compareTo(dest) < 0){ state = origin + "," + dest; }
			else{ state = dest + "," + origin; }

			if(flights.containsKey(state)){
				flights.put(state, flights.get(state) + 1); // if the key exists one is added

				if(max < flights.get(state)){
					max = flights.get(state);
					result = state; // updating max
				}
			}
			else{ flights.put(state, 1); } //if key does not exist yet put starter 1
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
		String r = Query6(input);
		System.out.println(r);
	}
}