package example.spring.config;

/**
 * @Author: yangmingyang
 * @Date: 2020/6/13
 */

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Sort;

import java.io.IOException;

/**
 * sort对象反序列化
 */
public class SortJacksonDeserializer extends JsonDeserializer<Sort> {
    @Override
    public Sort deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Sort.Order[] orders = new Sort.Order[node.size()];
        int i = 0;
        for(JsonNode obj : node){
            orders[i] =  new Sort.Order(Sort.Direction.valueOf(obj.get("direction").asText()), obj.get("property").asText());
            i++;
        }
        Sort sort = new Sort(orders);
        return sort;
    }
}