package com.example.database31.Core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class JavaConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    @ConditionalOnMissingBean
    public DataController postController(ReposImpl repos) {
        return new DataController(repos);
    }

    @Bean
    @ConditionalOnMissingBean
    public ReposImpl reposImpl() {
        return new ReposImpl(new NamedParameterJdbcTemplate(dataSource));
    }

}
