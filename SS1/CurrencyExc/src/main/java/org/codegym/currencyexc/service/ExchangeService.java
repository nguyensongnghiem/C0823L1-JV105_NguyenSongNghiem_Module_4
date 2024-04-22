package org.codegym.currencyexc.service;

import org.springframework.stereotype.Service;
@Service
public class ExchangeService {
private final float RATE=25000;
    public float exchange(float usd) {
        return usd*RATE;
    }
}
