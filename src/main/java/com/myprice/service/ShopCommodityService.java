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
import com.myprice.mapper.auto.ShopCommodityMapper;
import com.myprice.model.auto.ShopCommodity;
import com.myprice.model.auto.ShopCommodityExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;
import org.slf4j.*;

/**
 * Shop Commodity ShopCommodityService
 * @Title: ShopCommodityService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-31 13:35:29  
 **/
@Service
public class ShopCommodityService implements BaseService<ShopCommodity, ShopCommodityExample>{
	@Autowired
	private ShopCommodityMapper shopCommodityMapper;
	
	private static final Logger log = LoggerFactory.getLogger(ShopCommodityService.class);
	
      	   	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ShopCommodity> list(Tablepar tablepar,ShopCommodity shopCommodity){
	        ShopCommodityExample testExample=new ShopCommodityExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(shopCommodity);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ShopCommodity> list= shopCommodityMapper.selectByExample(testExample);
	        PageInfo<ShopCommodity> pageInfo = new PageInfo<ShopCommodity>(list);
	        return  pageInfo;
	 }
	 
	 public List <ShopCommodity> list(ShopCommodity shopCommodity){
	        ShopCommodityExample testExample=new ShopCommodityExample();
			 
	        	testExample.createCriteria().andLikeQuery(shopCommodity);
	        List<ShopCommodity> list= shopCommodityMapper.selectByExample(testExample);
	        return  list;
	 }
	 

	 
	 public PageInfo<ShopCommodity> list(Tablepar tablepar,String searchText,Integer commodityId){
	        ShopCommodityExample testExample=new ShopCommodityExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText()).andCommodityIdEqualTo(commodityId);
	        } 
			if(commodityId!=null&&!commodityId.equals("")) {
				testExample.createCriteria().andCommodityIdEqualTo(commodityId);
			}
		 
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ShopCommodity> list= shopCommodityMapper.queryCommodityList(testExample);
	        PageInfo<ShopCommodity> pageInfo = new PageInfo<ShopCommodity>(list);
	        return  pageInfo;
	 }
	 
	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ShopCommodityExample example=new ShopCommodityExample();
			example.createCriteria().andIdIn(stringB);
			return shopCommodityMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ShopCommodity selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return shopCommodityMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ShopCommodity record) {
		return shopCommodityMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ShopCommodity record) {
				
		record.setId(null);
		
				
		return shopCommodityMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ShopCommodity record, ShopCommodityExample example) {
		
		return shopCommodityMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ShopCommodity record, ShopCommodityExample example) {
		
		return shopCommodityMapper.updateByExample(record, example);
	}

	@Override
	public List<ShopCommodity> selectByExample(ShopCommodityExample example) {
		
		return shopCommodityMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ShopCommodityExample example) {
		
		return shopCommodityMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ShopCommodityExample example) {
		
		return shopCommodityMapper.deleteByExample(example);
	}


}
