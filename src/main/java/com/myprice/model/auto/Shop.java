package com.myprice.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;
import java.math.BigDecimal;

public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ID")
	private Integer id;
	
	@ApiModelProperty(value = "Shop Name")
	private String shopName;
	
	@ApiModelProperty(value = "Description")
	private String description;
	
	@ApiModelProperty(value = "Logo")
	private String logo;
	
	@ApiModelProperty(value = "Address")
	private String address;
	
	@ApiModelProperty(value = "Website")
	private String website;
	
	@ApiModelProperty(value = "Hotline")
	private String hotline;
	
	@ApiModelProperty(value = "Keywords")
	private String keywords;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("shopName")
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName =  shopName;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description =  description;
	}
	@JsonProperty("logo")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo =  logo;
	}
	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address =  address;
	}
	@JsonProperty("website")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website =  website;
	}
	@JsonProperty("hotline")
	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline =  hotline;
	}
	@JsonProperty("keywords")
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords =  keywords;
	}

																
	public Shop(Integer id,String shopName,String description,String logo,String address,String website,String hotline,String keywords) {
				
		this.id = id;
				
		this.shopName = shopName;
				
		this.description = description;
				
		this.logo = logo;
				
		this.address = address;
				
		this.website = website;
				
		this.hotline = hotline;
				
		this.keywords = keywords;
				
	}

	public Shop() {
	    super();
	}

	

}