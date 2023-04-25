package com.tianjiaxu.controller;

import com.tianjiaxu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id) {
        return restTemplate.getForEntity("http://localhost:8010/student/findById/{id}",Student.class,id).getBody();
    }

    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestBody Student student) {
        restTemplate.postForEntity("http://localhost:8010/student/saveOrUpdate",student,null).getBody();
    }

    @PostMapping("/saveOrUpdate2")
    public void saveOrUpdate2(@RequestBody Student student) {
        restTemplate.postForObject("http://localhost:8010/student/saveOrUpdate",student,null);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        restTemplate.delete("http://localhost:8010/student/deleteById/{id}",id);
    }
}
