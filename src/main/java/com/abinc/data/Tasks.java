package com.abinc.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;


@JacksonXmlRootElement(localName = "tasks")
public class Tasks {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Task> task;

    public Tasks()  {

    }

    public Tasks(List<Task> tasks)   {
        this.task = tasks;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }


}