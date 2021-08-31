package com.myprice.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;
import java.math.BigDecimal;

public class ShopCommodity implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ID")
	private Integer id;
	
	@ApiModelProperty(value = "Shop")
	private Integer shopId;
	
	@ApiModelProperty(value = "Commodity")
	private Integer commodityId;
	
	@ApiModelProperty(value = "URL")
	private String uRL;
	
	@ApiModelProperty(value = "Status")
	private Integer status;
	
	@ApiModelProperty(value = "CommodityName")
	private String commodityName;
	
	@ApiModelProperty(value = "shopName")
	private String shopName;
	
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
	@JsonProperty("uRL")
	public String getURL() {
		return uRL;
	}

	public void setURL(String uRL) {
		this.uRL =  uRL;
	}
	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status =  status;
	}

										
	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public ShopCommodity(Integer id,Integer shopId,Integer commodityId,String uRL,Integer status) {
				
		this.id = id;
				
		this.shopId = shopId;
				
		this.commodityId = commodityId;
				
		this.uRL = uRL;
				
		this.status = status;
				
	}

	public ShopCommodity() {
	    super();
	}

	

}