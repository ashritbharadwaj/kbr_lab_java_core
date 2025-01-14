package day3_day4.q1_q2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {
    private int timeTaken;

    public int getTimeTaken() {
        return timeTaken;
    }

    FileInputOutputStream(){
        try(FileInputStream fis = new FileInputStream("src/day3_day4/q1_q2/favorite_player.webp"); FileOutputStream fos = new FileOutputStream("src/day3_day4/q1_q2/favorite_player_copy_inout.webp");){
            int b;
            int start = (int) System.currentTimeMillis();
            while((b=fis.read()) != -1) fos.write(b);
            int end = (int) System.currentTimeMillis();
            System.out.println("File copied successfully Using FileInputOutputStream");
            System.out.println("Time Taken: "+(end-start)+"ms");
            timeTaken = end-start;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
