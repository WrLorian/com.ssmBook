package ssmBook.dao;

import org.apache.ibatis.annotations.*;
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
    @Select("select * from admin order by adminId desc limit #{begin},#{size}")
    public List<admin> selectAll(@Param("begin")int begin, @Param("size")int size);

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
     * 修改Admin信息
     * @return
     */
    @Update("update admin set passWord=#{passWord},adminName=#{adminName} where adminId=#{adminId}")
    public boolean adminUpdate(admin admin);

    /**
     * 删除管理员
     */
    @Delete("delete from admin where adminId=#{adminId}")
    public boolean delectAdmin(int adminId);
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

    /**
     * 通过名称搜索
     * 由于此处如果查询出多条记录会抛异常, 所以加上limit防止数据引起的错误
     */
    @Select("select * from admin where adminName=#{adminName} and passWord=#{passWord} limit 1")
    public admin selectByUsernameAndPassword(@Param("adminName")String adminName, @Param("passWord")String passWord);

    /**
     * 获取管理员的总数
     * @return
     */
    @Select("select count(*) from admin")
    public long selectTotal();


}
