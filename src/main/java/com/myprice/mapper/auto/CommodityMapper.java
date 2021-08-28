package com.myprice.mapper.auto;

import com.myprice.model.auto.Commodity;
import com.myprice.model.auto.CommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * commodity CommodityMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-24 16:48:22
 */
public interface CommodityMapper {
      	   	      	      	      	      	      	      	      	      	      
    long countByExample(CommodityExample example);

    int deleteByExample(CommodityExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(Commodity record);

    int insertSelective(Commodity record);

    List<Commodity> selectByExample(CommodityExample example);
		
    Commodity selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example); 
		
    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);

 	List<Commodity> queryCommodityList(String searchText);
 	
	List<Commodity> queryCommodityList(CommodityExample example);
  	  	
}