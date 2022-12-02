
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Tester t = new Tester("WebLogProgram/weblog2_log");
        t.testCountUniqueIPVisitsInRange();
        t.testUniqueIP();
        t.testUniqueIPVisitsOnDay();
        t.testMostNumberVisitsByIP();
        t.testIPsMostVisits();
        t.testDayWithMostIPVisits();
        t.testIPsWithMostVisitsOnDay();
    }
    LogAnalyzer la;
    public Tester(String fname){
        la = new LogAnalyzer();
        la.readFile(fname);
    }
    
    public void testLogAnalyzer() {
        la.printAll();
        // complete method
    }
    public void testUniqueIP(){
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + " unique IPS.");
    }
    public void testPrintAllHigherThanNum(){
        System.out.println("Testing STATUS: ");
        la.printAllHigherThanNum(400);
    }

    public void testUniqueIPVisitsOnDay(){
        System.out.println("IPs on Sep 24: " + la.uniqueIPVisitsOnDay("Sep 24").size());
    }
    public void testCountUniqueIPVisitsInRange(){
        System.out.println("IPs on range: 400, 499: " + la.countUniqueIPsInRange(400, 499));
    }


    //NEW TESTERS
    public void testCountsVisitsPerIP(){
        System.out.println("Counts IP per day: " + la.countVisitsPerIP());
    }
    public void testMostNumberVisitsByIP(){
        int max = la.mostNumberVisitsByIP(la.countVisitsPerIP());
        System.out.println("Most number of visits from ip: " + max);
    }
    public void testIPsMostVisits(){
        HashMap<String, Integer> map = la.countVisitsPerIP();
        System.out.println("The IP with most visits: " + la.iPsMostVisits(map));
    }

    public void testIPsForDays(){
        HashMap<String, ArrayList<String>> map = la.iPsForDays();
        System.out.println("Mapping day-vist: ");
        System.out.println(map);
    }

    public void testDayWithMostIPVisits(){
        String map = la.dayWithMostIPVisits(la.iPsForDays());
        System.out.println("Day with most visits: ");
        System.out.println(map);
    }
    public void testIPsWithMostVisitsOnDay(){
        ArrayList<String> map = la.iPsWithMostVisitsOnDay("Sep 30");
        System.out.println("IPs with most visits on Sep 30: ");
        System.out.println(map);
    }
}
