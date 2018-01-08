package com.oc.associate.objectives;

/**
 * Integer is a covariant of Number, since it's a subclass.
 *
 * Number is not a covariant of Integer
 * Number is not a covariant of int
 * int is not a covariant of Number
 * int is not a covariant of Integer
 */
public class Covariants {
    public static void main(String[] args) {
        MP3Player mp3 = new MP3Player();
//        mp3.play();
        System.out.println(new MP3Player().showTrack(-8));
    }
}

class Player {
    protected Integer play() throws Exception {
        System.out.println("Player is playing...");
        return 9;
    }
}

interface Display {
    public default int showTrack(int trackNumber) { return 0; }
}

class MP3Player extends Player implements Display {

    /**
     * Invalid case one
     */
//    public String showTrack(int trackNumber) { return "7"; }  // int and String are not covariant returns types i.e. int is not a subclass of String

    /**
     * Invalid case two
     */
//    public Number play() throws RuntimeException {            // Incompatible return type, Number type is not a covariant of Integer
//        System.out.println("MP3 is playing...");
//        return 8;
//    }

}