package jun.ossProject.getTeam;

import jun.ossProject.getTeam.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootTest
public class UserTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    UserRepository userRepository;

    @Test
    public void Connection() throws SQLException {
        String sql = String.format("INSERT INTO user set id='%s', nickname='%s'", "testId", "testNickName");
        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();
    }

    @Test
    public void assign() throws SQLException {
        userRepository.insertUser("testId", "testNickName");
    }

    @Test
    public void find() throws SQLException{
        userRepository.selectUser("testId");
    }
}
