package example.spring.controller;

import example.spring.client.FeignTestClient;
import example.spring.dto.FeignDemoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * 银行业务相关接口
 */
@RestController
@Slf4j
@RequestMapping("/feign/server")
public class FeignServerController {

    @GetMapping("/get1")
    public String get1() {
        return "get1";
    }
    @GetMapping("/get2/{para}")
    public String get2(@PathVariable("para") String para){
        return para;
    }
    @PostMapping("/post1")
    public FeignDemoDto  post1(@RequestBody FeignDemoDto demo) {
        return demo;
    }
}
