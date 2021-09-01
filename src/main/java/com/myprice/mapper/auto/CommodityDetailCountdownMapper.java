package com.myprice.mapper.auto;

import com.myprice.model.auto.CommodityDetailCountdown;
import com.myprice.model.auto.CommodityDetailCountdownExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CountDown CommodityDetailCountdownMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-09-01 17:45:36
 */
public interface CommodityDetailCountdownMapper {
      	   	      	      	      	      	      	      	      	      
    long countByExample(CommodityDetailCountdownExample example);

    int deleteByExample(CommodityDetailCountdownExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(CommodityDetailCountdown record);

    int insertSelective(CommodityDetailCountdown record);

    List<CommodityDetailCountdown> selectByExample(CommodityDetailCountdownExample example);
		
    CommodityDetailCountdown selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") CommodityDetailCountdown record, @Param("example") CommodityDetailCountdownExample example);

    int updateByExample(@Param("record") CommodityDetailCountdown record, @Param("example") CommodityDetailCountdownExample example); 
		
    int updateByPrimaryKeySelective(CommodityDetailCountdown record);

    int updateByPrimaryKey(CommodityDetailCountdown record);
  	  	
}