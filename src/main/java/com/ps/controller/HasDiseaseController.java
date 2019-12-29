package com.ps.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ps.core.Result;
import com.ps.core.ResultGenerator;
import com.ps.entity.HasDisease;
import com.ps.service.HasDiseaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by QY
 */
@RestController
@RequestMapping("/ps/hasDisease")
public class HasDiseaseController {
    @Resource
    private HasDiseaseService hasDiseaseService;

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        hasDiseaseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody HasDisease hasDisease) {
        hasDiseaseService.update(hasDisease);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        HasDisease hasDisease = hasDiseaseService.findById(id);
        return ResultGenerator.genSuccessResult(hasDisease);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<HasDisease> list = hasDiseaseService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
