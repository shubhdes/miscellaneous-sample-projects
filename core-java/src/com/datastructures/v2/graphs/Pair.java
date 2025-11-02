package com.datastructures.v2.graphs;

class Pair<T1, T2> {

    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 first() {
        return this.first;
    }

    public T2 second() {
        return this.second;
    }
}

