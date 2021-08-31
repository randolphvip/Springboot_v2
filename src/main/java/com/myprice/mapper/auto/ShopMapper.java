package com.myprice.mapper.auto;

import com.myprice.model.auto.Shop;
import com.myprice.model.auto.ShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Shop ShopMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-31 01:46:33
 */
public interface ShopMapper {
      	   	      	      	      	      	      	      	      	      
    long countByExample(ShopExample example);

    int deleteByExample(ShopExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(Shop record);

    int insertSelective(Shop record);

    List<Shop> selectByExample(ShopExample example);
		
    Shop selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example); 
		
    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
  	  	
}