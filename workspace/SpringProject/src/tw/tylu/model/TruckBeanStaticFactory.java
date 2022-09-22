package tw.tylu.model;

import java.util.HashMap;

public class TruckBeanStaticFactory {
	private static HashMap<Integer, TruckBean> map = new HashMap<Integer, TruckBean>();

	public TruckBeanStaticFactory() {
	}

	static {
		map.put(1, new TruckBean(3, "toyota"));
		map.put(2, new TruckBean(4, "nissan"));
	}

	public static TruckBean getTruckBean(int key) {
		return map.get(key);
	}
}
