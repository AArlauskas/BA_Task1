import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileBrowser {
    public List<File> files = new ArrayList<>();
    public FileBrowser()
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory to save your file: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                listf(jfc.getSelectedFile().getAbsolutePath());
            }
        }
    }

    public void listf(String directoryName)
    {
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        if(fList != null)
            for (File file : fList) {
                if (file.isFile() && (file.getName().endsWith(".txt") || file.getName().endsWith(".cs"))) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    listf(file.getAbsolutePath());
                }
            }
    }
}

