package com.example.database31.Core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/")
public class DataController {

    ReposImpl repos;

    public DataController(ReposImpl repos) {this.repos = repos;}

    @GetMapping("/products/fetch-product")
    public List<String> getProducte(@RequestParam("name") String name) {
        return repos.otvet(name);
    }
}