package com.dz.controller.admin;

import com.dz.pojo.Flink;
import com.dz.service.FlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FlinkController {
    @Autowired
    private FlinkService flinkService;

    @RequestMapping("/toFlink") //去友情链接界面
    public String toFlink(Model model){
        List<Flink> flinks = flinkService.queryAllFlinks();
        model.addAttribute("flinks",flinks);
        return "admin/flink";
    }
    @RequestMapping("/toaddFlink") //去添加文章界面
    public String toaddFlink(){
        return "admin/add-flink";
    }
    @RequestMapping("/addFlink")
    public String addType(Flink flink){
       flinkService.addFlink(flink);
        return "redirect:/toFlink";
    }

    @RequestMapping("/deleteFlink{name}")
    public String deleteArticle(@PathVariable("name") String name){
        flinkService.deleteFlink(name);
        return "redirect:/toFlink";
    }
}
