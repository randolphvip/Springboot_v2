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
import com.myprice.mapper.auto.CommodityDetailCountdownMapper;
import com.myprice.model.auto.CommodityDetailCountdown;
import com.myprice.model.auto.CommodityDetailCountdownExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;
import org.slf4j.*;

/**
 * CountDown CommodityDetailCountdownService
 * @Title: CommodityDetailCountdownService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-09-01 17:45:36  
 **/
@Service
public class CommodityDetailCountdownService implements BaseService<CommodityDetailCountdown, CommodityDetailCountdownExample>{
	@Autowired
	private CommodityDetailCountdownMapper commodityDetailCountdownMapper;
	
	private static final Logger log = LoggerFactory.getLogger(CommodityDetailCountdownService.class);
	
      	   	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<CommodityDetailCountdown> list(Tablepar tablepar,CommodityDetailCountdown commodityDetailCountdown){
	        CommodityDetailCountdownExample testExample=new CommodityDetailCountdownExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(commodityDetailCountdown);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<CommodityDetailCountdown> list= commodityDetailCountdownMapper.selectByExample(testExample);
	        PageInfo<CommodityDetailCountdown> pageInfo = new PageInfo<CommodityDetailCountdown>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			CommodityDetailCountdownExample example=new CommodityDetailCountdownExample();
			example.createCriteria().andIdIn(stringB);
			return commodityDetailCountdownMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public CommodityDetailCountdown selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return commodityDetailCountdownMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(CommodityDetailCountdown record) {
		return commodityDetailCountdownMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(CommodityDetailCountdown record) {
				
		record.setId(null);
		
				
		return commodityDetailCountdownMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(CommodityDetailCountdown record, CommodityDetailCountdownExample example) {
		
		return commodityDetailCountdownMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(CommodityDetailCountdown record, CommodityDetailCountdownExample example) {
		
		return commodityDetailCountdownMapper.updateByExample(record, example);
	}

	@Override
	public List<CommodityDetailCountdown> selectByExample(CommodityDetailCountdownExample example) {
		
		return commodityDetailCountdownMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(CommodityDetailCountdownExample example) {
		
		return commodityDetailCountdownMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(CommodityDetailCountdownExample example) {
		
		return commodityDetailCountdownMapper.deleteByExample(example);
	}


}
