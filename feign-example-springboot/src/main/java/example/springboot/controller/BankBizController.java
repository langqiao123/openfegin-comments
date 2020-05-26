package example.springboot.controller;

import com.alibaba.fastjson.JSON;
import example.springboot.dto.BankCardValidateBaseReqDto;
import example.springboot.dto.BasicResponse;
import example.springboot.dto.NameUnionMatchValidationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 银行业务相关接口
 */
@RestController
@Slf4j
@RequestMapping(value = {"/payment/bank"})
public class BankBizController {

    /**
     * 银行卡有效性验证.
     */
    @RequestMapping(value = {"/nameValidation"}, method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse<NameUnionMatchValidationDto> nameValidation(@RequestBody BankCardValidateBaseReqDto bindingCardDto) {
        BasicResponse<NameUnionMatchValidationDto> result = new BasicResponse<>();
        log.info("nameValidation,调用,param:{}", JSON.toJSONString(bindingCardDto));
        try {
            Thread.sleep(15* 1000);
            result.setCode(1);
            result.setMessage("成功");
        } catch (Exception e) {
            result.setCode(-1);
            result.setMessage("失败");
            log.info("nameValidation,调用失败,原因:{}", e);
        }
        log.info("nameValidation,调用,result:{}", JSON.toJSONString(result));
        return result;
    }


}
