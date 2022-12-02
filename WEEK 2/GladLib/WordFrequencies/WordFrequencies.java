package WordFrequencies;
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
    public static void main(String[] args) {
        WordFrequencies wf = new WordFrequencies();
        wf.tester();
    }
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myFreqs.clear();
        myWords.clear();
        FileResource fr = new FileResource();
        for(String word : fr.words()){
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1){
                myWords.add(word);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
    }
    
    public void tester(){
        findUnique();
        System.out.println("Number of unique words: "+myWords.size());
        for (int i = 0; i < myWords.size(); i++) {
            System.out.println("Frequencies: " + myFreqs.get(i) + "\t" + "Word: " + myWords.get(i));
        }
        int index = findMax();
        System.out.println("The word that occurs most offten and its count are: "+myWords.get(index)+" "+myFreqs.get(index));
    }
    public int findMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
