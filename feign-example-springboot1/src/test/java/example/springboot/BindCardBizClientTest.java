package example.springboot;

import com.alibaba.fastjson.JSON;
import example.springboot.client.BankBizClient;
import example.springboot.dto.BankCardValidateBaseReqDto;
import example.springboot.dto.BasicResponse;
import feign.Feign;
import feign.Logger;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BindCardBizClientTest extends UnitTestBase{

    private BankBizClient client;

    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private HttpClient httpClient;

    @Before
    public void init(){
        this.client = Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .logLevel(Logger.Level.FULL)
            .client(new ApacheHttpClient(httpClient))
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

        log.info("nameValidation,start.............：" + JSON.toJSON(req));
        BasicResponse resp = client.nameValidation(req);

        log.info("nameValidatio,end.................：" + JSON.toJSON(resp));

    }

}
