package com.progbm.Moogle.sample;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public Sample getSample() {
        Sample message = new Sample();
        message.setMessage("message");
        return message;
    }
}
