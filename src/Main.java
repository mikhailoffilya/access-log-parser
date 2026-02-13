import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int validFileNumber = 0;
        int allLength = 0;
        while (true) {
            System.out.println("Введите путь к файлу");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!fileExists) {
                System.out.println("Файл не существует");
                continue;
            }

            if (isDirectory) {
                System.out.println("Указанный путь ведет к папке, а не к файлу");
                continue;
            }

            validFileNumber++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + validFileNumber);
            System.out.println();

            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader =
                        new BufferedReader(fileReader);
                String line1;
                int max = 0;
                while ((line1 = reader.readLine()) != null) {
                    max = line1.length();
                    allLength++;
                    if (max > 1024) throw new InvalidLengthException("Найдена строка длиннее " + max + " символов");
                }
                System.out.println("Количество строк " + allLength);
                System.out.println("Самая длинная строка имеет " + max + " символов");
                List<String> lines = Files.readAllLines(Paths.get(path));
                int min = Integer.MAX_VALUE;
                String minLenght = "";
                for (String line2 : lines) {
                    int length = line2.length();

                    if (length < min) {
                        min = length;
                        minLenght = line2;
                    }
                }
                System.out.println("Самая короткая строка " + minLenght);
                System.out.println("Самая короткая строка имеет " + minLenght.length() + " символов");

            } catch (InvalidLengthException ex) {
                System.err.println(ex.getMessage());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class InvalidLengthException extends RuntimeException {
        public InvalidLengthException(String message) {
            super(message);
        }
    }
}