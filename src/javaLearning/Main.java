package javaLearning;

import boxes.BigBox;
import boxes.SmallBox;
import flashcards.Flashcard;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        BigBox box = new BigBox();
        box.addFlashcardToBox();
        box.addFlashcardToBox();
        box.addFlashcardToBox();
        box.addFlashcardToBox();
        box.addFlashcardToBox();

        box.smallBoxes.get(0).printSmallBoxElement();
        box.printAllSmallBoxes();

        box.test();
        box.smallBoxes.get(0).printSmallBoxElement();
        box.smallBoxes.get(1).printSmallBoxElement();
        box.smallBoxes.get(2).printSmallBoxElement();
        box.smallBoxes.get(3).printSmallBoxElement();
        box.smallBoxes.get(4).printSmallBoxElement();
        box.printAllSmallBoxes();




    }
}
