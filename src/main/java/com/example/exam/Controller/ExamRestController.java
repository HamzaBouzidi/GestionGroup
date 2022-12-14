package com.example.exam.Controller;


import com.example.exam.Entities.Project;
import com.example.exam.Entities.User;
import com.example.exam.Repositories.ProjectRepository;
import com.example.exam.Repositories.SprintRepository;
import com.example.exam.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest")
public class ExamRestController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    SprintRepository sprintRepository;

    @Autowired
    UserRepository userRepository;


    //http://localhost:9090/rest/add-User
    @PostMapping("/add-User")
    public User addUser(@RequestBody User entity) {
        return	userRepository.save(entity);
    }



    //http://localhost:9090/rest/add-Project
    @PostMapping("/add-Project")
    public Project addProject(@RequestBody Project entity) {
        return	projectRepository.save(entity);
    }



    @PutMapping("/{projectId}/{userId}")
    public void assignProjectToUser(@PathVariable Integer projectId , @PathVariable Integer userId){

        User user =userRepository.findById(userId).orElse(null);
        Project project =projectRepository.findById(projectId).orElse(null);

        user.setProjects((List<Project>) project);
        userRepository.save(user);

    }


    @PutMapping("/{projectId}/{firstName}/{lastName}")
    public void assignProjectToClient(@PathVariable Integer projectId
            , @PathVariable String firstName, @PathVariable String lastName){
        Project project= projectRepository.findById(projectId).orElse(null);
        List<User> users = userRepository.findAll();

        for(User user: users){
            if(user.getFName().equals(firstName) && user.getFName().equals(lastName)){

            }
        }

       // project.setUsers(User,lastName);

    }


    @GetMapping()
    public List<Project> getAllCurrentProject() {
        List<Project> currentProjects =projectRepository.findAll();
        for( Project p : currentProjects){
            if (p.getSprints().getClass().)
        }
    }






    @Scheduled(fixedRate = 30000)
    public List<Project> getNbrSprintByCurrentProject(){


    }














}
