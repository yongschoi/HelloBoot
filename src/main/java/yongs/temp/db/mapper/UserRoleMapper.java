package yongs.temp.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yongs.temp.db.vo.User;

public interface UserRoleMapper {
	public List<String> findRoles(User user) throws Exception;
	public void deleteRoles(String username) throws Exception;
	public void insertRole(@Param("username") String username, @Param("role") String role) throws Exception;
}