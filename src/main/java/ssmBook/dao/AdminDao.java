package ssmBook.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ssmBook.pojo.admin;

import java.util.List;

/**
 * 管理员Dao层接口
 * @author Gimmick 2020.7.8
 */
public interface AdminDao {

    /**
     * 查询所有Admin
     * @return
     */
    @Select("select * from admin")
    public List<admin> selectAll();

    /**
     * 通过ID查询Admin
     */
    @Select("select * from admin where adminId=#{adminId}")
    public admin selectById(int adminId);

    /**
     * 插入Admin
     * @return
     */
    @Insert("insert into admin (adminName, passWord) values (#{adminName}, #{passWord})")
    public boolean adminInsert(admin admin);

    /**
     * 修改Admin密码
     * @return
     */
    @Update("update admin set passWord=#{passWord} where adminId=#{adminId}")
    public boolean adminUpdate(admin admin);




    /**
     * 通过用户名查询Admin
     */
    @Select("select * from admin where adminName like #{adminName} limit 1")
    public admin selectByName(@Param("adminName")String adminName);

    /**
     * 通过ID 查询Admin列表
     */
    @Select("select * from admin where adminId = #{adminId}")
    public List<admin> selectList(int adminId);

}
