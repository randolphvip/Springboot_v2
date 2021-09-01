package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.Category;
import com.fc.v2.model.auto.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 产品分类  
 * @author fuce_自动生成
 * @email ${email}
 * @date 2021-06-26 14:52:52
 */
public interface CategoryMapper {
      	   	      	      	      	      	      
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);
		
    Category selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example); 
		
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
  	  	
}