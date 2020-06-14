package example.springboot.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import example.springboot.config.CustomSortDeserializer;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * 银行卡校验
 */
@Data
public class BankCardValidateBaseReqDto implements Serializable {

    /**
     * 银行账（卡）号
     */
    private String accountNo;

    /**
     * 账户名称
     */
    private String accountName;

    /**
     * 银行编号
     */
    private String bankCode;

    /**
     * accountNo账户类型：
     * 0 - 银行账号
     * 1 - 银行卡号
     * 不传，系统默认【0 - 银行账号】
     */
    private Integer accountType;

    private Long userId;

    private String businessNo;

    /**
     * 绑卡验证服务供应商
     */
    private String provider;
    @JsonDeserialize(using = CustomSortDeserializer.class)
    private Sort sort;
}
