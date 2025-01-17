package day6.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

class FileUtil{
    List<String> readFile(String path){
        List<String> fileList = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line = bufferedReader.readLine();
            while(line != null){
                fileList.add(line);
                line = bufferedReader.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return fileList;
    }
}

public class FileDownloader {

    public static void downloadFile(List<String> fileList) throws InterruptedException {
        for(String url : fileList) {
            try {
                System.out.println("Downloading from " + url);
                sleep(1000);
                System.out.println("Downloading completed from " + url);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void downloadFileWithThread(List<String> fileList) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();

        for (String url : fileList) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Downloading from " + url);
                    sleep(1000);
                    System.out.println("Downloading completed from " + url);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threadList.add(thread);
        }
        for(Thread thread : threadList)
            thread.start();
        for(Thread thread : threadList)
            thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> fileList = new FileUtil().readFile("src/day6/q1/links.txt");
        System.out.println(fileList);
        int start = (int) System.currentTimeMillis();
        try {
            downloadFile(fileList);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int end = (int) System.currentTimeMillis();

        int startWithThread = (int) System.currentTimeMillis();
        downloadFileWithThread(fileList);
        int endWithThread = (int) System.currentTimeMillis();

        System.out.println("Time taken without thread: " + (end - start));
        System.out.println("Time taken with thread: " + (endWithThread - startWithThread));
    }
}
