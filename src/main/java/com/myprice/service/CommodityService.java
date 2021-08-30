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
import com.myprice.mapper.auto.CommodityMapper;
import com.myprice.model.auto.Commodity;
import com.myprice.model.auto.CommodityExample;
 
import cn.hutool.core.util.StrUtil;

/**
 * commodity CommodityService
 * @Title: CommodityService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-24 16:48:22  
 **/
@Service
public class CommodityService implements BaseService<Commodity, CommodityExample>{
	@Autowired
	private CommodityMapper commodityMapper;
	
	 
	private static final Logger log = LoggerFactory.getLogger(CommodityService.class);
      	   	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Commodity> list(Tablepar tablepar,Commodity commodity){
 	        CommodityExample testExample=new CommodityExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText()).andCreatorEqualTo(ShiroUtils.getUserId());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(commodity).andCreatorEqualTo(ShiroUtils.getUserId());
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	       List<Commodity> list= commodityMapper.queryCommodityList(testExample);
	        
	           //     List<Commodity> list= commodityMapper.selectByExample(testExample);
	        PageInfo<Commodity> pageInfo = new PageInfo<Commodity>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			CommodityExample example=new CommodityExample();
			example.createCriteria().andIdIn(stringB);
			return commodityMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Commodity selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return commodityMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Commodity record) {
		return commodityMapper.updateByPrimaryKeySelective(record);
	}
	 
	
	/**
	 * 添加
	 */
	@Override
	@Transactional(propagation =Propagation.REQUIRED)
	public int insertSelective(Commodity record) {
		int status =0;
		record.setId(null);
		record.setCreator(ShiroUtils.getUserId());
		record.setCreateDate(new Date());
		status=commodityMapper.insertSelective(record);
		if(status>0) {
			System.out.println("commondityID:"+ record.getId());
//			CommodityTradeMeDetail tradeMeDetail =new CommodityTradeMeDetail();
//					tradeMeDetail.setId(record.getId()-1);
//			commodityTrademeDetailService.insertSelective(tradeMeDetail);
//			
			
//		//	tradeMeDetail =TradeMeCrawler.doCrawlerDetail(record.getId(),record.getUrl());
//			log.debug("begin to save the detail of the commodity.");
//			System.out.println(tradeMeDetail.toString());
//			 
//			commodityTrademeDetailService.insertSelective(tradeMeDetail);
			
		}else {
			System.out.println("fail to save :"+status);
		}
		return status;
	}
	
	
	@Override
	public int updateByExampleSelective(Commodity record, CommodityExample example) {
		
		return commodityMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Commodity record, CommodityExample example) {
		
		return commodityMapper.updateByExample(record, example);
	}

	@Override
	public List<Commodity> selectByExample(CommodityExample example) {
		
		return commodityMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(CommodityExample example) {
		
		return commodityMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(CommodityExample example) {
		
		return commodityMapper.deleteByExample(example);
	}

	


}
