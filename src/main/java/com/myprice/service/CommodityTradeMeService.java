package com.myprice.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.shiro.util.ShiroUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myprice.crawler.TradeMeCrawler;
import com.myprice.mapper.auto.CommodityTradeMeMapper;
import com.myprice.model.auto.CommodityTradeMe;
import com.myprice.model.auto.CommodityTradeMeExample;

import cn.hutool.core.util.StrUtil;

/**
 * Trade Me CommodityTradeMeService
 * @Title: CommodityTradeMeService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-29 16:56:02  
 **/
@Service
public class CommodityTradeMeService implements BaseService<CommodityTradeMe, CommodityTradeMeExample>{
	@Autowired
	private CommodityTradeMeMapper commodityTrademeMapper;
	
	private static final Logger log = LoggerFactory.getLogger(CommodityTradeMeService.class);
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<CommodityTradeMe> list(Tablepar tablepar,CommodityTradeMe commodityTrademe){
	        CommodityTradeMeExample testExample=new CommodityTradeMeExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(commodityTrademe);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<CommodityTradeMe> list= commodityTrademeMapper.selectByExample(testExample);
	        PageInfo<CommodityTradeMe> pageInfo = new PageInfo<CommodityTradeMe>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			CommodityTradeMeExample example=new CommodityTradeMeExample();
			example.createCriteria().andIdIn(stringB);
			return commodityTrademeMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public CommodityTradeMe selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return commodityTrademeMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(CommodityTradeMe record) {
		return commodityTrademeMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	@Transactional(propagation =Propagation.REQUIRED)
	public int insertSelective(CommodityTradeMe record) {
		record.setCreator(ShiroUtils.getUserId());
		record.setCreateDate(new Date());
		record =TradeMeCrawler.doCrawlerDetail(record);
		int operationStatus = commodityTrademeMapper.insertSelective(record);
		System.out.println(record.toString());
		return operationStatus;
	}
	
	
	@Override
	public int updateByExampleSelective(CommodityTradeMe record, CommodityTradeMeExample example) {
		
		return commodityTrademeMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(CommodityTradeMe record, CommodityTradeMeExample example) {
		
		return commodityTrademeMapper.updateByExample(record, example);
	}

	@Override
	public List<CommodityTradeMe> selectByExample(CommodityTradeMeExample example) {
		
		return commodityTrademeMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(CommodityTradeMeExample example) {
		
		return commodityTrademeMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(CommodityTradeMeExample example) {
		
		return commodityTrademeMapper.deleteByExample(example);
	}


}
