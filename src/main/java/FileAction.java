import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAction {

    public void saveFile(String str) throws IOException {
        File file = new File("gameInfo.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        List<Character> characterList = new ArrayList<>();
        while (fileReader.ready()) {
            characterList.add((char) fileReader.read());
        }
        fileReader.close();
        FileWriter fileWriter = new FileWriter(file);
        final String[] readerStr = {""};
        characterList.forEach(n -> readerStr[0] += n);
        fileWriter.append(readerStr[0]).append("\n").append(str);
        fileWriter.close();
    }

    public void getFile(String name) {
        try {
            FileReader fileReader = new FileReader("gameInfo.txt");
            List<Character> characterList = new ArrayList<>();
            while (fileReader.ready()) {
                characterList.add((char) fileReader.read());
            }
            fileReader.close();
            final String[] readerStrArray = {""};
            characterList.forEach(n -> readerStrArray[0] += n);
            String readerStr = readerStrArray[0];
            String[] readerStrSplitEnter = readerStr.split("\n");
            List<ResultGame> resultGameList = new ArrayList<>();
            for (int i = 0; i < readerStrSplitEnter.length; i++) {
                if (readerStrSplitEnter[i].contains(name)) {
                    String[] readerStrSplitCama = readerStrSplitEnter[i].split(",");
                    ResultGame resultGame = new ResultGame();
                    resultGame.setName(readerStrSplitCama[0].substring(readerStrSplitCama[0].indexOf("=") + 1, readerStrSplitCama[0].length()));
                    resultGame.setTime(readerStrSplitCama[1].substring(readerStrSplitCama[1].indexOf("=") + 1, readerStrSplitCama[1].length()));
                    resultGame.setRight(Integer.parseInt(readerStrSplitCama[2].substring(readerStrSplitCama[2].indexOf("=") + 1, readerStrSplitCama[2].length())));
                    resultGame.setWrongs(Integer.parseInt(readerStrSplitCama[3].substring(readerStrSplitCama[3].indexOf("=") + 1, readerStrSplitCama[3].length())));
                    resultGameList.add(resultGame);

                }
            }
            for (int i = 0; i < resultGameList.size(); i++) {
                if (i + 1 != resultGameList.size()) {
                    for (int j=i;j<resultGameList.size();j++) {
                        if (resultGameList.get(i).getRight() < resultGameList.get(j).getRight()) {
                            ResultGame resultGame = resultGameList.get(i);
                            resultGameList.set(i, resultGameList.get(j));
                            resultGameList.set(j, resultGame);
                        }
                        if (resultGameList.get(i).getRight().equals(resultGameList.get(j).getRight())){
                            int iTime=Integer.parseInt(resultGameList.get(i).getTime().substring(resultGameList.get(i).getTime().indexOf(":")+1,resultGameList.get(i).getTime().length()));
                            int jTime=Integer.parseInt(resultGameList.get(j).getTime().substring(resultGameList.get(j).getTime().indexOf(":")+1,resultGameList.get(j).getTime().length()));
                            if (iTime>jTime){
                                ResultGame resultGame = resultGameList.get(i);
                                resultGameList.set(i, resultGameList.get(j));
                                resultGameList.set(j, resultGame);
                            }
                        }
                    }
                }
            }
           resultGameList.stream()
                   .forEach(n-> System.out.println(n.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
