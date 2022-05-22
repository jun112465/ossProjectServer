package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.Entity.Message;
import jun.ossProject.getTeam.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @ResponseBody
    @GetMapping("/get")
    // 모든 메세지 가져오기
    public List<Message> getMessages(){
        // user 가 receiver 인 모든 메세지 가져오기

        List<Message> msgList = new ArrayList<>();
        msgList.add(new Message(1, "inviteLink", "user1", "user2", "contentcontent", 1, "team1"));
        msgList.add(new Message(2, "message", "user2", "user4", "contentcontent", 2, "team2"));

        return msgList;
    }

    // 메세지 전송
    public void sendMessage(User sender, User receiver){

    }

    // 메세지 삭제
    public void deleteMessage(User user){

    }
}
