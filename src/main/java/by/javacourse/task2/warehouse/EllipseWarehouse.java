package by.javacourse.task2.warehouse;

import java.util.HashMap;
import java.util.Map;

public class EllipseWarehouse {

	private static EllipseWarehouse instance;

	private Map<Long, EllipseParameters> warehouse;

	private EllipseWarehouse() {
		warehouse = new HashMap<Long, EllipseParameters>();
	}

	public static EllipseWarehouse getInstance() {
		if (instance == null) {
			instance = new EllipseWarehouse();
		}
		return instance;
	}

	public EllipseParameters putParameters(long ellipseId, EllipseParameters param) {
		return warehouse.put(ellipseId, param);
	}

	public EllipseParameters getParameters(long ellipseId) {
		return warehouse.get(ellipseId);
	}

	public void putAllParameters(Map<Long, EllipseParameters> newEllipseMap) {
		warehouse.putAll(newEllipseMap);
	}
	
	public boolean containsId (long ellipseId) {
		return warehouse.containsKey(ellipseId);
	}
	
	public String toSting () {
		return warehouse.toString();
	}
}
