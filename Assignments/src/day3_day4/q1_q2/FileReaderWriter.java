package day3_day4.q1_q2;

import java.io.*;

public class FileReaderWriter {
    FileReaderWriter(){
        try(FileReader fis = new FileReader("src/day3_day4/q1_q2/favorite_player.webp"); FileWriter fos = new FileWriter("src/day3_day4/q1_q2/favorite_player_copy.webp");){
            int b;
            while((b=fis.read()) != -1) fos.write(b);
            System.out.println("File copied successfully Using FileInputOutputStream");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
