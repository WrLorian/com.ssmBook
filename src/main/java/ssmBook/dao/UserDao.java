package ssmBook.dao;


import org.apache.ibatis.annotations.*;
import ssmBook.pojo.user;

import java.util.List;

/**
 * 用户Dao层接口
 * @GimmciK 2020.7.8
 */
public interface UserDao {

    /**
     * 增加用户（注册）
     */
    @Insert("insert into user (userName, uPassWord, uSex,uAge,uTel,uLoc) values (#{userName}, #{uPassWord}, #{uSex}, #{uAge},#{uTel},#{uLoc})")
    @SelectKey(before=false, keyProperty="userId", resultType=Integer.class, statement="SELECT LAST_INSERT_ID()")
    public boolean insert(user user);

    /**
     * 删除用户
     */
    @Delete("delete from user where userId=#{userId}")
    public boolean delete(int userId);

    /**
     * 修改用户信息
     */
    @Update("update user set userName=#{userName}, uPassWord=#{uPassWord}, uSex=#{uSex} , uAge=#{uAge} , uTel=#{uTel} , uLoc=#{uLoc} where userId=#{userId}")
    public boolean update(user user);

    /**
     * 根据用户ID查询用户
     */
    @Select("select * from user where userId=#{userId}")
    public user select(int userId);

    /**
     * 查询所有用户
     */
    @Select("select * from user order by userId desc limit #{begin}, #{size}")
    public List<user> selectList(@Param("begin")int begin, @Param("size")int size);

    /**
     * 查询用户总数
     */
    @Select("select count(*) from user")
    public long selectTotal();

    /**
     * 通过名称搜索用户
     */
    @Select("select * from user where userName=#{userName} limit 1")
    public user selectByUsername(@Param("userName")String userName);

    /**
     * 用户登录
     */
    @Select("select * from user where userName=#{userName} and uPassWord=#{uPassWord}")
    public user selectByUsernameAndPassword(@Param("userName")String userName, @Param("uPassWord")String uPassWord);
}
