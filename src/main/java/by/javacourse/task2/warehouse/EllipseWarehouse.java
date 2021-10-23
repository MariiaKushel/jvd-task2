package by.javacourse.task2.warehouse;

import java.util.Collections;
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

	public boolean putParameters(long ellipseId, EllipseParameters param) {
		return warehouse.put(ellipseId, param) != null;
	}

	public EllipseParameters getParameters(long ellipseId) {
		return warehouse.get(ellipseId);
	}

	public Map<Long, EllipseParameters> getWarehouse (){
		return Collections.unmodifiableMap(warehouse);
	}
	
	public boolean containsId (long ellipseId) {
		return warehouse.containsKey(ellipseId);
	}
	
	public String toSting () {
		return warehouse.toString();
	}
}
