package com.example.lab5.Students.Controller;


import com.example.lab5.Students.Api.ApiResponse;
import com.example.lab5.Students.Model.Students;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    ArrayList<Students> students = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Students> studentNames(){
        return students;
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Students student){
        students.add(student);
        return new ApiResponse("Student added successfully");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateStudnet(@PathVariable int index, @RequestBody Students student){
        students.set(index, student);
        return new ApiResponse("updated successfuly");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("student successfully deleted");
    }
    //CRUD created successfully.!


    //get only the name
    @GetMapping("/name/{index}")
    public String getName(@PathVariable int index){
        return students.get(index).getName();
    }

    //get only the age
    @GetMapping("/age/{index}")
    public int getAge(@PathVariable int index){
        return students.get(index).getAge();
    }
    //only get the degree
    @GetMapping("/degree/{index}")
    public String getDegree(@PathVariable int index){
        return students.get(index).getDegree();
    }

    //get only the status
    @GetMapping("/status/{index}")
    public boolean getStatus(@PathVariable int index){
        return students.get(index).isStatus();
    }
}
