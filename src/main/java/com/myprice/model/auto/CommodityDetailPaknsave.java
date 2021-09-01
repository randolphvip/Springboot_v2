package com.myprice.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;
import java.math.BigDecimal;

public class CommodityDetailPaknsave implements Serializable {
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
	
	@ApiModelProperty(value = "Unit")
	private String unit;
	
	@ApiModelProperty(value = "Category")
	private String category;
	
	@ApiModelProperty(value = "shop_commondity")
	private Integer shopCommondityId;
	
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
	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category =  category;
	}
	@JsonProperty("shopCommondityId")
	public Integer getShopCommondityId() {
		return shopCommondityId;
	}

	public void setShopCommondityId(Integer shopCommondityId) {
		this.shopCommondityId =  shopCommondityId;
	}

																
	public CommodityDetailPaknsave(Integer id,String title,String description,BigDecimal price,String img,String unit,String category,Integer shopCommondityId) {
				
		this.id = id;
				
		this.title = title;
				
		this.description = description;
				
		this.price = price;
				
		this.img = img;
				
		this.unit = unit;
				
		this.category = category;
				
		this.shopCommondityId = shopCommondityId;
				
	}

	public CommodityDetailPaknsave() {
	    super();
	}

	

}