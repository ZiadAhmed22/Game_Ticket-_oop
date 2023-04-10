/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameticket;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
//import java.lang.*;

/**
 *
 * @author itop
 */
public class GameTicket {

    public static void main(String[] args) {
        Date date = new Date();
        game[] G = new game[3];
        seats[] S = new seats[3];
        ticket[] t = new ticket[3];

        fans[] F = new fans[3];
        fans f1 = new fans();

        G[0] = new international(date, "Barchelona", "RealMadrid", "50", "Campnou", (float) 7.30, 3000);

        G[0].display();
        G[0].refree_nationality();
//        G[0].sum_person(11, 11);
//        G[0].sum_person(11, 11, 5);
        

        System.out.println("***********************");
        S[0] = new seats(15, 50, "one");
        S[0].dsplay();

        System.out.println("***********************");
        t[0] = new ticket(G[0], S[0]);
        t[0].display();

        System.out.println("***********************");
        f1.check_seats();
        f1.reserve();

        f1.cancel();
        f1.makebet();
        f1.upgrade();
        System.out.println("***********************");
        G[1] = new national(date, "Ahly", "Zamalek", "80", "Cairo", (float) 8.30, 2000);
        G[1].display();
        G[1].refree_nationality();

        S[1] = new seats(10, 80, "two");
        S[1].dsplay();

        t[1] = new ticket(G[1], S[1]);
        t[1].display();

    }
}
/**
 * @author 
 * using class game the parent class of national and international and it is an abstract class  
 */
 abstract class game {

    Date date;
    protected String team1, team2, refree;/**
     * @see 
     * protected members that can using in child classes only
     */

    String code, location_stad;
    float match_hrs;
    public int noOFseats;
    /**
     * @param 
     * overloading method (polymorphism compile time ) 
     */

    public int sum_person(int playerst1, int playerst2) {

        return (playerst1 + playerst2);
    }

    public int sum_person(int playerst1, int playerst2, int numofRefrees) {

        return (playerst1 + playerst2 + numofRefrees);

    }

    public game(Date date, String team1, String team2, String code, String location_stad, float match_hrs, int noOFseats) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.code = code;
        this.location_stad = location_stad;
        // this.fav_team = fav_team;
        this.match_hrs = match_hrs;
        this.noOFseats = noOFseats;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMatch_hrs() {
        return match_hrs;
    }

    public void setMatch_hrs(float match_hrs) {
        this.match_hrs = match_hrs;
    }

    ArrayList<seats> cat1 = new ArrayList<>();
    ArrayList<seats> cat2 = new ArrayList<>();
    ArrayList<seats> cat3 = new ArrayList<>();

    public game() {
    }

    public String getCode() {
        return code;
    }

    public String getLocation_stad() {
        return location_stad;
    }

    public ArrayList<seats> getCat1() {
        return cat1;
    }

    public ArrayList<seats> getCat2() {
        return cat2;
    }

    public ArrayList<seats> getCat3() {
        return cat3;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLocation_stad(String location_stad) {
        this.location_stad = location_stad;
    }

    public void setCat1(ArrayList<seats> cat1) {
        this.cat1 = cat1;
    }

    public void setCat2(ArrayList<seats> cat2) {
        this.cat2 = cat2;
    }

    public void setCat3(ArrayList<seats> cat3) {
        this.cat3 = cat3;
    }

    void display() {

        System.out.println("this date " + date);
        System.out.println("this code " + code);
        System.out.println("this location  " + location_stad);
        System.out.println("this number of seats " + noOFseats);

    }

    abstract void refree_nationality();/**
     * @param
     * abstract method must exist in abstract class and must to declared only and the implemention of the method in override method in the child classes 
     * Using Inheritance as national and international are the child of the parent class(game)
     */
}
/**
 * class national extends from game
 * @author itop
 */
class national extends game {

    public national(Date date, String team1, String team2, String code, String location_stad, float match_hrs, int noOFseats) {
        super(date, team1, team2, code, location_stad, match_hrs, noOFseats);
    }
/**@param 
 * Using Override of method that declared in the abstract class(game)
 */
    @Override
    void refree_nationality() {
        refree = "EGYPT";
        System.out.println("The refree nationality is " + refree);

    }
}

/**
 * class  international extends from game
 * @author itop
 */
class international extends game {

    public international(Date date, String team1, String team2, String code, String location_stad, float match_hrs, int noOFseats) {
        super(date, team1, team2, code, location_stad, match_hrs, noOFseats);
    }

    @Override
    void refree_nationality() {
         System.out.println("Enter the refree Nationalty");
        Scanner in = new Scanner(System.in);
        String r = in.nextLine();
        refree = r;

        System.out.println("The refree nationality is " + refree);

    }
}

class seats {
/**@see 
 * Using static and final member
 */
    static int number = 0;
    final int catprice = 50;
    String category;

    public seats() {
    }

    public seats(int number, int catprice, String category) {
        // this.catprice = catprice;
        this.category = category;
        seats.number = number;
    }

    void dsplay() {
        System.out.println("The number of  seat " + number);
        System.out.println("The category  is" + category);
        System.out.println("The price of seat " + catprice);

    }
    /**
     * @param 
     * using static method that should have static member
     */

    public static void number_method() {

        System.out.println("The number of  seat " + number);

    }

    public seats(int number) {

        seats.number = number;
    }

    public int getCatprice() {
        return catprice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        seats.number = number;
    }

}
/**
 * @param 
 * Using the interface that have the declaration of the method and implements in another class Using Override 
 */
interface the_game {

    public void display();

}

class ticket implements the_game {

    private static int ticket_code;
    public float ticket_price;
    game gg;
    seats ss;

    public ticket(game g, seats s) {
        ss = s;
        gg = g;

    }

    @Override
    public void display() {

        System.out.println("The ticket code is " + ticket_code);

        System.out.println("The ticket Price  is " + ss.catprice);

        System.out.println("The Category is " + ss.category);

        System.out.println("The game code" + gg.code);
        System.out.println("The first team is " + gg.team1);

        System.out.println("The Second team is " + gg.team2);

        System.out.println("The Location Stadium " + gg.location_stad);

    }
/**
 * Using final method 
 * @return 
 */
    final float getticketprice() {
        return ticket_price = 60.0f;
    }
}

class fans {

    ticket t1;
    seats s1;
    game x;

    public void check_seats() {

        System.out.println("Which number of seat you want to check ? ");
        //  System.out.println("Num is" +t1.ss.number);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        try {
            if (n == seats.number) {
                System.out.println("The number of seat is available ");
                //return true;

            } else {

                System.out.println("Sorrry,the number of seat isn't available ");
                // return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void reserve() {
        Scanner in = new Scanner(System.in);

        System.out.println("Which Category of seat you want to Reserve ? ");
        String hh = in.nextLine();

        System.out.println("Which number of seat you want to Reserve ? ");
        try {
            int n = in.nextInt();

            System.out.println("Your Reserve has Done");
            System.out.println("Your number is" + n);
            System.out.println("Your category is " + hh);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void cancel() {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter the day and months of the Match ");
            int day = in.nextInt();
            int months = in.nextInt();

            System.out.println("Enter the day and months of today  ");
            int day_to = in.nextInt();
            int months_to = in.nextInt();
            if (day - day_to >= 3 && months == months_to) {
                System.out.println("Canceling the Ticket has Done");
            }
        } catch (Exception e) {

            System.out.println("Sorrry,You are too Late to Cancel this ticket ");
        }

    }

    public void makebet() {

        Scanner in = new Scanner(System.in);
        System.out.println(" please Enter the Match teams");
        String t1 = in.nextLine();
        String t2 = in.nextLine();
        System.out.println("Enter your name and which team will win in your opinion ?");

        String person1 = in.nextLine();
        String op_of_p1 = in.nextLine();
        String person2 = in.nextLine();
        String op_of_p2 = in.nextLine();

        System.out.println("What is the result of the Match ?");
        int scoret1 = in.nextInt();
        int scoret2 = in.nextInt();
        try {
        if (scoret1 > scoret2) {
            if (t1.equals(op_of_p1)) {
                System.out.println("The winner is " + t1 + " and the winner of a bet is " + person1);
            }
            if (t1.equals(op_of_p2)) {
                System.out.println("The winner is " + t1 + "and the winner of a bet is " + person2);

            }

        } else if (scoret1 < scoret2) {
            if (t2.equals(op_of_p1)) {
                System.out.println("The winner is " + t2 + " and the winner of a bet is " + person1);

            }
            if (t2.equals(op_of_p2)) {
                System.out.println("The winner is" + t2 + " and the winner of a bet is " + person2);

            }
        } else {
            System.out.println("The result is Draw");

        }
        }
        catch (Exception e)
        {
        e.getMessage();
        }
    }

    public void upgrade() {

        System.out.println("Which Category you reserve ? ");
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine();
        if (ss.equals("three")) {
            System.out.println("Which Category you want to upgrade one or two ? ");
            String zz = in.nextLine();
            if (zz.equals("one")) {
                System.out.println("Now you Upgrade to Category " + zz);

            }
            if (zz.equals("two")) {
                System.out.println("Now you Upgrade to Category " + zz);
            }
        } else {
            System.out.println("Sorry you cannot Upgrade ");
        }
        if (ss.equals("two")) {
            System.out.println("You can Upgrade to category one only  Yes or no ?");

            String dd = in.nextLine();
            if (dd.equals("yes")) {
                System.out.println("Now you Upgrade to Category One");

            } else {
                System.out.println("Sorry you cannot Upgrade ");

            }

        }

    }

}
