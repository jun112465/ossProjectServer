package jun.ossProject.getTeam.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Repository
public class TeamRepository {
    DataSource dataSource;
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    @Autowired
    TeamRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Connection getConnection(){
        return DataSourceUtils.getConnection(dataSource);
    }

    public void createTeam(String userId, String teamName) throws SQLException {
        String teamId = UUID.randomUUID().toString();
        String sqlTeam = String.format("Insert into team_list set team_id='%s', team_name='%s'",
                teamId, teamName);
        String sqlUser = String.format("Insert into team_members set user_id='%s', team_id='%s'",
                userId, teamId);

        con = getConnection();
        pstmt = con.prepareStatement(sqlTeam);
        pstmt.executeUpdate();

        pstmt = con.prepareStatement(sqlUser);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    public void addUserToTeam(String userId, String teamId) throws SQLException {
        String sql = String.format("Insert into team_members set user_id='%s', team_id='%s'",
                userId, teamId);

        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();
    }
}
