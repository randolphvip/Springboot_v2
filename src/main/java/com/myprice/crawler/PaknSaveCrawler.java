package com.myprice.crawler;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaknSaveCrawler {
	private static final Logger log = LoggerFactory.getLogger(PaknSaveCrawler.class);
	Map<String, String> cookies =null;
	public  PaknSaveCrawler () {
		init("b83029b6-5dd5-449e-8056-26f3943a4e18|false");//lower Hutt
	}
	
	public  PaknSaveCrawler (String StoreID) {
		init(StoreID);
	}
	
	private void init(String StoreID) {
		try {
			String url = "https://www.paknsave.co.nz/";
			 this.cookies = Jsoup.connect(url).execute().cookies();
			 this.cookies.put("STORE_ID_V2", StoreID);// 设置要采购的店铺ID。
		} catch (Exception e) {
			log.error("Getting session from Pakn Save fail");
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

		 
		System.out.println(System.currentTimeMillis() - begin);
		
		
		System.out.println("duration :" + (System.currentTimeMillis() - begin));
		
		
		}catch (Exception e) {
			log.error("Getting session from Pakn Save fail");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		String url = "https://www.paknsave.co.nz/shop/product/5046542_kgm_000pns?name=bananas";
		PaknSaveCrawler paknSaveCrawler =new PaknSaveCrawler();
		paknSaveCrawler.doCrawlerPaknSave(url);

	}

	public static void crawlerCategroy(String URL) {
		long begin = System.currentTimeMillis();

		try {

			// Map<String, String> cookies =new HashMap<String, String>();

			Map<String, String> cookies = Jsoup.connect(URL).execute().cookies();
			cookies.put("STORE_ID_V2", "98ec3885-ac93-4fcb-807b-59c9055c52c4|false");// 设置要采购的店铺ID。

			Document doc = Jsoup.connect(URL).cookies(cookies).get();
			System.out.println("4:" + (System.currentTimeMillis() - begin));

//			
//		Map<String, String> cookies =  Jsoup.connect(URL).execute().cookies();
//			cookies.put("STORE_ID_V2", "98ec3885-ac93-4fcb-807b-59c9055c52c4|false");
//			Document doc= Jsoup.connect(URL).cookies(cookies).get();
// 

			Elements elements = doc.select(
					"#pol > div > div.fs-product-detail__price > div.fs-price-lockup.fs-price-lockup--large.u-margin-bottom.u-margin-top > span:nth-child(2) > meta:nth-child(1)");
			System.out.println(elements.size());
			for (Element e : elements) {

				System.out.println("-->  :" + e.attr("content"));

			}
			System.out.println(System.currentTimeMillis() - begin);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
