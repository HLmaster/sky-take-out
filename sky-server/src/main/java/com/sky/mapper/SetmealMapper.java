package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    Page<SetmealVO> page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 添加套餐
     * @param setmeal
     */
    @AutoFill(value = OperationType.INSERT)
    void save(Setmeal setmeal);

    /**
     * 根据id查找套餐信息
     * @param id
     * @return
     */
    @Select("select * from setmeal where id=#{id}")
    SetmealVO getById(Long id);

    /**
     *批量删除套餐
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 套餐起售/停售状态修改
     * @param status
     * @param id
     */
    @Update("update setmeal set status=#{status} where id =#{id}")
    void updateStatus(Integer status, Integer id);

    /**
     * 修改套餐
     * @param setmeal
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Setmeal setmeal);
}
