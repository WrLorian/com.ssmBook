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
     * 封装订单信息
     */
    private List<indent> pack(List<indent> indentList) {
        if(Objects.nonNull(indentList)) {
            for(indent indent : indentList) {
                indent = pack(indent);
            }
        }
        return indentList;
    }

    /**
     * 封装订单信息
     */
    private indent pack(indent indent) {
        if(Objects.nonNull(indent)) {
            List<item> itemList = itemDao.selectListByIndentId(indent.getiId());
            for(item item : itemList) {
                item.setBook(bookService.getBookById(item.getBookId()));
                item.setTotal(item.getbPrice() * item.getbNum());
            }
            indent.setItemList(itemList);
            indent.setUser(userService.get(indent.getUserId()));
        }
        return indent;
    }
    /**
     * 获取订单列表
     */
    public List<indent> getIndentList(byte status,int page,int size)
    {
        return pack(indentDao.selectListByStatus(status,(page-1)*size, size));
    }

    /**
     * 处理订单
     */
    public boolean indentReady(int id)
    {
        indent indent=indentDao.selectById(id);
        indent.setState(2);
        return indentDao.update(indent);
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
    public boolean ItemDelete(int id)
    {
        return indentDao.delete(id);
    }

    /**
     * 判断订单中是否存在这一商品
     */
    public boolean checkBook(int bookId,int iId)
    {
        return Objects.nonNull(itemDao.selectItemInIndent(bookId,iId));
    }

    /**
     * 订单项列表
     */
    public List<item> getItemListById(int iId)
    {
        List<item> itemList = itemDao.selectListByIndentId(iId);
        if (itemList!=null && !itemList.isEmpty()) {
            for (item item : itemList) {
                item.setTotal(item.getbPrice() * item.getbNum());
                item.setBook(bookService.getBookById(item.getBookId()));
            }
        }
        return itemList;
    }
}
