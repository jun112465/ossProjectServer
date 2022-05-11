package jun.ossProject.getTeam.Repository;


import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class MessageRepository {
    DataSource dataSource;
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    // 메세지 생성
    public int createMessage(String senderId, String receiverId, String content){
        // DB에 메세지 2개를 추가하는 것이다.

        // sender 추가
        //// INSERT INTO message SET  userId=senderId, sender=senderId, receiver=receiverId


        // receiver 추가
        //// INSERT INTO message SET  userId=receiverId, sender=senderId, receiver=receiverId

        //메세지 id 반환
        return 0;
    }

    // 메세지 삭제
    public void deleteMessage(String messageId){

    }

}
