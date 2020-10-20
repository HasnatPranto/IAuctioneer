package com.company;

public interface IBidder {
    public abstract void update(String highestBidder, double bidAmount);
    String getName();
}
