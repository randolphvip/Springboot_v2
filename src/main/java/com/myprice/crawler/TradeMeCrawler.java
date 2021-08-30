package com.myprice.crawler;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fc.v2.util.DateUtils;
import com.myprice.model.auto.CommodityTradeMe;

 
public class TradeMeCrawler {
	private static final Logger log = LoggerFactory.getLogger(TradeMeCrawler.class);
	public static void main(String[] args) throws IOException {
//		
		
		System.out.println( DateUtils.parseDateToStr ("MMM dd, yyyy", new Date()));
		// 		DateUtils.parseTradeMeDate("Tue 17th Aug, 1:29pm");
//		DateUtils.parseTradeMeDate("Tue 31st Dec, 8:00pm");
//		DateUtils.parseTradeMeDate("4days, 20 hours, 35 minutes");
//		DateUtils.parseTradeMeDate("Thu 2nd Jan, 8:00pm");
//		DateUtils.parseTradeMeDate("");
//		DateUtils.parseTradeMeDate(null);
//		
//        
//        
//        
 		String URL = "https://www.trademe.co.nz/a/marketplace/flatmates-wanted/listing/3225818971";
  		CommodityTradeMe tradeMe = new CommodityTradeMe ();
 		tradeMe.setId(22);
 		tradeMe.setUrl(URL);
 		CommodityTradeMe  d =TradeMeCrawler.doCrawlerDetail( tradeMe);
 		System.out.println(d.toString());
//	 log.debug(DateUtils.dateTime("E, MMM dd yyyy HH:mm a", "Thu, Dec 31 1998 10:35 PM"));
//	 log.debug(DateUtils.parseDateToStr("E, MMM dd yyyy HH:mm a ",DateUtils.dateTime("E, MMM dd yyyy HH:mm a", "Thu, Dec 31 1998 10:35 PM")));
//	 
//	 
//	 log.debug(DateUtils.dateTime("E, MMM dd yyyy HH:mm", "Thu, Dec 31 1998 14:35"));
	//	DateUtils.dateTime("TT dd MM, HH:mm", "Thu 26th Aug, 10:35am");
		
	}
 
 
	public static void doCrawler(String URL) {
		 
		long begin = System.currentTimeMillis();
		
		try {
			Document doc = Jsoup.connect(URL).get();
			System.out.println(System.currentTimeMillis()-begin);
			Elements elements = doc.select("tg-box2.tm-listing-auction__box > p.h-text-align-center > strong");
			log.debug("--> Price:"+elements.get(0).ownText());
			System.out.println(System.currentTimeMillis()-begin);
			for (Element e : elements) {
				
				log.debug("--> Price:"+e.ownText());
				
			}
			System.out.println(System.currentTimeMillis()-begin);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	public static CommodityTradeMe  doCrawlerDetail(CommodityTradeMe tradeMe) {
 		long begin = System.currentTimeMillis();
 		 
		try {
			System.out.println("begin to crawler: "+tradeMe.getUrl());
			Document doc = Jsoup.connect(tradeMe.getUrl()).get();
			
			System.out.println("parse  time"+ (System.currentTimeMillis()-begin));
			
			Element priceElement = doc.selectFirst("tg-box2.tm-listing-auction__box > p.h-text-align-center > strong");
			if(priceElement!=null) {
				String price=priceElement.ownText();
				log.debug("--> Price:"+price);
				price= price.replace("$", "");
				tradeMe.setStartingPrice(new BigDecimal(price));
			}
			
			Element titleElement = doc.selectFirst("tg-col.tm-marketplace-listing__flex-column.l-col > tm-marketplace-buyer-options > h1" );
			if(titleElement!=null) {
			log.debug("--> title:"+titleElement.ownText());
			tradeMe.setTitle(titleElement.ownText());
			}
			Element buyNowPriceElement  = doc.selectFirst("tm-marketplace-buyer-options > div > tm-buy-now-box > tg-box2 > div > div > p.tm-buy-now-box__price.p-h1 > strong" );
			if(buyNowPriceElement!=null) {
				String buyNowPrice=buyNowPriceElement.ownText();
				log.debug("--> buyNowPrices:"+buyNowPrice);
				buyNowPrice=buyNowPrice.replace("$", "");
				tradeMe.setBuyNowPrice(new BigDecimal(buyNowPrice));
				log.debug("--> buyNowPrices:"+buyNowPrice);
			}
			
			
			
			
			Element closingDatetimeElement  = doc.selectFirst("tg-rack-item-primary > div > tm-marketplace-closing-datetime > tm-closing-time > div" );
			if(closingDatetimeElement!=null) {
				log.debug("--> closingDatetimes:"+closingDatetimeElement.ownText());
				Date closeDate= DateUtils.parseTradeMeDate(closingDatetimeElement.ownText());
				tradeMe.setCloseDatetime (closeDate);
			}
			
			Element closingDatetime2Element  = doc.selectFirst("tg-rack-item-primary > div > tm-marketplace-closing-datetime > div" );
			if(closingDatetime2Element!=null) {
				log.debug("--> closingDatetimes2:"+closingDatetime2Element.ownText());
				Date closeDate=  DateUtils.parseTradeMeDate(closingDatetime2Element.ownText());
				if(tradeMe.getCloseDatetime()==null) {
					tradeMe.setCloseDatetime(closeDate);
				}
			}
				
				
				
 			
			
			Element conditionElement  = doc.selectFirst("tm-listing-attributes-rack > tg-rack > tg-rack-item > div > div > tg-rack-item-secondary" );
			if(conditionElement!=null) {
				log.debug("--> condition:"+conditionElement.ownText());
				tradeMe.setConditionLevel(conditionElement.ownText());
			}
			
			Elements descriptionElements  = doc.select("#tm-marketplace-listing-body-item-description > tm-markdown > div > p" );
			
			java.util.List<String> descriptionList= new java.util.ArrayList<String>();
			//	Elements es=  description.getElementsByTag("p"); 
					for(Element descriptionElement :descriptionElements) {
						descriptionList.add(descriptionElement.ownText());
 					}
		
			log.debug("-->description"+descriptionList.toString());
			tradeMe.setDescription(descriptionList.toString());	
			
			Elements shippingElements  = doc.select("#shipping-options > tg-row > tg-col:nth-child(2) > tm-listing-shipping-details > table > tbody > tr" );
				
				java.util.Map<String, String> shippingMap = new HashMap<String, String>();
				for(Element shippingElement :shippingElements) {
					Elements shippingTD  = shippingElement.getElementsByTag("td");
					String shippingMethod= shippingTD.get(0).ownText();
					String shippingPrice= shippingTD.get(1).ownText();
					//log.debug("shipping price-->"+shippingMethod +"    " + shippingPrice);
					shippingMap.put(shippingMethod, shippingPrice);
				}
				log.debug("-->shipping:"+shippingMap.toString());
				tradeMe.setShipping(shippingMap.toString());
 			 
				
				
			System.out.println(System.currentTimeMillis()-begin);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return tradeMe;

	}
	
	
	
	public static CommodityTradeMe  doCrawlerDetail_bak(int id, String URL) {
 		long begin = System.currentTimeMillis();
 		CommodityTradeMe tradeMeDetail= new CommodityTradeMe();
 		tradeMeDetail.setId(id);
		try {
			Document doc = Jsoup.connect(URL).get();
			
			System.out.println("解析耗时："+ (System.currentTimeMillis()-begin));
			Element priceElement = doc.selectFirst("tg-box2.tm-listing-auction__box > p.h-text-align-center > strong");
			if(priceElement!=null) {
				String price=priceElement.ownText();
				log.debug("--> Price:"+price);
				price= price.replace("$", "");
				tradeMeDetail.setStartingPrice(new BigDecimal(price));
			}
			
			Element titleElement = doc.selectFirst("tg-col.tm-marketplace-listing__flex-column.l-col > tm-marketplace-buyer-options > h1" );
			if(titleElement!=null) {
			log.debug("--> title:"+titleElement.ownText());
			tradeMeDetail.setTitle(titleElement.ownText());
			}
			Element buyNowPriceElement  = doc.selectFirst("tm-marketplace-buyer-options > div > tm-buy-now-box > tg-box2 > div > div > p.tm-buy-now-box__price.p-h1 > strong" );
			if(buyNowPriceElement!=null) {
				String buyNowPrice=buyNowPriceElement.ownText();
				log.debug("--> buyNowPrices:"+buyNowPrice);
				buyNowPrice=buyNowPrice.replace("$", "");
				tradeMeDetail.setBuyNowPrice(new BigDecimal(buyNowPrice));
				log.debug("--> buyNowPrices:"+buyNowPrice);
			}
			
			
			
			
			Element closingDatetimeElement  = doc.selectFirst("tg-rack-item-primary > div > tm-marketplace-closing-datetime > tm-closing-time > div" );
			if(closingDatetimeElement!=null) {
				log.debug("--> closingDatetimes:"+closingDatetimeElement.ownText());
				Date closeDate= DateUtils.parseTradeMeDate(closingDatetimeElement.ownText());
				tradeMeDetail.setCloseDatetime (closeDate);
			}
			
			Element closingDatetime2Element  = doc.selectFirst("tg-rack-item-primary > div > tm-marketplace-closing-datetime > div" );
			if(closingDatetime2Element!=null) {
				log.debug("--> closingDatetimes2:"+closingDatetime2Element.ownText());
				Date closeDate=  DateUtils.parseTradeMeDate(closingDatetime2Element.ownText());
				if(tradeMeDetail.getCloseDatetime()==null) {
					tradeMeDetail.setCloseDatetime(closeDate);
				}
			}
				
				
				
 			
			
			Element conditionElement  = doc.selectFirst("tm-listing-attributes-rack > tg-rack > tg-rack-item > div > div > tg-rack-item-secondary" );
			if(conditionElement!=null) {
				log.debug("--> condition:"+conditionElement.ownText());
				tradeMeDetail.setConditionLevel(conditionElement.ownText());
			}
			
			Elements descriptionElements  = doc.select("#tm-marketplace-listing-body-item-description > tm-markdown > div > p" );
			
			java.util.List<String> descriptionList= new java.util.ArrayList<String>();
			//	Elements es=  description.getElementsByTag("p"); 
					for(Element descriptionElement :descriptionElements) {
						descriptionList.add(descriptionElement.ownText());
 					}
		
			log.debug("-->description"+descriptionList.toString());
			tradeMeDetail.setDescription(descriptionList.toString());	
			
			Elements shippingElements  = doc.select("#shipping-options > tg-row > tg-col:nth-child(2) > tm-listing-shipping-details > table > tbody > tr" );
				
				java.util.Map<String, String> shippingMap = new HashMap<String, String>();
				for(Element shippingElement :shippingElements) {
					Elements shippingTD  = shippingElement.getElementsByTag("td");
					String shippingMethod= shippingTD.get(0).ownText();
					String shippingPrice= shippingTD.get(1).ownText();
					//log.debug("shipping price-->"+shippingMethod +"    " + shippingPrice);
					shippingMap.put(shippingMethod, shippingPrice);
				}
				log.debug("-->shipping:"+shippingMap.toString());
				tradeMeDetail.setShipping(shippingMap.toString());
 			 
				
				
			System.out.println(System.currentTimeMillis()-begin);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return tradeMeDetail;

	}
	
	
	
	
}
