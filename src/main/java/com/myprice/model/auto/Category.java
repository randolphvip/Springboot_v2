package com.myprice.model.auto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "id")
	private Integer id;
	
	@ApiModelProperty(value = "parent_id")
	private Integer parentId;
	
	@ApiModelProperty(value = "categoryName")
	private String categoryName;
	
	@ApiModelProperty(value = "status")
	private Integer status;
	
	@ApiModelProperty(value = "orderNum")
	private Integer orderNum;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
	}
	@JsonProperty("parentId")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId =  parentId;
	}
	@JsonProperty("categoryName")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName =  categoryName;
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

										
	public Category(Integer id,Integer parentId,String categoryName,Integer status,Integer orderNum) {
				
		this.id = id;
				
		this.parentId = parentId;
				
		this.categoryName = categoryName;
				
		this.status = status;
				
		this.orderNum = orderNum;
				
	}

	public Category() {
	    super();
	}

	

}