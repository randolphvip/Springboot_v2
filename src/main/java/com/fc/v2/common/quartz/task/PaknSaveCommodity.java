package com.fc.v2.common.quartz.task;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fc.v2.shiro.util.ShiroUtils;
import com.myprice.crawler.PaknSaveCategoryCrawler;
import com.myprice.model.auto.Category;
import com.myprice.model.auto.Commodity;
import com.myprice.model.auto.ShopCommodity;
import com.myprice.service.CategoryService;
import com.myprice.service.CommodityService;
import com.myprice.service.ShopCommodityService;

/**
 
 */
@Component("PaknSaveCommodity")
public class PaknSaveCommodity {
 
	
	@Autowired
	private CommodityService commodityService;
@Autowired
	private CategoryService categoryService;
@Autowired
private ShopCommodityService shopCommodityService;

PaknSaveCategoryCrawler crawler = new PaknSaveCategoryCrawler();
	public void runCrawlerPaknSaveCommodities(String source) {
	 System.out.println("--------------开始抓取商品信息");
	 PaknSaveCategoryCrawler crawler = new PaknSaveCategoryCrawler();
		//https://www.paknsave.co.nz/shop/category/fresh-foods-and-bakery/fruit--vegetables/fresh-fruit?pg=3
	     // https://www.paknsave.co.nz/shop/category/Kitchen-Dining & Household/Stationery & Entertainment/Toys & Recreation
	 String url= "https://www.paknsave.co.nz/shop/category";
	 getUrl(url,62);
	}
	
	 
	public String getUrl(String url, Integer parentID){
		
		Category category=	new Category();
		category.setParentId(parentID);
	 	List<Category> categoryList=	categoryService.list(category);
	 	if(categoryList.size()==0) {
	 		//跳出迭代
	 		url =url.toLowerCase();
	 		url=url.replaceAll(",","").replaceAll("&", "");
	 		saveCommodits(url,parentID);
	 		System.out.println("--------------------"+url);
	 		return url;
	 	}else {
			//证明有子节点，继续迭代。
	 		for (Category category2 : categoryList) {
	 			String categoryName =category2.getCategoryName();
	 			if(category2.getParentId()==62) {
	 				
	 				categoryName=categoryName.replace(" & ", "-and-");
	 			}else {
	 				categoryName=categoryName.replace(" & ", "--");
	 			}
	 			categoryName=categoryName.replace(",", "").replace(" ", "-");
	 			getUrl(url+"/"+categoryName,category2.getId());
			}
		}
		
		 return null;
	}
	
	public void saveCommodits(String url, Integer categoryId) {
		System.out.println("分类URL"+url);
		System.out.println("categoryId"+categoryId);
		int page=1;
		url=url+"?pg=";
		String URL =url+page;
		//1.保存商品信息。2保存u_shop_commodity
		java.util.List<Map<String, String>>  list =	crawler.doCrawlerPaknSavepCommodities(URL);
		while (list.size()>0) {
			for (Map<String, String> map : list) {
				Commodity commodity = new Commodity();
				commodity.setCategoryId(categoryId);
				 
				commodity.setCreator("1");
				commodity.setImage(map.get("image"));
				commodity.setTitle(map.get("title"));
				commodity.setUnit(map.get("unit"));
				commodity.setStatus(1);
				System.out.println(commodity.toString());
			 	commodityService.insertSelective(commodity);
			 	System.out.println("---------------------------------------------------------");
				ShopCommodity shopCommodity= new ShopCommodity();
				shopCommodity.setCommodityId(commodity.getId());
				shopCommodity.setShopId(2);
				shopCommodity.setStatus(1);
				shopCommodity.setURL(map.get("url"));
				System.out.println(shopCommodity.toString());
				shopCommodityService.insertSelective(shopCommodity);
			}
			page++;
			URL =url+page;
			list =	crawler.doCrawlerPaknSavepCommodities(URL);
			
		}
		
	}
	
	
 public static void main(String[] args) {
	String url="https://www.paknsave.co.nz/shop/categoryKitchen, Dining & Household/Stationery & Entertainment/Toys & Recreation";
	url =url.toLowerCase().replaceAll(",","-").replace(", ", "-");
	System.out.println(url);
}
 

}
