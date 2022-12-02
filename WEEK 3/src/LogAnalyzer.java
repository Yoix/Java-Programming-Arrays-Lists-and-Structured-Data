import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
     private final ArrayList<LogEntry> records;

     public LogAnalyzer() {
         records = new ArrayList<>();
         // complete constructor
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for (String s : fr.lines()) {
             records.add(WebLogParser.parseEntry(s));
         }
         // complete method
     }

     public int countUniqueIPs(){
         ArrayList<String> unique = new ArrayList<>();
         for(LogEntry log : records){
            String ip = log.getIpAddress();
            if(!unique.contains(ip)){
                unique.add(ip);
            }
         }
         return unique.size();
     }

     public void printAllHigherThanNum(int num){
         System.out.println("Num is: " + num);
         for(LogEntry le : records){
             int status = le.getStatusCode();
             if (status > num){
                 System.out.println(le);
             }
         }
     }

     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> ipsOneDay = new ArrayList<>();
         for (LogEntry le : records) {
             String time = le.getAccessTime().toString();
             String ip = le.getIpAddress();
             if(time.contains(someday)) {
                 if (!ipsOneDay.contains(ip)) {
                     ipsOneDay.add(ip);
                 }
             }
         }
         return ipsOneDay;
     }

     public int countUniqueIPsInRange(int low, int high){
         ArrayList<String> unique = new ArrayList<>();
         for(LogEntry le : records){
             String ip = le.getIpAddress();
             int statusCode = le.getStatusCode();
             if((statusCode >= low) && (statusCode <= high)){
                 if(!unique.contains(ip)){
                     unique.add(ip);
                 }
             }
         }
         return unique.size();
     }

     //THIS IS THE FIRST PROGRAM:

     public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> map = new HashMap<>();
        for(LogEntry le : records){
            String ip = le.getIpAddress();
            if(!map.containsKey(ip)){
                map.put(ip, 1);
            }
            else {
                map.put(ip, map.get(ip)+1);
            }
        }
        return map;
     }
     //HELPER METHOD FOR THE FIRST PROGRAM
    private HashMap<String, Integer> countVisitsPerIP(String day){
         HashMap<String, Integer> map = new HashMap<>();
         for(LogEntry le : records){
             if(!getDay(le).equals(day)){
                 continue;
             }
             String ip = le.getIpAddress();
             if(!map.containsKey(ip)){
                 map.put(ip, 1);
             }
             else {
                 map.put(ip, map.get(ip)+1);
             }
         }
         return map;
    }

     //THIS IS THE SECOND PROGRAM

     public int mostNumberVisitsByIP(HashMap<String, Integer> map){
        int maxVisits = 0;
        for(int visits : map.values()){
            if(visits > maxVisits){
                maxVisits = visits;
            }
        }
        return maxVisits;
     }

     //THIS IS THE THIRD PROGRAM TO USE

     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> addressNumberTime){
         ArrayList<String> maxIps = new ArrayList<>();
         int greatest;
         greatest = mostNumberVisitsByIP(addressNumberTime);
         for(String s: addressNumberTime.keySet()){
             if (addressNumberTime.get(s) == greatest) {
                 maxIps.add(s);
             }
         }
         return maxIps;
     }

     //THIS IS THE FOURTH PROGRAM  TO USE

     public HashMap<String, ArrayList<String>> iPsForDays(){
         HashMap<String, ArrayList<String>> map = new HashMap<>();
         for(LogEntry le : records){
             String day = getDay(le);
             String ip = le.getIpAddress();

             if(!map.containsKey(day)) {
                 ArrayList<String> list = new ArrayList<>();
                 list.add(ip);
                 map.put(day,list);
             }
             else {
                 if(!map.get(day).contains(ip)){
                     map.get(day).add(ip);
                 }
             }
         }
         return map;
     }

    //THIS IS THE FIFTH PROGRAM TO USE

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
         int maxSize = 0;
         String most = null;
         for(String day : map.keySet()){
             int size = map.get(day).size();
             if(size > maxSize){
                 maxSize = size;
                 most = day;
             }
         }
         return most;
    }

    //THIS IS THE SIXTH PROGRAM TO USE
    public ArrayList<String> iPsWithMostVisitsOnDay(String day){
         //output
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> visits = countVisitsPerIP(day);

        //finding the max visits count
         int maxCount = 0;
         for(int count : visits.values()){
             if(count > maxCount) {
                 maxCount = count;
             }
         }
         for(String ip : visits.keySet()){
             if(visits.get(ip) == maxCount){
                 list.add(ip);
             }
         }
         return list;
    }
    //THIS PROGRAM HELP TO THE DATE IN MM DD
    public String getDay(LogEntry le){
         String date = le.getAccessTime().toString();
         return date.substring(4,10);
     }
    //THIS PROGRAM RETURN EVERYTHING IN THE LOG
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println("Number of Log: " + le);
         }
         
     }
     
     
}
