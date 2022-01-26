import java.io.*;
import java.util.*;

class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    public Movie(double rating, String name, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public int compareTo(Movie m1) {
        return this.year - m1.year;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}

class CompareRating implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        if (m1.getRating() > m2.getRating()) {
            return 1;
        } else if (m1.getRating() < m2.getRating()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class CompareName implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getName().compareTo(m2.getName());

    }
}

class PQ14 {
    public static void main(String[] args) {

        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie(7.2, "deepak", 1999));
        list.add(new Movie(8.2, "ankit", 2000));
        list.add(new Movie(4.2, "jitender", 1998));
        list.add(new Movie(5.2, "ravinder", 1997));
        list.add(new Movie(9.2, "mohit", 2001));
        CompareName compareName= new CompareName();
        CompareRating comRating=new CompareRating();
        println("sorted by name");
        Collections.sort(list, compareName);
        for( Movie movie:list){
            println(movie.getName());
        }
         Collections.sort(list, comRating);
        println("short by Rating ");
        for(Movie movie:list){
            println(movie.getRating()+"  "+movie.getName());
        }
    }
    static void println(Object line){
        System.out.println(line);
    }
}