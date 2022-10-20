package com.demo.exportbigdata.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 订单类
 *
 * @author frankeleyn
 * @email lvjian@qhdswl.com
 * @date 2022/9/14 15:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CbecOrder {

    @ExcelProperty("序号")
    private String orderSn;

    @ExcelProperty("商户订单编号")
    private String merchOrderSn;

    @ExcelProperty("商户号")
    private String merchSn;

    @ExcelProperty("商户名称")
    private String merchName;

    @ExcelProperty("门店编号")
    private String shopSn;

    @ExcelProperty("门店名称")
    private String shopName;

    @ExcelIgnore
    private String platSn;

    @ExcelProperty("平台名称")
    private String platName;

    @ExcelIgnore
    private String logisticsNo;

    @ExcelIgnore
    private String cusShopId;

    @ExcelIgnore
    private String thirdPartyMerchCode;

    @ExcelIgnore
    private String thirdPartyMerchName;

    @ExcelIgnore
    private String eBizType;

    @ExcelIgnore
    private String eClearType;

    @ExcelIgnore
    private String cusCode;

    @ExcelIgnore
    private String bondedCode;

    @ExcelIgnore
    private String wareSn;

    @ExcelIgnore
    private String orderStatus;

    @ExcelIgnore
    private Date placeOrderlTime;

    @ExcelIgnore
    private String autoSend;

    @ExcelIgnore
    private Date buyerBillTime;

    @ExcelIgnore
    private String buyerIdType;

    @ExcelProperty("购买人身份证")
    private String buyerIdCode;

    @ExcelProperty("购买人姓名")
    private String buyerName;

    @ExcelIgnore
    private String buyerMob;

    @ExcelIgnore
    private String buyerTel;

    @ExcelIgnore
    private String consigneeIdType;

    @ExcelIgnore
    private String consigneeIdCode;

    @ExcelProperty("收货人姓名")
    private String consigneeName;

    @ExcelIgnore
    private String consigneeMob;

    @ExcelIgnore
    private String consigneeTel;

    @ExcelIgnore
    private String consigneeCountryCode;

    @ExcelIgnore
    private String consigneeProvinceCode;

    @ExcelIgnore
    private String consigneeProvince;

    @ExcelIgnore
    private String consigneeCityCode;

    @ExcelIgnore
    private String consigneeCity;

    @ExcelIgnore
    private String consigneeDistrictCode;

    @ExcelIgnore
    private String consigneeDistrict;

    @ExcelProperty("收货人地址")
    private String consigneeAddress;

    @ExcelIgnore
    private String consigneeZipCode;

    @ExcelIgnore
    private String payerName;

    @ExcelIgnore
    private String payerIdType;

    @ExcelIgnore
    private String payerIdCode;

    @ExcelIgnore
    private String payerMob;

    @ExcelIgnore
    private String payerTel;

    @ExcelIgnore
    private String payEntCusCode;

    @ExcelIgnore
    private String payNo;

    @ExcelIgnore
    private BigDecimal itemAmount;

    @ExcelIgnore
    private BigDecimal acturalPaid;

    @ExcelIgnore
    private Date payTime;

    @ExcelIgnore
    private BigDecimal exprFee;

    @ExcelIgnore
    private BigDecimal insuredFee;

    @ExcelIgnore
    private BigDecimal postTax;

    @ExcelIgnore
    private String currencyCode;

    @ExcelIgnore
    private String buyerRemark;

    @ExcelIgnore
    private String createrSn;

    @ExcelIgnore
    private Date createTime;

    @ExcelIgnore
    private String moderSn;

    @ExcelIgnore
    private Date modTime;

    @ExcelIgnore
    private Date tstm;

    @ExcelIgnore
    private String exField;

    @ExcelIgnore
    private String exField2;

    @ExcelIgnore
    private String exField3;

    @ExcelIgnore
    private String exField4;

    @ExcelIgnore
    private String exField5;

    @ExcelIgnore
    private String orderShipType;

    @ExcelIgnore
    private String cusPaymentSucceeded;

    @ExcelIgnore
    private String cusOrderSucceeded;

    @ExcelIgnore
    private String paySucceeded;

    @ExcelIgnore
    private String buyerPayerCheck;

    @ExcelIgnore
    private Date orderSuccessTime;

    @ExcelIgnore
    private Date orderChargebackTime;
}
