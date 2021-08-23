package com.myprice.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ProductID")
	private Integer productId;
	
	@ApiModelProperty(value = "ProductName")
	private String productName;
	
	@ApiModelProperty(value = "Description")
	private String productDesc;
	
	@ApiModelProperty(value = "Status")
	private Integer status;
	
	@ApiModelProperty(value = "Categrory")
	private Integer categroryId;
	
	@JsonProperty("productId")
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId =  productId;
	}
	@JsonProperty("productName")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName =  productName;
	}
	@JsonProperty("productDesc")
	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc =  productDesc;
	}
	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status =  status;
	}
	@JsonProperty("categroryId")
	public Integer getCategroryId() {
		return categroryId;
	}

	public void setCategroryId(Integer categroryId) {
		this.categroryId =  categroryId;
	}

										
	public Product(Integer productId,String productName,String productDesc,Integer status,Integer categroryId) {
				
		this.productId = productId;
				
		this.productName = productName;
				
		this.productDesc = productDesc;
				
		this.status = status;
				
		this.categroryId = categroryId;
				
	}

	public Product() {
	    super();
	}

	

}