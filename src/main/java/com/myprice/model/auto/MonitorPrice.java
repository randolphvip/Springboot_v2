package com.myprice.model.auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fc.v2.util.DateUtils;

import io.swagger.annotations.ApiModelProperty;

public class MonitorPrice implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ID")
	private Integer id;
	
	@ApiModelProperty(value = "Shop(reserved field)")
	private Integer shopId;
	
	@ApiModelProperty(value = "Comondity(reserved field)")
	private Integer commodityId;
	
	@ApiModelProperty(value = "shop_commodity_id")
	private Integer shopCommodityId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "Date")
	private Date date;
	
	@ApiModelProperty(value = "Price")
	private BigDecimal price;
	
	@ApiModelProperty(value = "Branch")
	private Integer branchId;
	
	@ApiModelProperty(value = "shopName")
	private String shopName;
	@ApiModelProperty(value = "commodityName")
	private String commodityName;
	@ApiModelProperty(value = "branchName")
	private String branchName;
	 
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("shopId")
	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId =  shopId;
	}
	@JsonProperty("commodityId")
	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId =  commodityId;
	}
	@JsonProperty("shopCommodityId")
	public Integer getShopCommodityId() {
		return shopCommodityId;
	}

	public void setShopCommodityId(Integer shopCommodityId) {
		this.shopCommodityId =  shopCommodityId;
	}
	@JsonProperty("date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date =  date;
	}
	@JsonProperty("price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price =  price;
	}
	@JsonProperty("branchId")
	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId =  branchId;
	}

														
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public MonitorPrice(Integer id,Integer shopId,Integer commodityId,Integer shopCommodityId,Date date,BigDecimal price,Integer branchId) {
				
		this.id = id;
				
		this.shopId = shopId;
				
		this.commodityId = commodityId;
				
		this.shopCommodityId = shopCommodityId;
				
		this.date = date;
				
		this.price = price;
				
		this.branchId = branchId;
				
	}

	@Override
	public String toString() {
		return "MonitorPrice [id=" + id + ", shopId=" + shopId + ", commodityId=" + commodityId + ", shopCommodityId="
				+ shopCommodityId + ", date=" + date + ", price=" + price + ", branchId=" + branchId + ", shopName="
				+ shopName + ", commodityName=" + commodityName + ", branchName=" + branchName + "]";
	}

	public MonitorPrice() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}