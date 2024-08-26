package lern.spring.users.configuration;

import lern.spring.users.repository.UserRepository;
import lern.spring.users.repository.UserRepositoryImp;
import lern.spring.users.repository.UserRepositoryJDBCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${repository.type}")
    private String repositoryType;

    private final ApplicationContext applicationContext;

    public AppConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
@Bean
    UserRepository getRepository(){
        if("list".equalsIgnoreCase(repositoryType)){
         return applicationContext.getBean(UserRepositoryImp.class);

        }else{
          return applicationContext.getBean(UserRepositoryJDBCImpl.class);
        }

    }

}
