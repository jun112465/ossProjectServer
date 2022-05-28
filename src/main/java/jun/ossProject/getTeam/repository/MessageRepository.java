package jun.ossProject.getTeam.repository;


import jun.ossProject.getTeam.entity.Message;
import jun.ossProject.getTeam.vo.MessageVO;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MessageRepository {
    DataSource dataSource;
    public MessageRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public Connection getConnection(){
        return DataSourceUtils.getConnection(dataSource);
    }

    // 메세지 받아오기
    public List<Message> getMessage(String userId) throws SQLException {
        String sql = String.format("SELECT * FROM message WHERE to_id='%s' ORDER BY id DESC", userId);
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<Message> msgList = new ArrayList<>();

        while(rs.next()){
            int id = Integer.parseInt(rs.getString("id"));
            String from_id = rs.getString("from_id");
            String content = rs.getString("content");
            String type = rs.getString("type");
            String team_id = rs.getString("team_id");
            String teamName = rs.getString("team_name");

            Message message = new Message(id, type, from_id, userId, content, team_id, teamName);
            msgList.add(message);
        }

        rs.close();
        pstmt.close();
        con.close();

        return msgList;
    }

    // 메세지 생성
    public void createMessage(Message msg) throws SQLException {

        System.out.println(msg.toString());

        String from_id = msg.getFrom();
        String to_id = msg.getTo();
        String content = msg.getContent();
        String type = msg.getType();

        String sql = String.format("INSERT INTO message SET " +
                        "from_id='%s', " +
                        "to_id='%s', " +
                        "content='%s', " +
                        "type='%s', " +
                        "team_id='%s', " +
                        "team_name='%s'"
                , from_id, to_id, content, type, msg.getTeamId(), msg.getTeamName());

        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    // 메세지 삭제
    public void deleteMessage(int messageId) throws SQLException {
        String sql = String.format("DELETE FROM message WHERE id=%d", messageId);

        con = dataSource.getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.executeQuery();

        pstmt.close();
        con.close();
    }
}
