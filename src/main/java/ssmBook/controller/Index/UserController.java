package ssmBook.controller.Index;


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
@RequestMapping("/index")
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
     *原先项目中的该变量设置为自动填装@Autowired在service层中自动实现
     *考虑到貌似大家都对spring不太熟悉，则也可通过构造函数的方式实现^^
     *如果会写相应的service层，则也可使用自动填装，将new BookService()删去即可。
     *
     *
     * 该变量的作用为读取后台的书本数据。
     */


    /**
     * 注册用户
     */
    @RequestMapping("/reg")
    public String reg()
    {
        return "/index/register.jsp";
    }

    /**
     * 注册用户按钮实现
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest request, user user)
    {
        request.setAttribute("flag", 7);
        if(user.getUserName().isEmpty()||user.getuPassWord().isEmpty())
        {
            request.setAttribute("msg","用户名或密码不能为空!");
            return "/index/register.jsp";
        }
        else if(userService.isExist(user.getUserName()))
        {
            request.setAttribute("msg","用户名已存在!");
            return "/index/register.jsp";
        }
        else
        {
            userService.add(user);
            request.setAttribute("msg","注册成功，请登录！");
            return "/index/login.jsp";
        }
    }

    /**
     * 用户登录
     */
    @RequestMapping("/log")
    public String log()
    {
        return "/index/login.jsp";
    }

    /**
     * 用户登录按钮的实现
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, user user)
    {
        request.setAttribute("flag",6);
        if(userService.checkUser(user.getUserName(), user.getuPassWord()))
        {
            request.getSession().setAttribute("username", user.getUserName());
            return "index";
        }
        else
        {
            request.setAttribute("msg", "用户名或密码错误!");
            return "/index/login.jsp";
        }
    }

    /**
     * 用户注销
     *
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("indent");
        return "/index/login.jsp";
    }

    /**
     * 查看购物车
     */
    @RequestMapping("/cart")//判断用户名不为空，set购物车列表
    public String cart(HttpServletRequest request)
    {
        Object username = request.getSession().getAttribute("username");
        if(!username.toString().isEmpty()&&username!=null)
        {
            List<indent> indentList = indentService.getIndentByUser(userService.get(username.toString()).getUserId());//获取用户所有订单
            if (indentList!=null && !indentList.isEmpty()) {
                List<item> itemList=itemDao.selectListByIndentId( indentList.get(0).getiId());
                request.setAttribute("item", itemList);//感觉怪怪的
            }
        }
        return "/index/cart.jsp";
    }

    /**
     * 购买书籍
     * 添加进购物车
     */
    @RequestMapping("/buy")
    public String buy(HttpServletRequest request, int bookId)
    {
        Object username = request.getSession().getAttribute("username");
        indent indent1 = (indent) request.getSession().getAttribute(indentKey);
        if(indent1==null)
        {
            request.getSession().setAttribute(indentKey, indentService.create(bookService.get(bookId),userService.get(username.toString())));//创建订单
        }
        else
        {
            request.getSession().setAttribute(indentKey, indentService.itemAdd(indent1, bookService.get(bookId)));//向已有订单里加项目
        }
        return "ok";
    }

    /**
     * 减少数量
     */
    @RequestMapping("/lessen")
    public String lessen(HttpServletRequest request, int bookId)
    {
        indent indent = (indent) request.getSession().getAttribute(indentKey);
        if (indent != null) {
            request.getSession().setAttribute(indentKey, indentService.itemLess(indent, bookService.get(bookId)));
        }
        return "ok";
    }

    /**
     * 删除书籍
     */
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, int bookId)
    {
        indent indent2 = (indent) request.getSession().getAttribute(indentKey);
        if (indent2 != null) {
            request.getSession().setAttribute(indentKey, indentService.itemDelete(indent2, bookService.get(bookId)));
        }
        return "ok";
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
            return "/index/login.jsp";
        }
            indent indentSession = (indent) request.getSession().getAttribute(indentKey);
            user user = userService.get(username.toString());
            indent.setState(indentSession.STATUS_WAIT);
            indent.setTime(new Date());
            indentSession.setUserId(user.getUserId());
            indentSession.setUserName(indent.getUserName());
            indentSession.setTel(indent.getTel());
            indentSession.setLoc(indent.getLoc());

            indentDao.insert(indentSession);    // 保存订单

            request.getSession().removeAttribute(indentKey);    // 清除购物车
            request.setAttribute("msg", "提交订单成功!");
            return "/index/cart.jsp";
        }



    /**
     * 查看用户所有订单
     */
    @RequestMapping("/order")
    public String order(HttpServletRequest request)
    {
        Object username=request.getSession().getAttribute("username");
        if(username==null||username.toString().isEmpty())
        {
            request.setAttribute("msg","请登录后再查看订单！");
            return "login";
        }
        else
        {
            request.setAttribute("indentList",indentService.getIndentByUser(userService.get(username.toString()).getUserId()));
            return "/index/order.jsp";
        }
    }

}
