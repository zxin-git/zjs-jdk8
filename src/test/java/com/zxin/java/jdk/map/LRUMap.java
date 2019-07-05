package com.zxin.java.jdk.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于volume大小的LRU缓存Map
 * @author zxin
 *
 * @param <K>
 * @param <V>
 */
public class LRUMap<K, V> extends LinkedHashMap<K, V>{

	private static final long serialVersionUID = -6773758584719565310L;

	/**
	 * LRU容量
	 */
	private final int capacity;

	public LRUMap(int capacity){
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}
	
	/**
	 * 删除策略
	 */
	@Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
		if (this.size() > this.capacity) {
			return true;
		}
        return false;
    }
	
}
