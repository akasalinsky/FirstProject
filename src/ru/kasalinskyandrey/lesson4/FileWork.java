package ru.kasalinskyandrey.lesson4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWork {
    public static void main(String[] args) {
        String path = "c:\\123\\123.txt";

        try(FileOutputStream output = new FileOutputStream(path))
        {
            output.write(11111111);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
