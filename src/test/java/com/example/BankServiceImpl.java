package com.example;

public class BankServiceImpl implements BankService {
    public boolean payWasCalled = false;
    @Override
    public void pay(String id, double amount) {
        payWasCalled = true;
    }
}
