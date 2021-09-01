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
import com.myprice.mapper.auto.MonitorPriceMapper;
import com.myprice.model.auto.MonitorPrice;
import com.myprice.model.auto.MonitorPriceExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;
import org.slf4j.*;

/**
 * Price MonitorPriceService
 * @Title: MonitorPriceService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-09-02 02:04:51  
 **/
@Service
public class MonitorPriceService implements BaseService<MonitorPrice, MonitorPriceExample>{
	@Autowired
	private MonitorPriceMapper monitorPriceMapper;
	
	private static final Logger log = LoggerFactory.getLogger(MonitorPriceService.class);
	
      	   	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<MonitorPrice> list(Tablepar tablepar,MonitorPrice monitorPrice){
	        MonitorPriceExample testExample=new MonitorPriceExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(monitorPrice);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<MonitorPrice> list= monitorPriceMapper.selectByExample2(testExample);
	        PageInfo<MonitorPrice> pageInfo = new PageInfo<MonitorPrice>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			MonitorPriceExample example=new MonitorPriceExample();
			example.createCriteria().andIdIn(stringB);
			return monitorPriceMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public MonitorPrice selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return monitorPriceMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(MonitorPrice record) {
		return monitorPriceMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(MonitorPrice record) {
				
		record.setId(null);
		
				
		return monitorPriceMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(MonitorPrice record, MonitorPriceExample example) {
		
		return monitorPriceMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(MonitorPrice record, MonitorPriceExample example) {
		
		return monitorPriceMapper.updateByExample(record, example);
	}

	@Override
	public List<MonitorPrice> selectByExample(MonitorPriceExample example) {
		
		return monitorPriceMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(MonitorPriceExample example) {
		
		return monitorPriceMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(MonitorPriceExample example) {
		
		return monitorPriceMapper.deleteByExample(example);
	}


}
