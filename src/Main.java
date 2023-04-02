import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final String path = "C:\\Users\\dan\\IdeaProjects\\ReportGenerator\\Report";
    private static String pathToFile;

    public static void createFileInDir(int num) {
        String pathToDir = path + num;

        try {
            Path p = Paths.get(pathToDir);
            Files.createDirectory(p);
            System.out.println("Success");
        } catch (IOException e) {
            System.err.println("Directory exists: " + e.getMessage());
        }

        pathToFile = pathToDir + "\\main.tex";

        try {
            Path p = Paths.get(pathToFile);
            Files.createFile(p);
            System.out.println("Success");
        } catch (IOException e) {
            System.err.println("File exists: " + e.getMessage());
        }
    }

    public static void moveImg() {
        String pathAnsysImg = "C:\\AnsysForReports\\";
        String pathReportImg = "C:\\Users\\dan\\IdeaProjects\\ReportGenerator\\Report1\\";

        File folder = new File(pathAnsysImg);
        List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(folder.listFiles()))); // жесть

        for (File file : files) {
            Path p = Paths.get(file.toURI());
            if (p.toString().endsWith(".jpeg") || p.toString().endsWith(".png")) {
                try {
                    Path pOut = Paths.get(p.toUri());
                    Path pIn = Paths.get(pathReportImg + p.getFileName());
                    Files.copy(pOut, pIn, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println("Cannot copy image: " + e.getMessage());
                }
            }
        }
    }

    public static void writeReport(String res) throws IOException {
        FileWriter fw = new FileWriter(pathToFile);
        fw.write(res);
        fw.close();
    }


    public static void main(String[] args) throws IOException {
        //createFileInDir(1);

//        String pathAnsys = "C:\\Program Files\\ANSYS Inc\\v211\\ansys\\bin\\winx64\\ANSYS211.exe -p ane3fl -dir" +
//                " C:\\AnsysForReports -j resFile -s read -l en-us -b -i C:\\AnsysRes\\input.apdl -o C:\\AnsysRes\\res.out";
//        Runtime.getRuntime().exec(pathAnsys);

        moveImg();

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