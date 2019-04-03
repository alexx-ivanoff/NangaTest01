package com.abinc.taskParser;

import com.abinc.data.Task;
import com.abinc.data.Tasks;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JacksonXmlTaskParser implements TaskParser {

    XmlMapper xmlMapper;

    public JacksonXmlTaskParser(XmlMapper xmlMapper)   {
        this.xmlMapper = xmlMapper;
    }

    @Override
    public List<Task> parse(String path) throws IOException {
        String xmlData = new String(Files.readAllBytes(Paths.get(path)));

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setDefaultUseWrapper(false);
        List<Task> tasks = new ArrayList<>();
        try {
            tasks = Arrays.asList(xmlMapper.readValue(xmlData, Task[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    @Override
    public void write(List<Task> tasks, String path) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File outputFile = new File(path);
        xmlMapper.writeValue(outputFile, new Tasks(tasks));
    }
}
