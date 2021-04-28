package com.dz.controller.admin;

import com.dz.pojo.Type;
import com.dz.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping("/toCategory") //去栏目页面
    public String toCategory(Model model){
        List<Type> types = typeService.allTypes();
        model.addAttribute("types",types);
        return "admin/category";
    }
    @RequestMapping("/toaddType") //去添加文章界面
    public String toaddType(){
        return "admin/add-category";
    }
    @RequestMapping("/addType")
    public String addType(Type type){
        typeService.addType(type);
        return "redirect:/toCategory";
    }

    @RequestMapping("/toUpdataType{id}")
    public String toUpdataArticle(@PathVariable("id") Integer id, Model model){
        Type type = typeService.getTypeByid(id);
        model.addAttribute("type",type);
        return "admin/update-category";
    }
    @RequestMapping("/updateType")
    public String updateArticle(Type type){
        typeService.updataType(type);
        return "redirect:/toCategory";
    }
    @RequestMapping("/deleteType{id}")
    public String deleteArticle(@PathVariable("id") Integer id){
        typeService.deleteType(id);
        return "redirect:/toCategory";
    }
}
