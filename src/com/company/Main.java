package com.company;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintStream out = System.out;
    public static void tryListSort(){

        Fraction[] arrQuickSort = {new Fraction(1, 2), new Fraction(1, -4),new Fraction(1, -4), new Fraction(-1, 4),new Fraction(-5, 1), new Fraction(5, 1)};
        ArrayList<Fraction> listQuickSort = new ArrayList<>();
        ArrayList<Fraction> listInsertionSort = new ArrayList<>();
        for (int i = 0; i < arrQuickSort.length; i++) {
            listQuickSort.add(arrQuickSort[i]);
            listInsertionSort.add(arrQuickSort[i]);
        }


        System.out.println("Список до сортировки:");
        for (Fraction f : listQuickSort){
            System.out.println(f);
        }
        QuickSortClass quickSortClass = new QuickSortClass();
        quickSortClass.quickSort(listQuickSort, 0, listQuickSort.size() - 1);

        System.out.println("\nПосле быстрой сортировки:");
        for (Fraction f : listQuickSort){
            System.out.println(f);
        }

    }


    public static void tryArrSort(){
        Fraction[] arrQuickSort = {new Fraction(1, 2), new Fraction(1, -4),new Fraction(1, -4), new Fraction(-1, 4),new Fraction(-5, 1), new Fraction(5, 1)};
        Fraction[] arrInsertionSort = Arrays.copyOf(arrQuickSort, arrQuickSort.length);
        System.out.println("Массив до сортировки:");
        for (Fraction f : arrQuickSort){
            System.out.println(f);
        }
        QuickSortClass quickSortClass = new QuickSortClass();
        quickSortClass.quickSort(arrQuickSort, 0, arrQuickSort.length - 1);

        System.out.println("\nПосле быстрой сортировки:");
        for (Fraction f : arrQuickSort){
            System.out.println(f);
        }
        System.out.println("\n\n");
    }


    public static void main(String[] args) {
        tryListSort();
        tryArrSort();
    }

}