package com.hdgj.api.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weidian.open.sdk.AbstractWeidianClient;
import com.weidian.open.sdk.exception.OpenException;
import com.weidian.open.sdk.http.Param;
import com.weidian.open.sdk.request.AbstractCommonRequest;
import com.weidian.open.sdk.util.JsonUtils;
import com.weidian.open.sdk.util.SystemConfig;

@Service
public class WeiDianService{
	@Autowired
	private AbstractWeidianClient vdClient;
	
	@Autowired
	private String vdAccessToken;
	
	private String buildPublicValue(String method, String version) throws OpenException {
        return this.buildPublicValue(method, version, "json");
    }

	
	private String buildPublicValue(String method, String version, String format) throws OpenException {
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
    private Map<String, Object> removeNullValue(Map<String, Object> map) {
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



	
	public String vdianItemListGet(Number page_num, Number orderby, Number page_size, String update_end, Number status, String update_start) throws OpenException {
	    Map< String, Object> map = new HashMap< String, Object>();
	    map.put("page_num", page_num);
	    map.put("orderby", orderby);
	    map.put("page_size", page_size);
	    map.put("update_end", update_end);
	    map.put("status", status);
	    map.put("update_start", update_start);
	    removeNullValue(map);
	    
	    System.out.println("map:" + map);
	    return vdClient.executePostForString(SystemConfig.API_URL_FOR_POST,
	            new Param(SystemConfig.PUBLIC_PARAM, buildPublicValue("vdian.item.list.get", "1.0")),
	            new Param(SystemConfig.BIZ_PARAM, JsonUtils.toJson(map)));
	}
}


