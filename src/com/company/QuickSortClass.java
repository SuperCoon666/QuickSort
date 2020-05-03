package com.company;

import java.util.List;

public class QuickSortClass<E extends Comparable<E> > {

    public void quickSort(E[] a, int lowBorder, int highBorder) {
        if (a.length == 0 || lowBorder > highBorder) {
            // конец сортировки
            return;
        }
        // выбор первого эелемента
        int middle = lowBorder + (highBorder - lowBorder) / 2;
        E middleFraction = a[middle];


        int l = lowBorder, r = highBorder;


        // Перенос
        while (l <= r) {
            while (a[l].compareTo(middleFraction) < 0) {
                l++;
            }
            while (a[r].compareTo(middleFraction) > 0) {
                r--;
            }

            if (l <= r) { //swap
                E temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;
                r--;
            }
        }

        //Рекурсия
        if (lowBorder < r)
            quickSort(a, lowBorder, r);

        if (highBorder > l)
            quickSort(a, l, highBorder);
    }



    public void quickSort(List<E> a, int lowBorder, int highBorder) {
        if (a.size() == 0 || lowBorder > highBorder) {
            // конец сортировки
            return;
        }
        // выбор опорного элемента
        int middle = lowBorder + (highBorder - lowBorder) / 2;
        E middleFraction = a.get(middle);


        int l = lowBorder, r = highBorder;


        // выбор первого эелемента
        while (l <= r) {

            while (a.get(l).compareTo(middleFraction) < 0) {
                l++;
            }

            while (a.get(r).compareTo(middleFraction) > 0) {
                r--;
            }

            if (l <= r) { //swap
                E temp = a.get(l);
                a.set(l, a.get(r));
                a.set(r, temp);
                l++;
                r--;
            }
        }

            //Рекурсия
        if (lowBorder < r)
            quickSort(a, lowBorder, r);

        if (highBorder > l)
            quickSort(a, l, highBorder);
    }
}
