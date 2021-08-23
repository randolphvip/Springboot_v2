package com.myprice.mapper.auto;

import com.myprice.model.auto.Template;
import com.myprice.model.auto.TemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * crawler TemplateMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-23 00:56:01
 */
public interface TemplateMapper {
      	   	      	      	      	      
    long countByExample(TemplateExample example);

    int deleteByExample(TemplateExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(Template record);

    int insertSelective(Template record);

    List<Template> selectByExample(TemplateExample example);
		
    Template selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") Template record, @Param("example") TemplateExample example);

    int updateByExample(@Param("record") Template record, @Param("example") TemplateExample example); 
		
    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);
  	  	
}