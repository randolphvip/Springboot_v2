package com.fc.v2.common.quartz.task;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myprice.model.auto.CommodityTradeMe;
import com.myprice.model.auto.CommodityTradeMeExample;
import com.myprice.service.CommodityTradeMeService;

@Component("CrawlerTradeMePriceTask")
public class CrawlerTradeMePriceTask {

	@Autowired
	private CommodityTradeMeService commodityTradeMeService;

	public void runTradeMeCrawlerByDay(String source) {
		// 1.取出所有的tradeMe模板数据。

		CommodityTradeMeExample commocdityTradeMe = new CommodityTradeMeExample();
 		List<CommodityTradeMe> list = commodityTradeMeService.selectByExample(commocdityTradeMe);
		// 2.创建线程池
		ExecutorService exec = Executors.newFixedThreadPool(3);

		for (CommodityTradeMe commodityTradeMe2 : list) {
			exec.submit(() -> {
				System.out.println("当前线程：" + Thread.currentThread().getName() + ":" + commodityTradeMe2.getUrl());
			});
		}
		// 从数据库中把所有的商品信息拉取出来，然后循环抓取价格信息

	}

//	public void runTradeMeCrawlerByHour(String source) {
//		// ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//	}

}

//class CrawlerTask implements Runnable {
//	private String url;
//
//	public CrawlerTask(String url) {
//		this.url = url;
//	}
//
//	public void run() {
//		System.out.println("当前线程：" + Thread.currentThread().getName() + ":" + url);
//		// 抓取数据：
//		// TradeMeCrawler.doCrawler(url);
//
//	}
//
//}
