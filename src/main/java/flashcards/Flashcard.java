package flashcards;
import javaLearning.Main;
public class Flashcard
{
    String frontSide;
    String backSide;

    public Flashcard()
    {
        System.out.println("Adding new flashcard: ");
        System.out.println("Front side: ");
        frontSide = Main.sc.nextLine();
        System.out.println("Back side: ");
        backSide = Main.sc.nextLine();
    }
    public Flashcard(String frontSide, String backSide)
    {
        this.frontSide = frontSide;
        this.backSide = backSide;
    }

    public String getFrontSide() {
        return frontSide;
    }

    public String getBackSide() {
        return backSide;
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "frontSide='" + frontSide + '\'' +
                ", backSide='" + backSide + '\'' +
                '}';
    }
}
