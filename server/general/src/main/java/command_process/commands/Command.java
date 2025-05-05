package command_process.commands;

import command_process.data.LabWork;

public interface Command{
    public String execute(String args, LabWork lab);
}
