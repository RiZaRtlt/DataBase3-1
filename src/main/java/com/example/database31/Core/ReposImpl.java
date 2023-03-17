package com.example.database31.Core;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Repository
public class ReposImpl implements Repos {

    private String request;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReposImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {this.request = read("Reqest.sql");
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;}

    public List<String> otvet(String name) {
        return namedParameterJdbcTemplate.queryForList(request, new MapSqlParameterSource("name", name), String.class);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
