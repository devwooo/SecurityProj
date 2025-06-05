package com.made.securityproj.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@EnableTransactionManagement  // 이 어노테이션이 있어야 Transaction 기능이 동작을 한다 > 트랜잭션을 활성화 시키는 어노테이션
@MapperScan(basePackages = {"com.made.securityproj.model.dao"}, sqlSessionFactoryRef = "SqlSessionFactory", sqlSessionTemplateRef = "SessionTemplate")
public class MybatisConfig {
    /**
     *  기본적으로 application-db.yml 을 읽어서 Spring-boot가 Bean 생성을 해주지만
     *  사용자가 직접 Bean 생성을 할경웨 Spring-boot는 Bean 생성을 하지 않는다.
     * */
    /*
    @Value("${spring.datasource.jndi-name}")
    private String jndiName;
    */
    @Value("${mybatis.config-location}")
    private String configLocation;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Bean(name = "dataSource")
    @Profile("local")
    @ConfigurationProperties(prefix = "spring.datasource") // application.yml의 spring.datasource.* 값을 기준으로 DB 연결 생성
    public DataSource DataSource() {
        return DataSourceBuilder.create().build();
    }

    /*
    @Bean(name = "dataSource")
    @Profile("!local")
    public DataSource jndiDataSource() {
        return new JndiDataSourceLookup().getDataSource(jndiName);
    }
    */

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("dataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResources(configLocation)[0]);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mapperLocations));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "SessionTemplate")
    public SqlSessionTemplate SqlSessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}