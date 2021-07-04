package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class ProductType implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "id")
	private Integer id;
	
	@ApiModelProperty(value = "parent_id")
	private String parentId;
	
	@ApiModelProperty(value = "产品分类名称")
	private String productTypeName;
	
	@ApiModelProperty(value = "状态")
	private Integer status;
	
	@ApiModelProperty(value = "排序")
	private Integer orderNum;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("parentId")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId =  parentId;
	}
	@JsonProperty("productTypeName")
	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName =  productTypeName;
	}
	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status =  status;
	}
	@JsonProperty("orderNum")
	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum =  orderNum;
	}

										
	public ProductType(Integer id,String parentId,String productTypeName,Integer status,Integer orderNum) {
				
		this.id = id;
				
		this.parentId = parentId;
				
		this.productTypeName = productTypeName;
				
		this.status = status;
				
		this.orderNum = orderNum;
				
	}

	public ProductType() {
	    super();
	}

	

}