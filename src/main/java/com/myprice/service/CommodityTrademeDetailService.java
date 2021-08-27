package com.myprice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myprice.mapper.auto.CommodityTrademeDetailMapper;
import com.myprice.model.auto.CommodityTrademeDetail;
import com.myprice.model.auto.CommodityTrademeDetailExample;

import cn.hutool.core.util.StrUtil;

/**
 * Commodity Detail(Trade me) CommodityTrademeDetailService
 * @Title: CommodityTrademeDetailService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-27 00:37:42  
 **/
@Service
public class CommodityTrademeDetailService implements BaseService<CommodityTrademeDetail, CommodityTrademeDetailExample>{
	@Autowired
	private CommodityTrademeDetailMapper commodityTrademeDetailMapper;
	
      	   	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<CommodityTrademeDetail> list(Tablepar tablepar,CommodityTrademeDetail commodityTrademeDetail){
	        CommodityTrademeDetailExample testExample=new CommodityTrademeDetailExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(commodityTrademeDetail);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<CommodityTrademeDetail> list= commodityTrademeDetailMapper.selectByExample(testExample);
	        PageInfo<CommodityTrademeDetail> pageInfo = new PageInfo<CommodityTrademeDetail>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			CommodityTrademeDetailExample example=new CommodityTrademeDetailExample();
			example.createCriteria().andIdIn(stringB);
			return commodityTrademeDetailMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public CommodityTrademeDetail selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return commodityTrademeDetailMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(CommodityTrademeDetail record) {
		return commodityTrademeDetailMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(CommodityTrademeDetail record) {
		return commodityTrademeDetailMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(CommodityTrademeDetail record, CommodityTrademeDetailExample example) {
		
		return commodityTrademeDetailMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(CommodityTrademeDetail record, CommodityTrademeDetailExample example) {
		
		return commodityTrademeDetailMapper.updateByExample(record, example);
	}

	@Override
	public List<CommodityTrademeDetail> selectByExample(CommodityTrademeDetailExample example) {
		
		return commodityTrademeDetailMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(CommodityTrademeDetailExample example) {
		
		return commodityTrademeDetailMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(CommodityTrademeDetailExample example) {
		
		return commodityTrademeDetailMapper.deleteByExample(example);
	}


}
