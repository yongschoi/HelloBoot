package yongs.temp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.db.mapper.TempMapper;
import yongs.temp.db.vo.TempVo;

@Service
public class TempService {
    @Autowired
    TempMapper tempMapper;
    
    public List<TempVo> getAll() throws Exception {
        return tempMapper.getAll();
    }
}