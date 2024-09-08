package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味
     * @param flavors
     */
    void batchSave(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除口味数据
     * @param ids
     */
    void deleteByDianId(List<Long> ids);
}
