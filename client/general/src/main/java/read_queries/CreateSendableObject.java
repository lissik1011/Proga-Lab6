package read_queries;

import java.io.File;
import java.io.Serializable;

import command_process.data.LabWork;

public class CreateSendableObject implements Serializable{
    String command;
    String args = "";
    LabWork labWork = null;
    File file = null;

    public CreateSendableObject(String command){
        this.command = command;
    }

    public CreateSendableObject(String command, String args){
        this.args = args;
        this.command = command;
    }

    public CreateSendableObject(String command, LabWork labWork){
        this.command = command;
        this.labWork = labWork;
    }

    public CreateSendableObject(String command, String args, LabWork labWork){
        this.command = command;
        this.args = args;
        this.labWork = labWork;
    }
    
    public CreateSendableObject(String command, File file){
        this.command = command;
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getCommand() {
        return command;
    }

    public String getArgs() {
        return args;
    }

    public LabWork getLabWork() {
        return labWork;
    }

}
