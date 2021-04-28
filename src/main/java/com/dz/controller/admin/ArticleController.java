package com.dz.controller.admin;

import com.dz.pojo.Article;
import com.dz.pojo.Type;
import com.dz.service.ArticleService;
import com.dz.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeService typeService;

    @RequestMapping("/toArticle")  //去文章管理页面
    public String toArticle(Model model){
        List<Article> articles = articleService.allArticles();
        model.addAttribute("articles",articles);
        return "admin/article";
    }
    @RequestMapping("/toaddArticle") //去添加文章界面
    public String toaddArticle(Model model){
        List<Type> types = typeService.allTypes();
        model.addAttribute("types",types);
        return "admin/add-article";
    }
    @PostMapping("/addArticle")
    public String addArticle(Article article){
        List<Type> types = typeService.allTypes();
        articleService.addArticle(article);
        for (Type type : types) {
            if (article.getTid()==type.getId()){
                int number = type.getNumber();
                int num=number+1;
                typeService.updateNum(article.getTid(),num);
            }
        }
        return "redirect:/toArticle";
    }
    //删除文章
    @RequestMapping("/deleteArticle{id}")
    public String deleteArticle(@PathVariable("id") Integer id){
        List<Type> types = typeService.allTypes();
        Article articleByid = articleService.getArticleByid(id);
        for (Type type : types) {
            if (articleByid.getTid()==type.getId()){
                int number = type.getNumber();
                typeService.updateNum(articleByid.getTid(),number-1);
            }
        }
        articleService.deleteArticle(id);
        return "redirect:/toArticle";
    }
    @RequestMapping("/toUpdataArticle{id}")
    public String toUpdataArticle(@PathVariable("id") Integer id, Model model){
        Article article = articleService.getArticleByid(id);
        List<Type> types = typeService.allTypes();
        model.addAttribute("types",types);
        model.addAttribute("article",article);
        return "admin/update-article";
    }
    @RequestMapping("/updateArticle")
    public String updateArticle(Article article){
        articleService.updataArticle(article);
        return "redirect:/toArticle";
    }


    @RequestMapping("/toSetting") //去站点管理界面
    public String toSetting(){
        return "admin/setting";
    }
}
