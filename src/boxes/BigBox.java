package boxes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import flashcards.Flashcard;
import javaLearning.Main;

public class BigBox {
    String owner;
    String title;
    String category;
    public List<SmallBox> smallBoxes = new ArrayList<SmallBox>();
    public BigBox()
    {
        System.out.println("Owner: ");
        owner = Main.sc.nextLine();
        System.out.println("Title: ");
        title = Main.sc.nextLine();
        System.out.println("category: ");
        category = Main.sc.nextLine();
        for(int boxNumber = 1; boxNumber<=5; boxNumber++)
        {

            smallBoxes.add(new SmallBox());
        }

    }
    public BigBox(String owner, String title, String category)
    {
        this.owner = owner;
        this.title = title;
        this.category = category;
        for(int boxNumber = 1; boxNumber<=5; boxNumber++)
        {
            smallBoxes.add(new SmallBox());
        }
    }
    @Override
    public String toString(){
        System.out.println("This is main box");
        return "BigBox{" +
                "owner='" + owner + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
    public void congratulationNotification(Flashcard flashcard){
        System.out.println("Congratulation! You've learnt this flashcard!");
        System.out.println(flashcard);
        //more action here in the future
    }
    public void addFlashcardToBox(){
        smallBoxes.get(0).addFlashcard(new Flashcard());
    }
    public void loadFlashcardToBox(String frontSide, String backSide, int boxNumber){
        smallBoxes.get(boxNumber).addFlashcard(new Flashcard(frontSide, backSide));
    }
    public void printAllSmallBoxes(){
        smallBoxes.get(0).printSmallBoxElement();
        smallBoxes.get(1).printSmallBoxElement();
        smallBoxes.get(2).printSmallBoxElement();
        smallBoxes.get(3).printSmallBoxElement();
        smallBoxes.get(4).printSmallBoxElement();

    }
    public void loadFlashcards() throws FileNotFoundException {
        String frontSide;
        String backSide;

        Scanner sc = new Scanner("SB1.csv");
        String filesNames[] = {"SB1.csv", "SB2.csv", "SB3.csv", "SB4.csv", "SB5.csv"};
        for(int i = 0; i <5; i++)
        {
            sc = new Scanner(new File(filesNames[i]));
            while(sc.hasNextLine())
            {
                frontSide = sc.nextLine();
                backSide = sc.nextLine();
                loadFlashcardToBox(frontSide, backSide, i);
            }
        }
        sc.close();
    }
    public void saveFlashcards() throws IOException {
        FileWriter fileWriter = new FileWriter("SB1.csv");
        String filesNames[] = {"SB1.csv", "SB2.csv", "SB3.csv", "SB4.csv", "SB5.csv"};
        for(int i =0; i<5; i++)
        {
            fileWriter = new FileWriter(filesNames[i]);
            for(Flashcard tmp: smallBoxes.get(i).flashcards)
            {

                System.out.println(tmp.getFrontSide() + "\n");
                System.out.println(tmp.getBackSide() + "\n");
                fileWriter.write(tmp.getFrontSide() + "\n");
                fileWriter.write(tmp.getBackSide() + "\n");
            }
            fileWriter.close();
        }

    }
    public void test()
    {
        System.out.println("++++++++++START TEST++++++++++++");
        String backSide;
        String frontSide;
        String userAnswer;
        int loopStoper;
        for(int smallBoxNumber = 0; smallBoxNumber<smallBoxes.size(); smallBoxNumber++)
        {
            loopStoper = smallBoxes.get(smallBoxNumber).flashcards.size();
            if(loopStoper == 0) continue;
            for(int flashcardNumber = 0; flashcardNumber < smallBoxes.get(smallBoxNumber).flashcards.size(); flashcardNumber++)
            {
                if(loopStoper == 0) continue;
                System.out.println("Small box number " + smallBoxNumber);
                //current flashcard
                Flashcard flashcard = smallBoxes.get(smallBoxNumber).flashcards.get(0);

                frontSide = flashcard.getFrontSide();
                System.out.println("Front side: " + frontSide + "\nBack side: ");
                userAnswer = Main.sc.nextLine();
                backSide = flashcard.getBackSide();
                if (backSide.equalsIgnoreCase(userAnswer))
                {           //if user answered well
                    if (smallBoxNumber != 4)
                    {
                        smallBoxes.get(smallBoxNumber + 1).flashcards.add(flashcard);
                        smallBoxes.get(smallBoxNumber).flashcards.remove(flashcard);
                        System.out.println("Good answer");
                        flashcardNumber--;

                    } else { //if user answered well in the last small box
                        smallBoxes.get(smallBoxNumber).flashcards.remove(flashcard);
                        congratulationNotification(flashcard);
                        flashcardNumber--;
                        //learned flashcards list??
                    }
                } else {//if user didnt answer well
                    smallBoxes.get(smallBoxNumber).flashcards.add(flashcard);//add at the end of a list
                    smallBoxes.get(smallBoxNumber).flashcards.remove(0);
                    System.out.println("Wrong answer");
                    flashcardNumber--;
                }
                loopStoper--;
            }
        }
    }

}

