package com.myprice.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

 
public class TradeMeCrawler {
	public static void main(String[] args) throws IOException {
		String URL = "https://www.trademe.co.nz/a/marketplace/electronics-photography/ipods/ipod-touch/listing/3223412473";
		TradeMeCrawler tradeMeCrawler= new TradeMeCrawler();
		tradeMeCrawler.doCrawler(URL);
	 
	}

	public  void doCrawler(String URL) {
		try {
			Document doc = Jsoup.connect(URL).get();

			Elements elements = doc.select("tg-box2.tm-listing-auction__box > p.h-text-align-center > strong");

			for (Element e : elements) {
				
				System.out.println("--> Price:"+e.ownText());

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
}
