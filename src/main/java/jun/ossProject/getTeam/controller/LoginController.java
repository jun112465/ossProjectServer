package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.Entity.User;
import jun.ossProject.getTeam.Repository.UserRepository;
import jun.ossProject.getTeam.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class LoginController {

    UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository, LoginService loginService) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @PostMapping({"/kakao"})
    public User userAdd(@RequestBody  User user) throws SQLException {
        // 회원이 아닌 경우 DB에 회원정보 추가
        if(userRepository.selectUser(user.getId())==0)
            userRepository.insertUser(user.getId(), user.getNickname());
        return user;
    }
}
