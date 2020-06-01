package example.springboot.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 名称验证结果.
 * @author shengke
 * @date 2018/3/19
 */
@Data
public class NameUnionMatchValidationDto implements Serializable {

    /**
     * 校验结果
     * CommConstant.BizBankCardType
     */
    private Integer status;

    /**
     * 银行账号.
     */
    private String bankAccountNumber;

    /**
     * 用户银行登记名字.
     */
    private String bankAccountHolderName;

    /**
     * 银行code.
     */
    private String bankCode;

    /**
     * 是否是正常的卡
     */
    private Boolean isNormalAccount;

    /**
     * 业务类型ID.
     */
    private String businessNo;

}
