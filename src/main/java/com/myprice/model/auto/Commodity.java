package com.myprice.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Commodity implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ID")
	private Integer id;
	
	@ApiModelProperty(value = "url")
	private String url;
	
	@ApiModelProperty(value = "creator")
	private String creator;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "create date")
	private Date createDate;
	
	@ApiModelProperty(value = "status")
	private Integer status;
	
	@ApiModelProperty(value = "category")
	private Integer categoryId;
	
	@ApiModelProperty(value = "templet")
	private Integer templetId;
	
	@ApiModelProperty(value = "frequence")
	private String frequence;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "closeDate")
	private Date closeDate;
	
	@ApiModelProperty(value = "creatorName")
	private String creatorName;
	
	@ApiModelProperty(value = "templetName")
	private String templetName;	
	
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
	@JsonProperty("frequence")
	public String getFrequence() {
		return frequence;
	}

	public void setFrequence(String frequence) {
		this.frequence =  frequence;
	}
	@JsonProperty("closeDate")
	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate =  closeDate;
	}

																		
	public Commodity(Integer id,String url,String creator,Date createDate,Integer status,Integer categoryId,Integer templetId,String frequence,Date closeDate) {
				
		this.id = id;
				
		this.url = url;
				
		this.creator = creator;
				
		this.createDate = createDate;
				
		this.status = status;
				
		this.categoryId = categoryId;
				
		this.templetId = templetId;
				
		this.frequence = frequence;
				
		this.closeDate = closeDate;
				
	}

	public Commodity() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	
	@JsonProperty("creatorName")
	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	@JsonProperty("templetName")
	public String getTempletName() {
		return templetName;
	}

	public void setTempletName(String templetName) {
		this.templetName = templetName;
	}
	
	@JsonProperty("categoryName")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	

}