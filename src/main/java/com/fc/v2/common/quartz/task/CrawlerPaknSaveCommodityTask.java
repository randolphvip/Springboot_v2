package com.fc.v2.common.quartz.task;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myprice.crawler.PaknSaveCrawlerCommodityInformation;
import com.myprice.model.auto.Category;
import com.myprice.model.auto.Commodity;
import com.myprice.model.auto.ShopCommodity;
import com.myprice.service.CategoryService;
import com.myprice.service.CommodityService;
import com.myprice.service.ShopCommodityService;

/**
 
 */
@Component("CrawlerPaknSaveCommodityTask")
public class CrawlerPaknSaveCommodityTask {
 
	
@Autowired
private CommodityService commodityService;
@Autowired
	private CategoryService categoryService;
@Autowired
private ShopCommodityService shopCommodityService;

PaknSaveCrawlerCommodityInformation crawler =null;


/**
 * 定时器的入口
 * @param source
 */
	public void runCrawlerPaknSaveCommodities(String  storeID) {
	 System.out.println("--------------开始抓取商品信息");
	 System.out.println("--------------storeID"+storeID);
	  
	  crawler = new PaknSaveCrawlerCommodityInformation();//可以传入店的编号。默认为Lower Hutt
	 String url= "https://www.paknsave.co.nz/shop/category";
	 int root_categoryID=62;
	 getUrlOfCommodityCategory(url,root_categoryID);//
	}
	
	
	 
	
	 
	public String getUrlOfCommodityCategory(String url, Integer parentID){
		
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
			//证明有子节点，继续迭代。将本节点的内容拼接到URL
	 		for (Category category2 : categoryList) {
	 			String categoryName =category2.getCategoryName();
	 			if(category2.getParentId()==62) {
	 				categoryName=categoryName.replace(" & ", "-and-");
	 			}else {
	 				categoryName=categoryName.replace(" & ", "--");
	 			}
	 			categoryName=categoryName.replace(",", "").replace(" ", "-");
	 			getUrlOfCommodityCategory(url+"/"+categoryName,category2.getId());
			}
		}
		
		 return null;
	}
	/**
	 * 通过URL和分类ID抓取商品信息。并保存商品信息（非单个商品）
	 * @param url
	 * @param categoryId
	 */
	
	private void saveCommodits(String url, Integer categoryId) {
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
	
	
  
 

}
