package util;

import java.util.HashMap;
import java.util.Map;

public class BiMap<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = -3403159036588716938L;

	Map<V, K> otherWay;

	public BiMap() {
		super();
		otherWay = new HashMap<V, K>();
	}

	@Override
	public V put(K key, V value) {
		otherWay.put(value, key);
		return super.put(key, value);
	}

	public K getKey(V value) {
		return otherWay.get(value);
	}

}
