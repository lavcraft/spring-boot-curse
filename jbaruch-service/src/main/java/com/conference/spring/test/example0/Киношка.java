package com.conference.spring.test.example0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Киношка {
    @Autowired СуперГерой герой;
    @Autowired СуперЗлодей злодей;

    public Киношка снимать() {
        return new Киношка();
    }
}
