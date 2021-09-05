package com.fc.v2.common.quartz.task;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myprice.crawler.PaknSaveCrawlerCommodityInformation;
import com.myprice.crawler.PaknSaveCrawlerCommodityPrice;
import com.myprice.model.auto.MonitorPrice;
import com.myprice.model.auto.ShopCommodity;
import com.myprice.service.MonitorPriceService;
import com.myprice.service.ShopCommodityService;

import net.bytebuddy.build.Plugin.Engine.PoolStrategy.Eager;

/**
 
 */
@Component("CrawlerPaknSavePrice")
public class CrawlerPaknSavePrice {
 
	
@Autowired
private MonitorPriceService monitorPriceService;

@Autowired 
private ShopCommodityService shopCommodityService;

PaknSaveCrawlerCommodityInformation crawler =null;

PaknSaveCrawlerCommodityPrice paknSaveCrawlerCommodityPrice;
/**
 * 定时器的入口
 * @param source
 */
	public void runCrawlerPaknSavePrice(String  storeID) {
		ShopCommodity shopCommodity = new ShopCommodity();
		//状态为正常的。
		shopCommodity.setStatus(1);
		//2:PaknSave
		shopCommodity.setShopId(2);
		
		
		List <ShopCommodity>commondityList= shopCommodityService.list(shopCommodity);
		
		paknSaveCrawlerCommodityPrice = new PaknSaveCrawlerCommodityPrice(storeID);
		
		///开启线程池。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
		ExecutorService exec= Executors.newFixedThreadPool(3);
		
		for (ShopCommodity commodity : commondityList) {
			//exec.submit(new CrawlerTask(commodity.getURL()));
			exec.submit(()->{
				try {
				System.out.println(Thread.currentThread().getName()+"--------"+commodity.getURL());
				MonitorPrice monitorPrice= new MonitorPrice();
				monitorPrice.setCommodityId(commodity.getCommodityId());
				monitorPrice.setDate(new java.util.Date());
				monitorPrice.setShopId(commodity.getShopId());
				monitorPrice.setShopCommodityId(commodity.getId());
				String priceString =paknSaveCrawlerCommodityPrice.doCrawlerPaknSave(commodity.getURL());
				if(priceString!=null) {
					//价格抓取失败。
					monitorPrice.setPrice(new BigDecimal(priceString));
					System.out.println(monitorPrice.toString());
					monitorPriceService.insertSelective(monitorPrice);
				}else {
					System.out.println("价额抓取失败。。。");
				}
				
				
				
				 
					
				
				
				//monitorPriceService.insertSelective(null);
				}catch (Exception e) {
					e.printStackTrace();
					
				}
			});
		}
		
		
//	  crawler = new PaknSaveCrawlerCommodityInformation(); 
  	  
	}
	
	 
	 
	  
  
 

}
