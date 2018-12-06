package com.conference.spring.test.example0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class СуперЗлодей implements Герой {
    @Autowired СуперГерой вражина;

    @Override
    public void бить() {
        вражина.страдать();
    }
}
