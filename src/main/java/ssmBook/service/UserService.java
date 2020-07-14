package ssmBook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssmBook.dao.UserDao;
import ssmBook.pojo.user;

/**
 *
 * 用户service
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 通过id获取
     */
    public user getById(int userId){
        return userDao.select(userId);
    }

    /**
     * 通过username获取
     */
    public user getByUsername(String username)
    {
        return userDao.selectByUsername(username);
    }

    /**
     * 用户列表
     */
    public List<user> getList(int page, int size) {
        return userDao.selectList((page-1)*size, size);
    }

    /**
     * 用户总数
    */
    public long getTotal() {
        return userDao.selectTotal();
    }

    /**
     * 判断用户是否存在
     */
    public boolean isExist(String username) {
        return userDao.selectByUsername(username) != null;
    }

    /**
     * 验证用户密码
     */
    public boolean checkUser(String username, String password){
        return userDao.selectByUsernameAndPassword(username,password) !=null;
    }

    /**
     * 添加
     */
    public boolean userAdd(user user) {
        return userDao.insert(user);
    }

    /**
     */
    public boolean update(user user) {
        return userDao.update(user);
    }

    /**
     * 删除用户
     */
    public boolean deleteUser(int id)
    {
        return userDao.delete(id);
    }
}
