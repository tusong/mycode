import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRewrite {


    public static void main(String[] args) throws IOException {

        String filePath = "D:/jdck/ck.txt";
        File file = new File(filePath);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        List<String> readLines = new ArrayList<>();
        while (true){
            String line = bufferedReader.readLine();
            if(line != null){
                readLines.add(line);

            }else {
                break;
            }
        }

        int fileSize = 100;
        int count = readLines.size()/fileSize;

        for (int i = 0; i < count; i++) {
            String filePath1 = "D:/jdck/ck"+i+".txt";
            File file1 = new File(filePath1);
            if(!file1.exists()){
                file1.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file1);
            for (int j = 0; j < fileSize; j++) {

                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(readLines.get(fileSize*i+j));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            fileWriter.close();
        }

    }
}
