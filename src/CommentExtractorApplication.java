import java.io.File;
import java.io.IOException;
import java.util.List;

public class CommentExtractorApplication {

    public static void main(String []args) throws IOException {
        FileReader fileReader = new FileReader();
        FileBrowser fileBrowser = new FileBrowser();
        FileWritter fileWritter = new FileWritter();

        for(File file : fileBrowser.files)
        {
           fileWritter.writeToFile(file.getName(),fileReader.FindComments(file.getAbsolutePath()));
        }

        fileWritter.closeWriter();
    }
}
