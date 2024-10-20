package practice.controller;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @author shguddnr2@coremethod.co.kr
 * @version 1.0
 * @since 24. 10. 21.
 */
@Slf4j
public class FieldIntroduction {

    public static void main(String[] args) throws IllegalAccessException {
//        Movie movie = new Movie("movie", 2024, true, Category.ACTION, 10.99d);
//        printDeclaredFieldsInfo(Movie.MovieStats.class);
//        printDeclaredFieldsInfo(Category.class, Category.ACTION);
//        printDeclaredFieldsInfo(Movie.class, movie);
        printDeclaredFieldsInfo(Movie.class);
    }

    public static <T> void printDeclaredFieldsInfo(Class<T> clazz) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            log.info("name = {}", fields[i].getName());
            log.info("type name = {}", fields[i].getType().getName());
            log.info("is synthetic = {}", fields[i].isSynthetic());
        }
    }

    public static <T> void printDeclaredFieldsInfo(Class<T> clazz, T instance) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            log.info("name = {}", fields[i].getName());
            log.info("type name = {}", fields[i].getType().getName());
            log.info("is synthetic = {}", fields[i].isSynthetic());
            log.info("field value = {}", fields[i].get(instance));
        }
    }

    public static class Movie extends Product {
        public static final double MINIMUM_PRICE = 10.99;
        private boolean isReleased;
        private Category category;
        private double actualPrice;

        public Movie(String name, int year, boolean isReleased, Category category, double actualPrice) {
            super(name, year);
            this.isReleased = isReleased;
            this.category = category;
            this.actualPrice = actualPrice;
        }

        public class MovieStats {

            private double timesWatched;

            public MovieStats(double timesWatched) {
                this.timesWatched = timesWatched;
            }

            public double getRevenue() {
                return timesWatched * actualPrice;
            }

        }

    }

    public static class Product {
        protected String name;
        protected int year;
        protected double actualPrice;

        public Product(String name, int year) {
            this.name = name;
            this.year = year;
        }
    }

    public enum Category {ADVENTURE, ACTION, COMEDY}

}
