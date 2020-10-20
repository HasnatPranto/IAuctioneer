package com.company;

import java.util.Scanner;

public class AuctioneerConsole {
    Scanner sc= new Scanner(System.in);

    public void beginAuction(){

        int optln=0, bidderID;
        double bidAmount;
        String name;
        BiddingCore biddingCore=new BiddingCore();

        while(optln!=4){
            System.out.println("1.Add Bidders\t\t2.View Bidders List\n3.Remove A Bidder\t4.Proceed to Bidding!");
            optln= sc.nextInt();
            sc.nextLine();
            switch (optln){
                case 1:
                    System.out.print("Bidder's Name: ");
                    name= sc.nextLine();
                    IBidder newBidder= new Bidder(name);
                    biddingCore.addNewBidder(newBidder);
                    System.out.println("A New Bidder Has been Added To The List\n");
                    break;

                case 2:
                    System.out.println("Current Bidders:");
                    for(IBidder iBidder: biddingCore.bidders)
                        System.out.println(iBidder.getName());
                    break;

                case 3:
                    System.out.print("Bidder's Name: ");
                    name= sc.nextLine();
                    IBidder bidder= new Bidder(name);
                    biddingCore.removeBidder(bidder);
                    break;
            }
        }
        optln=0;
        System.out.println("****   Today's Auction Has Begun!!!   ****\nReserve Price:£1,000,000");

        while(optln!=2){
            System.out.println("\n1.Place a Bid\t2.Finalize!");
            optln=sc.nextInt();
            sc.nextLine();

            switch (optln){
                case 1:
                    System.out.println("ID\tName");

                    for(int i=0;i<biddingCore.bidders.size();i++)
                    {
                        System.out.println(i+"\t"+biddingCore.bidders.get(i).getName());
                    }
                    System.out.print("Enter Bidder ID: "); bidderID= sc.nextInt();sc.nextLine();

                    if(bidderID>biddingCore.bidders.size()-1) {
                        System.out.println("invalid ID!");break;}

                    System.out.println("Bidding At: "); bidAmount=sc.nextDouble();sc.nextLine();
                    biddingCore.setBid(bidAmount,biddingCore.bidders.get(bidderID).getName());
                    break;

                case 2:
                    if(biddingCore.currentBid==1000000) System.out.println("item unsold!");
                    else
                    System.out.println("** ITEM SOLD!! **\n  £ "+biddingCore.currentBid);
            }
        }
    }
}
