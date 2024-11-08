package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 添加菜品
     * @param dish
     */
    @AutoFill(value = OperationType.INSERT)
    void addDish(Dish dish);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> page(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据id查下菜品
     * @param id
     * @return
     */
    @Select("select * from dish where id=#{id}")
    Dish getById(Long id);

    /**
     * 菜品批量删除
     * @param ids
     */
    void deleteDish(List<Long> ids);

    /**
     * 修改菜品
     * @param dish
     */
    @AutoFill(value = OperationType.UPDATE)
    void updateDish(Dish dish);

    /**
     * 根据分类id查询菜品
     * @param dish
     * @return
     */
    List<DishVO> list(Dish dish);
}
