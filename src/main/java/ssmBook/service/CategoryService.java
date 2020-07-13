package ssmBook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssmBook.dao.CategoryDao;
import ssmBook.pojo.category;

import java.util.List;

/**
 * 书本分类service
 * 类目的增删改查
 * 类目的列表获取
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    /**
     * 获取分类列表（需要分页）
     */
    public List<category> getCategoryList(int page,int size)
    {
        return categoryDao.selectList((page-1)*size, size);
    }

    /**
     * 获取分类列表（需要分页）
     */
    public List<category> getCategoryListAll()
    {
        return categoryDao.selectListAll();
    }

    /**
     * 获取分类总数
     */
    public long getTotal()
    {
        return categoryDao.selectTotal();
    }

    /**
     * 通过ID查询分类
     */
    public category getCategory()
    {
        return null;
    }

    /**
     * 添加分类
     */
    public boolean categoryAdd(category category)
    {
        return categoryDao.insert(category);
    }

    /**
     * 通过ID查询分类
     */
    public category getCategoryById(int id)
    {
        return categoryDao.selectById(id);
    }

    /**
     * 更新分类
     */
    public boolean categoryUpdate(category category)
    {
        return categoryDao.update(category);
    }

    /**
     * 删除分类
     */
    public boolean categoryDelete(int id)
    {
        return categoryDao.delete(id);
    }

}
