package yongs.temp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yongs.temp.db.vo.TempVo;
import yongs.temp.service.TempService;

@RestController
public class NonJspController {
    @Autowired
    TempService tempService;
    
    @RequestMapping("/query")
    public List<TempVo> query() throws Exception{
        return tempService.getAll();
    }
}