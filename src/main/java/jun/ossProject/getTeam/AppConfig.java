package jun.ossProject.getTeam;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@ComponentScan
public class AppConfig {
    DataSource dataSource;

    public AppConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
}
