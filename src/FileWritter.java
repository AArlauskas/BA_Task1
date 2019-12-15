import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class FileWritter
{
    private BufferedWriter bufferedWriter;
    private File file = new File(System.getProperty("user.dir") + "\\Comments.txt");
    {
        if(file.exists() && file.isFile())
        {
            file.delete();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeToFile(String filename, List<String> comments)
    {
        if(comments.isEmpty())
        {
            return;
        }
        try {
            bufferedWriter.newLine();
            String SEPARATOR = "==========";
            bufferedWriter.write(SEPARATOR + filename + SEPARATOR);
            bufferedWriter.newLine();
            int counter = 1;
            for(String comment : comments)
            {
                bufferedWriter.write(counter + comment);
                counter++;
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void closeWriter() throws IOException {
        bufferedWriter.close();
    }
}
