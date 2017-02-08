package com.jobll.web.user;
 
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
 
import com.jobll.web.user.User;
 
@Mapper
public interface UserMapper {
     public User readUser(String username);
     public List<String> readAuthority(String username);
}

