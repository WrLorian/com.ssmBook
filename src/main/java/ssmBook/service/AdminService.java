package ssmBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import ssmBook.dao.AdminDao;
import ssmBook.pojo.*;

import java.util.List;
import java.util.Objects;

/**
 *后台管理员服务
 *订单、用户、图书、分类
 * 注意，例如图书的推优、特惠等服务都通过此实现
 *
 */
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    /**
     * 验证登录
     * 该方法的传入值也可以写为Admin
     * 但需要和Controller一致
     */
    public boolean checkUser(String username,String password)
    {
        return Objects.nonNull(adminDao.selectByUsernameAndPassword(username, password));
    }

    /**
     * 判断用户名是否存在（注册时）
     */
    public boolean isExist(String username)
    {
        return Objects.nonNull(adminDao.selectByName(username));
    }
    /**
     * 已经处理订单页面的显示
     */
    public List<item> getAlreadyItemList()
    {
        return null;
    }

    /**
     * 未处理订单页面的显示
     */
    public List<item> getUnreadyItemList()
    {
        return null;
    }



    /**
     * 标记处理
     */
    public boolean dealItem()
    {
        return true;
    }

    /**
     * 订单删除
     */
    public boolean itemdelect()
    {
        return true;
    }

    /**
     * 获取用户列表
     */
    public List<user> getUser()
    {
        return null;
    }

    /**
     *删除用户
     */
    public boolean userDelect()
    {
        return true;
    }

    /**
     * 添加用户
     */
    public boolean userAdd()
    {
        return true;
    }

    /**
     *  获取图书列表
     *  只需获取全部，controller那边会处理数据
     */
    public List<book> getBookList()
    {
        return null;
    }

    /**
     * 图书删除
     */
    public boolean bookdelect()
    {
        return true;
    }

    /**
     * 添加图书
     */
    public boolean bookAdd()
    {
        return true;
    }

    /**
     * 获取分类列表
     */
    public List<category> getCategoryList()
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
     * 获取管理员列表
     */
    public List<admin> getAdminList(int page,int size)
    {
        return adminDao.selectAll((page-1)*size,size);

    }

    /**
     * 添加管理员
     */
    public boolean adminAdd(admin admin)
    {
        adminDao.adminInsert(admin);
        return true;
    }

    /**
     * 获取管理员的总数
     * @return
     */
    public long getTotal() {
        return adminDao.selectTotal();
    }

    /**
     * 通过id查询管理员
     */
    public admin selectAdminById(int adminId)
    {
        return adminDao.selectById(adminId);
    }

    /**
     * 更新管理员信息
     */
    public boolean updateAdmin(admin admin)
    {
        return adminDao.adminUpdate(admin);
    }

    /**
     * 管理员删除
     */
    public boolean deleteAdmin(int adminId)
    {
        return adminDao.delectAdmin(adminId);
    }
}
