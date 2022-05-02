package jun.ossProject.getTeam.beanTest;

import jun.ossProject.getTeam.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class GetBeans {

    @Test
    @DisplayName("모든 빈 얻어오기")
    public void getBeans(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        for(String s : ac.getBeanDefinitionNames())
            System.out.println(s);
    }
}
