import java.io.File;
import java.io.IOException;
import java.util.List;

public class CommentExtractorApplication {

    public static void main(String []args) throws IOException {
        FileReader fileReader = new FileReader();
        FileBrowser fileBrowser = new FileBrowser();
        FileWritter fileWritter = new FileWritter();
        //fileWritter.writeToFile("test.txt",fileReader.FindComments("C:\\Users\\Aurimas\\Desktop\\ReadmeBA-master\\ReadmeBA\\startup.cs"));
        for(File file : fileBrowser.files)
        {
           fileWritter.writeToFile(file.getName(),fileReader.FindComments(file.getAbsolutePath()));
            //System.out.println(file.getAbsolutePath());
        }
        System.out.println("Finished");
    }
}
