package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.entity.Message;
import jun.ossProject.getTeam.entity.User;
import jun.ossProject.getTeam.vo.MessageVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @ResponseBody
    @GetMapping("/get")
    // 모든 메세지 가져오기
    public HashMap<String, List<Message>> getMessages(@RequestParam (value = "user_id") String user_id){
        // user 가 receiver 인 모든 메세지 가져오기
        List<Message> msgList = new ArrayList<>();
        msgList.add(new Message(1, "inviteLink", "user1", "user2", "contentcontent", 1, "team1"));
        msgList.add(new Message(2, "message", "user2", "user4", "contentcontent", 2, "team2"));

        HashMap<String, List<Message>> json = new HashMap<>();
        json.put("msgList", msgList);
        return json;
    }

    @ResponseBody
    @PostMapping("/add")
    // 메세지 전송
    public void sendMessage(@RequestBody MessageVO msgVo){

    }

    // 메세지 삭제
    public void deleteMessage(User user){

    }
}
