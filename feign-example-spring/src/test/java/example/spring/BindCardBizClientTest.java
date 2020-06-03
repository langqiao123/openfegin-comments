package example.spring;

import com.alibaba.fastjson.JSON;
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
public class BindCardBizClientTest extends UnitTestBase{

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
            .target(BankBizClient.class, "http://localhost:8098");
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
//        req.setSort(Sort.by(new Sort.Order(Sort.Direction.DESC, "inserttime")));
        req.setSort(sort);
        log.info("nameValidation,start.............：" + JSON.toJSON(req));
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
        BasicResponse resp = client.nameValidation1(req,new Sort(Sort.Direction.DESC,"inserttime"));

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
}
