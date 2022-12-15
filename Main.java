import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Распарсить файл с логами из заданий, выполненных на семинаре, найти записи уровня INFO/DEBUG.

public class Main {
    public static void main(String[] args) {
        System.out.println("ethg");

        Logger log = Logger.getLogger("MyLogger");
        FileHandler fh;

        try {
            fh = new FileHandler("file.txt", true);
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        log.log(Level.INFO, "msgSupplier");
        log.log(Level.WARNING, "12333");
        log.log(Level.INFO, "9999");
        ArrayList<String> logDataArr = new ArrayList<>();
        try {
            File file = new File("file.txt");
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    logDataArr.add((line));
                }
            }
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        } catch (IOException e) {

            throw new RuntimeException(e);

        }
        System.out.println(logDataArr);
        bubbleSort();

    }

    public static void bubbleSort() {
        int[] arr = new int[20];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = 20 - index;
        }
        System.out.println(Arrays.toString(arr));

        int countStar = 0;
        int countEnd = 0;
        int temp = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    countEnd++;
                }
            }
            System.out.println(Arrays.toString(arr));

            if (countStar == countEnd) {
                flag = false;
            } else {
                countEnd = 0;
            }
        }

    }
}
