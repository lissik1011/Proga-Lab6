package command_process.commands;

import java.util.Scanner;

import connection.UDPClient;
import read_queries.CreateSendableObject;
import read_queries.MakeRequest;
import read_queries.MakeResponse;

// Вывести элементы, значение поля name которых содержит заданную подстроку.
public class FilterConteinsName implements Command{
    @Override
    public void execute(String args, Scanner scan) throws IllegalArgumentException{
        if (args.isEmpty()) throw new IllegalArgumentException("Введите подстроку.");

        String answ = MakeResponse.answer(UDPClient.sendAndReceive(MakeRequest.request(new CreateSendableObject("filter_contains_name"))));
        if (!answ.isEmpty()) {
            System.out.println(answ);
        } else {
            System.out.println("Не удается подключиться к серверу.");
        }
    }
}
