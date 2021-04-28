package com.dz.controller.blog;

import com.dz.pojo.Article;
import com.dz.pojo.Comment;
import com.dz.pojo.Type;
import com.dz.service.ArticleService;
import com.dz.service.CommentService;
import com.dz.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogTypeController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CommentService commentService;
    //去分类页面
    @RequestMapping("/toTypes{id}")
    public String toTypes(@PathVariable("id")Integer id, Model model){
        List<Type> types = typeService.allTypes();
        model.addAttribute("types",types);
        List<Article> articles = articleService.allArticles();
        List<Article> articleList = new ArrayList<>();
        for (Article article : articles) {
            if (article.getTid()==id){
                articleList.add(article);
            }
        }
        model.addAttribute("articles",articleList);
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
        return "blog/types";
    }
}
