import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileReader {

    List<String> FindComments(String filePath)
    {
        String line;
        List<String> Comments = new ArrayList<>();
        StringBuilder wholeCode = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(new File(filePath)));
            while ((line = bufferedReader.readLine()) != null)
            {
                wholeCode.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       wholeCode = new StringBuilder(wholeCode.toString().replaceAll("\"([^\"]*)\"", ""));

        Matcher matcher = Pattern.compile("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/").matcher(wholeCode.toString());
        while (matcher.find())
        {
            Comments.add(matcher.group());
        }
        return Comments;
    }
}
