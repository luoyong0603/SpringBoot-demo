package com.example.demo.component.javaDemo.JavaPackage.genericity;

public class GenericBoundary<T extends Number> {
    private T data;

    public GenericBoundary(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
