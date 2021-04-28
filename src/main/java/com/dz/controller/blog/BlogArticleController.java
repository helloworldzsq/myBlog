package com.dz.controller.blog;

import com.dz.pojo.Article;
import com.dz.pojo.Comment;
import com.dz.service.ArticleService;
import com.dz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogArticleController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;
    //去博客展示界面
    @RequestMapping("/toarticle{id}")
    public String toArticle(@PathVariable("id")Integer id, Model model){
        Integer commentNumById = commentService.getCommentNumById(id);
        model.addAttribute("commentNum",commentNumById);
        Article article = articleService.getArticleByid(id);
        Integer hits = article.getHits();
        articleService.updataHitNum(id,hits+1);
        model.addAttribute("article",article);
        List<Comment> comments = commentService.queryCommentsById(id);
        model.addAttribute("comments",comments);
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
        return "blog/article";
    }
}
