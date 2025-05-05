package command_process.commands;

import java.util.Scanner;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;
import connection.UDPClient;
import read_queries.CreateSendableObject;
import read_queries.MakeRequest;
import read_queries.MakeResponse;

// Удалить элемент из коллекции по его id.
public class RemoveById implements Command{
    @Override
    public void execute(String args, Scanner scan) throws IllegalArgumentException{
        if (args.isEmpty()) throw new IllegalArgumentException("Введите id работы, которую хотите удалить.");
        

        String answFirst = MakeResponse.answer(UDPClient.sendAndReceive(MakeRequest.request(new CreateSendableObject("find_id", args))));
        if (answFirst.isEmpty()) {
            LabWork labwork = new CollectionManager().getLabWork(scan);
            String answ = MakeResponse.answer(UDPClient.sendAndReceive(MakeRequest.request(new CreateSendableObject("remove_by_id", args, labwork))));
            if (!answ.isEmpty()) {
                System.out.println(answ);
            } else {
                System.out.println("Ошибка соединения с сервером.");
            }
        } else {
            System.out.println(answFirst);
        }
    }
}
