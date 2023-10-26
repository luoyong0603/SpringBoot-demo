package com.example.demo.component.redis.mediat;

import com.example.demo.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Redis中介类，用于从redis中读取内容或者更新数据
 *
 */
@Slf4j
//@Component
public class RedisMediator {

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Value("${luoyong.redis.login-time-out:1800}")
	private Integer timeOut;

	/**
	 * 获取唯一健
	 */
	public String getUniqKey() {
		String key = UUID.randomUUID().toString();
		while (this.hasKey(key)) {
			key = UUID.randomUUID().toString();
		}
		return key;
	}

	/**
	 * 普通缓存，保存对象
	 *
	 * @param key    键
	 * @param object 要保存的对象
	 * @param time   过期时间
	 */
	public void set(String key, Object object, long time) throws JsonProcessingException {
		String value = JsonUtils.writeValueAsString(object);
		set(key, value, time);
	}

	/**
	 * 普通缓存，保存对象
	 *
	 * @param key    键
	 * @param object 要保存的对象
	 */
	public void set(String key, Object object) throws JsonProcessingException {
		String value = JsonUtils.writeValueAsString(object);
		set(key, value, timeOut);
	}

	/**
	 * 普通缓存放入
	 *
	 * @param key   键
	 * @param value 值
	 */
	public void set(String key, String value) {
		set(key, value, timeOut);
	}

	/**
	 * 普通缓存放入并设置时间
	 *
	 * @param key   键
	 * @param value 值 String
	 * @param time  过期时间
	 */
	public void set(String key, String value, long time) {
		this.checkKey(key);
		stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
	}

	/**
	 * 普通缓存获取对象
	 *
	 * @param key  键
	 * @param type 泛型对象
	 */
	public <T> T get(String key, TypeReference<T> type) throws JsonProcessingException {
		this.checkKey(key);
		String value = stringRedisTemplate.opsForValue().get(key);
		if (StringUtils.isBlank(value)) {
			return null;
		}
		return JsonUtils.readValue(value, type);
	}

	/**
	 * 普通缓存获取
	 *
	 * @param key 键
	 */
	public String get(String key) {
		this.checkKey(key);
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 判断key是否存在
	 *
	 * @param key 键
	 * @return true 存在 false不存在
	 */
	public boolean hasKey(String key) {
		this.checkKey(key);
		return stringRedisTemplate.hasKey(key);
	}


	/**
	 * 删除缓存
	 *
	 * @param key 健
	 */
	public void del(String key) {
		this.checkKey(key);
		stringRedisTemplate.delete(key);
	}

	/**
	 * 刷新缓存时间
	 *
	 * @param key
	 */
	public Boolean expire(String key) {
		return this.expire(key, timeOut);
	}

	/**
	 * 指定缓存失效时间
	 *
	 * @param key  键
	 * @param time 时间(秒)
	 * @return
	 */
	public Boolean expire(String key, long time) {
		return stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
	}

	/**
	 * 检查key是否为空
	 *
	 * @param key 健
	 */
	private void checkKey(String key) {
		if (StringUtils.isBlank(key)) {
			throw new RuntimeException("redis key不能为空");
		}
	}

	/**
	 * 获取key的过期时间
	 */
	public long getKeyExpirationTime(String key){
		this.checkKey(key);
		return stringRedisTemplate.getExpire(key);
	}

}
