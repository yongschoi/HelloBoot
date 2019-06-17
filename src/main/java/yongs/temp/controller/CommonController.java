package yongs.temp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yongs.temp.db.service.TempService;
import yongs.temp.db.vo.TempVo;

@RestController
public class CommonController {
    @Autowired
    TempService tempService;

    @RequestMapping("/")
    public String root_test() throws Exception{
        return "Hello Root(/)";
    }
    
    @RequestMapping("/query")
    public List<TempVo> query() throws Exception{
        return tempService.getAll();
    }
}