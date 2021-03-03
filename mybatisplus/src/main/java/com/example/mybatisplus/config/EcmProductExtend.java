package com.example.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.math.BigDecimal;
import java.util.Date;

public class EcmProductExtend {

  private Integer id;

  private String productNid;

  private String inviteCode;

  private BigDecimal applyAmount;

  private Integer pushProductType;

  private String pushProductUser;

  private Date createTime;

  private Date updateTime;

  private String exhibitionPeriodOperatorApplyUser;

  private Date exhibitionPeriodOperatorApplyTime;

  private Date exhibitionPeriodBorrowerConfirmTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProductNid() {
    return productNid;
  }

  public void setProductNid(String productNid) {
    this.productNid = productNid;
  }

  public String getInviteCode() {
    return inviteCode;
  }

  public void setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
  }

  public BigDecimal getApplyAmount() {
    return applyAmount;
  }

  public void setApplyAmount(BigDecimal applyAmount) {
    this.applyAmount = applyAmount;
  }

  public Integer getPushProductType() {
    return pushProductType;
  }

  public void setPushProductType(Integer pushProductType) {
    this.pushProductType = pushProductType;
  }

  public String getPushProductUser() {
    return pushProductUser;
  }

  public void setPushProductUser(String pushProductUser) {
    this.pushProductUser = pushProductUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getExhibitionPeriodOperatorApplyUser() {
    return exhibitionPeriodOperatorApplyUser;
  }

  public void setExhibitionPeriodOperatorApplyUser(String exhibitionPeriodOperatorApplyUser) {
    this.exhibitionPeriodOperatorApplyUser = exhibitionPeriodOperatorApplyUser;
  }

  public Date getExhibitionPeriodOperatorApplyTime() {
    return exhibitionPeriodOperatorApplyTime;
  }

  public void setExhibitionPeriodOperatorApplyTime(Date exhibitionPeriodOperatorApplyTime) {
    this.exhibitionPeriodOperatorApplyTime = exhibitionPeriodOperatorApplyTime;
  }

  public Date getExhibitionPeriodBorrowerConfirmTime() {
    return exhibitionPeriodBorrowerConfirmTime;
  }

  public void setExhibitionPeriodBorrowerConfirmTime(Date exhibitionPeriodBorrowerConfirmTime) {
    this.exhibitionPeriodBorrowerConfirmTime = exhibitionPeriodBorrowerConfirmTime;
  }
}
