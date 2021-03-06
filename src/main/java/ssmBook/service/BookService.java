package ssmBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import ssmBook.dao.BookDao;
import ssmBook.pojo.book;
import ssmBook.util.UploadUtil;

import java.util.List;
import java.util.Objects;

/**
 * 书本service
 * 书本分类检索、名字搜索、获取列表等
 */
public class BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 获取图书列表
     */
    public List<book> getBookList(int page,int size)
    {
        return bookDao.selectList((page-1)*size,size);
    }

    /**
     * 返回有多少本书
     */
    public long getTotal()
    {
        return bookDao.selectTotal();
    }

    /**
     * 返回有多少本推荐图书
     */
    public long getTotalIsSpecial()
    {
        return bookDao.selectTotalIsSpecial();
    }

    /**
     * 获得最新图书列表
     */
    public List<book> getListIsNews(int page,int size)
    {
        return bookDao.selectListIsNew((page-1)*size,size);
    }

    /**
     * 通过名称搜索图书
     */
    public List<book> getTotalByName(String name)
    {
        return null;
    }

    /**
     * 通过ID搜索图书
     */
    public book getBookById(int id)
    {
        book book = bookDao.selectById(id);
        if (Objects.nonNull(book) && Objects.nonNull(book.getBrief()) && book.getBrief().length() > 70)
        {
            book.setBrief(book.getBrief().substring(0, 70) + "...");
        }
        return book;
    }

    /**
     * 通过分类搜索图书
     * 该搜索的字段既是该分类的ID
     */
    public List<book> getTotalByCategoryId()
    {
        return null;
    }

    /**
     * 获取推荐列表
     */
    public List<book> selectListIsSpecial(int page,int size)
    {
        return bookDao.selectListIsSpecial(page,size);
    }

    /**
     * 获取最新图书有多少本
     */
    public long getTotalIsNews()
    {
        return bookDao.selectTotalIsNews();
    }

    /**
     * 图书详情
     */
    public book getBookAbout()
    {
        return null;
    }

    /**
     * 添加图书
     */
    public boolean bookAdd(book book)
    {
        book.setImg(UploadUtil.upload(book.getFile()));
        return bookDao.insert(book);
    }

    /**
     * 修改图书
     */
    public boolean bookUpdate(book book)
    {
        if (Objects.nonNull(book.getFile()) && !book.getFile().isEmpty()) {
            book.setImg(UploadUtil.upload(book.getFile()));
        }
        return bookDao.update(book);
    }

    /**
     * 删除图书
     */
    public boolean bookDelete(int id)
    {
        return bookDao.bookDelete(id);
    }


}
