package command_process.collection_manager;

import java.util.Scanner;

import command_process.data.Coordinates;
import command_process.data.Difficulty;
import command_process.data.LabWork;
import command_process.data.Location;
import command_process.data.Person;
import command_process.get.ALocName;
import command_process.get.ALocationX;
import command_process.get.ALocationY;
import command_process.get.AuthorName;
import command_process.get.AuthorPassportId;
import command_process.get.AuthorWeight;
import command_process.get.CoordinatesX;
import command_process.get.CoordinatesY;
import command_process.get.DifficultyName;
import command_process.get.MinimalPoint;
import command_process.get.Name;

public class CollectionManager{
    // public LabWork makeLabWork(String name, String coordinatesX, String coordinatesY, String minimalPoint, String difficulty, String authorName, String authorWeight, String authorPassportId, String authorLocationX, String authorLocationY, String authorLocationName) {
    //     LabWork lad = null;
    //     return lad;
    // }

    public LabWork getLabWork(Scanner scan){
        String name = Name.getName(scan);
        int coordinatesX = CoordinatesX.getCoordX(scan);
        float coordinatesY = CoordinatesY.getCoordY(scan);
        int minimalPoint = MinimalPoint.getMinPoint(scan);
        Difficulty difficulty = DifficultyName.getDif(scan);
        String authorName = AuthorName.getAName(scan);

        if (authorName.isEmpty()) {
            LabWork labwork = new LabWork(name, new Coordinates(coordinatesX, coordinatesY),
            minimalPoint, difficulty, null);
            return labwork;
        } else {
            Float authorWeight = AuthorWeight.getAWeight(scan);
            String authorPassportId = AuthorPassportId.getAPassportId(scan);
            Float authorLocationX = ALocationX.getLocX(scan);
            Double authorLocationY = ALocationY.getLocY(scan);
            String authorLocationName = ALocName.getALName(scan);

            LabWork labwork = new LabWork(name, new Coordinates(coordinatesX, coordinatesY),
            minimalPoint, difficulty,
            new Person(authorName, authorWeight, authorPassportId,
            new Location(authorLocationX, authorLocationY, authorLocationName)));

            return labwork;
        }
    }
}
