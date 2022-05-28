package jun.ossProject.getTeam.repository;

import jun.ossProject.getTeam.entity.Schedule;
import jun.ossProject.getTeam.vo.ScheduleVO;
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

@Repository
public class ScheduleRepository {
    DataSource dataSource;
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    @Autowired
    ScheduleRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Connection getConnection(){
        return DataSourceUtils.getConnection(dataSource);
    }

    // 스케줄 get
    public List<Schedule> getSchedule(String teamId) throws SQLException {
        String sql = String.format("SELECT * FROM calendar WHERE team_id='%s'", teamId);
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();

        List<Schedule> scheduleList = new ArrayList<>();
        while(rs.next()){
            int id = Integer.parseInt(rs.getString("id"));
            String registrant = rs.getString("registrant_id");
            String date = rs.getString("date");
            String content = rs.getString("content");

            Schedule schedule = new Schedule(id, teamId, registrant, content, date);
            scheduleList.add(schedule);
        }

        rs.close();
        pstmt.close();
        con.close();

        return scheduleList;
    }


    // 스케줄 추가
    public void addSchedule(ScheduleVO scheduleVO) throws SQLException {
        String teamId = scheduleVO.getTeamId();
        String userId = scheduleVO.getUserId();
        String content = scheduleVO.getContent();
        String date = scheduleVO.getDate();

        String sql = String.format("INSERT INTO calendar " +
                "SET team_id='%s', registrant_id='%s', content='%s', date='%s' ",
                teamId, userId, content, date);

        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }


    // 스케줄 삭제
    public void deleteSchedule(int scheduleId) throws SQLException {
        String sql = String.format("DELETE FROM calendar where id=%d", scheduleId);
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }
}
