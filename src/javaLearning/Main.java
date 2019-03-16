package javaLearning;

import boxes.BigBox;
import boxes.SmallBox;
import flashcards.Flashcard;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {

        BigBox box = new BigBox();


        box.printAllSmallBoxes();
        box.loadFlashCards();
        box.printAllSmallBoxes();



    }
}
