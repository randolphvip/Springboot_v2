package com.myprice.mapper.auto;

import com.myprice.model.auto.ShopBranch;
import com.myprice.model.auto.ShopBranchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Shop Branch ShopBranchMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-09-01 23:13:10
 */
public interface ShopBranchMapper {
      	   	      	      	      	      	      	      	      	      	      
    long countByExample(ShopBranchExample example);

    int deleteByExample(ShopBranchExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ShopBranch record);

    int insertSelective(ShopBranch record);

    List<ShopBranch> selectByExample(ShopBranchExample example);
		
    ShopBranch selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ShopBranch record, @Param("example") ShopBranchExample example);

    int updateByExample(@Param("record") ShopBranch record, @Param("example") ShopBranchExample example); 
		
    int updateByPrimaryKeySelective(ShopBranch record);

    int updateByPrimaryKey(ShopBranch record);
    List<ShopBranch> selectByExample2(ShopBranchExample example);
  	  	
}