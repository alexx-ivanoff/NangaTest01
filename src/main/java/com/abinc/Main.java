package com.abinc;

import com.abinc.data.TaskComparator;

public class Main {
    public static void main(String[] args) {

        String testData1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><tasks><task><name>svchost.exe</name><memory>3455</memory></task><task><name>chrome.exe</name><memory>1984</memory></task></tasks>\n";
        String testData2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><tasks><task><name>svchost.exe</name><memory>3455</memory></task><task><name>opera.exe</name><memory>2001</memory></task></tasks>\n";

        XmlHelper xmlHelper = new XmlHelper();
        TaskComparator taskComparator = new TaskComparator();
        taskComparator.compare(xmlHelper.readData(testData1), xmlHelper.readData(testData2));
    }
}
