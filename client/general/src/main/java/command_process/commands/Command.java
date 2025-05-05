package command_process.commands;

import java.util.Scanner;


public interface Command{
    public void execute(String args, Scanner scan) throws IllegalArgumentException;
}

// @Override
// public void execute(Deque<LabWork> labWork, String args) throws Exception{
//     if (!args.isEmpty()) throw new Exception("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");
