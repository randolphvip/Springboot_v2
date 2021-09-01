package com.myprice.model.auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fc.v2.util.DateUtils;

import io.swagger.annotations.ApiModelProperty;

public class CommodityTradeMe implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ID")
	private Integer id;
	
	@ApiModelProperty(value = "URL")
	private String url;
	
	@ApiModelProperty(value = "Creator")
	private String creator;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "Create Date")
	private Date createDate;
	
	@ApiModelProperty(value = "Status")
	private Integer status;
	
	@ApiModelProperty(value = "Category")
	private Integer categoryId;
	
	@ApiModelProperty(value = "Templet(reserve)")
	private Integer templetId;
	
	@ApiModelProperty(value = "Frequency(reserve)")
	private String frequency;
	
	@ApiModelProperty(value = "Title ")
	private String title;
	
	@ApiModelProperty(value = "Description")
	private String description;
	
	@ApiModelProperty(value = "Starting Price")
	private BigDecimal startingPrice;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "Close Date")
	private Date closeDatetime;
	
	@ApiModelProperty(value = "Buy Now Price")
	private BigDecimal buyNowPrice;
	
	@ApiModelProperty(value = "Condition")
	private String conditionLevel;
	

	@ApiModelProperty(value = "Shipping ")
	private String shipping;
	
	@ApiModelProperty(value = "Reserve Status")
	private Integer reserveStatus;
	
	
	
	@ApiModelProperty(value = "categoryName")
	private String categoryName;	
	
	
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url =  url;
	}
	@JsonProperty("creator")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator =  creator;
	}
	@JsonProperty("createDate")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate =  createDate;
	}
	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status =  status;
	}
	@JsonProperty("categoryId")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId =  categoryId;
	}
	@JsonProperty("templetId")
	public Integer getTempletId() {
		return templetId;
	}

	public void setTempletId(Integer templetId) {
		this.templetId =  templetId;
	}
	@JsonProperty("frequency")
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency =  frequency;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title =  title;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("startingPrice")
	public BigDecimal getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(BigDecimal startingPrice) {
		this.startingPrice =  startingPrice;
	}
	@JsonProperty("closeDatetime")
	public Date getCloseDatetime() {
		return closeDatetime;
	}

	public void setCloseDatetime(Date closeDatetime) {
		this.closeDatetime =  closeDatetime;
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
	@JsonProperty("shipping")
	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping =  shipping;
	}
	@JsonProperty("reserveStatus")
	public Integer getReserveStatus() {
		return reserveStatus;
	}

	public void setReserveStatus(Integer reserveStatus) {
		this.reserveStatus =  reserveStatus;
	}

	@JsonProperty("categoryName")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

																																
	public CommodityTradeMe(Integer id,String url,String creator,Date createDate,Integer status,Integer categoryId,Integer templetId,String frequency,String title,String description,BigDecimal startingPrice,Date closeDatetime,BigDecimal buyNowPrice,String conditionLevel,String shipping,Integer reserveStatus) {
				
		this.id = id;
				
		this.url = url;
				
		this.creator = creator;
				
		this.createDate = createDate;
				
		this.status = status;
				
		this.categoryId = categoryId;
				
		this.templetId = templetId;
				
		this.frequency = frequency;
				
		this.title = title;
				
		this.description = description;
				
		this.startingPrice = startingPrice;
				
		this.closeDatetime = closeDatetime;
				
		this.buyNowPrice = buyNowPrice;
				
		this.conditionLevel = conditionLevel;
				
		this.shipping = shipping;
				
		this.reserveStatus = reserveStatus;
				
	}
 

	@Override
	public String toString() {
		return "CommodityTradeMe [id=" + id + ", url=" + url + ", creator=" + creator + ", createDate=" + createDate
				+ ", status=" + status + ", categoryId=" + categoryId + ", templetId=" + templetId + ", frequency="
				+ frequency + ", title=" + title + ", description=" + description + ", startingPrice=" + startingPrice
				+ ", closeDatetime=" + closeDatetime + ", buyNowPrice=" + buyNowPrice + ", conditionLevel="
				+ conditionLevel + ", shipping=" + shipping + ", reserveStatus=" + reserveStatus + ", categoryName="
				+ categoryName + "]";
	}

	public CommodityTradeMe() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}