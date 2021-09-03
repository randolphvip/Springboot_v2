package com.myprice.crawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myprice.service.CommodityService;

public class PaknSaveCategoryCrawler {
	private static final Logger log = LoggerFactory.getLogger(PaknSaveCategoryCrawler.class);
	Map<String, String> cookies =null;
	@Autowired
	CommodityService commodityService; 
	
	
	public  PaknSaveCategoryCrawler () {
		init("b83029b6-5dd5-449e-8056-26f3943a4e18|false");//lower Hutt
	}
	
	public  PaknSaveCategoryCrawler (String StoreID) {
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
	public  void doCrawlerPaknSaveCategory(String URL) {
		try {
		long begin = System.currentTimeMillis();

		Document doc = Jsoup.connect(URL).cookies(cookies).get();
		
		Elements elements = doc.select(
				"div.fs-mega-menu__panel.fs-mega-menu__panel--one.m-one-header-nav__megamenu-panel-level1.fs-mega-menu__panel--show");
		System.out.println(elements.size());
 
			for (Element element : elements) {
				System.out.println("------------------------------------------------------------------------------");
				System.out.println(element.html());
				System.out.println("------------------------------------------------------------------------------");

			}

		System.out.println("duration :" + (System.currentTimeMillis() - begin));
		
		
		}catch (Exception e) {
			log.error("Getting session from Pakn Save fail");
			e.printStackTrace();
		}
	}
	
	
	
 /**
  * 通过URL抓取这个页面中的所有商品信息。
  * @param URL
  * @return
  */
	public  java.util.List<Map<String, String>>  doCrawlerPaknSavepCommodities(String URL) {
		java.util.List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
		long begin = System.currentTimeMillis();
 
		Document doc = Jsoup.connect(URL).cookies(cookies).get();
		
		Elements elements = doc.select(
				"#wrapper > section > div.l-main.u-flex-justify-center > div > div.l-columns.l-columns--five > div");
		System.out.println("--->size:"+elements.size());
 
			for (Element element : elements) {
				java.util.Map<String, String> map = new HashMap<String, String>();
				System.out.println("---------------------------------------------------:");
				
				String url="https://www.paknsave.co.nz/"+element.getElementsByTag("a").get(0).attr("href");
				System.out.println("URL:"+url);
				map.put("url", url);
				String title=element.getElementsByClass("u-p2").get(0).ownText();
				System.out.println("title:"+title);
				map.put("title", title);
				String image= (element.getElementsByClass("fs-product-card__product-image").get(0).attr("data-src-s"));
				System.out.println("image:"+image);
				map.put("image", image);
				String unit=(element.getElementsByClass("u-p3").get(0).ownText());
				System.out.println("unit:"+unit);
				map.put("unit", unit);
				list.add(map);
				
   		}

		 
		System.out.println(System.currentTimeMillis() - begin);
		
		
		System.out.println("duration :" + (System.currentTimeMillis() - begin));
		
	
		}catch (Exception e) {
			log.error("Getting session from Pakn Save fail");
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		String url = "https://www.paknsave.co.nz/shop/category/fresh-foods-and-bakery/fruit--vegetables/fresh-fruit?pg=1";
		PaknSaveCategoryCrawler paknSaveCrawler =new PaknSaveCategoryCrawler();
	    paknSaveCrawler.doCrawlerPaknSavepCommodities(url);
		

	}

//	public static void crawlerCategroy(String URL) {
//		long begin = System.currentTimeMillis();
//
//		try {
//
//			// Map<String, String> cookies =new HashMap<String, String>();
//
//			Map<String, String> cookies = Jsoup.connect(URL).execute().cookies();
//			cookies.put("STORE_ID_V2", "98ec3885-ac93-4fcb-807b-59c9055c52c4|false");// 设置要采购的店铺ID。
//
//			Document doc = Jsoup.connect(URL).cookies(cookies).get();
//			System.out.println("4:" + (System.currentTimeMillis() - begin));
//
////			
////		Map<String, String> cookies =  Jsoup.connect(URL).execute().cookies();
////			cookies.put("STORE_ID_V2", "98ec3885-ac93-4fcb-807b-59c9055c52c4|false");
////			Document doc= Jsoup.connect(URL).cookies(cookies).get();
//// 
//
//			Elements elements = doc.select(
//					"#pol > div > div.fs-product-detail__price > div.fs-price-lockup.fs-price-lockup--large.u-margin-bottom.u-margin-top > span:nth-child(2) > meta:nth-child(1)");
//			System.out.println(elements.size());
//			for (Element e : elements) {
//
//				System.out.println("-->  :" + e.attr("content"));
//
//			}
//			System.out.println(System.currentTimeMillis() - begin);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}

}
