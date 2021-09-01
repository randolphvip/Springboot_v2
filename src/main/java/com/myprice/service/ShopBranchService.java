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
import com.myprice.mapper.auto.ShopBranchMapper;
import com.myprice.model.auto.ShopBranch;
import com.myprice.model.auto.ShopBranchExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;
import org.slf4j.*;

/**
 * Shop Branch ShopBranchService
 * @Title: ShopBranchService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-09-01 23:13:10  
 **/
@Service
public class ShopBranchService implements BaseService<ShopBranch, ShopBranchExample>{
	@Autowired
	private ShopBranchMapper shopBranchMapper;
	
	private static final Logger log = LoggerFactory.getLogger(ShopBranchService.class);
	
      	   	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ShopBranch> list(Tablepar tablepar,ShopBranch shopBranch){
	        ShopBranchExample testExample=new ShopBranchExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(shopBranch);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ShopBranch> list= shopBranchMapper.selectByExample2(testExample);
	        PageInfo<ShopBranch> pageInfo = new PageInfo<ShopBranch>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ShopBranchExample example=new ShopBranchExample();
			example.createCriteria().andIdIn(stringB);
			return shopBranchMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ShopBranch selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return shopBranchMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ShopBranch record) {
		return shopBranchMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ShopBranch record) {
				
		record.setId(null);
		
				
		return shopBranchMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ShopBranch record, ShopBranchExample example) {
		
		return shopBranchMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ShopBranch record, ShopBranchExample example) {
		
		return shopBranchMapper.updateByExample(record, example);
	}

	@Override
	public List<ShopBranch> selectByExample(ShopBranchExample example) {
		
		return shopBranchMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ShopBranchExample example) {
		
		return shopBranchMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ShopBranchExample example) {
		
		return shopBranchMapper.deleteByExample(example);
	}


}
