package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {

    private WebDriver driver;
    private final By privacyPolicyLink = By.xpath("/html/body/div[2]/footer/div[2]/div[1]/div[3]/ul/li[5]/a");

    public String[] readUserDatas() {
        String[] result = new String[2];
        try {
            File myUser = new File("User.txt");
            Scanner scanner = new Scanner(myUser);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] temp = data.split(" = ");
                if (temp[0].equals("email")) {
                    result[0] = temp[1];
                } else {
                    result[1] = temp[1];
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void saveToFile(String filename, String text) {


        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.append(text +"\n" );
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
