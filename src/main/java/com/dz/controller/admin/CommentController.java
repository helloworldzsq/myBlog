package com.dz.controller.admin;

import com.dz.pojo.Comment;
import com.dz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping("/toComment")  //去评论页面
    public String toComment(Model model){
        List<Comment> comments = commentService.queryAllComments();
        model.addAttribute("comments",comments);
        return "admin/comment";
    }
    //删除文章
    @RequestMapping("/deleteComment{id}")
    public String deleteArticle(@PathVariable("id") Integer id){
        commentService.deleteComment(id);
        return "redirect:/toComment";
    }
}
