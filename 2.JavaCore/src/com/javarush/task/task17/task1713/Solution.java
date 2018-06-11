package com.javarush.task.task17.task1713;

import java.util.*;

/* 
Общий список
*/

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    @Override
    public synchronized int size() {
        return this.original.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return this.original.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return this.original.contains(o);
    }

    @Override
    public synchronized Iterator<Long> iterator() {
        return this.original.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return this.original.toArray();
    }

    @Override
    public synchronized <T> T[] toArray(T[] a) {
        return this.original.toArray(a);
    }

    @Override
    public synchronized boolean add(Long aLong) {
        return this.original.add(aLong);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return this.original.remove(o);
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return this.original.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends Long> c) {
        return this.original.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends Long> c) {
        return this.original.addAll(index, c);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return this.original.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return this.original.retainAll(c);
    }

    @Override
    public synchronized void clear() {
        this.original.clear();
    }

    @Override
    public synchronized Long get(int index) {
        return this.original.get(index);
    }

    @Override
    public synchronized Long set(int index, Long element) {
        return this.original.set(index, element);
    }

    @Override
    public synchronized void add(int index, Long element) {
        this.original.add(index, element);
    }

    @Override
    public synchronized Long remove(int index) {
        return this.original.remove(index);
    }

    @Override
    public synchronized int indexOf(Object o) {
        return this.original.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return this.original.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator<Long> listIterator() {
        return this.original.listIterator();
    }

    @Override
    public synchronized ListIterator<Long> listIterator(int index) {
        return this.original.listIterator(index);
    }

    @Override
    public synchronized List<Long> subList(int fromIndex, int toIndex) {
        return this.original.subList(fromIndex, toIndex);
    }
}
