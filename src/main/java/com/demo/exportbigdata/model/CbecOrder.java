package com.demo.exportbigdata.model;

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

    private String orderSn;

    private String merchOrderSn;

    private String merchSn;

    private String merchName;

    private String shopSn;

    private String shopName;

    private String platSn;

    private String platName;

    private String logisticsNo;

    private String cusShopId;

    private String thirdPartyMerchCode;

    private String thirdPartyMerchName;

    private String eBizType;

    private String eClearType;

    private String cusCode;

    private String bondedCode;

    private String wareSn;

    private String orderStatus;

    private Date placeOrderlTime;

    private String autoSend;

    private Date buyerBillTime;

    private String buyerIdType;

    private String buyerIdCode;

    private String buyerName;

    private String buyerMob;

    private String buyerTel;

    private String consigneeIdType;

    private String consigneeIdCode;

    private String consigneeName;

    private String consigneeMob;

    private String consigneeTel;

    private String consigneeCountryCode;

    private String consigneeProvinceCode;

    private String consigneeProvince;

    private String consigneeCityCode;

    private String consigneeCity;

    private String consigneeDistrictCode;

    private String consigneeDistrict;

    private String consigneeAddress;

    private String consigneeZipCode;

    private String payerName;

    private String payerIdType;

    private String payerIdCode;

    private String payerMob;

    private String payerTel;

    private String payEntCusCode;

    private String payNo;

    private BigDecimal itemAmount;

    private BigDecimal acturalPaid;

    private Date payTime;

    private BigDecimal exprFee;

    private BigDecimal insuredFee;

    private BigDecimal postTax;

    private String currencyCode;

    private String buyerRemark;

    private String createrSn;

    private Date createTime;

    private String moderSn;

    private Date modTime;

    private Date tstm;

    private String exField;

    private String exField2;

    private String exField3;

    private String exField4;

    private String exField5;

    private String orderShipType;

    private String cusPaymentSucceeded;

    private String cusOrderSucceeded;

    private String paySucceeded;

    private String buyerPayerCheck;

    private Date orderSuccessTime;

    private Date orderChargebackTime;
}
