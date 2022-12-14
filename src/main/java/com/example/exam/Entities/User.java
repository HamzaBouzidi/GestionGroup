package com.example.exam.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String pwd;
    private String fName;
    private String lName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Project> projects;

    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Project> projectList;
}
