import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
        String wholeCode = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(new File(filePath)));
            while ((line = bufferedReader.readLine()) != null)
            {
                wholeCode += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Matcher matcher = Pattern.compile("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/").matcher(wholeCode);
        while (matcher.find())
        {
            String comment = matcher.group();
            if(comment.startsWith("\"") && comment.endsWith("\""))
            {
               continue;
            }
            Comments.add(comment);
        }
        return Comments;
    }
}
