package com.abinc.helpers;

import com.abinc.data.Task;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskHelper {
    public static List<Task> compare(List<Task> tasks1, List<Task> tasks2) {
        final Map<String, Integer> result = tasks1.stream().collect(Collectors.toMap(Task::getName, Task::getMemory));
        tasks2.stream().forEach(t ->
                result.put(t.getName(),
                        result.containsKey(t.getName())
                                ? result.get(t.getName()) + t.getMemory()
                                : t.getMemory()
                )
        );

        return result.entrySet().stream().map(t -> new Task(t.getKey(), t.getValue())).collect(Collectors.toList());
    }

    public static void sortByName(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getName));
    }

    public static void sortByMemory(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getMemory));
    }
}
