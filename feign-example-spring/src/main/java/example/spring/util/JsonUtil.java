package example.spring.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Map;

/**
 * @author supengfei
 */
public final class JsonUtil {
    private static final SerializeConfig CONFIG;

    static {
        CONFIG = new SerializeConfig();
        // compatible with the java.util.Date and the java.sql.Date
        CONFIG.put(java.util.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss.SSS"));
        CONFIG.put(java.sql.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    /**
     * set the default value of the object which the value is null
     */
    private static final SerializerFeature[] FEATURES= {
//            SerializerFeature.WriteMapNullValue,
//            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullBooleanAsFalse,
//            SerializerFeature.WriteNullStringAsEmpty,
    };


    /**
     * map to json
     *
     * @param map the map that will transform to json string
     * @return the json string of map transform
     */
    public static String map2json(Map map) {
        return JSONObject.toJSONString(map);
    }


    /**
     * object to json
     *
     * @param object the object that will transform to json string
     * @return the json string of object
     */
    public static String toJson(Object object) {
        return JSON.toJSONString(object, CONFIG, FEATURES);
    }

    /**
     * json to map
     *
     * @param json json string that will transform to map
     * @return the map fo json string
     */
    public static Map json2map(String json) {
        return JSONObject.parseObject(json);
    }

    /**
     * json string to object
     *
     * @param json  the json string that will transform to object
     * @param clazz the class that json will transform
     * @param <T>   the object class
     * @return the object of json string
     */
    public static <T> T json2Obj(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }


    public static boolean isJsonType(String str) {
        boolean result = false;
        if (null != str && !str.equals("")) {
            str = str.trim();
            if (str.startsWith("{") && str.endsWith("}")) {
                result = true;
            } else if (str.startsWith("[") && str.endsWith("]")) {
                result = true;
            }
        }
        return result;
    }


    public static boolean isJSON2(String str) {
        boolean result = false;
        try {
            Map<String,Object> obj=JSONObject.parseObject(str);
            result = true;
        } catch (Exception e) {
            result=false;
        }
        return result;
    }

}

