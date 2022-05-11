package jun.ossProject.getTeam.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class UserRepository {
    DataSource dataSource;
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    @Autowired
    UserRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void insertUser(String id, String nickname) throws SQLException {
        String sql = String.format("INSERT INTO user set id='%s', nickname='%s'", id, nickname);
        con = dataSource.getConnection();
        pstmt = con.prepareStatement(sql);
        int rs = pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    public boolean isUserPresent(String id) throws SQLException {
        String sql = String.format("Select * from user where id='%s'", id);
        con = dataSource.getConnection();
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();

        rs.last();
        return rs.getRow() == 1;
    }
}
