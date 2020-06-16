package example.spring.client;

import example.spring.dto.FeignDemoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="feginTestClient",url="http://localhost:8078/feign/server",fallback = FeignTestClient.DefaultFallback.class)
public interface FeignTestClient {

    @RequestMapping(value = "/getError/{id}", method = RequestMethod.GET)
    public String getError(@RequestParam("id") Integer id);


    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    public String get1();

    @RequestMapping(value = "/get2/{param}", method = RequestMethod.GET)
    public String get2(@RequestParam("param") String param);

    @RequestMapping(value = "/post1", method = RequestMethod.POST)
    public FeignDemoDto post1(@RequestBody FeignDemoDto demo);

    @RequestMapping(value = "/post1", method = RequestMethod.GET)
    public FeignDemoDto get3(@RequestBody FeignDemoDto demo);


    @RequestMapping(value = "/post4", method = RequestMethod.POST)
    public FeignDemoDto post4(@RequestBody FeignDemoDto demo,@RequestParam("userId") Long userId);


    @Component
    public class DefaultFallback implements FeignTestClient {

        @Override
        public String getError(@RequestParam("id") Integer id){
            return "";
        }

        @Override
        public String get1() {
            return null;
        }

        @Override
        public String get2(String param) {
            return null;
        }

        @Override
        public FeignDemoDto post1(FeignDemoDto demo) {
            return null;
        }

        @Override
        public FeignDemoDto get3(FeignDemoDto demo) {
            return null;
        }

        @Override
        public FeignDemoDto post4(FeignDemoDto demo, Long userId) {
            return null;
        }
    }
}
