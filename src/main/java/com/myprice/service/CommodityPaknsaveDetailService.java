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
import com.myprice.mapper.auto.CommodityPaknsaveDetailMapper;
import com.myprice.model.auto.CommodityPaknsaveDetail;
import com.myprice.model.auto.CommodityPaknsaveDetailExample;

import cn.hutool.core.util.StrUtil;

/**
 * paknsave CommodityPaknsaveDetailService
 * @Title: CommodityPaknsaveDetailService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-28 20:06:21  
 **/
@Service
public class CommodityPaknsaveDetailService implements BaseService<CommodityPaknsaveDetail, CommodityPaknsaveDetailExample>{
	@Autowired
	private CommodityPaknsaveDetailMapper commodityPaknsaveDetailMapper;
	
      	   	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<CommodityPaknsaveDetail> list(Tablepar tablepar,CommodityPaknsaveDetail commodityPaknsaveDetail){
	        CommodityPaknsaveDetailExample testExample=new CommodityPaknsaveDetailExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(commodityPaknsaveDetail);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<CommodityPaknsaveDetail> list= commodityPaknsaveDetailMapper.selectByExample(testExample);
	        PageInfo<CommodityPaknsaveDetail> pageInfo = new PageInfo<CommodityPaknsaveDetail>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			CommodityPaknsaveDetailExample example=new CommodityPaknsaveDetailExample();
			example.createCriteria().andIdIn(stringB);
			return commodityPaknsaveDetailMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public CommodityPaknsaveDetail selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return commodityPaknsaveDetailMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(CommodityPaknsaveDetail record) {
		return commodityPaknsaveDetailMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(CommodityPaknsaveDetail record) {
				
		record.setId(null);
		
				
		return commodityPaknsaveDetailMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(CommodityPaknsaveDetail record, CommodityPaknsaveDetailExample example) {
		
		return commodityPaknsaveDetailMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(CommodityPaknsaveDetail record, CommodityPaknsaveDetailExample example) {
		
		return commodityPaknsaveDetailMapper.updateByExample(record, example);
	}

	@Override
	public List<CommodityPaknsaveDetail> selectByExample(CommodityPaknsaveDetailExample example) {
		
		return commodityPaknsaveDetailMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(CommodityPaknsaveDetailExample example) {
		
		return commodityPaknsaveDetailMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(CommodityPaknsaveDetailExample example) {
		
		return commodityPaknsaveDetailMapper.deleteByExample(example);
	}


}
