package jun.ossProject.getTeam.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class UserRepository {
    DataSource dataSource;

    @Autowired
    UserRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public int insertUser(String id, String nickname) throws SQLException {
        String sql = String.format("INSERT INTO user set id='%s', nickname='%s'", id, nickname);
        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        int rs = pstmt.executeUpdate();

        pstmt.close();
        con.close();
        return rs;
    }

    public int selectUser(String id) throws SQLException {
        String sql = String.format("Select * from user where id='%s'", id);
        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        rs.last();
        System.out.println(rs.getRow());
        return rs.getRow();

//        rs.next();
//        if(rs.getString("id")!=null){
//            rs.close();
//            pstmt.close();
//            con.close();
//            return true;
//        }else{
//            rs.close();
//            pstmt.close();
//            con.close();
//            return false;
//        }
    }
}
