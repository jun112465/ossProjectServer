package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.entity.Message;
import jun.ossProject.getTeam.entity.User;
import jun.ossProject.getTeam.repository.MessageRepository;
import jun.ossProject.getTeam.vo.IdVo;
import jun.ossProject.getTeam.vo.MessageVO;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    MessageRepository messageRepository;

    MessageController(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }


    @ResponseBody
    @GetMapping("/get")
    // 모든 메세지 가져오기
    public HashMap<String, List<Message>> getMessages(@RequestParam (value = "user_id") String user_id) throws SQLException {
        // 유저의 모든 메세지 가져오기
        List<Message> msgList = messageRepository.getMessage(user_id);
        HashMap<String, List<Message>> json = new HashMap<>();
        json.put("msgList", msgList);

        System.out.println(json);
        return json;
    }

    @ResponseBody
    @PostMapping("/send")
    // 메세지 전송
    public void sendMessage(@RequestBody Message msg) throws SQLException {
        System.out.println(msg);
        messageRepository.createMessage(msg);
    }

    // 메세지 삭제
    @PostMapping("/delete")
    @ResponseBody
    public void deleteMessage(@RequestBody IdVo vo) throws SQLException {
        System.out.println(vo.toString());
        messageRepository.deleteMessage(Integer.parseInt(vo.getId()));
    }
}
