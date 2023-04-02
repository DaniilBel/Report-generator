import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathToDir = "C:\\Users\\dan\\IdeaProjects\\ReportGenerator\\Report1";

        try {


            Path path = Paths.get(pathToDir);
            Files.createDirectory(path);
            System.out.println("Success");
        } catch (IOException e) {
            System.err.println("Directory exists: " + e.getMessage());
        }

        String pathToFile = "C:\\Users\\dan\\IdeaProjects\\ReportGenerator\\Report1\\report.tex";

        try {
            Path path = Paths.get(pathToFile);
            Files.createFile(path);
            System.out.println("Success");
        } catch (IOException e) {
            System.err.println("File exists: " + e.getMessage());
        }

        FileWriter fw = new FileWriter(pathToFile);
        fw.write(Template.template.toString());
        fw.close();

    }
}