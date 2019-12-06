import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWritter
{
    private final String SEPARATOR = "==========";
    public void writeToFile(String filename, List<String> comments)
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Comments.txt"));
            System.out.println();
            System.out.println(SEPARATOR + filename + SEPARATOR);
            System.out.println();
            int counter = 1;
            for(String comment : comments)
            {
                System.out.println(counter + comment);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
