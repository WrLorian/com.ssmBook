package ssmBook.dao;


import org.apache.ibatis.annotations.*;
import ssmBook.pojo.admin;
import ssmBook.pojo.item;

import java.util.List;

/**
 * 订单项目Dao层接口
 * @GimmciK 2020.7.8
 */
public interface ItemDao {

    /**
     * 判断该订单中是否存在该书籍
     */
    @Select("select * from item where bookId=#{bookId} and iId=#{iId}")
    public item selectItemInIndent(@Param("bookId")int bookId,@Param("iId")int iId);


    /**
     * 增加订单项目（添加购物车）
     */
    @Insert("insert into item (bPrice, bookId, bName, bNum,iId) values (#{bPrice}, #{bookId}, #{bName}, #{bNum}, #{iId})")
    public boolean insert(item item);

    /**
     * 删除订单项目
     */
    @Delete("delete from items where itemId=#{itemId}")
    public boolean deleteById(int itemId);

    /**
     *修改订单项目（这有啥用？？貌似是用在增加和减少商品数量）
     */
    @Update("update items set bPrice=#{bPrice}, bookId=#{bookId}, bName=#{bName}, bNum=#{bNum} , iId=#{iId} where itemId=#{itemId}")
    public boolean update(item item);

    /**
     * 通过订单项目ID查询订单项目
     */
    @Select("select * from items where itemId=#{itemId}")
    public item select(int id);

    /**
     * 查询订单项目总数
     */
    @Select("select count(*) from items")
    public long selectTotal();

    /**
     * 查询一整张订单内的所有订单项目
     */
    @Select("select * from item where iId=#{iId}")
    public List<item> selectListByIndentId(@Param("iId")int iId);

}
