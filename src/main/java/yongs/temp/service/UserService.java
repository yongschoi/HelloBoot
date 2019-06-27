package yongs.temp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.common.SecurityUtil;
import yongs.temp.db.mapper.UserMapper;
import yongs.temp.db.mapper.UserRoleMapper;
import yongs.temp.db.vo.User;

@Service("userService")
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;
    
    public User findUser(String username) throws Exception {
    	User user = userMapper.findUser(username);    	
    	user.setUserRoles(userRoleMapper.findRoles(user));
   	
    	return user;
    }
    
	public void createUser(User user) throws Exception {
		userMapper.createUser(user);
		// 최초 Role은 USER
		userRoleMapper.insertRole(user.getUsername(), "USER");
	}
}
