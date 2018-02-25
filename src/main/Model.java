package main;

import java.util.HashMap;
import java.util.Map;


public class Model {
	static Map<Integer,String> HOT_MAP = new HashMap<Integer,String>();
	static Map<Integer,String> COLD_MAP = new HashMap<Integer,String>();
	
	public Model() {
		HOT_MAP.put(1, "sandals");
		HOT_MAP.put(2, "sun visor");
		HOT_MAP.put(3, "fail");
		HOT_MAP.put(4, "t-shirt");
		HOT_MAP.put(5, "fail");
		HOT_MAP.put(6, "shorts");
		HOT_MAP.put(7, "leaving house");
		HOT_MAP.put(8, "Removing PJs");
		
		COLD_MAP.put(1, "boots");
		COLD_MAP.put(2, "hat");
		COLD_MAP.put(3, "socks");
		COLD_MAP.put(4, "shirt");
		COLD_MAP.put(5, "jacket");
		COLD_MAP.put(6, "pants");
		COLD_MAP.put(7, "leaving house");
		COLD_MAP.put(8, "Removing PJs");
	}

}
