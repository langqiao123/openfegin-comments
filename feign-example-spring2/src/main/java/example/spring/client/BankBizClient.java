package example.spring.client;

import example.spring.dto.*;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

public interface BankBizClient {

    /**
     *
     * 银行卡有效性验证.
     */
    @RequestLine("POST /payment/bank/nameValidation")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    BasicResponse<NameUnionMatchValidationDto> nameValidation(BankCardValidateBaseReqDto req);
    /**
     *
     * 银行卡有效性验证.
     */
    @RequestLine("POST /payment/bank/nameValidation1")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    BasicResponse<NameUnionMatchValidationDto> nameValidation1(@Param("req") BankCardValidateBaseReqSortDto req, @Param("sort")Sort sort);


    /**
     *
     * 银行卡有效性验证.
     */
    @RequestLine("POST /payment/bank/nameValidation2")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    BasicResponse<NameUnionMatchValidationDto> nameValidation2(BankCardValidateBaseReqDto2 req);

    /**
     *
     * 银行卡有效性验证.
     */
    @RequestLine("POST /payment/bank/nameValidation2")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    BasicResponse<NameUnionMatchValidationDto> nameValidation3(BankCardValidateBaseReqDto2 req);

    /**
     *
     * 银行卡有效性验证.
     */
    @RequestLine("POST /payment/bank/nameValidation4")
    @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: application/json"})
    BasicResponse<NameUnionMatchValidationDto> nameValidation4(BankCardValidateBaseReqDto2 req,@RequestParam Long userId);

    /**
     *
     * 银行卡有效性验证.
     */
    @RequestLine("POST /payment/bank/nameValidation5")
    @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: application/json"})
    BasicResponse<NameUnionMatchValidationDto> nameValidation5(@RequestParam String userName,@RequestParam Long userId);
}
