package ssmBook.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssmBook.pojo.category;
import ssmBook.service.CategoryService;
import ssmBook.util.PageUtil;

import javax.servlet.http.HttpServletRequest;

public class categoryController {
    private static final int size = 10;

    @Autowired
    private CategoryService categoryService;
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


}
