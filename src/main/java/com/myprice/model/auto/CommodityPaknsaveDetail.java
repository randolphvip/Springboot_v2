package com.myprice.model.auto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class CommodityPaknsaveDetail extends Commodity implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ID")
	private Integer id;
	
	@ApiModelProperty(value = "Title")
	private String title;
	
	@ApiModelProperty(value = "Description")
	private String description;
	
	@ApiModelProperty(value = "Starting price")
	private BigDecimal price;
	
	@ApiModelProperty(value = "iamge")
	private String img;
	
	@ApiModelProperty(value = "unit")
	private String unit;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id =  id;
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
	@JsonProperty("price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price =  price;
	}
	@JsonProperty("img")
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img =  img;
	}
	@JsonProperty("unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit =  unit;
	}

												
	public CommodityPaknsaveDetail(Integer id,String title,String description,BigDecimal price,String img,String unit) {
				
		this.id = id;
				
		this.title = title;
				
		this.description = description;
				
		this.price = price;
				
		this.img = img;
				
		this.unit = unit;
				
	}

	public CommodityPaknsaveDetail() {
	    super();
	}

	

}