package ssmBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service
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
     * 获取用户列表
     */
    public List<user> getUser()
    {
        return null;
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
