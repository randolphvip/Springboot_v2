package com.myprice.crawler;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountdownCrawler {
	private static final Logger log = LoggerFactory.getLogger(CountdownCrawler.class);
	Map<String, String> cookies =null;
	public  CountdownCrawler () {
		init("b83029b6-5dd5-449e-8056-26f3943a4e18|false");//lower Hutt
	}
	
	public  CountdownCrawler (String StoreID) {
		init(StoreID);
	}
	
	private void init(String StoreID) {
		try {
			String url = "https://shop.countdown.co.nz/shop/productdetails?stockcode=914140";
			System.out.println("--------------------------------------------------------------------------------------------");
			 this.cookies = Jsoup.connect(url).execute().cookies();
			 
		 
			 this.cookies.put("ARRAffinity", "c2dba6f1a343c8b908c4c09af49d7b98f09d8a609f95e791c930db34ec6d2ef1");// 设置要采购的店铺ID。
			System.out.println("--------------------------------------------------------------------------------------------");
 		} catch (Exception e) {
			log.error("Getting session from Pakn Save fail");
			e.printStackTrace();
		}
	}

 
//	
	
	public static void main(String[] args) {
		String url = "https://www.newworld.co.nz/shop/product/5046542_kgm_000nw?name=bananas";
		CountdownCrawler crawler= new CountdownCrawler();
		crawler.crawlerCategroy(url);

	}

	public   void crawlerCategroy(String URL) {
		long begin = System.currentTimeMillis();

		try {


 		 

			Document doc = Jsoup.connect(URL).get();
			System.out.println("411111:" + (System.currentTimeMillis() - begin));
			
		 	System.out.println(doc.html());

//			
//   

			Elements elements = doc.select(
					"#pol > div > div.fs-product-detail__price > div.fs-price-lockup.fs-price-lockup--large.u-margin-bottom.u-margin-top > span:nth-child(2) > meta:nth-child(1)"); 
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(); 
			System.out.println(elements.html());
			for (Element e : elements) {

				System.out.println("-->  :" + e.attr("content"));

			}
			System.out.println(System.currentTimeMillis() - begin);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
