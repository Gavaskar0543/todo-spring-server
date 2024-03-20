package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name ="todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private boolean completed;

    public void setId(int id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String desc){
        this.description = desc;
    }
    public void setCompleted(boolean val){
        this.completed = val;
    }

    public int getId(){
        return  this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public boolean getCompleted(){
        return this.completed;
    }
}
