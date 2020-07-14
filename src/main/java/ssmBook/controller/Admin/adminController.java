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
        System.out.println("密码错误");
        return "admin/login.jsp";
    }

    /**
     * 管理员注销
     */
    @RequestMapping("/loggout")
    public String logout(HttpServletRequest request)
    {
        request.getSession().removeAttribute("admin");
        return "redirect:admin/login";
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

    /**
     * 图书列表
     * 可通过if语句将图书列表分为推荐列表、最新列表等
     * 如有困难，可将该方法分成3个方法，逐一编写
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
        return "/admin/book-list";
    }

    /**
     * 跳转到图书添加页面
     */
    @RequestMapping("/bookAd")
    public String bookAd(HttpServletRequest request)
    {
        request.setAttribute("categoryList",categoryService.getCategoryListAll());
        return "admin/book-add";
    }

    /**
     * 图书添加
     */
    @RequestMapping("/bookAdd")
    public String bookAdd(book book)
    {
        bookService.bookAdd(book);
        return "redirect:bookList";
    }

    /**
     * 跳转到图书修改
     */
    @RequestMapping("/bookUp")
    public String bookUpdate(HttpServletRequest request,int bookId)
    {
        request.setAttribute("categoryList",categoryService.getCategoryListAll());
        request.setAttribute("book",bookService.getBookById(bookId));
        return "/admin/book-update";
    }

    /**
     * 图书更新
     */
    @RequestMapping("/bookUpdate")
    public String bookUpdate(book book)
    {
        bookService.bookUpdate(book);
        return "redirect:bookList";
    }

    /**
     * 图书删除
     */
    @RequestMapping("/bookDelete")
    public String bookDelete(int id)
    {
        bookService.bookDelete(id);
        return "redirect:bookList";
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
     */
    @RequestMapping("categoryList")
    public String categoryList(HttpServletRequest request,
                               @RequestParam(required = false,defaultValue = "1")int page)
    {
        request.setAttribute("categoryList", categoryService.getCategoryList(page,size));
        request.setAttribute("pageTool", PageUtil.getPageToolAdmin(request, categoryService.getTotal(), page, size));
        return "/admin/category-list";
    }

    /**
     * 跳转添加分类页面
     */
    @RequestMapping("categoryAd")
    public String categoryAd()
    {
        return "/admin/category-add";
    }

    /**
     * 添加分类
     */
    @RequestMapping("categoryAdd")
    public String categoryAdd(category category)
    {
        categoryService.categoryAdd(category);
        return "redirect:categoryList";
    }

    /**
     * 跳转类目修改页面
     */
    @RequestMapping("/categoryUp")
    public String categoryUp(HttpServletRequest request,int id)
    {
        request.setAttribute("category",categoryService.getCategoryById(id));
        return "/admin/category-update";
    }

    /**
     * 类目修改
     */
    @RequestMapping("/categoryUpdate")
    public String categoryUpdate(category category)
    {
        categoryService.categoryUpdate(category);
        return "redirect:categoryList";
    }

    /**
     * 类目删除
     */
    @RequestMapping("/categoryDelete")
    public String categoryDelete(int id)
    {
        categoryService.categoryDelete(id);
        return "redirect:categoryList";
    }

    /**
     * 查看所有订单列表
     */
    @RequestMapping("/indentList")
    public String indentList(byte status, HttpServletRequest request,
                             @RequestParam(required = false,defaultValue = "1")int page)
    {
        request.setAttribute("page",page);
        request.setAttribute("status",status);
        request.setAttribute("indentList",indentService.getIndentList(status,page,size));
        return "/admin/indent-list";
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
     */
    @RequestMapping("/dealIndent")
    public String dealIndent(int id,byte status,int page)
    {
        indentService.indentReady(id);
        return "redirect:indentList?status="+status+"&page="+page;

    }
    /**
     * 删除订单
     */
    @RequestMapping("/delectIndent")
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
     */
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request,
                           @RequestParam(required = false,defaultValue = "1")int page)
    {
        request.setAttribute("userList",userService.getList(page,size));
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
