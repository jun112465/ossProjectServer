package jun.ossProject.getTeam.repository;

import jun.ossProject.getTeam.vo.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    // 스케줄 추가
    public void addSchedule(ScheduleVO scheduleVO) throws SQLException {
        String teamId = scheduleVO.getTeamId();
        String userId = scheduleVO.getUserId();
        String content = scheduleVO.getContent();
        String date = scheduleVO.getDate();

        String sql = String.format("INSERT INTO calendar " +
                "team_id='%s', registrant_id='%s', content='%s', date='%s' ",
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
    }
}
