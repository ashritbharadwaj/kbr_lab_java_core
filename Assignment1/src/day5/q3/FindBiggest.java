package day5.q3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class FindBiggest {
    public static void main(String[] args) {
        ArrayList<String> tokens = HandleFile("src/day5/q3/data.txt");
        ArrayList<Double> values = stringToDoubleCast(tokens);
        double val = findBiggest(values);
        System.out.println(val);
    }

    private static double findBiggest(ArrayList<Double> values) {
        values.sort(Comparator.reverseOrder());
        return values.getFirst();
    }

    private static ArrayList<Double> stringToDoubleCast(ArrayList<String> tokens) {
        ArrayList<Double> res = new ArrayList<>();
        Iterator<String> it = tokens.iterator();
        while(it.hasNext()){
            res.add(Double.parseDouble(it.next()));
        }
        return res;
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
