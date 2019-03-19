package javaLearning;

import boxes.BigBox;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        BigBox box = new BigBox();



        box.loadFlashcards();
        box.printAllSmallBoxes();
        box.test();
        box.printAllSmallBoxes();
        box.saveFlashcards();
    }
}
