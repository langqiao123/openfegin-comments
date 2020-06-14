package example.springboot.client;

import example.springboot.dto.BankCardValidateBaseReqDto;
import example.springboot.dto.BasicResponse;
import example.springboot.dto.NameUnionMatchValidationDto;
import feign.Headers;
import feign.RequestLine;

public interface BankBizClient {

    /**
     *
     * 银行卡有效性验证.
     */
    @RequestLine("POST /payment/bank/nameValidation")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    BasicResponse<NameUnionMatchValidationDto> nameValidation(BankCardValidateBaseReqDto req);

}
