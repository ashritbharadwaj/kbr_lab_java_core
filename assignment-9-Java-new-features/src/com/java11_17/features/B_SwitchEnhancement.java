package com.java11_17.features;

public class B_SwitchEnhancement {
    public static void main(String[] args) {
        //java 6 u can only use char or int long: switch
        //java 7: string can also be used
        //java 13+ to simply the syntex of switch case


        enum WeekDay {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        WeekDay day = WeekDay.TUESDAY;
        switch (day) {
            case MONDAY, WEDNESDAY, FRIDAY ->
                System.out.println("Let's meet!");
            case TUESDAY, THURSDAY, SATURDAY ->
                System.out.println("no meeting!");
            case SUNDAY->
                System.out.println("Let's meet (although Sunday should be a free day, man!)!");
            default->
                System.out.println("Do I really need this?!");
        }


    }
}
