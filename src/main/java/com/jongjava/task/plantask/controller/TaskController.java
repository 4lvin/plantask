package com.jongjava.task.plantask.controller;

import com.jongjava.task.plantask.dto.TaskDto;
import com.jongjava.task.plantask.models.Task;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jongjava.task.plantask.repositories.TaskRepository;
import org.springframework.hateoas.ResourceAssembler;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository repository;

//    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = {"application/json"})
//    public ResponseEntity getAllTasks(){
//        List<Task> tasks= repository.findAll();
//        Map<String, Object> data = new HashMap<>();
//        if (tasks.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        data.put("tasks", tasks);
//        return new ResponseEntity<>(data, HttpStatus.OK);
//    }
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity getAllTasks2(){
        List<Task> tasks= repository.findAll();
        if (tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
       TaskDto taskDto = new TaskDto();
        taskDto.setTasks(tasks);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getPetById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyTaskById(@PathVariable("id") ObjectId id, @Valid @RequestBody Task tasks) {
        tasks.set_id(id);
        repository.save(tasks);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Task createPet(@Valid @RequestBody Task tasks) {
        tasks.set_id(ObjectId.get());
        repository.save(tasks);
        return tasks;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

}
