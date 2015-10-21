package com.cfilmcloud.auth.base.cas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.session.Session;

/**
 * 存储ticket到sessionID的映射
 */
public final class HashMapBackedSessionMappingStorage {

	/**
	 * Maps the ID from the CAS server to the Session ID.
	 */
	// XXX 后期请换成缓存
	private final Map<String, Serializable> MANAGED_SESSIONS_ID = new HashMap<String, Serializable>();

	public synchronized void addSessionById(String mappingId, Session session) {
		MANAGED_SESSIONS_ID.put(mappingId, session.getId());
	}

	public synchronized Serializable getSessionIDByMappingId(String mappingId) {
		return MANAGED_SESSIONS_ID.get(mappingId);
	}
}
