import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    public static void main(String[] args) {
        CharactersInPlay cip = new CharactersInPlay();
        cip.tester();
    }
    //Creating to privates ArrayLists
    private ArrayList<String> names;
    private ArrayList<Integer> counts;

    public CharactersInPlay(){
        names = new ArrayList<>();
        counts = new ArrayList<>();
    }
    //Update method will do add names to the ArrayList, if Person isn't already in the
    //string, will be added
    public void update(String person){
        //If person is not already in names, add person as a new names object and 1 to the arrayList as a new object:
        if (!names.contains(person)){
            names.add(person);
            counts.add(1);
        }
        else{
            int indexCounts = counts.get(names.indexOf(person))+1;
            counts.set(names.indexOf(person), indexCounts);
        }
    }

    //Find the possibles name, calling the method update to add the variables in the ArrayList with the new names
    public void findAllCharacters(){
        FileResource f = new FileResource();
        String firstOccur;
        for(String line : f.lines()){
            if (line.contains(".")){
                firstOccur = line.substring(0, line.indexOf("."));
                update(firstOccur);
            }
        }
    }
    //Testing the two methods that I was write
    public void tester(){
        names.clear();
        counts.clear();
        findAllCharacters();
        for (int i = 0; i < names.size(); i++) {
            if(counts.get(i)>1){
                System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
        charactersWithNumParts(10, 15);
    }

    //Print out the names of all those characters that have exactly number speaking parts
    public void charactersWithNumParts(int num1, int num2){
        System.out.println("Characters that have between " + num1 + " and " + num2 + " lines: ");
        for (int i = 0; i < names.size(); i++) {
            if (counts.get(i) >= num1 && counts.get(i) <= num2){
                System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
    }

}
