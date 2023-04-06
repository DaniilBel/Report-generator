import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final String path = "C:\\Users\\dan\\IdeaProjects\\ReportGenerator\\Report";
    private static String pathToFile;
    static int num = 1;

    // Создаётся отдельная папка для хранения отчета
    public static void createFileAndDir() {
        String pathToDir = path + num;

        try {
            Path p = Paths.get(pathToDir);
            Files.createDirectory(p);
            System.out.println("Success to create directory");
        } catch (IOException e) {
            System.err.println("Directory exists: " + e.getMessage());
        }

        pathToFile = pathToDir + "\\main.tex";

        try {
            Path p = Paths.get(pathToFile);
            Files.createFile(p);
            System.out.println("Success to create file");
        } catch (IOException e) {
            System.err.println("File exists: " + e.getMessage());
        }
    }

    public static void writeReport(String res) throws IOException {
        FileWriter fw = new FileWriter(pathToFile);
        fw.write(res);
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        createFileAndDir();

        Ansys ansys = new Ansys(num);
        ansys.runAnsys();

        // Результатом работы будут изображения, файл со значениями, apdl программа
//        runAnsys();

//        StringBuilder res = new StringBuilder(Template.startDoc +
//                Template.introduction +
//                Template.geometryModel +
//                Template.modelWithBorderCond +
//                Template.results +
//                Template.listing +
//                Template.endDoc);
//        writeReport(res.toString());


    }
}