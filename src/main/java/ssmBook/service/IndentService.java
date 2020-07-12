package ssmBook.service;


import org.springframework.beans.factory.annotation.Autowired;
import ssmBook.dao.IndentDao;
import ssmBook.dao.ItemDao;
import ssmBook.pojo.indent;
import ssmBook.pojo.item;

import java.util.List;
import java.util.Objects;

/**
 * 订单相关service
 *
 */
public class IndentService {

    @Autowired
    private IndentDao indentDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;


    /**
     * 获取订单列表
     */
    public List<indent> getIndentList()
    {
        return null;
    }

    /**
     * 处理订单
     */
    public boolean indentReady()
    {
        return true;
    }

    /**
     * 删除订单
     */
    public boolean indentDelect()
    {
        return true;
    }

    /**
     * 添加订单
     */
    public boolean indentAdd()
    {
        return true;
    }

    /**
     * 获取某用户全部订单
     */
    public List<indent> getIndentByUser()
    {
        return null;
    }

    /**
     * 创建订单项
     *
     */
    public item itemCreate()
    {
        return null;
    }

    /**
     * 向订单内添加数据
     */
    public indent ItemAdd()
    {
        return null;
    }

    /**
     * 从订单中减少项目
     */
    public indent ItemLess()
    {
        return null;
    }

    /**
     * 从订单中删除项目
     */
    public indent ItemDelect()
    {
        return null;
    }

    /**
     * 判断订单中是否存在这一商品
     */
    public boolean checkBook(int bookId,int iId)
    {
        return Objects.nonNull(itemDao.selectItemInIndent(bookId,iId));
    }
}
