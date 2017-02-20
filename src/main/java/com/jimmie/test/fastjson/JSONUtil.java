package com.jimmie.test.fastjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * json操作工具类
 * 
 * @author yangtao
 *
 */
public final class JSONUtil {

	/**
	 * 默认json格式化方式
	 */
	public static final SerializerFeature[] DEFAULT_FORMAT = { SerializerFeature.WriteDateUseDateFormat,
			SerializerFeature.WriteEnumUsingToString, SerializerFeature.WriteNonStringKeyAsString,
			SerializerFeature.QuoteFieldNames, SerializerFeature.SkipTransientField, SerializerFeature.SortField,
			SerializerFeature.PrettyFormat };

	private JSONUtil() {
	}

	/**
	 * 用自定义模板从json字符串中取值
	 * 
	 * @param json
	 * @param template demo:items.items.x_item.0[].open_iid---->0[]：[]表示数组，0表示取第几个
	 * @return
	 * @author yangtao
	 */
	public static String getJSONValueByTemplate(String json, String template) {
		String keys[] = template.split("\\.");
		for (String key : keys) {
			if (json == null) {
				return null;
			}
			if (key.indexOf("[]") > 0) {
				json = JSON.parseObject(json, new TypeReference<List<String>>(){}).get(Integer.parseInt(key.replace("[]", "")));
			} else{
				json = JSON.parseObject(json).getString(key);
			}
		}
		return json;
	}
	
	/**
	 * JSON转Map
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> parseJSON2Map(String jsonStr){ 
        Map<String, Object> map = new HashMap<String, Object>();  
        //最外层解析  
        JSONObject json = JSONObject.parseObject(jsonStr);  
        for(Object k : json.keySet()){ 
            Object v = json.get(k);   
            //如果内层还是数组的话，继续解析  
            if(v instanceof JSONArray){
            	//数组对象又分为两种（简单数组或键值对）
                List list = parseJSON2List(json.get(k).toString());
				map.put((String)k, list);  
            } else {  
                map.put((String)k, v);  
            }  
        }  
        return map;  
    }
	
	/**
	 * JSON转List<Map<String, Object>>
	 * @param json
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Map<String, Object>> parseJSON2List(String json){
    	JSONArray jsonArray = JSONArray.parseArray(json);
        List list = new ArrayList();
        for (Object object : jsonArray) {
        	try {
        		JSONObject jsonObject = (JSONObject) object;
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (Map.Entry entry : jsonObject.entrySet()) {
                    if(entry.getValue() instanceof  JSONArray){
                        map.put((String)entry.getKey(), parseJSON2List(entry.getValue().toString()));
                    }else{
                        map.put((String)entry.getKey(), entry.getValue());
                    }
                }
                list.add(map);
			} catch (Exception e) {
				list.add(object);
			}
        }
        return list;
    }  
}
