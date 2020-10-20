package com.company;

public class Bidder implements IBidder {

    String name;

    @Override
    public String getName() {
        return name;
    }

    public Bidder(String bidderName){
        name=bidderName;
    }

    @Override
    public void update(String highestBidder, double bidAmount) {
        if(highestBidder.equals(this.name)){
            System.out.println(this.name+"'s console: "+"You have the highest bid now: "+bidAmount+"£");
        }
        else
            System.out.println(this.name+"'s console: A bid of "+bidAmount+"£ has been placed by "+highestBidder+"!");
    }
}
