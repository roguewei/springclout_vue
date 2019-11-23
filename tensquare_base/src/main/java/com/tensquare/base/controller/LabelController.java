package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BaseController
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/23 16:50
 * @Version：
 */
@RestController
@RequestMapping("/label")
// 跨域访问
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Result findAll(){
        List<Label> labels = labelService.findAll();
        int i=1/0;
        return new Result(true, StatusCode.OK, "查询成功", labels);
    }

    @GetMapping("/{labelId}")
    public Result findById(@PathVariable String labelId){
        Label label = labelService.findById(labelId);
        return new Result(true, StatusCode.OK, "查询成功", label);
    }

    @PostMapping
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @PutMapping("/{labelId}")
    public Result update(@PathVariable String labelId, @RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "新增成功");
    }

    @DeleteMapping("/{labelId}")
    public Result delete(@PathVariable String labelId){
        labelService.delete(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
