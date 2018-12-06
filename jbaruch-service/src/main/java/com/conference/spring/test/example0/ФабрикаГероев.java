package com.conference.spring.test.example0;

import java.util.Random;

public class ФабрикаГероев {
    public Object родить() {
        if (new Random().nextBoolean()) {
            return new СуперГерой();
        }
        return new СуперЗлодей();
    }
}
