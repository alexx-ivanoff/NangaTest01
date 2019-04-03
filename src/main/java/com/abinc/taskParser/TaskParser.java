package com.abinc.taskParser;

import com.abinc.data.Task;

import java.io.IOException;
import java.util.List;


public interface TaskParser {
    public List<Task> parse(String path) throws IOException;

    public void write(List<Task> tasks, String path) throws IOException;
}
