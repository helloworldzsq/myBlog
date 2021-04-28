package com.dz.controller.admin;

import com.dz.pojo.Article;
import com.dz.pojo.Comment;
import com.dz.service.ArticleService;
import com.dz.service.CommentService;
import com.dz.service.FlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private FlinkService flinkService;
    @RequestMapping("/toindex")  //去首页
    public String toIndex(Model model){
        Long articleCount = articleService.getArticleCount();
        Long flinkCount = flinkService.getFlinkCount();
        List<Comment> comments = commentService.queryAllComments();
        int size = comments.size();
        int sum=0;
        for (Article article : articleService.allArticles()) {
            sum+=article.getHits();
        }
        model.addAttribute("hits",sum);
        model.addAttribute("commentsNum",size);
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("flinkCount",flinkCount);
        return "admin/index";
    }
}
