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
import com.myprice.mapper.auto.ShopMapper;
import com.myprice.model.auto.Shop;
import com.myprice.model.auto.ShopExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;
import org.slf4j.*;

/**
 * Shop ShopService
 * @Title: ShopService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-31 01:46:33  
 **/
@Service
public class ShopService implements BaseService<Shop, ShopExample>{
	@Autowired
	private ShopMapper shopMapper;
	
	private static final Logger log = LoggerFactory.getLogger(ShopService.class);
	
      	   	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Shop> list(Tablepar tablepar,Shop shop){
	        ShopExample testExample=new ShopExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(shop);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Shop> list= shopMapper.selectByExample(testExample);
	        PageInfo<Shop> pageInfo = new PageInfo<Shop>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ShopExample example=new ShopExample();
			example.createCriteria().andIdIn(stringB);
			return shopMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Shop selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return shopMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Shop record) {
		return shopMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Shop record) {
				
		record.setId(null);
		
				
		return shopMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(Shop record, ShopExample example) {
		
		return shopMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Shop record, ShopExample example) {
		
		return shopMapper.updateByExample(record, example);
	}

	@Override
	public List<Shop> selectByExample(ShopExample example) {
		
		return shopMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ShopExample example) {
		
		return shopMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ShopExample example) {
		
		return shopMapper.deleteByExample(example);
	}


}
