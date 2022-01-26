/*PQ13 Create a solution to sort movies on the basis of their year of release?*/


import java.io.*;
import java.util.*;

// A class 'Movie' that implements Comparable
class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    public Movie(String name, double rating, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public int compareTo(Movie m1) {
        return this.year - m1.year;
    }

    public double getRating() {
        return this.rating;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }
}

class MovieSortbyYear {
    public static void main(String[] args) {
        ArrayList<Movie> source = new ArrayList<Movie>();
        source.add(new Movie("Deepak", 7.2, 1999));
        source.add(new Movie("JItender", 8.2, 2000));
        source.add(new Movie("Ravinde", 5.2, 1988));
        Collections.sort(source);
        // prinnt short Movie by year
        for (Movie movie : source) {
            println("Name= " + movie.getName() + " Rating is " + movie.getRating() + " Year is " + movie.getYear());
        }

    }

    public static void println(Object line) {
        System.out.println(line);
    }
}