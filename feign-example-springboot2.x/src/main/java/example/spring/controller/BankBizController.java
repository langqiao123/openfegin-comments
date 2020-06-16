package example.spring.controller;

import com.alibaba.fastjson.JSON;
import example.spring.dto.BankCardValidateBaseReqDto;
import example.spring.dto.BankCardValidateBaseReqDto2;
import example.spring.dto.BasicResponse;
import example.spring.dto.NameUnionMatchValidationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
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
    public BasicResponse<NameUnionMatchValidationDto> nameValidation(@RequestBody BankCardValidateBaseReqDto req) {
        BasicResponse<NameUnionMatchValidationDto> result = new BasicResponse<>();
        log.info("nameValidation,调用,param:{}", JSON.toJSONString(req));
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

    /**
     * 银行卡有效性验证.
     */
    @RequestMapping(value = {"/nameValidation1"}, method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse<NameUnionMatchValidationDto> nameValidation1(@RequestBody BankCardValidateBaseReqDto req,Sort sort) {
        BasicResponse<NameUnionMatchValidationDto> result = new BasicResponse<>();
        log.info("nameValidation,调用,param:{}", JSON.toJSONString(req));
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


    /**
     * 银行卡有效性验证.
     */
    @RequestMapping(value = {"/nameValidation2"}, method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse<NameUnionMatchValidationDto> nameValidation2(@RequestBody BankCardValidateBaseReqDto2 req) {
        BasicResponse<NameUnionMatchValidationDto> result = new BasicResponse<>();
        log.info("nameValidation,调用,param:{}", JSON.toJSONString(req));
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

    /**
     * 银行卡有效性验证.
     */
    @RequestMapping(value = {"/nameValidation3"}, method = RequestMethod.GET)
    @ResponseBody
    public BasicResponse<NameUnionMatchValidationDto> nameValidation3(@RequestBody BankCardValidateBaseReqDto2 req) {
        BasicResponse<NameUnionMatchValidationDto> result = new BasicResponse<>();
        log.info("nameValidation,调用,param:{}", JSON.toJSONString(req));
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

    /**
     * 银行卡有效性验证.
     */
    @RequestMapping(value = {"/nameValidation4"}, method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse<NameUnionMatchValidationDto> nameValidation4(@RequestBody BankCardValidateBaseReqDto2 req,@RequestParam Long userId) {
        BasicResponse<NameUnionMatchValidationDto> result = new BasicResponse<>();
        log.info("nameValidation,调用,param:{}", JSON.toJSONString(req));
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

    /**
     * 银行卡有效性验证.
     */
    @RequestMapping(value = {"/nameValidation5"}, method = RequestMethod.POST)
    @ResponseBody
    public BasicResponse<NameUnionMatchValidationDto> nameValidation5(@RequestParam(value="userId1") String userId1,@RequestParam(value="userId") Long userId) {
        BasicResponse<NameUnionMatchValidationDto> result = new BasicResponse<>();
        log.info("nameValidation,调用,userId1:{},userId:{}", userId1,userId);
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
