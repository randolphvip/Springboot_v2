package com.myprice.model.auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.ApiModelProperty;

public class CommodityTrademeDetail implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ID")
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "CloseDate")
	private Date closeDatetime;
	
	@ApiModelProperty(value = "Title")
	private String title;
	
	@ApiModelProperty(value = "Buy Now Price")
	private BigDecimal buyNowPrice;
	
	@ApiModelProperty(value = "Condition")
	private String conditionLevel;
	
	@ApiModelProperty(value = "Description")
	private String description;
	
	@ApiModelProperty(value = "Shipping ")
	private String shipping;
	
	@ApiModelProperty(value = "Starting price")
	private BigDecimal startingPrice;
	
	@ApiModelProperty(value = "Reserve Status")
	private String reserveStatus;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("closeDatetime")
	public Date getCloseDatetime() {
		return closeDatetime;
	}

	public void setCloseDatetime(Date closeDatetime) {
		this.closeDatetime =  closeDatetime;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title =  title;
	}
	@JsonProperty("buyNowPrice")
	public BigDecimal getBuyNowPrice() {
		return buyNowPrice;
	}

	public void setBuyNowPrice(BigDecimal buyNowPrice) {
		this.buyNowPrice =  buyNowPrice;
	}
	@JsonProperty("conditionLevel")
	public String getConditionLevel() {
		return conditionLevel;
	}

	public void setConditionLevel(String conditionLevel) {
		this.conditionLevel =  conditionLevel;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("shipping")
	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping =  shipping;
	}
	@JsonProperty("startingPrice")
	public BigDecimal getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(BigDecimal startingPrice) {
		this.startingPrice =  startingPrice;
	}
	@JsonProperty("reserveStatus")
	public String getReserveStatus() {
		return reserveStatus;
	}

	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus =  reserveStatus;
	}

																		
	public CommodityTrademeDetail(Integer id,Date closeDatetime,String title,BigDecimal buyNowPrice,String conditionLevel,String description,String shipping,BigDecimal startingPrice,String reserveStatus) {
				
		this.id = id;
				
		this.closeDatetime = closeDatetime;
				
		this.title = title;
				
		this.buyNowPrice = buyNowPrice;
				
		this.conditionLevel = conditionLevel;
				
		this.description = description;
				
		this.shipping = shipping;
				
		this.startingPrice = startingPrice;
				
		this.reserveStatus = reserveStatus;
				
	}

	public CommodityTrademeDetail() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}