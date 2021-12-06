package com.tzadikiel.adder;

import com.tzadikiel.resource.ElementsResource;

public class ResourceAdder extends Thread{
    private ElementsResource resource = null;
    private String value = null;

    public ResourceAdder(ElementsResource resource, String value) {
        this.resource = resource;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public void run() {
        resource.add(getValue());
    }
}
