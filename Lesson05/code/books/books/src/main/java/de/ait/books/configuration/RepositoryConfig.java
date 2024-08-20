package de.ait.books.configuration;

import de.ait.books.repository.BookRepository;
import de.ait.books.repository.BookRepositoryJDBCImpl;
import de.ait.books.repository.BookRepositoryListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Value("${repository.type}")
    private String repositoryType;

    private final ApplicationContext applicationContext;

    @Autowired
    public RepositoryConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public BookRepository bookRepository(){
        if("db".equalsIgnoreCase(repositoryType)){
            return applicationContext.getBean(BookRepositoryJDBCImpl.class);
        }else{
            return applicationContext.getBean(BookRepositoryListImpl.class);
        }
    }

}
