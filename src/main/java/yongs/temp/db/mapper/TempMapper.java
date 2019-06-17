package yongs.temp.db.mapper;

import java.util.List;

import yongs.temp.db.vo.TempVo;

public interface TempMapper {
	public List<TempVo> getAll() throws Exception;
}