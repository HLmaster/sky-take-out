package com.sky.mapper;


import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 保存套餐内菜品信息
     * @param setmealDishes
     */
    void save(List<SetmealDish> setmealDishes);

    /**
     * 删除套餐的同时删除套餐菜品关联信息
     * @param ids
     */
    void delete(Long[] ids);
}
