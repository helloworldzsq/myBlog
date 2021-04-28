package com.dz.controller.blog;

import com.dz.pojo.Article;
import com.dz.pojo.Comment;
import com.dz.pojo.Type;
import com.dz.service.ArticleService;
import com.dz.service.CommentService;
import com.dz.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogAboutController {
    //去首页
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CommentService commentService;
    //去关于我界面
    @RequestMapping("/toabout")
    public String toabout(Model model){
 //        ------------------------------------
        Long articleCount = articleService.getArticleCount();
        model.addAttribute("articlesNum",articleCount);
        List<Comment> comments1 = commentService.queryAllComments();
        int size = comments1.size();
        model.addAttribute("commentsNum",size);
        int sum=0;
        for (Article allArticle : articleService.allArticles()) {
            sum+=allArticle.getHits();
        }
        model.addAttribute("hits",sum);
        return "blog/about";
    }
}
