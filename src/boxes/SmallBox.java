package boxes;
import javaLearning.Main;
import flashcards.Flashcard;

import java.util.ArrayList;
import java.util.List;

public class SmallBox {
    public List<Flashcard> flashcards = new ArrayList<Flashcard>();

    public void addFlascard(Flashcard flashcard)
    {
        flashcards.add(flashcard);
    }
    public void deleteFlashcard(Flashcard flashcard)
    {
        flashcards.remove(flashcard);
    }

    public void printSmallBoxElement(){
        System.out.println(flashcards);
    }
}
