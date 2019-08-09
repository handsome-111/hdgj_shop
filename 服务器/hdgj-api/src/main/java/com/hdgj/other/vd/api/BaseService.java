package com.hdgj.other.vd.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.weidian.open.sdk.AbstractWeidianClient;
import com.weidian.open.sdk.exception.OpenException;
import com.weidian.open.sdk.util.JsonUtils;

public class BaseService {
	@Autowired
	protected AbstractWeidianClient vdClient;
	
	@Autowired
	protected String vdAccessToken;
	
	protected String buildPublicValue(String method, String version) throws OpenException {
        return this.buildPublicValue(method, version, "json");
    }

	
	protected String buildPublicValue(String method, String version, String format) throws OpenException {
        Map<String, String> map = new HashMap<String, String>(8);
        map.put("method", method);
        map.put("access_token", vdAccessToken);
        map.put("version", version);
        map.put("format", format);
        map.put("lang", "java");
        return JsonUtils.toJson(map);
    }

	/**
	 * 移除值为NULL或0 的 key
	 * @param map
	 * @return
	 */
	protected Map<String, Object> removeNullValue(Map<String, Object> map) {
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        outer:
        while(it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            
            if(entry.getValue() == null) {
                it.remove();
                continue outer;
            }
            
            if(entry.getValue().toString().equals("0")){
                it.remove();
                continue outer;
    		}
        }
        return map;
    }
}
