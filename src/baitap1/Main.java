package baitap1;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nhập tên tệp tin nguồn: ");
        String sourceFile = null;
        try {
            sourceFile = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Nhập tên tệp tin đích: ");
        String targetFile = null;
        try {
            targetFile = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream in = new FileInputStream(sourceFile);
            OutputStream out = new FileOutputStream(targetFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();

            FileReader fileReader = new FileReader(targetFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int characterCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                characterCount += line.length();
            }
            bufferedReader.close();
            fileReader.close();

            System.out.println("Số ký tự trong tệp tin đích là: " + characterCount);
        } catch (FileNotFoundException e) {
            System.out.println("Tệp tin nguồn không tồn tại!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
