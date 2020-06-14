package example.spring;

import example.spring.client.FeignTestClient;
import example.spring.dto.FeignDemoDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class FeginClientUT extends UnitTestBase{
    @Autowired
    private FeignTestClient feginTestClient;

    @Test
    public void testFallback(){
        feginTestClient.getError(1);
    }
    @Test
    public void testGet1(){
        System.out.println(feginTestClient.get1());
        System.out.println(feginTestClient.get2("abc"));
        System.out.printf("..");
        FeignDemoDto feignDemo = new FeignDemoDto();
        feignDemo.setName("name");
        feignDemo.setAge(1);
        System.out.println(feginTestClient.post1(feignDemo));
    }
}
