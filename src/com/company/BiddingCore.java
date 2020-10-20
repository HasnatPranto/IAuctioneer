package com.company;

import java.util.ArrayList;
import java.util.List;

public class BiddingCore{

    List<IBidder> bidders= new ArrayList<>();
    double currentBid=1000000;
    String highestBidder="";

    public void setBid(double latestBid, String bidderName){

        if(latestBid<=currentBid)
            System.out.println("Cannot bid less or equal to the current bid of: "+currentBid+"£");

        else {
            currentBid=latestBid;
            highestBidder=bidderName;
            notifyBidders();
        }
    }

    public void addNewBidder(IBidder bidder){
        bidders.add(bidder);
    }

    public void removeBidder(IBidder bidder){
        if(bidders.contains(bidder)) {
            bidders.remove(bidder);
            System.out.println("The Bidder Has been Removed\n");
        }
        else
            System.out.println("No Bidder Has Been Found With This Name\n");
    }

    public void notifyBidders() {
        System.out.println("***  NEW BID!  ***\n");

       for(IBidder iBidder: bidders){
           iBidder.update(highestBidder,currentBid);
       }
    }
}
