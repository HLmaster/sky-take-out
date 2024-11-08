package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Select("INSERT INTO employee(name, username, password, phone, sex, id_number,status,create_time, update_time, create_user, update_user)\n" +
            "        VALUES (#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    @AutoFill(value = OperationType.INSERT)
    void addEmployee(Employee employee);

    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     */
    Page<Employee> page(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 员工更新
     * @param emp
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Employee emp);

    /**
     * 根据id查找员工信息
     * @param id
     * @return
     */
    @Select("select * from employee where id=#{id}")
    Employee getEmployee(Long id);

    /**
     * 修改员工密码
     * @param empId
     * @param oldPassword
     * @param newPassword
     */
    @Update("update employee set password = #{newPassword} where id=#{empId} and password=#{oldPassword}")
    @AutoFill(value = OperationType.UPDATE)
    void editPassword(Integer empId, String oldPassword, String newPassword);
}
