package com.dz.controller.admin;

import com.dz.pojo.Article;
import com.dz.pojo.Comment;
import com.dz.service.ArticleService;
import com.dz.service.CommentService;
import com.dz.service.FlinkService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class login {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private FlinkService flinkService;
    //去登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "admin/login";
    }
    int count=0;
    @PostMapping("/user/login")
    public String login(@RequestParam("name")String name, @RequestParam("pwd") String pwd, Model model, HttpSession session){
        if (name.equals("dzsq123") && "123456".equals(pwd)) {
            //设置一个session
            session.setAttribute("loginuser",name);
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
        else {
            model.addAttribute("msg", "用户名或者密码错误");
            return "admin/login";
        }
    }
}
