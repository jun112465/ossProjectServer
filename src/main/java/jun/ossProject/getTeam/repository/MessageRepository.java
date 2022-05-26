package jun.ossProject.getTeam.repository;


import jun.ossProject.getTeam.vo.MessageVO;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class MessageRepository {
    DataSource dataSource;
    MessageRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public Connection getConnection(){
        return DataSourceUtils.getConnection(dataSource);
    }

    // 메세지 생성
    public void createMessage(MessageVO msgVO) throws SQLException {
        String from_id = msgVO.getFromId();
        String to_id = msgVO.getToId();
        String content = msgVO.getContent();

        // DB에 메세지 2개를 추가하는 것이다.
        String sql = String.format("INSERT INTO message set from_id=%s, to_id=%s, content=%s", from_id, to_id, content);

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
