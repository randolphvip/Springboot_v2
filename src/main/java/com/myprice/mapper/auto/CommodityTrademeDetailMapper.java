package com.myprice.mapper.auto;

import com.myprice.model.auto.CommodityTrademeDetail;
import com.myprice.model.auto.CommodityTrademeDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Commodity Detail(Trade me) CommodityTrademeDetailMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-27 00:37:42
 */
public interface CommodityTrademeDetailMapper {
      	   	      	      	      	      	      	      	      	      	      
    long countByExample(CommodityTrademeDetailExample example);

    int deleteByExample(CommodityTrademeDetailExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(CommodityTrademeDetail record);

    int insertSelective(CommodityTrademeDetail record);

    List<CommodityTrademeDetail> selectByExample(CommodityTrademeDetailExample example);
		
    CommodityTrademeDetail selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") CommodityTrademeDetail record, @Param("example") CommodityTrademeDetailExample example);

    int updateByExample(@Param("record") CommodityTrademeDetail record, @Param("example") CommodityTrademeDetailExample example); 
		
    int updateByPrimaryKeySelective(CommodityTrademeDetail record);

    int updateByPrimaryKey(CommodityTrademeDetail record);
  	  	
}