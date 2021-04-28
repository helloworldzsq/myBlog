package com.dz.dao;

import com.dz.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CommentMapper {

        //查询所有评论
        List<Comment> queryAllComments();
        //根据文章id查询评论
        List<Comment> queryCommentsById(Integer cid);
        int addComment(Comment comment);
        //删除评论
        void deleteComment(Integer id);
       //查询某一文章的评论数数量
       Integer getCommentNumById(Integer cid);
}
