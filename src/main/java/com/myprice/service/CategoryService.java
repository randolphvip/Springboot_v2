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
import com.myprice.mapper.auto.CategoryMapper;
import com.myprice.model.auto.Category;
import com.myprice.model.auto.CategoryExample;

import cn.hutool.core.util.StrUtil;

/**
 * _自动生成
 * @email ${email}
 * @date 2021-06-26 14:52:52  
 **/
@Service
public class CategoryService implements BaseService<Category, CategoryExample>{
	@Autowired
	private CategoryMapper categoryMapper;
	
      	   	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Category> list(Tablepar tablepar,Category category){
	        CategoryExample testExample=new CategoryExample();
 
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(category);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Category> list= categoryMapper.selectByExample(testExample);
	        PageInfo<Category> pageInfo = new PageInfo<Category>(list);
	        return  pageInfo;
	 }
	 
	 public List <Category> list(Category category){
	        CategoryExample testExample=new CategoryExample();
	        testExample.createCriteria().andLikeQuery(category);
	        List<Category> list= categoryMapper.selectByExample(testExample);
 	        return  list;
	 }
	 
	 

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			CategoryExample example=new CategoryExample();
			example.createCriteria().andIdIn(stringB);
			return categoryMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Category selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return categoryMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Category record) {
		return categoryMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Category record) {
				
		record.setId(null);
		
				
		return categoryMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(Category record, CategoryExample example) {
		
		return categoryMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Category record, CategoryExample example) {
		
		return categoryMapper.updateByExample(record, example);
	}

	@Override
	public List<Category> selectByExample(CategoryExample example) {
		example.createCriteria().andStatusEqualTo(1);
		return categoryMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(CategoryExample example) {
		
		return categoryMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(CategoryExample example) {
		
		return categoryMapper.deleteByExample(example);
	}

	public int updateVisible(Category record) {
		return categoryMapper.updateByPrimaryKeySelective(record);
	}


}
