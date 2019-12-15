import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileBrowser {
    List<File> files = new ArrayList<>();
    private List<String> supportedFileFormats = new ArrayList<>(Arrays.asList(".cs",".css",".html",".java",".c",".cpp"));

    FileBrowser()
    {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Choose a directory to save your file: ");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().isDirectory()) {
                ListFiles(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }

    private void ListFiles(String directoryName)
    {
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        if(fList != null)
            for (File file : fList) {
                if (file.isFile() && supportedFileFormats.contains(file.getName().substring(file.getName().indexOf(".")))) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    ListFiles(file.getAbsolutePath());
                }
            }
    }
}

