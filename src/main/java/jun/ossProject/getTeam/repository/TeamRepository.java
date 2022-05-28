package jun.ossProject.getTeam.repository;

import jun.ossProject.getTeam.entity.Team;
import jun.ossProject.getTeam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public List<Team> getTeam(String userId) throws SQLException {
        String sql = String.format("SELECT tl.team_id, team_name " +
                "FROM team_members as tm " +
                "JOIN team_list as tl " +
                "ON tm.team_id=tl.team_id " +
                "WHERE user_id='%s'", userId);

        con = getConnection();
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();

        List<Team> teamList = new ArrayList<>();
        while(rs.next()){
                String teamId = rs.getString("team_id");
                String teamName = rs.getString("team_name");

                Team team = new Team(teamId, teamName);
                teamList.add(team);
        }

        rs.close();
        pstmt.close();
        con.close();

        return teamList;
    }

    public List<User> getTeamMembers(String teamId) throws SQLException {
        String sql = String.format("SELECT user_id, nickname " +
                "FROM team_members as tm " +
                "JOIN user as u " +
                "ON tm.user_id = u.id " +
                "WHERE team_id = '%s'", teamId);

        con = getConnection();
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();

        List<User> userList = new ArrayList<>();
        while(rs.next()){
            String id = rs.getString("user_id");
            String nickname = rs.getString("nickname");
            User user = new User(id, nickname);
            userList.add(user);
        }

        rs.close();
        pstmt.close();
        con.close();

        return userList;
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

        pstmt.close();
        pstmt = con.prepareStatement(sqlUser);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    public void addUserToTeam(String userId, String teamId) throws SQLException {
        String sql = String.format("INSERT INTO team_members SET user_id='%s', team_id='%s'",
                userId, teamId);

        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    public void exitTeam(String teamId, String userId) throws SQLException {
        String sql = String.format("DELETE FROM team_members WHERE team_id='%s' AND user_id='%s'", teamId, userId);
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

}