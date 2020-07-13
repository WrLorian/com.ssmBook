package ssmBook.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssmBook.pojo.book;
import ssmBook.service.BookService;
import ssmBook.service.CategoryService;
import ssmBook.util.PageUtil;

import javax.servlet.http.HttpServletRequest;


public class bookController {

    private static final int size = 10;
    /**
     *原先项目中的该变量设置为自动填装@Autowired在service层中自动实现
     *考虑到貌似大家都对spring不太熟悉，则也可通过构造函数的方式实现^^
     *如果会写相应的service层，则也可使用自动填装，将new BookService()删去即可。
     *
     */
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

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
}
