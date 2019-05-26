package com.medicine.mapper;

import com.medicine.pojo.TbShop;
import com.medicine.pojo.TbShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShopMapper {
    int countByExample(TbShopExample example);

    int deleteByExample(TbShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbShop record);

    int insertSelective(TbShop record);

    List<TbShop> selectByExampleWithBLOBs(TbShopExample example);

    List<TbShop> selectByExample(TbShopExample example);

    TbShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbShop record, @Param("example") TbShopExample example);

    int updateByExampleWithBLOBs(@Param("record") TbShop record, @Param("example") TbShopExample example);

    int updateByExample(@Param("record") TbShop record, @Param("example") TbShopExample example);

    int updateByPrimaryKeySelective(TbShop record);

    int updateByPrimaryKeyWithBLOBs(TbShop record);

    int updateByPrimaryKey(TbShop record);
}