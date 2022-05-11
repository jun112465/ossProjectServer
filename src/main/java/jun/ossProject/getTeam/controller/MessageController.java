package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.Entity.User;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    // 모든 메세지 가져오기
    public void getMessages(User user){
        // user 가 receiver 인 모든 메세지 가져오기
    }

    // 메세지 전송
    public void sendMessage(User sender, User receiver){

    }

    // 메세지 삭제
    public void deleteMessage(User user){

    }
}
