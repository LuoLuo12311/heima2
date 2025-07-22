package com.luo.basicdemo.basicdemo;

import com.luo.basicdemo.basicdemo.Movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MovieManager {
    private List<Movie> movies = new ArrayList<>();

    // 添加电影
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // 查询所有电影
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    // 根据电影名删除电影
    public boolean removeMovieByName(String name) {
        Iterator<Movie> it = movies.iterator();
        boolean removed = false;
        while (it.hasNext()) {
            Movie m = it.next();
            if (m.getName().equals(name)) {
                it.remove();
                removed = true;
            }
        }
        return removed;
    }

    // 根据主演删除所有相关电影
    public int removeMoviesByActor(String actor) {
        Iterator<Movie> it = movies.iterator();
        int count = 0;
        while (it.hasNext()) {
            Movie m = it.next();
            if (m.getActor().equals(actor)) {
                it.remove();
                count++;
            }
        }
        return count;
    }
} 