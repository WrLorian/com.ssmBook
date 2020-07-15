package ssmBook.dao;


import org.apache.ibatis.annotations.*;
import ssmBook.pojo.indent;

import java.util.List;

/**
 * 订单Dao层接口
 * @GimmciK 2020.7.8
 */
public interface IndentDao {
    /**
     * 增加订单
     */
    @Insert("insert into indent (state, userId, userName, loc, tel, time) "
            + "values (#{state}, #{userId}, #{userName}, #{loc}, #{tel}, #{time})")
    public boolean insert(indent indent);

    /**
     * 删除订单
     */
    @Delete("delete from indent where iId=#{iId}")
    public boolean delete(int id);

    /**
     * 修改订单
     */
    @Update("update indent set state=#{state}, userId=#{userId}, userName=#{userName}, loc=#{loc}, "
            + "tel=#{tel}, time=#{time} where id=#{id}")
    public boolean update(indent user);

    /**
     * 将订单从未处理标记为已处理
     */
    @Update("update indent set state=#{state} where iId=#{iId}")
    public boolean updateStatus(@Param("iId")int iId, @Param("state")byte state);

    /**
     * 通过ID查询该订单
     */
    @Select("select * from indent where iId=#{iId}")
    public indent selectById(int iId);

    /**
     * 查询一共有多少订单
     */
    @Select("select count(*) from indent")
    public long selectTotal();

    /**
     * 查询一共有多少订单（分是否处理两种情况）
     */
    @Select("select count(*) from indent where state=#{state}")
    public long selectTotalByStatus(@Param("state")byte state);

    /**
     * 查询所有的订单
     */
    @Select("select * from indent order by iId desc limit #{begin}, #{size}")
    public List<indent> selectList(@Param("begin")int begin, @Param("size")int size);

    /**
     * 查询所有的订单（分是否处理两种情况）
     */
    @Select("select * from indent where state=#{state} order by iId desc limit #{begin}, #{size}")
    public List<indent> selectListByStatus(@Param("state")int state,@Param("begin")int begin, @Param("size")int size);

    /**
     * 通过用户ID查询名下所有订单
     */
    @Select("select * from indent where userId=#{userId} order by iId desc")
    public List<indent> selectListByUserid(@Param("userId")int userId);

}
