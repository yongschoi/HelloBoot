package yongs.temp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yongs.temp.db.vo.TempVo;
import yongs.temp.service.TempService;

@RestController
@RequestMapping("/yongs-api/v1")
public class NonJspController {
    private static final Logger logger = LoggerFactory.getLogger(NonJspController.class);	

    @Autowired
    TempService tempService;
    
    @GetMapping("/temp")
    public List<TempVo> query() throws Exception{
        return tempService.getAll();
    }
    
    @GetMapping("/temp/{id}")
    public TempVo queryId(@PathVariable("id") int id) throws Exception{
        return tempService.getId(id);
    }
    
    @PostMapping("/temp")
    public void insertTemp(@RequestBody TempVo tempVo) throws Exception{
    	logger.debug("|" + tempVo + "|");
    	
    	tempService.insert(tempVo);
    }
    
    @DeleteMapping("/temp/{id}")
    public void deleteId(@PathVariable("id") int id) throws Exception{
        tempService.delete(id);
    }
}