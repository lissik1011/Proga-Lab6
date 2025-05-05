package command_process.commands;

import java.util.Scanner;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;
import connection.UDPClient;
import read_queries.CreateSendableObject;
import read_queries.MakeRequest;
import read_queries.MakeResponse;

// Удалить из коллекции все элементы, превышающие заданный.
public class RemoveGreaterById implements Command{
    @Override
    public void execute(String args, Scanner scan) throws IllegalArgumentException{
        if (args.isEmpty()) throw new IllegalArgumentException("Введите id.");

        String answFirst = MakeResponse.answer(UDPClient.sendAndReceive(MakeRequest.request(new CreateSendableObject("find_id", args))));
        if (answFirst.isEmpty()) {
            LabWork labwork = new CollectionManager().getLabWork(scan);

            String answ = MakeResponse.answer(UDPClient.sendAndReceive(MakeRequest.request(new CreateSendableObject("remove_greater_by_id", args, labwork))));
            if (!answ.isEmpty()) {
                System.out.println(answ);
            } else {
                System.out.println("Не удается подключиться к серверу.");
            }
        } else {
            System.out.println(answFirst);
        }
    }
}
