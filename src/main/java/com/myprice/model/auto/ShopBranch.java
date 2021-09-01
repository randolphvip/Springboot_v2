package com.myprice.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;
import java.math.BigDecimal;

public class ShopBranch implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ID")
	private Integer id;
	
	@ApiModelProperty(value = "Address")
	private String address;
	
	@ApiModelProperty(value = "Hotline")
	private String hotline;
	
	@ApiModelProperty(value = "Shop ID")
	private Integer shopId;
	
	@ApiModelProperty(value = "Strore ID")
	private String storeId;
	
	@ApiModelProperty(value = "Branch Name")
	private String branchName;
	
	@ApiModelProperty(value = "Status")
	private Integer status;
	
	@ApiModelProperty(value = "Is Default")
	private Integer isDefault;
	
	@ApiModelProperty(value = "Cookie information")
	private String cookie;
	
	@ApiModelProperty(value = "shopName")
	private String shopName;
	
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address =  address;
	}
	@JsonProperty("hotline")
	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline =  hotline;
	}
	@JsonProperty("shopId")
	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId =  shopId;
	}
	@JsonProperty("storeId")
	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId =  storeId;
	}
	@JsonProperty("branchName")
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName =  branchName;
	}
	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status =  status;
	}
	@JsonProperty("isDefault")
	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault =  isDefault;
	}
	@JsonProperty("cookie")
	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie =  cookie;
	}

																		
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public ShopBranch(Integer id,String address,String hotline,Integer shopId,String storeId,String branchName,Integer status,Integer isDefault,String cookie) {
				
		this.id = id;
				
		this.address = address;
				
		this.hotline = hotline;
				
		this.shopId = shopId;
				
		this.storeId = storeId;
				
		this.branchName = branchName;
				
		this.status = status;
				
		this.isDefault = isDefault;
				
		this.cookie = cookie;
				
	}

	public ShopBranch() {
	    super();
	}

	

}