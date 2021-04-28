package com.dz.controller.blog;

import com.dz.pojo.Article;
import com.dz.pojo.Comment;
import com.dz.service.ArticleService;
import com.dz.service.CommentService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogCommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/addComment")
    public String addComment(Comment comment){
        if (comment.getDate()==null){
            comment.setDate(new Date());
        }
        commentService.addComment(comment);
        Integer cid = comment.getCid();
        return "redirect:/blog/toarticle"+cid;
    }
}
