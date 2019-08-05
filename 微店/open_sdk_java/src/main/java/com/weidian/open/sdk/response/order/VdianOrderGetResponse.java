package com.weidian.open.sdk.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weidian.open.sdk.response.AbstractResponse;

public class VdianOrderGetResponse extends AbstractResponse {

  private VdianOrderGetResult result;

  public VdianOrderGetResult getResult() {
    return result;
  }

  public void setResult(VdianOrderGetResult result) {
    this.result = result;
  }


  /***** VdianOrderGetResult *****/
  public static class VdianOrderGetResult {

    private String total;
    private String express;
    private String quantity;
    private String note;
    private String sk;
    private String status;
    private String discount;
    private String price;
    private String status2;
    private String weixin;

    @JsonProperty("add_time")
    private String addTime;

    @JsonProperty("return_code")
    private String returnCode;

    @JsonProperty("original_total_price")
    private String originalTotalPrice;

    @JsonProperty("f_shop_name")
    private String fShopName;

    @JsonProperty("express_no")
    private String expressNo;

    @JsonProperty("order_type")
    private String orderType;

    @JsonProperty("f_seller_id")
    private String fSellerId;

    @JsonProperty("seller_id")
    private String sellerId;

    @JsonProperty("real_income_price")
    private String realIncomePrice;

    @JsonProperty("user_phone")
    private String userPhone;

    @JsonProperty("seller_name")
    private String sellerName;

    @JsonProperty("express_fee")
    private String expressFee;

    @JsonProperty("buyer_identity_id")
    private String buyerIdentityId;

    @JsonProperty("f_phone")
    private String fPhone;

    @JsonProperty("fx_fee_value")
    private String fxFeeValue;

    @JsonProperty("modify_price_enable")
    private String modifyPriceEnable;

    @JsonProperty("express_note")
    private String expressNote;

    @JsonProperty("express_type")
    private String expressType;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("order_type_des")
    private String orderTypeDes;

    @JsonProperty("confirm_expire")
    private String confirmExpire;

    @JsonProperty("send_time")
    private String sendTime;

    @JsonProperty("total_fee")
    private String totalFee;

    @JsonProperty("status_desc")
    private String statusDesc;

    @JsonProperty("trade_no")
    private String tradeNo;

    @JsonProperty("discount_info")
    private String discountInfo;

    @JsonProperty("express_fee_num")
    private String expressFeeNum;

    @JsonProperty("seller_phone")
    private String sellerPhone;

    @JsonProperty("pay_time")
    private String payTime;

    @JsonProperty("discount_amount")
    private String discountAmount;

    @JsonProperty("is_close")
    private int isClose;

    @JsonProperty("argue_flag")
    private int argueFlag;

    @JsonProperty("group_status")
    private String groupStatus;

    @JsonProperty("buyer_info")
    private BuyerInfo buyerInfo;

    private OrderItem[] items;

    @JsonProperty("discount_list")
    private DiscountList[] discountList;

    public String getTotal() {
      return total;
    }

    public void setTotal(String total) {
      this.total = total;
    }

    public String getExpress() {
      return express;
    }

    public void setExpress(String express) {
      this.express = express;
    }

    public String getQuantity() {
      return quantity;
    }

    public void setQuantity(String quantity) {
      this.quantity = quantity;
    }

    public String getNote() {
      return note;
    }

    public void setNote(String note) {
      this.note = note;
    }

    public String getSk() {
      return sk;
    }

    public void setSk(String sk) {
      this.sk = sk;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }

    public String getDiscount() {
      return discount;
    }

    public void setDiscount(String discount) {
      this.discount = discount;
    }

    public String getPrice() {
      return price;
    }

    public void setPrice(String price) {
      this.price = price;
    }

    public String getStatus2() {
      return status2;
    }

    public void setStatus2(String status2) {
      this.status2 = status2;
    }

    public String getAddTime() {
      return addTime;
    }

    public void setAddTime(String addTime) {
      this.addTime = addTime;
    }

    public String getReturnCode() {
      return returnCode;
    }

    public void setReturnCode(String returnCode) {
      this.returnCode = returnCode;
    }

    public String getOriginalTotalPrice() {
      return originalTotalPrice;
    }

    public void setOriginalTotalPrice(String originalTotalPrice) {
      this.originalTotalPrice = originalTotalPrice;
    }

    public String getfShopName() {
      return fShopName;
    }

    public void setfShopName(String fShopName) {
      this.fShopName = fShopName;
    }

    public String getExpressNo() {
      return expressNo;
    }

    public void setExpressNo(String expressNo) {
      this.expressNo = expressNo;
    }

    public String getOrderType() {
      return orderType;
    }

    public void setOrderType(String orderType) {
      this.orderType = orderType;
    }

    public String getfSellerId() {
      return fSellerId;
    }

    public void setfSellerId(String fSellerId) {
      this.fSellerId = fSellerId;
    }

    public String getSellerId() {
      return sellerId;
    }

    public void setSellerId(String sellerId) {
      this.sellerId = sellerId;
    }

    public String getRealIncomePrice() {
      return realIncomePrice;
    }

    public void setRealIncomePrice(String realIncomePrice) {
      this.realIncomePrice = realIncomePrice;
    }

    public String getUserPhone() {
      return userPhone;
    }

    public void setUserPhone(String userPhone) {
      this.userPhone = userPhone;
    }

    public String getSellerName() {
      return sellerName;
    }

    public void setSellerName(String sellerName) {
      this.sellerName = sellerName;
    }

    public String getExpressFee() {
      return expressFee;
    }

    public void setExpressFee(String expressFee) {
      this.expressFee = expressFee;
    }

    public String getBuyerIdentityId() {
      return buyerIdentityId;
    }

    public void setBuyerIdentityId(String buyerIdentityId) {
      this.buyerIdentityId = buyerIdentityId;
    }

    public String getfPhone() {
      return fPhone;
    }

    public void setfPhone(String fPhone) {
      this.fPhone = fPhone;
    }

    public String getFxFeeValue() {
      return fxFeeValue;
    }

    public void setFxFeeValue(String fxFeeValue) {
      this.fxFeeValue = fxFeeValue;
    }

    public String getModifyPriceEnable() {
      return modifyPriceEnable;
    }

    public void setModifyPriceEnable(String modifyPriceEnable) {
      this.modifyPriceEnable = modifyPriceEnable;
    }

    public String getExpressNote() {
      return expressNote;
    }

    public void setExpressNote(String expressNote) {
      this.expressNote = expressNote;
    }

    public String getExpressType() {
      return expressType;
    }

    public void setExpressType(String expressType) {
      this.expressType = expressType;
    }

    public String getOrderId() {
      return orderId;
    }

    public void setOrderId(String orderId) {
      this.orderId = orderId;
    }

    public String getOrderTypeDes() {
      return orderTypeDes;
    }

    public void setOrderTypeDes(String orderTypeDes) {
      this.orderTypeDes = orderTypeDes;
    }

    public String getConfirmExpire() {
      return confirmExpire;
    }

    public void setConfirmExpire(String confirmExpire) {
      this.confirmExpire = confirmExpire;
    }

    public String getSendTime() {
      return sendTime;
    }

    public void setSendTime(String sendTime) {
      this.sendTime = sendTime;
    }

    public String getTotalFee() {
      return totalFee;
    }

    public void setTotalFee(String totalFee) {
      this.totalFee = totalFee;
    }

    public String getStatusDesc() {
      return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
      this.statusDesc = statusDesc;
    }

    public String getTradeNo() {
      return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
      this.tradeNo = tradeNo;
    }

    public String getDiscountInfo() {
      return discountInfo;
    }

    public void setDiscountInfo(String discountInfo) {
      this.discountInfo = discountInfo;
    }

    public String getExpressFeeNum() {
      return expressFeeNum;
    }

    public void setExpressFeeNum(String expressFeeNum) {
      this.expressFeeNum = expressFeeNum;
    }

    public String getSellerPhone() {
      return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
      this.sellerPhone = sellerPhone;
    }

    public String getPayTime() {
      return payTime;
    }

    public void setPayTime(String payTime) {
      this.payTime = payTime;
    }

    public String getDiscountAmount() {
      return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
      this.discountAmount = discountAmount;
    }

    public int getIsClose() {
      return isClose;
    }

    public void setIsClose(int isClose) {
      this.isClose = isClose;
    }

    public int getArgueFlag() {
      return argueFlag;
    }

    public void setArgueFlag(int argueFlag) {
      this.argueFlag = argueFlag;
    }

    public BuyerInfo getBuyerInfo() {
      return buyerInfo;
    }

    public void setBuyerInfo(BuyerInfo buyerInfo) {
      this.buyerInfo = buyerInfo;
    }

    public OrderItem[] getItems() {
      return items;
    }

    public void setItems(OrderItem[] items) {
      this.items = items;
    }

    public String getWeixin() {
      return weixin;
    }

    public void setWeixin(String weixin) {
      this.weixin = weixin;
    }

    public String getGroupStatus() {
      return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
      this.groupStatus = groupStatus;
    }

    public DiscountList[] getDiscountList() {
      return discountList;
    }

    public void setDiscountList(DiscountList[] discountList) {
      this.discountList = discountList;
    }
  }


  /***** RefundInfo *****/
  public static class RefundInfo {

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("item_sku_id")
    private String itemSkuId;

    @JsonProperty("can_refund")
    private String canRefund;

    @JsonProperty("refund_status_desc")
    private String refundStatusDesc;

    @JsonProperty("refund_fee")
    private String refundFee;

    @JsonProperty("refund_express_fee")
    private String refundExpressFee;

    @JsonProperty("refund_item_fee")
    private String refundItemFee;

    @JsonProperty("refund_status")
    private String refundStatus;

    @JsonProperty("refund_status_str")
    private String refundStatusStr;

    @JsonProperty("refund_no")
    private String refundNo;

    public String getItemId() {
      return itemId;
    }

    public void setItemId(String itemId) {
      this.itemId = itemId;
    }

    public String getItemSkuId() {
      return itemSkuId;
    }

    public void setItemSkuId(String itemSkuId) {
      this.itemSkuId = itemSkuId;
    }

    public String getCanRefund() {
      return canRefund;
    }

    public void setCanRefund(String canRefund) {
      this.canRefund = canRefund;
    }

    public String getRefundStatusDesc() {
      return refundStatusDesc;
    }

    public void setRefundStatusDesc(String refundStatusDesc) {
      this.refundStatusDesc = refundStatusDesc;
    }

    public String getRefundFee() {
      return refundFee;
    }

    public void setRefundFee(String refundFee) {
      this.refundFee = refundFee;
    }

    public String getRefundExpressFee() {
      return refundExpressFee;
    }

    public void setRefundExpressFee(String refundExpressFee) {
      this.refundExpressFee = refundExpressFee;
    }

    public String getRefundItemFee() {
      return refundItemFee;
    }

    public void setRefundItemFee(String refundItemFee) {
      this.refundItemFee = refundItemFee;
    }

    public String getRefundStatus() {
      return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
      this.refundStatus = refundStatus;
    }

    public String getRefundStatusStr() {
      return refundStatusStr;
    }

    public void setRefundStatusStr(String refundStatusStr) {
      this.refundStatusStr = refundStatusStr;
    }

    public String getRefundNo() {
      return refundNo;
    }

    public void setRefundNo(String refundNo) {
      this.refundNo = refundNo;
    }
  }


  /***** OrderItem *****/
  public static class OrderItem {

    private String price;
    private String img;
    private String quantity;
    private String url;

    @JsonProperty("sku_merchant_code")
    private String skuMerchantCode;

    @JsonProperty("item_name")
    private String itemName;

    @JsonProperty("fx_fee_rate")
    private String fxFeeRate;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("sku_id")
    private String skuId;

    @JsonProperty("merchant_code")
    private String merchantCode;

    @JsonProperty("total_price")
    private String totalPrice;

    @JsonProperty("sku_title")
    private String skuTitle;

    @JsonProperty("refund_info")
    private RefundInfo refundInfo;

    @JsonProperty("deliver_status_desc")
    private String deliverStatusDesc;

    @JsonProperty("deliver_id")
    private String deliverId;

    @JsonProperty("is_delivered")
    private String isDelivered;

    @JsonProperty("can_deliver")
    private String canDeliver;


    public String getPrice() {
      return price;
    }

    public void setPrice(String price) {
      this.price = price;
    }

    public String getImg() {
      return img;
    }

    public void setImg(String img) {
      this.img = img;
    }

    public String getQuantity() {
      return quantity;
    }

    public void setQuantity(String quantity) {
      this.quantity = quantity;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public String getSkuMerchantCode() {
      return skuMerchantCode;
    }

    public void setSkuMerchantCode(String skuMerchantCode) {
      this.skuMerchantCode = skuMerchantCode;
    }

    public String getItemName() {
      return itemName;
    }

    public void setItemName(String itemName) {
      this.itemName = itemName;
    }

    public String getFxFeeRate() {
      return fxFeeRate;
    }

    public void setFxFeeRate(String fxFeeRate) {
      this.fxFeeRate = fxFeeRate;
    }

    public String getItemId() {
      return itemId;
    }

    public void setItemId(String itemId) {
      this.itemId = itemId;
    }

    public String getSkuId() {
      return skuId;
    }

    public void setSkuId(String skuId) {
      this.skuId = skuId;
    }

    public String getMerchantCode() {
      return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
      this.merchantCode = merchantCode;
    }

    public String getTotalPrice() {
      return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
      this.totalPrice = totalPrice;
    }

    public String getSkuTitle() {
      return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
      this.skuTitle = skuTitle;
    }

    public String getDeliverStatusDesc() {
      return deliverStatusDesc;
    }

    public void setDeliverStatusDesc(String deliverStatusDesc) {
      this.deliverStatusDesc = deliverStatusDesc;
    }

    public String getDeliverId() {
      return deliverId;
    }

    public void setDeliverId(String deliverId) {
      this.deliverId = deliverId;
    }

    public String getIsDelivered() {
      return isDelivered;
    }

    public void setIsDelivered(String isDelivered) {
      this.isDelivered = isDelivered;
    }

    public String getCanDeliver() {
      return canDeliver;
    }

    public void setCanDeliver(String canDeliver) {
      this.canDeliver = canDeliver;
    }

    public RefundInfo getRefundInfo() {
      return refundInfo;
    }

    public void setRefundInfo(RefundInfo refundInfo) {
      this.refundInfo = refundInfo;
    }
  }

  public static class DiscountList {

    @JsonProperty("discount_info")
    private String discountInfo;

    @JsonProperty("discount_type")
    private String discountType;

    @JsonProperty("discount_price")
    private String discountPrice;

    public String getDiscountInfo() {
      return discountInfo;
    }

    public void setDiscountInfo(String discountInfo) {
      this.discountInfo = discountInfo;
    }

    public String getDiscountType() {
      return discountType;
    }

    public void setDiscountType(String discountType) {
      this.discountType = discountType;
    }

    public String getDiscountPrice() {
      return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
      this.discountPrice = discountPrice;
    }
  }

}
