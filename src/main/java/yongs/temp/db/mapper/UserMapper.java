package yongs.temp.db.mapper;

import yongs.temp.db.vo.User;

public interface UserMapper {
	public User findUser(String username) throws Exception;
	public void createUser(User user) throws Exception;
}