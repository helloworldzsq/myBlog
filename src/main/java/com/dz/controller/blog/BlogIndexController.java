package com.dz.controller.blog;

import com.dz.pojo.Article;
import com.dz.pojo.Comment;
import com.dz.service.ArticleService;
import com.dz.service.CommentService;
import com.dz.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogIndexController {
    //去首页
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CommentService commentService;
    @RequestMapping("/")
    public String toindex(Model model){
        List<Article> articles = articleService.allArticles();
        for (Article article : articles) {
            Integer id = article.getId();
            Integer commentNumById = commentService.getCommentNumById(id);
            article.setCommentsNum(commentNumById);
        }
        model.addAttribute("articles",articles);
//        -------------------------------
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
        return "index";
    }

}
