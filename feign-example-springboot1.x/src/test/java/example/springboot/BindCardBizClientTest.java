package example.springboot;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.springboot.client.BankBizClient;
import example.springboot.dto.BankCardValidateBaseReqDto;
import example.springboot.dto.BasicResponse;
import example.springboot.interceptor.TokenRequestInterceptor;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

@Slf4j
public class BindCardBizClientTest extends UnitTestBase{

    private BankBizClient client;

    @Autowired
    private OkHttpClient okHttpClient;

//    @Autowired
//    private HttpClient httpClient;

    @Autowired
    private TokenRequestInterceptor tokenRequestInterceptor;

    @Before
    public void init(){
        this.client = Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .logLevel(Logger.Level.FULL)
//            .client(new ApacheHttpClient(httpClient))
            .requestInterceptor(tokenRequestInterceptor)
            .target(BankBizClient.class, "http://localhost:8098");
    }


    /**
     * nameValidation
     */
    @Test
    public void nameValidation() {
        Sort sort = new Sort(Sort.Direction.DESC,"inserttime");
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"inserttime");
        Sort sort1 = new Sort(order);
        log.info("nameValidation,start.............：" + JSON.toJSON(sort1));
        BankCardValidateBaseReqDto req = new BankCardValidateBaseReqDto();
        req.setBusinessNo("nameValidation:55:1");
        req.setUserId(55L);
        req.setAccountName("Philippine Gazzo");
        req.setBankCode("MANDIRI");
        req.setAccountNo("1150007319082");
        req.setSort(sort);
        log.info(":" + JSON.toJSON(req));
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

}
