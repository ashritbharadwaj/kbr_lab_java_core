package labExam_Jan13;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MerchandiseInventoryTest {
    public static void main(String[] args) {
        MerchandiseInventoryApp app = new MerchandiseInventoryApp("input.txt");
        app.sortByNameAscending();
        app.sortByPriceDescending();
    }
}
