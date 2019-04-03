package com.abinc;

import com.abinc.data.Task;
import com.abinc.data.Tasks;
import com.abinc.helpers.TaskHelper;
import com.abinc.taskParser.JacksonXmlTaskParser;
import com.abinc.taskParser.TaskParser;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String path1 = "";
    static String path2 = "";
    static String sortBy = "";
    static String outputPath = "result.xml";


    public static void main(String[] args) {
        getInputParameters(args);

        TaskParser taskParser = new JacksonXmlTaskParser(new XmlMapper());

        List<Task> result = new ArrayList<>();
        try {
            result = TaskHelper.compare(taskParser.parse(path1), taskParser.parse(path2));
        } catch (IOException e) {
            System.out.println("Could not read and compare files: " + e);
            System.exit(0);
        }
        if (sortBy.startsWith("N"))
            TaskHelper.sortByName(result);
        else if (sortBy.startsWith("M"))
            TaskHelper.sortByMemory(result);

        try {
            taskParser.write(result, outputPath);
            System.out.println("Writing is finished to " + outputPath);
        } catch (IOException e) {
            System.out.println("Could not write result file: " + e);
        }
    }

    private static void getInputParameters(String[] args) {
        if (args.length >= 2) {
            path1 = args[0];
            path2 = args[1];

            if (args.length == 3)
                sortBy = args[2].toUpperCase();
        } else {
            while (path1.equals("")) {
                System.out.print("Enter path to the first file: ");
                Scanner scanner = new Scanner(System.in);
                path1 = scanner.nextLine();
            }

            while (path2.equals("")) {
                System.out.print("Enter path to the second file: ");
                Scanner scanner = new Scanner(System.in);
                path2 = scanner.nextLine();
            }

            if (sortBy.equals("")) {
                System.out.print("Select sort by name (N) or by Memory (M) if needed: ");
                Scanner scanner = new Scanner(System.in);
                sortBy = scanner.nextLine().toUpperCase();
            }
        }
    }
}
