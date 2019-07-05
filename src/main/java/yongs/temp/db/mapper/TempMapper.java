package yongs.temp.db.mapper;

import java.util.List;

import yongs.temp.db.vo.TempVo;

public interface TempMapper {
	public List<TempVo> getAll() throws Exception;
	public TempVo getId(int id) throws Exception;
	public void insert(TempVo tempVo) throws Exception;
	public int delete(int id) throws Exception;
}