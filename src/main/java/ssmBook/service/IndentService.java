package ssmBook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssmBook.dao.IndentDao;
import ssmBook.dao.ItemDao;
import ssmBook.pojo.book;
import ssmBook.pojo.indent;
import ssmBook.pojo.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 订单相关service
 *
 */
@Service
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
            indent.setUser(userService.getById(indent.getUserId()));
        }
        return indent;
    }
    /**
     * 获取订单列表
     */
    public List<indent> getIndentList(int page,int size)
    {

        return pack(indentDao.selectListByStatus((page-1)*size, size));
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
     * 获取某用户全部订单
     */
    public List<indent> getIndentByUser(int userid)
    {
        return pack(indentDao.selectListByUserid(userid));
    }

    /**
     * 创建订单
     */
    public indent indentCreat(book book)
    {
        List<item> itemList=new ArrayList<>();
        itemList.add(itemCreate(book));
        indent indent =new indent();
        indent.setItemList(itemList);
        indent.setTotal(book.getPrice());
        indent.setAmount(1);
        return indent;
    }
    /**
     * 创建订单项
     *
     */
    public item itemCreate(book book)
    {
        item item =new item();
        item.setBook(book);
        item.setBookId(book.getBookId());
        item.setbPrice(book.getPrice());
        item.setbNum(1);
        item.setTotal(item.getbPrice()*item.getbNum());
        return item;
    }

    /**
     * 向订单内添加订单项目
     */
    public indent ItemAdd(indent indent,book book)
    {
        List<item> itemList=indent.getItemList();
        itemList=itemList==null?new ArrayList<item>():itemList;//三元运算符，如果有订单项目就继承，没有就新建

        boolean noThisBook=true;
        for (item item:itemList)
        {
            if(item.getBook().getBookId()==book.getBookId())
            {
                item.setbPrice(book.getPrice());
                item.setbNum(item.getbNum()+1);
                item.setTotal(item.getbPrice()*item.getbNum());
                noThisBook=false;
            }
        }
        if(noThisBook)
        {
            itemList.add(itemCreate(book));
        }
        indent.setTotal(indent.getTotal()+book.getPrice());
        indent.setAmount(indent.getAmount()+1);
        return indent;
    }

    /**
     * 从订单中减少项目
     */
    public indent ItemLess(indent indent,book book)
    {
        List<item> itemList=indent.getItemList();
        itemList=itemList==null?new ArrayList<item>():itemList;
        boolean noneThis=true;
        for (item item:itemList)
        {
            if(item.getBook().getBookId()==book.getBookId())
            {
                if(item.getbNum()-1<=0)
                {
                    return deleteItem(indent,book);
                }
                item.setbPrice(book.getPrice());
                item.setbNum(item.getbNum()-1);
                item.setTotal(item.getbPrice()*item.getbNum());
                noneThis=false;
            }
        }
        if(noneThis)
        {
            return indent;
        }
        indent.setTotal(indent.getTotal()-book.getPrice());
        indent.setAmount(indent.getAmount()-1);
        return indent;
    }

    /**
     * 从订单中删除项目
     */
    public boolean ItemDelete(int id)
    {
        return indentDao.delete(id);
    }

    /**
     * 从订单中删除项目
     */
    public indent deleteItem(indent indent, book book) {
        List<item> itemList = indent.getItemList();
        itemList = itemList==null ? new ArrayList<item>() : itemList;
        // 如果购物车已有此项目, 数量清零
        boolean noneThis = true;
        int itemAmount = 0;
        List<item> resultList = new ArrayList<item>();
        for (item item : itemList) {
            if (item.getBook().getBookId() == book.getBookId())
            {
                itemAmount = item.getbNum();
                noneThis = false;
                continue;
            }
            resultList.add(item);
        }
        // 如果已经没有项目, 返回null
        if (resultList.isEmpty()) {
            return null;
        }
        indent.setItemList(resultList);
        // 如果当前购物车没有项目, 直接返回
        if (noneThis) {
            return indent;
        }
        indent.setTotal(indent.getTotal() - book.getPrice() * itemAmount);
        indent.setAmount(indent.getAmount() - itemAmount);
        return indent;
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
