package com.example.exam.Repositories;

import com.example.exam.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

//    void assignProjectToUser(Integer projectId , Integer userId);


    void assignProjectToClient(Integer projectId, String firstName , String lastName);



}
