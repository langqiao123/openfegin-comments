package example.spring.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.data.domain.Sort;

import java.io.IOException;

/**
 * sort对象序列化
 * @Author: yangmingyang
 * @Date: 2020/6/14
 */
public class SortJacksonSerializer extends JsonSerializer<Sort> {

    @Override
    public void serialize(Sort sort, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeArrayFieldStart("sort");
        jsonGenerator.writeStartArray();
        for (Sort.Order order : sort) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("property", order.getProperty());
            jsonGenerator.writeStringField("direction", order.getDirection().name());
            jsonGenerator.writeBooleanField("ignoreCase", order.isIgnoreCase());
            jsonGenerator.writeStringField("nullHandling", order.getNullHandling().name());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}
