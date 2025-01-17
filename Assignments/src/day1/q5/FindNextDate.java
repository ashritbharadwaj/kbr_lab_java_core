package day1.q5;

public class FindNextDate {
    public static boolean isLeapYear(int y){
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
    }
    public static void findnextdate(int d,int m,int y){
        d++;
        if(m==2 && isLeapYear(y)){
            if(d>29){
                d=1;
                m++;
            }
        }else if(m==2 && !isLeapYear(y)){
            if(d>28){
                d=1;
                m++;
            }
        }else if(m==4 || m==6 || m==9 || m==11){
            if(d>30){
                d=1;
                m++;
            }
        }else if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12){
            if(d>31){
                d=1;
                m++;
            }
        }
        if(m>12){
            m=1;
            y++;
        }
        System.out.println("The next date is: "+d+"/"+m+"/"+y);
    }

    public static void main(String[] args) {
        int d=31,m=12,y=2024;
        findnextdate(d,m,y);
    }
}
