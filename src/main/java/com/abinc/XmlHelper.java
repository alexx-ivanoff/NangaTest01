package com.abinc;

import com.abinc.data.Task;
import com.fasterxml.jackson.xml.XmlMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlHelper {
    public List<Task> readData(String xmlData)  {
        XmlMapper xmlMapper = new XmlMapper();
        List<Task> tasks = new ArrayList<Task>();
        try {
            tasks = Arrays.asList(xmlMapper.readValue(xmlData, Task[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tasks;
    }
}
