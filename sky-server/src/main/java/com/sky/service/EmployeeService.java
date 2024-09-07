package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     *
     * @param employeeDTO
     * @return
     */
    void addEmployee(EmployeeDTO employeeDTO);

    /**
     * 分页查询
     *
     * @param employeePageQueryDTO
     * @return
     */
    PageResult page(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用/禁用员工账号
     * @param status
     * @param id
     */
    void enableOrDisable(Integer status, Long id);

    /**
     * 根据id查找员工信息
     * @param id
     * @return
     */
    Employee getEmployee(Long id);

    /**
     * 修改员工消息
     * @param employeeDTO
     */
    void updateEmployee(EmployeeDTO employeeDTO);

    /**
     * 修改员工密码
     * @param empId
     * @param oldPassword
     * @param newPassword
     */
    void editPassword(Integer empId, String oldPassword, String newPassword);
}
