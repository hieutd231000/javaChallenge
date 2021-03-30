package com.company;

public class Main {
    public static long toMilesPerHour(double kilometerPerHour){
        if(kilometerPerHour<0)
            return -1;
        return Math.round(kilometerPerHour/1.609);
    }
}
