package boxes;

import java.util.ArrayList;
import java.util.List;
import boxes.SmallBox;
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
    public void goodAnswer()
    {

    }
    public void moveToNextBox()
    {

    }
    public void test()
    {
        String backSide;
        String frontSide;
        for(int smallBoxNumber = 0; smallBoxNumber<smallBoxes.size(); smallBoxNumber++)
        {
            for(int flashcardNumber = 0; flashcardNumber < smallBoxes.get(smallBoxNumber).flashcards.size(); flashcardNumber++)
            {
                frontSide = smallBoxes.get(smallBoxNumber).flashcards.get(flashcardNumber).getFrontSide();
                System.out.println("Front side: " + frontSide);
                backSide = Main.sc.nextLine();
                if(backSide.equals(frontSide))
                    ;
                    //to next smallBox or its learned - to do congratulation notification
                else
                    ;
                    //move to back list

            }


        }
    }
}

