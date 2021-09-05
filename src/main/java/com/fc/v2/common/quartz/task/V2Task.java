package com.fc.v2.common.quartz.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fc.v2.mapper.auto.TsysUserMapper;
import com.fc.v2.model.auto.TsysUser;
import com.fc.v2.model.auto.TsysUserExample;

import cn.hutool.core.date.DateUtil;

/**
 * 测试类
 * 
 * @CLASSNAME V2Task
 * @Description 定时调度具体工作类
 * @Auther Jan 橙寂
 * @DATE 2019/9/2 0002 15:33
 */
@Component("v2Task")
public class V2Task {
	@Autowired
	private TsysUserMapper tsysUserMapper;

	/**
	 * 无参的任务
	 */
	public void runTask1() {
		System.out.println("正在执行定时任务，无参方法");
	}

	/**
	 * 有参任务 目前仅执行常见的数据类型 Integer Long 带L string 带 '' bool Double 带 d
	 * 
	 * @param a
	 * @param b
	 */
	public void runTask2(Integer a, Long b, String c, Boolean d, Double e) {
		List<TsysUser> list = tsysUserMapper.selectByExample(new TsysUserExample());
		System.err.println("用户查询num：" + list.size());
		System.out
				.println("正在执行定时任务，带多个参数的方法" + a + "   " + b + " " + c + "  " + d + " " + e + "执行时间:" + DateUtil.now());
	}

	public void runTask3(String source) {

		System.out.println("正在执行定时任务，source：" + source + " --  " + DateUtil.now());
	}
	
//	@Autowired
//	private CommodityTradeMeService commodityTradeMeService;
//
//	public void runTradeMeCrawlerByDay(String source) {
//		//1.取出所有的tradeMe模板数据。
//
//		CommodityTradeMeExample commocdityTradeMe =new CommodityTradeMeExample();
////		commodity.createCriteria().andTempletIdEqualTo(1);
//		List<CommodityTradeMe> list  =commodityTradeMeService.selectByExample(commocdityTradeMe);
//		//2.创建线程池
//		ExecutorService exec= Executors.newFixedThreadPool(3);
//		
//		for (CommodityTradeMe commodityTradeMe2 : list) {
////			exec.submit(new CrawlerTask(commodityTradeMe2.getUrl()));
//		}
//		//从数据库中把所有的商品信息拉取出来，然后循环抓取价格信息
//
//		
//	}
	
//	public void runTradeMeCrawlerByHour(String source) {
//		//ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//	}
//	
	
}


 
