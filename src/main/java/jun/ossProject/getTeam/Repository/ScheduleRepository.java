package jun.ossProject.getTeam.Repository;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class ScheduleRepository {
    DataSource dataSource;
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    // 스케줄 추가


    // 스케줄 삭제
}
