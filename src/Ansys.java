import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ansys {

    private int num;

    Ansys() {}

    Ansys(int num) {
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void runAnsys() throws IOException {
        // Для запуска нужен apdl file
        moveApdlFile();

        String pathAnsys = "C:\\Program Files\\ANSYS Inc\\v211\\ansys\\bin\\winx64\\ANSYS211.exe -p ane3fl -dir" +
                " C:\\AnsysForReports -j resFile -s read -l en-us -b -i C:\\AnsysForReports\\input.apdl -o C:\\AnsysForReports\\res.out";
        Runtime.getRuntime().exec(pathAnsys);

        // В результате работы проги появляются изображения и data, которые нужны
//        moveImg();
        moveData();
    }

    // Картинки перемещаются в папку с отчётом
    public void moveImg() {
        String pathAnsysImg = "C:\\AnsysForReports\\";
        String pathReportImg = "C:\\Users\\dan\\IdeaProjects\\ReportGenerator\\Report" + num + "\\";

        File folder = new File(pathAnsysImg);
        List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(folder.listFiles()))); // жесть

        for (File file : files) {
            Path p = Paths.get(file.toURI());
            if (p.toString().endsWith(".jpeg") || p.toString().endsWith(".png")) {
                try {
                    // Путь, куда копируем файл
                    Path pIn = Paths.get(pathReportImg + p.getFileName());
                    Files.copy(p, pIn, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println("Cannot copy image: " + e.getMessage());
                }
            }
        }
    }

    // Данные перемещаются в папку с отчётом
    public void moveData() {
        String pathAnsysData = "C:\\AnsysForReports\\";
        String pathReportData = "C:\\Users\\dan\\IdeaProjects\\ReportGenerator\\Report" + num + "\\";

        File folder = new File(pathAnsysData);
        List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(folder.listFiles()))); // жесть

        for (File file : files) {
            Path p = Paths.get(file.toURI());
            if (p.toString().endsWith(".txt")) {
                try {
                    // Путь, куда копируем файл
                    Path pIn = Paths.get(pathReportData + p.getFileName());
                    Files.copy(p, pIn, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println("Cannot copy data file: " + e.getMessage());
                }
            }
        }
    }

    // Для старта Ansys необходим файл с кодом
    public void moveApdlFile() {
        String pathAnsys = "C:\\AnsysForReports\\";
        String pathReport = "C:\\Users\\dan\\IdeaProjects\\ReportGenerator\\Report" + num + "\\";

        File folder = new File(pathReport);
        List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(folder.listFiles()))); // жесть

        for (File file : files) {
            Path p = Paths.get(file.toURI());
            if (p.toString().endsWith(".apdl")) {
                try {
                    // Путь, куда копируем файл
                    Path pIn = Paths.get(pathAnsys + p.getFileName());
                    Files.copy(p, pIn, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println("Cannot copy code file: " + e.getMessage());
                }
            }
        }
    }
}
