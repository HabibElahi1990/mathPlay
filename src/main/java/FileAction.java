import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileAction {

    public void saveFile(String str) throws IOException {
        File file = new File("gameInfo.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fileReader=new FileReader(file);
        List<Character> characterList=new ArrayList<>();
        while (fileReader.ready()){
            characterList.add((char) fileReader.read());
        }
        fileReader.close();
        FileWriter fileWriter = new FileWriter(file);
        String readerStr="";
        fileWriter.append(characterList.toString());
        fileWriter.append("\n" + str);
        fileWriter.close();
    }
}
