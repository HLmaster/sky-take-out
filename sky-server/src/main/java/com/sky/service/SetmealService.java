package com.sky.service;


import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

public interface SetmealService {
    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 添加套餐
     * @param setmealDTO
     */
    void save(SetmealDTO setmealDTO);

    /**
     * 根据id查找套餐信息
     * @param id
     * @return
     */
    SetmealVO getById(Long id);

    /**
     * 批量删除套餐
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 套餐起售/停售状态修改
     * @param status
     * @param id
     */
    void updateStatus(Integer status, Integer id);

    void update(SetmealDTO setmealDTO);
}
