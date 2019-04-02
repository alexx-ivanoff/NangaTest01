package com.abinc.data;

public class Task
{
    private int memory;

    private String name;

    public Task()    {
    }

    public Task(String name, int memory)    {
        this.name = name;
        this.memory = memory;
    }

    public int getMemory ()
    {
        return memory;
    }

    public void setMemory (int memory)
    {
        this.memory = memory;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Task [memory = "+memory+", name = "+name+"]";
    }
}