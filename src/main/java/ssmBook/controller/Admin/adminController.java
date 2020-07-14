package ssmBook.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssmBook.pojo.admin;
import ssmBook.pojo.book;
import ssmBook.pojo.category;
import ssmBook.pojo.user;
import ssmBook.service.*;
import ssmBook.util.PageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
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
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private IndentService indentService;
    @Autowired
    private UserService userService;



    /**
     * 管理员登录
     * 1
     */
    @RequestMapping("/login")
    public String login(admin admin, HttpServletRequest request)
    {
        if(adminService.checkUser(admin.getAdminName(),admin.getPassWord()))
        {
            request.getSession().setAttribute("admin",admin.getAdminName());
            return "admin/index";
        }
        request.setAttribute("msg","用户密码错误");
        System.out.println("密码错误");
        return "admin/pages/login";
    }

    /**
     * 管理员注销
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        request.getSession().removeAttribute("admin");
        return "admin/pages/login";
    }

    /**
     * 管理员列表
     * @return
     * OK
     */
    @RequestMapping("/adminList")
    public String adminList(HttpServletRequest request,
                            @RequestParam(required = false,defaultValue = "1")int page)
    {
        request.setAttribute("adminList",adminService.getAdminList(page,size));
        request.setAttribute("pageTool", PageUtil.getPageToolAdmin(request,adminService.getTotal(),page,size));

        return "admin/pages/admin-list";
    }

    /**
     * 跳转添加管理员页面
     */
//    @RequestMapping("/adminAd")
//    public String adminAd()
//    {
////        返回到添加管理员页面
//        return "admin/pages/admin-list";
//    }

    /**
     * 添加管理员页面的添加操作
     * OK
     */
    @RequestMapping("/adminAdd")
    public String adminAdd(HttpServletRequest request,admin admin)
    {
        if(adminService.isExist(admin.getAdminName()))
        {
            request.setAttribute("msg","用户名已存在！");
            return "admin/pages/admin-list";
        }
        adminService.adminAdd(admin);
        return "redirect:admin/pages/admin-list";
    }
    /**
     * 跳转重置管理员密码页面（需获取需要更改的管理员的ID）
     */
//    @RequestMapping("/adminRe")
//    public String adminResetPwd(HttpServletRequest request,int adminId)
//    {
//        request.setAttribute("admin",adminService.selectAdminById(adminId));
//        return "admin/admin";
//    }

    /**
     * 重置管理员密码
     * OK
     */
    @RequestMapping("/adminModify")
    public String adminResetPwd(admin admin)
    {
        adminService.updateAdmin(admin);
        return "redirect:admin/pages/admin-list";
    }

    /**
     * 删除管理员
     * OK
     */
    @RequestMapping("/adminDelete")
    public String adminDelect(int adminId)
    {
        adminService.deleteAdmin(adminId);
        return "redirect:admin/pages/admin-list";
    }

    /**
     * 图书列表
     * 可通过if语句将图书列表分为推荐列表、最新列表等
     * 如有困难，可将该方法分成3个方法，逐一编写
     * OK
     */
    @RequestMapping("/bookList")
    public String bookList(HttpServletRequest request,
                           @RequestParam(required=false, defaultValue="0")int status,
                           @RequestParam(required=false, defaultValue="1")int page)
    {
        if(status==0)
        {
            request.setAttribute("bookList",bookService.getBookList(page,size));
            request.setAttribute("pageTool", PageUtil.getPageToolAdmin(request,bookService.getTotal(),page,size));
        }
        else if(status == 1) {
            request.setAttribute("bookList", bookService.selectListIsSpecial(page, size));
            request.setAttribute("pageTool", PageUtil.getPageToolAdmin(request, bookService.getTotalIsSpecial(), page, size));
        }else if (status == 2) {
            request.setAttribute("bookList", bookService.getListIsNews(page, size));
            request.setAttribute("pageTool", PageUtil.getPageToolAdmin(request, bookService.getTotalIsNews(), page, size));
        }
        return "/admin/pages/book-list";
    }

    /**
     * 跳转到图书添加页面
     */
//    @RequestMapping("/bookAd")
//    public String bookAd(HttpServletRequest request)
//    {
//        request.setAttribute("categoryList",categoryService.getCategoryListAll());
//        return "admin/book-add";
//    }

    /**
     * 图书添加
     * OK
     */
    @RequestMapping("/bookAdd")
    public String bookAdd(book book)
    {
        bookService.bookAdd(book);
        return "redirect:admin/pages/book-list";
    }

    /**
     * 跳转到图书修改
     */
//    @RequestMapping("/bookUp")
//    public String bookUpdate(HttpServletRequest request,int bookId)
//    {
//        request.setAttribute("categoryList",categoryService.getCategoryListAll());
//        request.setAttribute("book",bookService.getBookById(bookId));
//        return "/admin/book-update";
//    }

    /**
     * 图书更新
     * ok
     */
    @RequestMapping("/bookUpdate")
    public String bookUpdate(book book)
    {
        bookService.bookUpdate(book);
        return "redirect:admin/pages/book-list";
    }

    /**
     * 图书删除
     * OK
     */
    @RequestMapping("/bookDelete")
    public String bookDelete(int id)
    {
        bookService.bookDelete(id);
        return "redirect:admin/pages/book-list";
    }

    /**
     * 图书设置
     * 暂时放空。。。
     */
    @RequestMapping("/bookSet")
    public String bookSet()
    {
        return "0";
    }

    /**
     * 分类列表
     * OK
     */
    @RequestMapping("/categoryList")
    public String categoryList(HttpServletRequest request,
                               @RequestParam(required = false,defaultValue = "1")int page)
    {
        request.setAttribute("categoryList", categoryService.getCategoryList(page,size));
        request.setAttribute("pageTool", PageUtil.getPageToolAdmin(request, categoryService.getTotal(), page, size));
        return "/admin/pages/category-list";
    }

    /**
     * 跳转添加分类页面
     */
//    @RequestMapping("categoryAd")
//    public String categoryAd()
//    {
//        return "/admin/category-add";
//    }

    /**
     * 添加分类
     * OK
     */
    @RequestMapping("/categoryAdd")
    public String categoryAdd(category category)
    {
        categoryService.categoryAdd(category);
        return "redirect:admin/pages/category-list";
    }

    /**
     * 跳转类目修改页面
     */
//    @RequestMapping("/categoryUp")
//    public String categoryUp(HttpServletRequest request,int id)
//    {
//        request.setAttribute("category",categoryService.getCategoryById(id));
//        return "/admin/category-update";
//    }

    /**
     * 类目修改
     * OK
     */
    @RequestMapping("/categoryUpdate")
    public String categoryUpdate(category category)
    {
        categoryService.categoryUpdate(category);
        return "redirect:categoryList";
    }

    /**
     * 类目删除
     * OK
     */
    @RequestMapping("/categoryDelete")
    public String categoryDelete(int id)
    {
        categoryService.categoryDelete(id);
        return "redirect:categoryList";
    }

    /**
     * 查看所有订单列表
     * OK
     */
    @RequestMapping("/indentList")
    public String indentList(byte status, HttpServletRequest request,
                             @RequestParam(required = false,defaultValue = "1")int page)
    {
        request.setAttribute("page",page);
        request.setAttribute("status",status);
        request.setAttribute("indentList",indentService.getIndentList(status,page,size));
        return "/admin/pages/indent-list";
    }


    /**
     * 查看订单详情
     */
    @RequestMapping("/indentConfig")
    public String indentConfig()
    {
        return "0";
    }

    /**
     * 标明订单处理
     * OK
     */
    @RequestMapping("/dealIndent")
    public String dealIndent(int id,byte status,int page)
    {
        indentService.indentReady(id);
        return "redirect:indentList?status="+status+"&page="+page;

    }
    /**
     * 删除订单
     * OK
     */
    @RequestMapping("/deleteIndent")
    public String delectIndent(int id,byte status,int page)
    {
        indentService.ItemDelete(id);
        return "redirect:indentList?status="+status+"&page="+page;
    }

    /**
     * 查看订单项详情
     */
    @RequestMapping("/itemList")
    public String itemList(int id,HttpServletRequest request)
    {
        request.setAttribute("itemList",indentService.getItemListById(id));
        return "/admin/item-list";
    }

    /**
     * 用户列表
     * OK
     */
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request,
                           @RequestParam(required = false,defaultValue = "1")int page)
    {
        request.setAttribute("userList",userService.getList(page,size));
        request.setAttribute("pageTool", PageUtil.getPageToolAdmin(request,userService.getTotal(),page,size));
        return "/admin/pages/user-modify";
    }

    /**
     * 跳转到用户添加页面
     */
//    @RequestMapping("/userAd")
//    public String userAd()
//    {
//        return "/admin/user-add";
//    }

    /**
     *用户添加页面
     */
    @RequestMapping("/userAdd")
    public String userAdd(user user, HttpServletRequest request)
    {
        if(userService.isExist(user.getUserName()))
        {
            request.setAttribute("msg","用户名已存在！");
            return "redirect:userList";
        }
        userService.userAdd(user);
        return "redirect:userList";
    }

    /**
     * 跳转到顾客密码重置页面
     */
//    @RequestMapping("/userRe")
//    public String userRe(int id,HttpServletRequest request)
//    {
//        request.setAttribute("user",userService.getById(id));
//        return "/admin/user-reset";
//    }

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
//    @RequestMapping("/userUp")
//    public String userUp(int id,HttpServletRequest request)
//    {
//        request.setAttribute("user",userService.getById(id));
//        return "/admin/user-update";
//    }

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
     * 删除用户
     */
    @RequestMapping("/deleteUser")
    public String delectUser(int id)
    {
        userService.deleteUser(id);
        return "redirect:userList";
    }

    /**
     * 通过用户名查找用户
     */
    @RequestMapping("/selectUserByName")
    public String selectUserByName(HttpServletRequest request,String username)
    {
        request.setAttribute("user",userService.getByUsername(username));
        return "redirect:userList";
    }



}
