package com.zxin.java.jdk.distributed;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

import lombok.Data;

/**
 * 一致性hash算法
 * <p>原理： 设置hash值闭环大小，创建节点hash方法，创建数据对象hash方法，sortmap存储 val - node 映射，以及下节点映射，</p>
 * 
 * 节点hash值冲突未解决
 * @author zxin
 *
 */
public class ConsistentHash{

	private final HashFunction hashFunction;
	
	/**
	 * 虚节点
	 */
	private final int virtualNodeReplicas;
	
	/**
	 * key: hash环，value: 实节点
	 */
	private final SortedMap<Integer, Node> circle = new TreeMap<Integer, Node>();

	public ConsistentHash(HashFunction hashFunction, int numberOfReplicas, Collection<Node> nodes) {
		this.hashFunction = hashFunction;
		this.virtualNodeReplicas = numberOfReplicas;

		for (Node node : nodes) {
			add(node);
		}
	}

	/**
	 * 添加新实节点
	 * @param node
	 */
	public void add(Node node) {
		for (int i = 0; i < virtualNodeReplicas; i++) {
			circle.put(hashFunction.hash(node.hashCode() , i), node);
		}
	}

	/**
	 * 删除实节点
	 * @param node
	 */
	public void remove(Node node) {
		for (int i = 0; i < virtualNodeReplicas; i++) {
			circle.remove(hashFunction.hash(node.hashCode() , i));
		}
	}

	public Node get(Object key) {
		if (circle.isEmpty()) {
			return null;
		}
		int hash = hashFunction.hash(key);
		if (!circle.containsKey(hash)) {
			SortedMap<Integer, Node> tailMap = circle.tailMap(hash);
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		}
		return circle.get(hash);
	}
	
	/**
	 * 限制hash值范围2^31-1
	 * <ul>
	 * 	<li>Node HashFunction</li>
	 * 	<li>Data HashFunction</li>
	 * </ul>
	 * @author zxin
	 *
	 */
	private static interface HashFunction{
		default <T> Integer hash(T t, int... seed){
			//虚节点算法  + 限制hash范围
//			t.hashCode() & Integer.MAX_VALUE;
			return 0;
		}
	}
	
	/**
	 * 服务器节点
	 * 
	 * @author zxin
	 *
	 */
	@Data
	private static class Node {
		
		private String ip;
		
		private int port;

	}

}

