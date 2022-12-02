import edu.duke.FileResource;

import java.util.HashMap;

public class CodonCount {
    public static void main(String[] args) {
        CodonCount cc = new CodonCount();
        cc.test();
    }
    private HashMap<String, Integer> dnaCounts;

    public CodonCount(){
        dnaCounts = new HashMap<>();
    }
    public void buildCodonMap(int start, String dna){
        dnaCounts.clear();
        int i = 0; //initialize the number of codons
        int num = 0; //initialize the number of the iterations with the while loop
        i = (dna.length()-start)/3;
        String current;
        while(num <= i-1){
            current = dna.substring(num*3+start, num*3+start+3);
            if(!dnaCounts.containsKey(current)){
                dnaCounts.put(current, 1);
            }
            else {
                dnaCounts.put(current, dnaCounts.get(current)+1);
            }
            num+=1;
        }
    }
    public String getMostCommonCodon(){
        int largest = 0;
        int current;
        String largestCount = null;
        for (String index : dnaCounts.keySet()) {
            current = dnaCounts.get(index);
            if(largest < current){
                largest = current;
                largestCount = index;
            }
        }
        return largestCount;
    }
    public void printCodonCounts(int start, int end){
        int current;
        for (String index : dnaCounts.keySet()) {
            current = dnaCounts.get(index);
            if (current >= start && current <= end){
                System.out.println(index+": " + current+"\t");
            }
        }
    }
    public void test(){
        FileResource fr = new FileResource("data1/dnaMystery2.txt");
        String dna = fr.asString();
        int start =1;
        int end = 10;

        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0 results in: " + dnaCounts.size() +" unique codons");
        String theLargestCount = getMostCommonCodon();
        System.out.println("and most common codon is " + theLargestCount + " with count " + dnaCounts.get(theLargestCount));
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are: ");
        printCodonCounts(start,end);

        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in: " + dnaCounts.size() +" unique codons");
        theLargestCount = getMostCommonCodon();
        System.out.println("and most common codon is " + theLargestCount + " with count " + dnaCounts.get(theLargestCount));
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are: ");
        printCodonCounts(start,end);

        buildCodonMap(2,dna);
        System.out.println("Reading frame starting with 2 results in: " + dnaCounts.size() +" unique codons");
        theLargestCount = getMostCommonCodon();
        System.out.println("and most common codon is " + theLargestCount + " with count " + dnaCounts.get(theLargestCount));
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are: ");
        printCodonCounts(start,end);

    }

}
