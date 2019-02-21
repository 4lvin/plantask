package com.jongjava.task.plantask.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Task {

    @Id
    public ObjectId _id;

    public String duedate;
    public String email;
    public String note;
    public String title;
    public String level;

    public Task() {}

    public Task(ObjectId _id, String duedate, String email, String note, String title, String level) {
        this._id = _id;
        this.duedate = duedate;
        this.email = email;
        this.note = note;
        this.title = title;
        this.level = level;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
