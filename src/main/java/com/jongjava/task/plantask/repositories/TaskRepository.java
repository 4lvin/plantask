package com.jongjava.task.plantask.repositories;

import com.jongjava.task.plantask.models.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task,String> {
    Task findBy_id(ObjectId _id);
}
