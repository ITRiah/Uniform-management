/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class GenerateID {
    public static int getNextID(String fileName, String startsWith, int stringLength, String regex) {
        // Đọc tệp tin để lấy ID lớn nhất hiện tại
        int maxID = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(regex);
                if (parts.length > 0) {
                    String currentId = parts[0];
                    if (currentId.startsWith(startsWith)) {
                        int id = Integer.parseInt(currentId.substring(stringLength));
                        maxID = Math.max(maxID, id);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxID + 1;
    }
    
}
