package com.jimmie.test.redis;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCli {
	private static int default_index;
	private static int max_index;
	private static RedisCli[] xRedisArray;
	private static JedisPool pool;
	private int set_index = -1;

	private RedisCli(int index) {
		this.set_index = index;
	}

	public static RedisCli getInstance() {
		return getInstance(default_index);
	}

	public static RedisCli getInstance(int index) {
		if ((index < 0) || (index > max_index - 1))
			return null;
		if (xRedisArray[index] != null) {
			return xRedisArray[index];
		}
		RedisCli xRedis = new RedisCli(index);
		xRedisArray[index] = xRedis;

		return xRedis;
	}


	public void release(Jedis jedis) {
		pool.returnResource(jedis);
	}

	public Jedis getJedis() {
		Jedis jedis = (Jedis) pool.getResource();
		if (this.set_index > -1)
			jedis.select(this.set_index);
		else {
			jedis.select(default_index);
		}

		return jedis;
	}

	public String get(String key) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = getJedis();
			value = jedis.get(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return value;
	}

	public String set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			String str1 = jedis.set(key, value);

			return str1;
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
			String str2 = "0";

			return str2;
		} finally {
			release(jedis);
		}
	}

	public Long del(String[] keys) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			Long localLong1 = jedis.del(keys);

			return localLong1;
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
			Long localLong2 = Long.valueOf(0L);

			return localLong2;
		} finally {
			release(jedis);
		}
	}

	public Long append(String key, String str) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.append(key, str);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
			Long localLong1 = Long.valueOf(0L);

			return localLong1;
		} finally {
			release(jedis);
		}
		return res;
	}

	public Boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			Boolean localBoolean1 = jedis.exists(key);

			return localBoolean1;
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
			Boolean localBoolean2 = Boolean.valueOf(false);

			return localBoolean2;
		} finally {
			release(jedis);
		}
	}

	public Long setnx(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			Long localLong1 = jedis.setnx(key, value);

			return localLong1;
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
			Long localLong2 = Long.valueOf(0L);

			return localLong2;
		} finally {
			release(jedis);
		}
	}

	public String setex(String key, String value, int seconds) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.setex(key, seconds, value);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long setrange(String key, String str, int offset) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			Long localLong1 = jedis.setrange(key, offset, str);

			return localLong1;
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
			Long localLong2 = Long.valueOf(0L);

			return localLong2;
		} finally {
			release(jedis);
		}
	}

	public List<String> mget(String[] keys) {
		Jedis jedis = null;
		List<String> values = null;
		try {
			jedis = getJedis();
			values = jedis.mget(keys);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return values;
	}

	public String mset(String[] keysvalues) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.mset(keysvalues);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long msetnx(String[] keysvalues) {
		Jedis jedis = null;
		Long res = Long.valueOf(0L);
		try {
			jedis = getJedis();
			res = jedis.msetnx(keysvalues);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String getset(String key, String value) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.getSet(key, value);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String getrange(String key, int startOffset, int endOffset) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.getrange(key, startOffset, endOffset);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long incr(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.incr(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long incrBy(String key, Long integer) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.incrBy(key, integer.longValue());
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long decr(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.decr(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long decrBy(String key, Long integer) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.decrBy(key, integer.longValue());
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long serlen(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.strlen(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long hset(String key, String field, String value) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.hset(key, field, value);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long hsetnx(String key, String field, String value) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.hsetnx(key, field, value);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String hmset(String key, Map<String, String> hash) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.hmset(key, hash);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String hget(String key, String field) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.hget(key, field);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public List<String> hmget(String key, String[] fields) {
		Jedis jedis = null;
		List<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.hmget(key, fields);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long hincrby(String key, String field, Long value) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.hincrBy(key, field, value.longValue());
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Boolean hexists(String key, String field) {
		Jedis jedis = null;
		Boolean res = Boolean.valueOf(false);
		try {
			jedis = getJedis();
			res = jedis.hexists(key, field);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long hlen(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.hlen(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long hdel(String key, String[] fields) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.hdel(key, fields);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Set<String> hkeys(String key) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.hkeys(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public List<String> hvals(String key) {
		Jedis jedis = null;
		List<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.hvals(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Map<String, String> hgetall(String key) {
		Jedis jedis = null;
		Map<String, String> res = null;
		try {
			jedis = getJedis();
			res = jedis.hgetAll(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long lpush(String key, String[] strs) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.lpush(key, strs);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long rpush(String key, String[] strs) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.rpush(key, strs);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long linsert(String key, BinaryClient.LIST_POSITION where,
			String pivot, String value) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.linsert(key, where, pivot, value);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String lset(String key, Long index, String value) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.lset(key, index.longValue(), value);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long lrem(String key, long count, String value) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.lrem(key, count, value);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String ltrim(String key, long start, long end) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.ltrim(key, start, end);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String lpop(String key) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.lpop(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String rpop(String key) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.rpop(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String rpoplpush(String srckey, String dstkey) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.rpoplpush(srckey, dstkey);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String lindex(String key, long index) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.lindex(key, index);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long llen(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.llen(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public List<String> lrange(String key, long start, long end) {
		Jedis jedis = null;
		List<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.lrange(key, start, end);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long sadd(String key, String[] members) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.sadd(key, members);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long srem(String key, String[] members) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.srem(key, members);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String spop(String key) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.spop(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Set<String> sdiff(String[] keys) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.sdiff(keys);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long sdiffstore(String dstkey, String[] keys) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.sdiffstore(dstkey, keys);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Set<String> sinter(String[] keys) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.sinter(keys);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long sinterstore(String dstkey, String[] keys) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.sinterstore(dstkey, keys);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Set<String> sunion(String[] keys) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.sunion(keys);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long sunionstore(String dstkey, String[] keys) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.sunionstore(dstkey, keys);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long smove(String srckey, String dstkey, String member) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.smove(srckey, dstkey, member);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long scard(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.scard(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Boolean sismember(String key, String member) {
		Jedis jedis = null;
		Boolean res = null;
		try {
			jedis = getJedis();
			res = jedis.sismember(key, member);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String srandmember(String key) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.srandmember(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Set<String> smembers(String key) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.smembers(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long zadd(String key, Map<String,Double> scoreMembers) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.zadd(key, scoreMembers);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long zadd(String key, double score, String member) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.zadd(key, score, member);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long zrem(String key, String[] members) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.zrem(key, members);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Double zincrby(String key, double score, String member) {
		Jedis jedis = null;
		Double res = null;
		try {
			jedis = getJedis();
			res = jedis.zincrby(key, score, member);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long zrank(String key, String member) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.zrank(key, member);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long zrevrank(String key, String member) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.zrevrank(key, member);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Set<String> zrevrange(String key, long start, long end) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.zrevrange(key, start, end);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Set<String> zrangebyscore(String key, String max, String min) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.zrevrangeByScore(key, max, min);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Set<String> zrangeByScore(String key, double max, double min) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.zrevrangeByScore(key, max, min);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long zcount(String key, String min, String max) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.zcount(key, min, max);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long zcard(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.zcard(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Double zscore(String key, String member) {
		Jedis jedis = null;
		Double res = null;
		try {
			jedis = getJedis();
			res = jedis.zscore(key, member);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long zremrangeByRank(String key, long start, long end) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.zremrangeByRank(key, start, end);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Long zremrangeByScore(String key, double start, double end) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();
			res = jedis.zremrangeByScore(key, start, end);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public Set<String> keys(String pattern) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();
			res = jedis.keys(pattern);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public String type(String key) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();
			res = jedis.type(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
		return res;
	}

	public void expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.expire(key, seconds);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
	}

	public void expire(byte[] key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.expire(key, seconds);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
	}

	public void expireAt(byte[] key, long unixTime) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.expireAt(key, unixTime);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
	}

	public void expireAt(String key, long unixTime) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.expireAt(key, unixTime);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			release(jedis);
		}
	}

	public static void main(String[] args) {
		RedisCli xRedis = getInstance();
		xRedis.hset("test", "name", "zhsan");
		String test = xRedis.hget("test", "name");
		System.out.println(test);

		Jedis jedis = new Jedis("192.168.248.55");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
	}


	static {
		ResourceBundle bundle = ResourceBundle.getBundle("redis");
		if (bundle == null) {
			throw new IllegalArgumentException(
					"[redis.properties] is not found!");
		}
		default_index = Integer.valueOf(bundle.getString("redis.defaultDBNum"))
				.intValue();
		max_index = Integer.valueOf(bundle.getString("redis.maxDBNum"))
				.intValue();
		xRedisArray = new RedisCli[max_index];

		JedisPoolConfig config = new JedisPoolConfig();

		config.setMaxTotal(Integer.valueOf(
				bundle.getString("jedis.pool.maxActive")).intValue());
		config.setMaxIdle(Integer.valueOf(
				bundle.getString("jedis.pool.maxIdle")).intValue());
		config.setMaxWaitMillis(Long.valueOf(bundle.getString("jedis.pool.maxWait"))
				.longValue());
		config.setTestOnBorrow(Boolean.valueOf(
				bundle.getString("jedis.pool.testOnBorrow")).booleanValue());
		config.setTestOnReturn(Boolean.valueOf(
				bundle.getString("jedis.pool.testOnReturn")).booleanValue());

		pool = new JedisPool(config, bundle.getString("redis.ip"), Integer
				.valueOf(bundle.getString("redis.port")).intValue());
	}
}
