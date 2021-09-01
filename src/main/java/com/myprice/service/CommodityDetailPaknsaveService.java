package com.myprice.service;

import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.myprice.mapper.auto.CommodityDetailPaknsaveMapper;
import com.myprice.model.auto.CommodityDetailPaknsave;
import com.myprice.model.auto.CommodityDetailPaknsaveExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;
import org.slf4j.*;

/**
 * PaknSave CommodityDetailPaknsaveService
 * @Title: CommodityDetailPaknsaveService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-09-01 17:47:19  
 **/
@Service
public class CommodityDetailPaknsaveService implements BaseService<CommodityDetailPaknsave, CommodityDetailPaknsaveExample>{
	@Autowired
	private CommodityDetailPaknsaveMapper commodityDetailPaknsaveMapper;
	
	private static final Logger log = LoggerFactory.getLogger(CommodityDetailPaknsaveService.class);
	
      	   	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<CommodityDetailPaknsave> list(Tablepar tablepar,CommodityDetailPaknsave commodityDetailPaknsave){
	        CommodityDetailPaknsaveExample testExample=new CommodityDetailPaknsaveExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(commodityDetailPaknsave);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<CommodityDetailPaknsave> list= commodityDetailPaknsaveMapper.selectByExample(testExample);
	        PageInfo<CommodityDetailPaknsave> pageInfo = new PageInfo<CommodityDetailPaknsave>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			CommodityDetailPaknsaveExample example=new CommodityDetailPaknsaveExample();
			example.createCriteria().andIdIn(stringB);
			return commodityDetailPaknsaveMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public CommodityDetailPaknsave selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return commodityDetailPaknsaveMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(CommodityDetailPaknsave record) {
		return commodityDetailPaknsaveMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(CommodityDetailPaknsave record) {
				
		record.setId(null);
		
				
		return commodityDetailPaknsaveMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(CommodityDetailPaknsave record, CommodityDetailPaknsaveExample example) {
		
		return commodityDetailPaknsaveMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(CommodityDetailPaknsave record, CommodityDetailPaknsaveExample example) {
		
		return commodityDetailPaknsaveMapper.updateByExample(record, example);
	}

	@Override
	public List<CommodityDetailPaknsave> selectByExample(CommodityDetailPaknsaveExample example) {
		
		return commodityDetailPaknsaveMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(CommodityDetailPaknsaveExample example) {
		
		return commodityDetailPaknsaveMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(CommodityDetailPaknsaveExample example) {
		
		return commodityDetailPaknsaveMapper.deleteByExample(example);
	}


}
