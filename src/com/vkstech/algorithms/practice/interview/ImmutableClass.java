package com.vkstech.algorithms.practice.interview;

public final class ImmutableClass {

    private final int value;

    public ImmutableClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ImmutableClass withNewValue(int newValue) {
        return new ImmutableClass(newValue);
    }

    @Override
    public String toString() {
        return "ImmutableClass{value=" + value + '}';
    }

    public static void main(String[] args) {
        ImmutableClass obj1 = new ImmutableClass(10);
        System.out.println("Original object: " + obj1);

        // Creating a new object with updated value
        ImmutableClass obj2 = obj1.withNewValue(20);
        System.out.println("New object: " + obj2);

        // Original object remains unchanged
        System.out.println("Original object after update attempt: " + obj1);
    }

}
