package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.ProductType;
import com.fc.v2.model.auto.ProductTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 产品分类 ProductTypeMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2021-06-26 14:52:52
 */
public interface ProductTypeMapper {
      	   	      	      	      	      	      
    long countByExample(ProductTypeExample example);

    int deleteByExample(ProductTypeExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductType> selectByExample(ProductTypeExample example);
		
    ProductType selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByExample(@Param("record") ProductType record, @Param("example") ProductTypeExample example); 
		
    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
  	  	
}