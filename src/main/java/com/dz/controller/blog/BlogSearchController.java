package com.dz.controller.blog;

import com.dz.pojo.Article;
import com.dz.pojo.Comment;
import com.dz.service.ArticleService;
import com.dz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogSearchController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @RequestMapping("/toSearch")
    public String toSearch(String query, Model model){
        List<Article> articleList = articleService.queryArticlesByInfo(query);
        int size = articleList.size();
        model.addAttribute("size",size);
        model.addAttribute("articles",articleList);
//        -------------------------------
        Long articleCount = articleService.getArticleCount();
        model.addAttribute("articlesNum",articleCount);
        List<Comment> comments1 = commentService.queryAllComments();
        int size1 = comments1.size();
        model.addAttribute("commentsNum",size1);
        int sum=0;
        for (Article allArticle : articleService.allArticles()) {
            sum+=allArticle.getHits();
        }
        model.addAttribute("hits",sum);
        return "blog/search";
    }
}
