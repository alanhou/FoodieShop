package org.alanhou.controller;

import org.alanhou.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuFooController {

    @Autowired
    private StuService stuService;

    @GetMapping("/getStu")
    public Object getStu(int id){
        return stuService.getStuInfo(id);
    }

    @PostMapping("/updateStu")
    public Object updateStu(int id){
        stuService.updateStu(id);
        return "Updated";
    }

    @PostMapping("/saveStu")
    public Object saveStu(){
        stuService.saveStu();
        return "Saved";
    }

    @PostMapping("/deleteStu")
    public Object deleteStu(int id){
        stuService.updateStu(id);
        return "Deleted";
    }
}
