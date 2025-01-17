package day3_day4.q1_q2;

import java.io.*;

public class BufferedReadWrite {
    private int timetaken;

    public int getTimetaken() {
        return timetaken;
    }

    BufferedReadWrite(){
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/day3_day4/q1_q2/favorite_player.webp"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/day3_day4/q1_q2/favorite_player_copy_buf.webp"))) {
            int b;
            int start = (int) System.currentTimeMillis();
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
            int end = (int) System.currentTimeMillis();
            System.out.println("File copied successfully using BufferedInputStream and BufferedOutputStream.");
            System.out.println("Time Taken: " + (end - start) + "ms");
            this.timetaken=end-start;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
