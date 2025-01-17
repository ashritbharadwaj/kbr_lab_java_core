package day5.q1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class FindFrequencies {
    public static void main(String[] args) {
        ArrayList<String> tokens = HandleFile("src/day5/q1/story.txt");
        HashMap<String,Integer> frequencies = computeFrequencies(tokens);
        print(frequencies);
    }

    public static void print(HashMap<String,Integer> freq){
        for(HashMap.Entry<String,Integer> entry:freq.entrySet())
            System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    public static HashMap<String,Integer> computeFrequencies(ArrayList<String> tokens){
        HashMap<String,Integer> frequencies = new HashMap<>();
        Iterator<String> it = tokens.iterator();
        while(it.hasNext()){
            String k = it.next();
            frequencies.merge(k, 1, Integer::sum);
        }
        return frequencies;
    }

    public static ArrayList<String> HandleFile(String path){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)))){
            ArrayList<String> tokens = new ArrayList<>();
            String line = bufferedReader.readLine();
            while(line!=null){
                String[] words = line.split(" ");
                tokens.addAll(Arrays.asList(words));
                line = bufferedReader.readLine();
            }
            return tokens;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}