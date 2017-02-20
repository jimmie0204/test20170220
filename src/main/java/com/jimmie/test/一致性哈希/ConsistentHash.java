package com.jimmie.test.一致性哈希;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import redis.clients.util.MurmurHash;

public class ConsistentHash<T> {

	private final static MurmurHash hashFunction = new MurmurHash();
	private final int numberOfReplicas;// 副本数
	private final SortedMap<Long, T> circle = new TreeMap<Long, T>();

	public SortedMap<Long, T> getCircle() {
		return circle;
	}

	public ConsistentHash(int numberOfReplicas, Collection<T> nodes) {
		// this.hashFunction = hashFunction;
		this.numberOfReplicas = numberOfReplicas;

		for (T node : nodes) {
			add(node);
		}
	}

	public void add(T node) {//相当于先把服务器节点映射到circle上
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.put(hashFunction.hash(node.toString() + i), node);
		}
	}

	public void remove(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.remove(hashFunction.hash(node.toString() + i));
		}
	}

    /**
     * 获得一个最近的顺时针节点
     * @param key 为给定键取Hash，取得顺时针方向上最近的一个虚拟节点对应的实际节点（即获取该key的映射服务器）
     * @return
     */
	public T getT(Object key) {
		if (circle.isEmpty()) {
			return null;
		}
//		long hash = hashFunction.hash(SafeEncoder.encode(key.toString()));
		long hash = hashFunction.hash(key.toString());
		if (!circle.containsKey(hash)) {
			SortedMap<Long, T> tailMap = circle.tailMap(hash);
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		}
		return circle.get(hash);
	}

	private int getSize() {
		// TODO Auto-generated method stub
		return circle.size();
	}

	public static <T> void main(String[] args) {
		Set<String> nodes = new HashSet<String>();
		nodes.add("127.0.0.1");
		nodes.add("127.0.0.2");
		nodes.add("127.0.0.3");
		ConsistentHash<String> consistentHash = new ConsistentHash<String>(160,
				nodes);

		consistentHash.add("127.0.0.4");
		System.out.println(consistentHash.getSize()); // 640

		//开始往set好服务器分布的circle上存取数据
		//TODO
		//EXAMPLE
		System.out.println("该key映射到的服务器为："+consistentHash.getT("test5sdsdsd118892"));
	}

}
