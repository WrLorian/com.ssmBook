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

    public boolean checkUser(String username, String password){
        return userDao.selectByUsernameAndPassword(username, password) != null;
    }

    public boolean isExist(String username)
    {
        return userDao.selectByUsername(username)!=null;
    }

    public boolean add(user user)
    {
        user.setUserName(user.getUserName());
        user.setuPassWord(user.getuPassWord());
        user.setuTel(user.getuTel());
        user.setuLoc(user.getuLoc());
        user.setuSex(user.getuSex());
        user.setuAge(user.getuAge());
        return userDao.insert(user);
    }

    public user get(int userid)
    {
        return userDao.select(userid);
    }

    public user get(String username)
    {
        return userDao.selectByUsername(username);
    }
}
