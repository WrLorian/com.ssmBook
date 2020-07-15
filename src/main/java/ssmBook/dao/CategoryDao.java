package ssmBook.dao;


import org.apache.ibatis.annotations.*;
import ssmBook.pojo.category;

import java.util.List;

/**
 * 书本分类Dao层接口
 * @GimmciK 2020.7.8
 */
public interface CategoryDao {

    /**
     * 增加分类
     */
    @Insert("insert into category (cName) values (#{cName})")
    @SelectKey(before=false, keyProperty="cId", resultType=Integer.class, statement="SELECT LAST_INSERT_ID()")
    public boolean insert(category category);

    /**
     * 删除分类
     */
    @Delete("delete from category where cId=#{cId}")
    public boolean delete(int cId);

    /**
     * 修改分类
     */
    @Update("update category set cName=#{cName} where cId=#{cId}")
    public boolean update(category category);

    /**
     * 通过ID查询分类（？？这个方法有用吗）
     */
    @Select("select * from category where cId=#{cId}")
    public category selectById(int cId);

    /**
     * 查询分类总数
     */
    @Select("select count(*) from category")
    public long selectTotal();

    /**
     * 查询所有分类（有行列显示要求的）
     */
    @Select("select * from category order by cId desc limit #{begin}, #{size}")
    public List<category> selectList(@Param("begin")int begin, @Param("size")int size);

    /**
     * 查询所有分类（无行列显示要求的）
     */
    @Select("select * from category order by cId desc")
    public List<category> selectListAll();
}
