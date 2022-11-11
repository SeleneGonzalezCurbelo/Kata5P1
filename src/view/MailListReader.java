package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MailListReader {
    public static List<String> read(String fileName){
        List<String> list = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while(true){
                String line = reader.readLine();
                if (line == null) break;
                if(isEmail(line)){
                    list.add(line);
                }
            }
        }
        catch(FileNotFoundException exception){
            System.out.println("ERROR MailListReader::read (FileNotFoundException)" 
                    + exception.getMessage());
        }
        catch(IOException exception){
            System.out.println("ERROR MailListReader::read (IOException)" 
                    + exception.getMessage());
        }
        return list;
    }
    
    public static boolean isEmail(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        return pattern.matcher(email).matches();
    } 
}
