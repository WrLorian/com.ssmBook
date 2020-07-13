package ssmBook.controller.Admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssmBook.dao.IndentDao;
import ssmBook.pojo.admin;
import ssmBook.pojo.indent;
import ssmBook.service.IndentService;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台管理页面Controller
 *
 */
public class indentController {

    private static final int size = 10;
    /**
     *原先项目中的该变量设置为自动填装@Autowired在service层中自动实现
     *考虑到貌似大家都对spring不太熟悉，则也可通过构造函数的方式实现^^
     *如果会写相应的service层，则也可使用自动填装，将new BookService()删去即可。
     *
     */
    @Autowired
    private IndentService indentService;


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


}
