package ssmBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import ssmBook.pojo.book;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssmBook.dao.BookDao;





/**
 * 书本service
 * 书本分类检索、名字搜索、获取列表等
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;
    /**
     * 获取图书列表
     */
    public List<book> getBookList()
    {
        return null;
    }

    /**
     * 通过名称搜索图书总数
     */
    public long getTotal(String name)
    {
        return bookDao.selectTotalLikeName(name);
    }
    /**
     * 通过名称搜索图书列表
     */
    public List<book> getList(String name, int page, int size) {
        return bookDao.selectListLikeName(name, (page-1)*size, size);
    }

    /**
     * 通过id获取图书内容
     */
    public book get(int id) {
        book book = bookDao.selectById(id);
        if(Objects.nonNull(book) && Objects.nonNull(book.getBrief()) && book.getBrief().length() > 100) {
            book.setBrief(book.getBrief().substring(0, 100) + "...");
        }
        return book;
    }

    /**
     * 获取精品推荐数量
     */
    public long getTotalIsBoutique()
    {
        return 0;
    }
    /**
     * 获取精品推荐列表,按评分，还未写
     */
    public List<book> getTotalIsBoutique(int page, int size)
    {
        return null;
    }
    /**
     * 获取最新列表总数
     */
    public long getTotalIsNews()
    {
        return 0;
    }
    /**
     * 获取最新列表
     */
    public List<book> getTotalIsNew()
    {
        return null;
    }


    /**
     * 图书详情
     */
    public book getBookAbout()
    {
        return null;
    }

    /**
     * 图书新品
     */
    public List<book> getListIsNews(int page, int size)
    {
        return null;
    }


    /**
     * 通过分类搜索
     * @return 无记录返回空集合
     */
    public long getTotalByCategoryId(int categoryid){
        return bookDao.selectTotalByCategoryId(categoryid);
    }

    /**
     * 通过分类搜索
     * @param page
     * @param size
     * @return
     */
    public List<book> getListByCategoryId(int categoryId, int page, int size) {
        return bookDao.selectListByCategoryId(categoryId, (page-1)*size, size);
    }


}
