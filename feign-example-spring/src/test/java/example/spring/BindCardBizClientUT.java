package example.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.spring.client.BankBizClient;
import example.spring.dto.BankCardValidateBaseReqDto;
import example.spring.dto.BankCardValidateBaseReqDto2;
import example.spring.dto.BasicResponse;
import example.spring.interceptor.TokenRequestInterceptor;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

@Slf4j
public class BindCardBizClientUT extends UnitTestBase{

    private BankBizClient client;

    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private TokenRequestInterceptor tokenRequestInterceptor;

    @Before
    public void init(){
        this.client = Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .logLevel(Logger.Level.FULL)
//            .contract(new Springmvc)
//            .client(new ApacheHttpClient(httpClient))
            .requestInterceptor(tokenRequestInterceptor)
            .target(BankBizClient.class, "http://localhost:8088");
    }


    /**
     * nameValidation
     */
    @Test
    public void nameValidation() {

        BankCardValidateBaseReqDto req = new BankCardValidateBaseReqDto();
        req.setBusinessNo("nameValidation:55:1");
        req.setUserId(55L);
        req.setAccountName("Philippine Gazzo");
        req.setBankCode("MANDIRI");
        req.setAccountNo("1150007319082");

        Sort sort = new Sort(Sort.Direction.DESC,"inserttime");
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"inserttime");
        Sort sort1 = new Sort(order);
//        req.setSort(Sort.by(new Sort.Order(Sort.Direction.DESC, "inserttime")));
        req.setSort(sort1);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonValue1 = mapper.writeValueAsString(req);
            String jsonValue2 = mapper.writeValueAsString(sort);
            log.info("jackson,序列化req:"+jsonValue1);
            log.info("jackson,序列化sort:"+jsonValue2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        BasicResponse resp = client.nameValidation(req);

        log.info("nameValidatio,end.................：" + JSON.toJSON(resp));

    }

    @Test
    public void testNameValidation1() {
        BankCardValidateBaseReqDto req = new BankCardValidateBaseReqDto();
        req.setBusinessNo("nameValidation:55:1");
        req.setUserId(55L);
        req.setAccountName("Philippine Gazzo");
        req.setBankCode("MANDIRI");
        req.setAccountNo("1150007319082");

        log.info("nameValidation,start.............：" + JSON.toJSON(req));
        Sort sort = Sort.by(Sort.Direction.DESC,"insertttime");
        log.info("sort:" + JSON.toJSONString(sort));
        Sort sort1 = new Sort(Sort.Direction.DESC,"inserttime");
        log.info("sort1:" + JSON.toJSONString(sort1));

        req.setSort(sort);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonValue1 = mapper.writeValueAsString(req);
            log.info("jackson,序列化req:"+jsonValue1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        BasicResponse resp = client.nameValidation1(req,sort);

        log.info("nameValidatio,end.................：" + JSON.toJSON(resp));

    }


    /**
     * nameValidation
     */
    @Test
    public void nameValidation2() {

        BankCardValidateBaseReqDto2 req = new BankCardValidateBaseReqDto2();
        req.setBusinessNo("nameValidation:55:1");
        req.setUserId(55L);
        req.setAccountName("Philippine Gazzo");
        req.setBankCode("MANDIRI");
        req.setAccountNo("1150007319082");

        req.setDirection(Sort.Direction.DESC);
        req.setProperty("inserttime");
        log.info("nameValidation,start.............：" + JSON.toJSON(req));
        BasicResponse resp = client.nameValidation2(req);

        log.info("nameValidatio,end.................：" + JSON.toJSON(resp));

    }


    /**
     * 测试jackson的序列化和反序列化
     * org.springframework.data.domain.Sort，反序列化失败的问题
     * com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `org.springframework.data.domain.Sort` (no Creators, like default construct, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
     */
    @Test
    public void testJacksonSerializationAndDeserialization() {
        Sort sort = Sort.by(Sort.Direction.DESC,"insertttime");
        try {
            String sortStr = JSON.toJSONString(sort, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.PrettyFormat);
            log.info("fastjson序列化："+sortStr);
//            Sort convertSort =(Sort) JSONObject.parse(sortStr);
            //序列化
            ObjectMapper mapper = new ObjectMapper();
            String jsonValue = mapper.writeValueAsString(sort);
            log.info("jackson,序列化sort:"+jsonValue);

            //反序列化
            Sort jacksonDeserialize = mapper.readValue(jsonValue, Sort.class);
            log.info("序列化和反序列化end....................");
        } catch (Exception e) {
            log.error("jackson反序列化发生异常：",e);
        }
    }
}
