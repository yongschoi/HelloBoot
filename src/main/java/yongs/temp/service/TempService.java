package yongs.temp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.db.mapper.TempMapper;
import yongs.temp.db.vo.TempVo;

@Service
public class TempService {
    private static final Logger logger = LoggerFactory.getLogger(TempService.class);	

    @Autowired
    TempMapper tempMapper;
    
    public List<TempVo> getAll() throws Exception {
        return tempMapper.getAll();
    }
    
    public TempVo getId(int id) throws Exception {
        return tempMapper.getId(id);
    }
    
    public void insert(TempVo tempVo) throws Exception {
        tempMapper.insert(tempVo);
        logger.debug("ID ::: " + new Integer(tempVo.getId()).toString());
    }
    
    public void delete(int id) throws Exception {
        int deletedId = tempMapper.delete(id);
        logger.debug("삭제건수 ::: " + new Integer(deletedId).toString());
    }
}