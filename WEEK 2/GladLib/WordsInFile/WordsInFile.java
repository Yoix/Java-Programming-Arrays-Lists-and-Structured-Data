package WordsInFile;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.*;
import java.util.*;

public class WordsInFile {
    public static void main(String[] args) {
        WordsInFile glm = new WordsInFile();
        glm.test();
    }
    HashMap<String, ArrayList<String>> wordFilename;
    public WordsInFile(){
        wordFilename = new HashMap<>();
    }
    public void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        String name = f.getName();
        for(String word : fr.words()){
            if(!wordFilename.containsKey(word)){
                ArrayList<String> myWords = new ArrayList<>();
                myWords.add(name);
                wordFilename.put(word, myWords);
            } else if (wordFilename.containsKey(word) && !wordFilename.get(word).contains(name)) {
                ArrayList<String> currentList = wordFilename.get(word);
                currentList.add(name);
                wordFilename.put(word, currentList);
            }
        }
    }
    public void buildWordFileMap(){
        wordFilename.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int max = 0;
        for(String word:wordFilename.keySet()){
            ArrayList<String> currentList = wordFilename.get(word);
            int currentNum = currentList.size();
            if(currentNum > max) {
                max=currentNum;
            }
        }
        return max;
    }
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> returnList = new ArrayList<>();
        for(String word:wordFilename.keySet()){
            ArrayList<String> currentList = wordFilename.get(word);
            int currentNum = currentList.size();
            if(currentNum == number){
                returnList.add(word);
            }
        }
        return returnList;
    }
    public void printFilesIn(String word){
        ArrayList<String> filenames = wordFilename.get(word);
        for (String filename : filenames) {
            System.out.println(filename);
        }
    }
    public void test(){
        buildWordFileMap();
        int max = maxNumber();
        ArrayList<String> testList = wordsInNumFiles(4);
        System.out.println("The maximum number of files words is in: " + max + " and there are " + testList.size());
        for (int k =0;k< testList.size(); k++)
        {
            System.out.println("All the words in the files "+testList.get(k)+"");
        }
        System.out.println("\t");

        for (int k =0;k <testList.size();k++){
            System.out.println("Filenames where the words are " + testList.get(k));
            printFilesIn(testList.get(k));
        }
    }
}
