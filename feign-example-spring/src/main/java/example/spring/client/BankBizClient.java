package example.spring.client;

import example.spring.dto.BankCardValidateBaseReqDto;
import example.spring.dto.BankCardValidateBaseReqDto2;
import example.spring.dto.BasicResponse;
import example.spring.dto.NameUnionMatchValidationDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.data.domain.Sort;

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
    BasicResponse<NameUnionMatchValidationDto> nameValidation1(@Param("req")BankCardValidateBaseReqDto req, @Param("sort")Sort sort);


    /**
     *
     * 银行卡有效性验证.
     */
    @RequestLine("POST /payment/bank/nameValidation2")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    BasicResponse<NameUnionMatchValidationDto> nameValidation2(BankCardValidateBaseReqDto2 req);
}
