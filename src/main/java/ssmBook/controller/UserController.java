package ssmBook.controller;


import java.util.Date;
import java.util.List;
import java.lang.*;

import javax.servlet.http.HttpServletRequest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssmBook.dao.UserDao;
import ssmBook.pojo.indent;
import ssmBook.pojo.item;
import ssmBook.pojo.user;
import ssmBook.service.BookService;
import ssmBook.service.IndentService;
import ssmBook.service.UserService;
import ssmBook.dao.ItemDao;
import ssmBook.dao.IndentDao;

/**
 * 用户相关Controller
 * 登录、注册、查看购物车、增加、减少商品
 */

@Controller

public class UserController {

    private static final String indentKey = "indent";//购物车

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private IndentService indentService;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private IndentDao indentDao;



    /**
     * 跳转到注册用户
     */
    @RequestMapping("/reg")
    public String reg()
    {
        return "index/register";
    }

    /**
     * 注册用户按钮实现
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest request, user user)
    {
        if(user.getUserName().isEmpty()||user.getuPassWord().isEmpty())
        {
            request.setAttribute("msg","用户名或密码不能为空!");
            return "index/register";
        }
        else if(userService.isExist(user.getUserName()))
        {
            request.setAttribute("msg","用户名已存在!");
            return "index/register";
        }
        else
        {
            userService.userAdd(user);
            request.setAttribute("msg","注册成功，请登录！");
            return "redirect:index";
        }
    }

    /**
     * 用户登录
     */
    @RequestMapping("/log")
    public String log()
    {
        return "index/login";
    }

    /**
     * 用户登录按钮的实现
     */
    @RequestMapping("/userLogin")
    public String login(HttpServletRequest request, user user)
    {
        request.setAttribute("flag",6);
        if(userService.checkUser(user.getUserName(), user.getuPassWord()))
        {
            request.getSession().setAttribute("username", user.getUserName());
            return "redirect:index";
        }
        else if(user.getUserName().isEmpty()||user.getuPassWord().isEmpty())
        {
            request.setAttribute("msg", "用户名或密码为空!");
            return "index/index";
        }
        else
        {
            request.setAttribute("msg", "用户名或密码错误!");
            return "index/login";
        }
    }

    /**
     * 用户注销
     *
     */
    @RequestMapping("/userLogout")
    public String logout(HttpServletRequest request)
    {
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("indent");
        return "index/login";
    }

    /**
     * 查看购物车
     * @return
     */
    @RequestMapping("/cart")
    public String cart(HttpServletRequest request) {
        Object username = request.getSession().getAttribute("username");
        if (username!=null && !username.toString().isEmpty())
        {
            List<indent> indentList = indentService.getIndentByUser(userService.getByUsername(username.toString()).getUserId());
            if (indentList!=null && !indentList.isEmpty()) {
                request.setAttribute("indent", indentList.get(0)); // 最后一次订单信息
            }
        }
        return "/index/shopList";
    }

    /**
     * 购买
     * @return
     */
    @RequestMapping("/buy")
    public String buy(HttpServletRequest request, int bookId){
        indent indent = (indent) request.getSession().getAttribute(indentKey);
        if (indent==null) {
            request.getSession().setAttribute(indentKey, indentService.indentCreat(bookService.getBookById(bookId)));
        }else {
            request.getSession().setAttribute(indentKey, indentService.ItemAdd(indent, bookService.getBookById(bookId)));
        }
        return "redirect:index";
    }

    /**
     * 减少数量
     */
    @RequestMapping("/lessen")
    public String lessen(HttpServletRequest request, int bookId)
    {
        indent indent = (indent) request.getSession().getAttribute(indentKey);
        if (indent != null) {
            request.getSession().setAttribute(indentKey, indentService.ItemLess(indent, bookService.getBookById(bookId)));
        }
        return "redirect:cart";
    }

    /**
     * 删除书籍
     */
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, int bookId)
    {
        indent indent2 = (indent) request.getSession().getAttribute(indentKey);
        if (indent2 != null) {
            request.getSession().setAttribute(indentKey, indentService.deleteItem(indent2, bookService.getBookById(bookId)));
        }
        return "redirect:cart";
    }

    /**
     * 提交订单
     */
    @RequestMapping("/save")
    public String save(HttpServletRequest request, indent indent)
    {
        Object username = request.getSession().getAttribute("username");
        //未登录，先跳转到登录页面
        if (username==null || username.toString().isEmpty()) {
            request.setAttribute("msg", "请登录后提交订单!");
            return "index/login";
        }
            indent indentSession = (indent) request.getSession().getAttribute(indentKey);
            user user = userService.getByUsername(username.toString());
            indentSession.setUserId(user.getUserId());
            indentSession.setUserName(indent.getUserName());
            indentSession.setAmount(indent.getAmount());
            indentSession.setTotal(indent.getTotal());
            indentSession.setTime(indent.getTime());
            indentSession.setTel(indent.getTel());
            indentSession.setLoc(indent.getLoc());


            indentDao.insert(indentSession);  // 保存订单

            request.getSession().removeAttribute(indentKey);    // 清除购物车
            request.setAttribute("msg", "提交订单成功!");
            return "index/shopList";
        }



    /**
     * 查看订单
     * @return
     */
    @RequestMapping("/order")
    public String order(HttpServletRequest request){
        Object username = request.getSession().getAttribute("username");
        if (username==null || username.toString().isEmpty()) {
            request.setAttribute("msg", "请登录后提交订单!");
            return "redirect:log";
        }
        request.setAttribute("indentList", indentService.getIndentByUser(userService.getByUsername(username.toString()).getUserId()));
        return "index/myorder";
    }

}
