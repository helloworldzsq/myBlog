package com.dz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id;
    private String title; //标题
    private String titlePic;  //标题图片
    private String status; //状态  已发布
    private String labels;
    private Integer commentsNum; // 评论数
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date date; //创建日期
    private Integer hits;  //点击次数
    private String content; //文章内容
    private String info; //描述文章内容
    private String type;
    private Integer tid; //外键，关联type
}
