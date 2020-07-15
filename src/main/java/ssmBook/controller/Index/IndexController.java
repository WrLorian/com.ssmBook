package ssmBook.controller.Index;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssmBook.service.BookService;

import javax.servlet.http.HttpServletRequest;
import ssmBook.util.PageUtil;

/**
 * 书店首页Controller
 */

@Controller
@RequestMapping("/index")
public class IndexController {


    /**
     * 原先项目中的该变量设置为自动填装@Autowired在service层中自动实现
     * 考虑到貌似大家都对spring不太熟悉，则也可通过构造函数的方式实现^^
     * 如果会写相应的service层，则也可使用自动填装，将new BookService()删去即可。
     * <p>
     * <p>
     * 该变量的作用为读取后台的书本数据。
     */

    private BookService bookService = new BookService();

    /**
     * 书店首页
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute("newList", bookService.getListIsNews(1, 2));//新品
        request.setAttribute("specialList", bookService.getListIsSpecial(1, 2));//精品
        request.setAttribute("flag", 1);
        return "index/index";
    }



    /**
     * 精品推荐
     */
    @RequestMapping("/special")
    public String special(HttpServletRequest request,
                          @RequestParam(required = false, defaultValue = "1") int page) {
        request.setAttribute("specialList", bookService.getListIsSpecial(page, 2));
        request.setAttribute("pageTool", PageUtil.getPageTool(request, bookService.getTotalIsSpecial(), page, 3));//精品推荐总数
        request.setAttribute("flag", 3);
        return "index/recommend";
    }

    /**
     * 最新出版，按时间改（要记得改！！！)
     * 注意，new在java中为关键字，故该方法名写为news
     */
    @RequestMapping("/news")
    public String news(HttpServletRequest request,
                       @RequestParam(required = false, defaultValue = "1") int page) {
        request.setAttribute("newsList", bookService.getListIsNews(page, 3));
        request.setAttribute("pageTool", PageUtil.getPageTool(request, bookService.getTotalIsNews(), page, 3));//获取上新总数
                request.setAttribute("flag", 4);
        return "index/new";
    }

    /**
     * 获取图书详情
     */
    @RequestMapping("/detail")
    public String detail(HttpServletRequest request, int bookId) {
        request.setAttribute("book", bookService.getBookById(bookId));
        return "index/detail";
    }

    /**
     * 图书名称搜索
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest request,
                         @RequestParam(required = false, defaultValue = "") String searchName,
                         @RequestParam(required = false, defaultValue = "1") int page) {
        if (searchName != null && !searchName.trim().isEmpty()) {
            request.setAttribute("bookList", bookService.getListByBookName(searchName, page, 12));
            request.setAttribute("pageTool", PageUtil.getPageTool(request, bookService.getTotal(searchName), page, 12));//一页12项
        }
        return "index/search";
    }
    /**
     * 类目搜索
     * @return
     */
    @RequestMapping("/category")
    public String category(HttpServletRequest request, int categoryId,
                           @RequestParam(required=false, defaultValue="1")int page){
        request.setAttribute("bookList", bookService.getListByCategoryId(categoryId, page, 12));
        request.setAttribute("pageTool", PageUtil.getPageTool(request, bookService.getTotalByCategoryId(categoryId), page, 12));
        return "index/search";
    }



}
