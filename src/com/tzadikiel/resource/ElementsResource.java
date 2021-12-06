package com.tzadikiel.resource;

import java.util.LinkedList;

public class ElementsResource {

    private final LinkedList<String> elements = new LinkedList<>();

    public synchronized void add(String value) {
        elements.offer(value);
    }

    public synchronized String remove() {
        return elements.poll();
    }

    public LinkedList<String> getElements() {
        return this.elements;
    }
}
