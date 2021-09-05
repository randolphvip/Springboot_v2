package com.myprice.crawler;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewWorldCrawler {
	private static final Logger log = LoggerFactory.getLogger(NewWorldCrawler.class);
	Map<String, String> cookies =null;
	public  NewWorldCrawler () {
		init("745d0bda-4b4f-4e4c-ab1f-6d77512f92f4|False");//lower Hutt
	}
	
	public  NewWorldCrawler (String StoreID) {
		init(StoreID);
	}
	
	private void init(String StoreID) {
		try {
			String url = "https://www.newworld.co.nz//";
			 this.cookies = Jsoup.connect(url).execute().cookies();
			 this.cookies.put("STORE_ID_V2", StoreID);// 设置要采购的店铺ID。
		} catch (Exception e) {
			log.error("Getting session from New World fail");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param URL
	 */
	public  void doCrawlerPaknSave(String URL) {
		try {
		long begin = System.currentTimeMillis();

		Document doc = Jsoup.connect(URL).cookies(cookies).get();
		
		Element element = doc.selectFirst(
				"#pol > div > div.fs-product-detail__price > div.fs-price-lockup.fs-price-lockup--large.u-margin-bottom.u-margin-top > span:nth-child(2) > meta:nth-child(1)");
 			System.out.println("-->  :" + element.attr("content"));
		 		
 			System.out.println("duration :" + (System.currentTimeMillis() - begin));
		
		}catch (Exception e) {
			log.error("Getting session from New World fail");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		String url = "https://www.newworld.co.nz/shop/product/5046542_kgm_000nw?name=bananas";
		NewWorldCrawler paknSaveCrawler =new NewWorldCrawler();
		paknSaveCrawler.doCrawlerPaknSave(url);

	}

 
}
