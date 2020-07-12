package ssmBook.controller.Admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import ssmBook.pojo.admin;
import ssmBook.service.IndentService;

/**
 * 后台管理页面Controller
 *
 */
public class indentController {

    /**
     *原先项目中的该变量设置为自动填装@Autowired在service层中自动实现
     *考虑到貌似大家都对spring不太熟悉，则也可通过构造函数的方式实现^^
     *如果会写相应的service层，则也可使用自动填装，将new BookService()删去即可。
     *
     */
    @Autowired
    private IndentService indentService;


    /**
     * 查看所有未订单列表
     */
    @RequestMapping("/alreadyIndentList")
    public String alreadyIndentList()
    {
        return "0";
    }

    /**
     * 查看所有已处理订单列表
     */
    @RequestMapping("/unreadyIndentList")
    public String unreadyIndentList()
    {
        return "0";
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
    public String dealIndent()
    {
        return "0";
    }
    /**
     * 删除订单
     */
    @RequestMapping("/delectIndent")
    public String delectIndent()
    {
        return "0";
    }

}
