package jun.ossProject.getTeam.Service;

import jun.ossProject.getTeam.Entity.User;
import jun.ossProject.getTeam.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoginService {
    UserRepository userRepository;

    @Autowired
    LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User addUser(User user) throws SQLException {
        // 회원가입 되있지 경우 추가 x
        if(!userRepository.isUserPresent(user.getId()))
            userRepository.insertUser(user.getId(), user.getNickname());
        return user;
    }
}
