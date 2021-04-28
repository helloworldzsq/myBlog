package com.dz.service.serviceImpl;

import com.dz.dao.ArticleMapper;
import com.dz.dao.CommentMapper;
import com.dz.pojo.Comment;
import com.dz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Comment> queryAllComments() {
        return commentMapper.queryAllComments();
    }

    @Override
    public List<Comment> queryCommentsById(Integer cid) {
          return commentMapper.queryCommentsById(cid);
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        commentMapper.deleteComment(id);
    }

    @Override
    public Integer getCommentNumById(Integer cid) {
        return commentMapper.getCommentNumById(cid);
    }
}
