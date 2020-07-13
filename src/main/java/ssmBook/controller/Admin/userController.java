package ssmBook.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssmBook.pojo.user;
import ssmBook.service.UserService;
import ssmBook.util.PageUtil;

import javax.servlet.http.HttpServletRequest;

public class userController {

    private static final int size = 10;
    /**
     *原先项目中的该变量设置为自动填装@Autowired在service层中自动实现
     *考虑到貌似大家都对spring不太熟悉，则也可通过构造函数的方式实现^^
     *如果会写相应的service层，则也可使用自动填装，将new BookService()删去即可。
     *
     */
    @Autowired
    private UserService userService;

    /**
     * 用户列表
     */
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request,
                           @RequestParam(required = false,defaultValue = "1")int page)
    {
        request.setAttribute("userList",userService.getTotal());
        request.setAttribute("pageTool", PageUtil.getPageToolAdmin(request,userService.getTotal(),page,size));
        return "/admin/user-list";
    }

    /**
     * 跳转到用户添加页面
     */
    @RequestMapping("/userAd")
    public String userAd()
    {
        return "/admin/user-add";
    }

    /**
     *用户添加页面
     */
    @RequestMapping("/userAdd")
    public String userAdd(user user, HttpServletRequest request)
    {
        if(userService.isExist(user.getUserName()))
        {
            request.setAttribute("msg","用户名已存在！");
            return "/admin/user-add";
        }
        userService.userAdd(user);
        return "redirect:userList";
    }

    /**
     * 跳转到顾客密码重置页面
     */
    @RequestMapping("/userRe")
    public String userRe(int id,HttpServletRequest request)
    {
        request.setAttribute("user",userService.getById(id));
        return "/admin/user-reset";
    }

    /**
     * 用户密码重置
     */
    @RequestMapping("/userResetPwd")
    public String userResetPwd(user user)
    {
        userService.update(user);
        return "redirect:userList";
    }

    /**
     * 跳转到用户更新界面
     */
    @RequestMapping("/userUp")
    public String userUp(int id,HttpServletRequest request)
    {
        request.setAttribute("user",userService.getById(id));
        return "/admin/user-update";
    }

    /**
     * 假如不需要密码加密，该方法可以和上述密码重置合并为一种方法
     * 用户更新
     */
    @RequestMapping("/userUpdate")
    public String userUpdate(user user)
    {
        userService.update(user);
        return "redirect:userList";
    }

    /**
     * 顾客电话号码更改
     */
    @RequestMapping("/userResetPhone")
    public String userResetPhone()
    {
        return "0";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delectUser")
    public String delectUser()
    {
        return "0";
    }
}
