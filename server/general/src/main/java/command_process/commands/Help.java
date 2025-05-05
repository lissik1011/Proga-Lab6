package command_process.commands;

import command_process.data.LabWork;

// Вывести справку по доступным командам.
public class Help implements Command{
    @Override
    public String execute(String args, LabWork labWork) {
        String answer = "";

        answer += "add {element} - ";
        answer += "Добавить новый элемент в коллекцию.\n";

        answer += "clear - ";
        answer += "Очистить коллекцию.\n";

        answer += "execute_script {file_name} - ";
        answer += "Считать и исполнить скрипт из указанного файла.\n";
    
        answer += "exit - ";
        answer += "Завершить программу (с сохранением в файл).\n";

        answer += "filter_contains_name {name} - ";
        answer += "Вывести элементы, значение поля name которых содержит заданную подстроку.\n";
        
        answer += "group_counting_by_author - ";
        answer += "Сгруппировать элементы коллекции по значению поля author, вывести количество элементов в каждой группе.\n";

        answer += "head - ";
        answer += "Вывести первый элемент коллекции.\n";

        answer += "help - ";
        answer += "Вывести справку по доступным командам.\n";

        answer += "history - ";
        answer += "Вывести последние 12 команд (без их аргументов).\n";

        answer += "info - ";
        answer += "Вывести информацию о коллекции.\n";

        answer += "print_ascending - ";
        answer += "Вывести элементы коллекции в порядке возрастания.\n";

        answer += "remove_by_id {id} - ";
        answer += "Удалить элемент из коллекции по его id.\n";

        answer += "remove_greater_by_id {id} - ";
        answer += "Удалить из коллекции все элементы, превышающие заданный.\n";

        answer += "show - ";
        answer += "Вывести все элементы коллекции в строковом представлении.\n";

        answer += "update_by_id {id} - ";
        answer += "Обновить значение элемента коллекции, id которого равен заданному.\n";

        return answer;
    }
}