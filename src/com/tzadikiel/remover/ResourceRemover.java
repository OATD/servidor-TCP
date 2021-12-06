package com.tzadikiel.remover;

import com.tzadikiel.resource.ElementsResource;

public class ResourceRemover extends Thread{
    private ElementsResource resource = null;

    public ResourceRemover(ElementsResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.remove();
    }
}
