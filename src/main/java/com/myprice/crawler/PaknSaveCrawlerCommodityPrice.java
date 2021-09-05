package com.myprice.crawler;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaknSaveCrawlerCommodityPrice {
	private static final Logger log = LoggerFactory.getLogger(PaknSaveCrawlerCommodityPrice.class);
	Map<String, String> cookies =null;
	public  PaknSaveCrawlerCommodityPrice () {
		init("b83029b6-5dd5-449e-8056-26f3943a4e18|false");//lower Hutt
	}
	
	public  PaknSaveCrawlerCommodityPrice (String StoreID) {
		init(StoreID);
	}
	
	private void init(String StoreID) {
		try {
			String url = "https://www.paknsave.co.nz/";
			 this.cookies = Jsoup.connect(url).execute().cookies();
			 this.cookies.put("SessionCookieIdV2", "826fea75121d421ea38e518ce2ae34df");
			 
			 this.cookies.put("brands_server_nearest_store", "{\"StoreId\":\"{52E4E8C4-8958-4CCC-907E-F7BB0D8AD8D9}\",\"UserLat\":\"-41.1703\",\"UserLng\":\"174.9949\",\"StoreLat\":\"-41.2054531645066\",\"StoreLng\":\"174.913454026984\",\"IsSuccess\":true}");
			 this.cookies.put("server_nearest_store_v2", "{\"StoreId\":\"b83029b6-5dd5-449e-8056-26f3943a4e18\",\"UserLat\":\"\",\"UserLng\":\"\",\"StoreLat\":\"-41.205578\",\"StoreLng\":\"174.913149\",\"IsSuccess\":true}");
			 
			 this.cookies.put("AllowRestrictedItems", "true");
			 this.cookies.put("STORE_ID_V2", "b83029b6-5dd5-449e-8056-26f3943a4e18|false");
			 
			 
			 
			 
//			 this.cookies.put("STORE_ID_V2", StoreID);// 设置要采购的店铺ID。
		} catch (Exception e) {
			log.error("Getting session from Pakn Save fail");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param URL
	 */
	public  String doCrawlerPaknSave(String URL) {
		try {
		long begin = System.currentTimeMillis();
//		for (String key:cookies.keySet()) {
//			System.out.println("---------------------------"+key +""+cookies.get(key));
//		}

		Document doc = Jsoup.connect(URL).cookies(cookies).get();
		
		Element element = doc.selectFirst(
				"#pol > div > div.fs-product-detail__price > div.fs-price-lockup.fs-price-lockup--large.u-margin-bottom.u-margin-top > span:nth-child(2) > meta:nth-child(1)");
		String price=element.attr("content");
		System.out.println("duration :" + (System.currentTimeMillis() - begin)+" ----price:"+price);
		return price;
 
		}catch (Exception e) {
			log.error("Getting session from Pakn Save fail");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		String url = "https://www.paknsave.co.nz/shop/product/5046542_kgm_000pns?name=bananas";
			   url = "https://www.paknsave.co.nz/shop/product/5116827_ea_000pns?name=sesame-seed-hamburger-buns";
	//	   url= "https://www.paknsave.co.nz/shop/product/5086478_ea_000pns?name=front-%26-top-loader-sensitive-laundry-powder";
		PaknSaveCrawlerCommodityPrice paknSaveCrawler =new PaknSaveCrawlerCommodityPrice();
		paknSaveCrawler.doCrawlerPaknSave(url);

	}

	 

}
