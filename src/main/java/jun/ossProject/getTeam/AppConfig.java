package jun.ossProject.getTeam;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class AppConfig {

    public AppConfig(DataSource dataSource){
    }
}
