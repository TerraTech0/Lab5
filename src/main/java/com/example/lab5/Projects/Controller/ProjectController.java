package com.example.lab5.Projects.Controller;

import com.example.lab5.Projects.Api.ApiResponse;
import com.example.lab5.Projects.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v2/project")
public class ProjectController {

    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/show-projects")
    public ArrayList<Project> showProjects(){
        return projects;
    }


    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project proj){
        projects.add(proj);
        return new ApiResponse("project added successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project proj){
        projects.set(index, proj);
        return new ApiResponse("Project updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index){
        projects.remove(index);
        return new ApiResponse("Porjcet deleted succssfully");
    }

    //change status
    @PostMapping("/change-status/{id}")
    public ApiResponse changeStatus(@PathVariable String id){
        for (Project project : projects){
            if (project.getID().equals(id)){
                project.setStatus(!project.isStatus());
                return new ApiResponse("Status Changed");
            }
        }
        return new ApiResponse("Porject not found!");
    }

    //search for title
    @GetMapping("/search/{title}")
    public ArrayList<Project> search(@PathVariable String title){
        ArrayList<Project> res = new ArrayList<>();
        for (Project project : projects){
            if (project.getTitle().equalsIgnoreCase(title)){
                res.add(project);
            }
        }
        return res;
    }

    //display all project for one company by companyName.
    @GetMapping("/projects/{companyName}")
    public ArrayList<Project> company(@PathVariable String companyName){
        ArrayList<Project> proj = new ArrayList<>();
        for (Project project : projects){
            if (project.getCompanyName().equalsIgnoreCase(companyName)){
                proj.add(project);
            }
        }
        return proj;
    }

}
