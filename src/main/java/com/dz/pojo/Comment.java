package com.dz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer id;
    private String nickname; //评论人的姓名
    private String email;
    private String content;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date date;
    private Integer cid;
}
