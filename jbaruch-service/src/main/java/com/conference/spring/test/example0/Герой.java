package com.conference.spring.test.example0;

public interface Герой {
    void бить();

    default void страдать() {
        System.out.println("герой " + this.getClass().getSimpleName() + " страдает");
    }
}
