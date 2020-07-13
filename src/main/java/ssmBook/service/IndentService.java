package ssmBook.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssmBook.dao.IndentDao;
import ssmBook.dao.ItemDao;
import ssmBook.pojo.book;
import ssmBook.pojo.indent;
import ssmBook.pojo.item;
import ssmBook.pojo.user;

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
    public boolean indentAdd(indent indent)
    {

        return true;
    }




    /**
     * 获取某用户全部订单
     */
    public List<indent> getIndentByUser(int userid) {
        return indentDao.selectListByUserid(userid);//这个返回的应该不是所有的数据

    }


    /**
     * 创建新订单
     *
     */
    public indent create(book book, user user){
        indent indent = new indent();
        indent.setTotal(0);
        indent.setAmount(0);
        indent.setLoc(user.getuLoc());
        indent.setTel(user.getuTel());
        indent.setTime(new Date());
        indent.setUserName(user.getUserName());
        indent.setUserId(user.getUserId());
        createItems(book,indent);
        return indent;
    }

    /**
     * 创建新书
     */
    private item createItems(book book,indent indent) {
        item item = new item();
        item.setbName(book.getBookName());
        item.setBookId(book.getBookId());
        item.setbPrice(book.getPrice());
        item.setbNum(1);
        item.setiId(indent.getiId());
        indent.setAmount(indent.getAmount()+1);
        indent.setTotal(indent.getTotal()+book.getPrice());
        return item;
    }

    /**
     * 向订单内添加数据
     */
    public indent itemAdd(indent indent, book book)
    {
        //1.本身有这本书
        if(Objects.nonNull(itemDao.selectItemInIndent(book.getBookId(),indent.getiId())))
        {
            item item=itemDao.selectItemInIndent(book.getBookId(),indent.getiId());
            item.setbNum(item.getbNum()+1);
            item.setbPrice(book.getPrice());
            indent.setAmount(indent.getAmount()+1);
            indent.setTotal(indent.getTotal()+book.getPrice());
            return indent;
        }
        //2.订单中没有这本书，要先添加
        else
        {
            createItems(book,indent);
            indent.setAmount(indent.getAmount()+1);
            indent.setTotal(indent.getTotal()+book.getPrice());
            return indent;
        }

    }

    /**
     * 从订单中减少项目
     */
    public indent itemLess(indent indent, book book)
    {
        //1.购物车有这本书
        if(Objects.nonNull(itemDao.selectItemInIndent(book.getBookId(),indent.getiId())))
        {
            item item=itemDao.selectItemInIndent(book.getBookId(),indent.getiId());
            //只有一本
            if(item.getbNum()==1)
            {
                return itemDelete(indent,book);
            }
            else
            {
                item.setbNum(item.getbNum()-1);
                item.setbPrice(book.getPrice());
                indent.setAmount(indent.getAmount()-1);
                indent.setTotal(indent.getTotal()-book.getPrice());
                return indent;
            }
        }
        else
        {
            return indent;
        }
    }

    /**
     * 从订单中删除项目
     */
    public indent itemDelete(indent indent, book book)
    {
        //1.若订单中有这本书，清零
        if(Objects.nonNull(itemDao.selectItemInIndent(book.getBookId(),indent.getiId())))
        {
            item item = itemDao.selectItemInIndent(book.getBookId(), indent.getiId());
            indent.setAmount(indent.getAmount()-item.getbNum());
            indent.setTotal(indent.getTotal()-item.getbNum()*item.getbPrice());
            itemDao.deleteById(book.getBookId());
            return indent;
        }
        //2.若订单中无此书
        else
        {
            return indent;
        }
    }
}
