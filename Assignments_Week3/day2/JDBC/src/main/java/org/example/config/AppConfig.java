package org.example.config;
//
//import org.example.dao.BookDao;
//import org.example.dao.BookDaoImp;
//import org.example.service.BookService;
//import org.example.service.BookServiceImp;
//import org.example.service.MethodLogger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
////@Configuration
////public class AppConfig {
////
////    @Bean
////    public BookDao bookDao() {
////        return new BookDaoImp();
////    }
////
////    @Bean
////    public BookService bookService() {
////        BookServiceImp bookService = new BookServiceImp();
////        bookService.setDao(bookDao());
////        return bookService;
////    }
////}
//
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.ComponentScan;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//@Configuration
//@EnableAspectJAutoProxy
//@ComponentScan(basePackages = "org.example")
//public class AppConfig {
//
//    @Bean
//    public BookDao bookDao() {
//        return new BookDaoImp();
//    }
//
//    @Bean
//    public BookService bookService() {
//        BookServiceImp bookService = new BookServiceImp();
//        bookService.setDao(bookDao());
//        return bookService;
//    }
//
//    @Bean
//    public MethodLogger methodLogger() {
//        return new MethodLogger();
//    }
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.example")
@EnableTransactionManagement
@PropertySource("classpath:dbconn.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DriverManagerDataSource getDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("jdbc.drivername")));
        dataSource.setUrl(environment.getProperty("jdbc.url"));

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager getdataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}