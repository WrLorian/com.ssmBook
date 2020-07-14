package ssmBook.dao;


import org.apache.ibatis.annotations.*;
import ssmBook.pojo.book;

import java.util.List;

/**
 * 书本Dao层接口
 * @GimmciK 2020.7.8
 */
public interface BookDao {

    /**
     * 添加图书
     */
    @Insert("insert into book (bookName, img, price, count, author, press, time, grade, cld)"
            + "values(#{bookName}, #{img}, #{price}, #{count}, #{author}, #{press}, #{time}, #{grade}, #{cId})")
    public boolean insert(book book);

    /**
     *删除图书
     */
    @Delete("delete from book where bookId = #{bookId}")
    public boolean bookDelect(int bookId);

    /**
     * 修改图书
     */
    @Update("update book set bookName=#{bookName}, img=#{img}, price=#{price}, count=#{count}, brief=#{brief}, author=#{author}, "
            + "press=#{press}, time=#{time}, grade=#{grade},cId=#{cId} where bookId=#{bookId}")
    public boolean update(book newbook);

    /**
     * 根据id查询图书
     */
    @Select("select * from book where bookId=#{bookId}")
    public book selectById(int id);

    /**
     * 查询共有多少本图书
     */
    @Select("select count(*) from book")
    public long selectTotal();

    /**
     * 通过名称查询图书共有多少本（like）
     */
    @Select("select count(*) from book where bookName like concat('%',#{bookName},'%')")
    public long selectTotalLikeName(@Param("bookName")String bookName);

    /**
    *查询该分类下共有多少本图书
     */
    @Select("select count(*) from book where cId=#{cId}")
    public long selectTotalByCategoryId(int cid);

    /**
     * 查询所有图书，按照time的时间顺序，从新到旧排列
     */
    @Select("select * from book ORDER BY time DESC limit #{begin}, #{size}")
    public List<book> selectBookByTimeDesc(@Param("begin")int begin, @Param("size")int size);


    /**
     * 显示所有图书
     */
    @Select("select * from book order by bookId desc limit #{begin}, #{size}")
    public List<book> selectList(@Param("begin")int begin, @Param("size")int size);

    /**
     * 通过名字查询图书
     * 注意：不止唯一结果
     */
    @Select("select * from book where bookName like concat('%',#{bookName},'%') order by id desc limit #{begin}, #{size}")
    public List<book> selectListLikeName(@Param("bookName")String bookName, @Param("begin")int begin, @Param("size")int size);

    /**
     * 通过分类查询图书
     */
    @Select("select * from book where cId=#{cId} order by id desc limit #{begin}, #{size}")
    public List<book> selectListByCategoryId(@Param("cId")int cId, @Param("begin")int begin, @Param("size")int size);








}
