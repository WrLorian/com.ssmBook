package ssmBook.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssmBook.pojo.admin;
import ssmBook.service.AdminService;
import ssmBook.util.PageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class adminController {

    private static final int size = 10;
    /**
     *原先项目中的该变量设置为自动填装@Autowired在service层中自动实现
     *考虑到貌似大家都对spring不太熟悉，则也可通过构造函数的方式实现^^
     *如果会写相应的service层，则也可使用自动填装，将new BookService()删去即可。
     *
     */
    @Autowired
    private AdminService adminService;


    /**
     * 判断用户名是否存在
     */

    /**
     * 管理员登录
     */
    @RequestMapping("/login")
    public String login(admin admin, HttpServletRequest request)
    {
        if(adminService.checkUser(admin.getAdminName(),admin.getPassWord()))
        {
            request.getSession().setAttribute("admin",admin.getAdminName());
            return "admin/main";
        }
        request.setAttribute("msg","用户密码错误");
        return "admin/login";
    }

    /**
     * 管理员注销
     */
    @RequestMapping("/loggout")
    public String logout(HttpServletRequest request)
    {
        request.getSession().removeAttribute("admin");
        return "admin/login";
    }

    /**
     * 管理员列表
     * @return
     */
    @RequestMapping("/adminList")
    public String adminList(HttpServletRequest request,
                            @RequestParam(required = false,defaultValue = "1")int page)
    {
        request.setAttribute("adminList",adminService.getAdminList(page,size));
        request.setAttribute("pageTool", PageUtil.getPageToolAdmin(request,adminService.getTotal(),page,size));

        return "admin/admin-list";
    }

    /**
     * 跳转添加管理员页面
     */
    @RequestMapping("/adminAd")
    public String adminAd()
    {
//        返回到添加管理员页面
        return "admin/admin-add";
    }

    /**
     * 添加管理员页面的添加操作
     */
    @RequestMapping("/adminAdd")
    public String adminAdd(HttpServletRequest request,admin admin)
    {
        if(adminService.isExist(admin.getAdminName()))
        {
            request.setAttribute("msg","用户名已存在！");
            return "admin/admin-add";
        }
        adminService.adminAdd(admin);
        return "redirect:adminList";
    }
    /**
     * 跳转重置管理员密码页面（需获取需要更改的管理员的ID）
     */
    @RequestMapping("/adminRe")
    public String adminResetPwd(HttpServletRequest request,int adminId)
    {
        request.setAttribute("admin",adminService.selectAdminById(adminId));
        return "admin/admin";
    }

    /**
     * 重置管理员密码
     */
    @RequestMapping("/adminResetPwd")
    public String adminResetPwd(admin admin)
    {
        adminService.updateAdmin(admin);
        return "redirect:adminList";
    }

    /**
     * 删除管理员
     */
    @RequestMapping("/adminDelect")
    public String adminDelect(int adminId)
    {
        adminService.deleteAdmin(adminId);
        return "redirect:adminList";
    }
}
