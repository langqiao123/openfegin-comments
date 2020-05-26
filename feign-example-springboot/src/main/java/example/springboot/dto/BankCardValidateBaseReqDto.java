package example.springboot.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 银行卡校验
 */
@Data
public class BankCardValidateBaseReqDto implements Serializable {

    /**
     * 银行账（卡）号
     */
    @NotNull(message = "银行账（卡）号[accountNo]不能为空")
    private String accountNo;

    /**
     * 账户名称
     */
    @NotNull(message = "账户名称[accountName]不能为空")
    private String accountName;

    /**
     * 银行编号
     */
    @NotNull(message = "银行编号[bankCode]不能为空")
    private String bankCode;

    /**
     * accountNo账户类型：
     * 0 - 银行账号
     * 1 - 银行卡号
     * 不传，系统默认【0 - 银行账号】
     */
    @Max(value = 1, message = "账户类型[accountType]最大值1")
    @Min(value = 0, message = "账户类型[accountType]最小值0")
    private Integer accountType;

    private Long userId;

    private String businessNo;

    /**
     * 绑卡验证服务供应商
     */
    private String provider;
}
