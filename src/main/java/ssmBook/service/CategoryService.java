package ssmBook.service;


import org.springframework.beans.factory.annotation.Autowired;
import ssmBook.dao.CategoryDao;
import ssmBook.pojo.category;

import java.util.List;

/**
 * 书本分类service
 * 类目的增删改查
 * 类目的列表获取
 */
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    /**
     * 获取分类列表
     */
    public List<category> getCategoryList()
    {
        return categoryDao.selectListAll();
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
    public boolean categoryAdd()
    {
        return true;
    }

    /**
     * 更新分类
     */
    public boolean categoryUpdate()
    {
        return true;
    }

    /**
     * 删除分类
     */
    public boolean categoryDelect()
    {
        return true;
    }

}
