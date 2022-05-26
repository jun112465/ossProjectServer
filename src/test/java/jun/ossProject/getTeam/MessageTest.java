package jun.ossProject.getTeam;

import jun.ossProject.getTeam.repository.MessageRepository;
import jun.ossProject.getTeam.vo.MessageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class MessageTest {
//    @Autowired DataSource dataSource;
    @Autowired MessageRepository mr;
    @Test
    public void createMessage() throws SQLException {

        MessageVO mv = new MessageVO();
        mv.setContent("content ");
        mv.setFromId("1234");
        mv.setToId(("1414"));
        mr.createMessage(mv);
    }
}
