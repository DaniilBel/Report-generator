import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    private static final String path = "C:\\Users\\dan\\IdeaProjects\\ReportGenerator\\Report";
    private static String pathToDir = null;
    private static String pathToFile;
    static int num = 12;

    // Создаётся отдельная папка для хранения отчета
    public static void createFileAndDir() {
        try {
            Path p = Paths.get(pathToDir);
            Files.createDirectory(p);
            System.out.println("Success to create directory");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {
            Path p = Paths.get(pathToFile);
            Files.createFile(p);
            System.out.println("Success to create file");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void checkFileAndDir() {
        pathToDir = path + num;
        pathToFile = pathToDir + "\\main.tex";

        if (!Files.exists(Path.of(pathToDir))) {
            System.out.println("Directory does not exist");
            createFileAndDir();
        } else {
            System.out.println("Directory and file exists");
        }
    }

    public static void writeReport(String res) throws IOException {
        FileWriter fw = new FileWriter(pathToFile);
        fw.write(res);
        fw.close();

        FileOutputStream zipFile = new FileOutputStream(pathToDir + "\\main.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        zip.putNextEntry(new ZipEntry("main.tex"));

        File file = new File(pathToFile);
        Files.copy(file.toPath(), zip);

        zip.close();
    }

    // Data имеет формат
    // номер(например ноды)   значение(например перемещение)
    public static String parsingData() {
        String pathToDir = path + num;
//        Map<Integer, Double> str = new HashMap<>();
        List<String> str = new ArrayList<>();

        try {
            File file = new File(pathToDir + "\\fileOut.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                int i = (int)Double.parseDouble(line[1]);
                double d = Double.parseDouble(line[line.length-1]);
                String tmp = i + "\t" + d;
                str.add(tmp);
            }

            reader.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        StringBuilder res = new StringBuilder();
//        for (Map.Entry<Integer, Double> l:
//             str.entrySet()) {
//            res.append(l.getKey()).append("\t").append(l.getValue()).append("\n").append("\n");
//        }
        for (String s : str) {
            res.append(s).append("\n").append("\n");
        }

        return res.toString();
    }

    public static String getCode() {
        String pathToDir = path + num;
        StringBuilder res = new StringBuilder();

        try {
            File file = new File(pathToDir + "\\input.apdl");

            List<String> list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            for (String line : list)
                res.append(line).append("\n");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return res.toString();
    }

    public static void main(String[] args) throws IOException {
        checkFileAndDir();

        // Результатом работы будут изображения, файл со значениями, apdl программа
        Ansys ansys = new Ansys(num);
        ansys.runAnsys();

        String[] geom = new String[1];
        geom[0] = "geom_1.BMP";

        String[] bc = new String[1];
        bc[0] = "bc_1.BMP";

        String[] result = new String[1];
        result[0] = "res_1.BMP";
//        result[1] = "res_2.BMP";
//        result[2] = "res_3.BMP";

        Template.picturesIntoGeomDoc(geom);
        Template.picturesIntoBCDoc(bc);
        Template.picturesAndDataIntoResultsDoc(result, parsingData());
        Template.inputCodeIntoDoc(getCode());

        String res = Template.startDoc +
                Template.introduction +
                Template.geometryModel +        // TODO: В geom вставлять картинки
                Template.modelWithBorderCond +  // TODO: В model вставлять картинки
                Template.results +              // TODO: В results вставлять картинки и результаты вычислений
                Template.listing +              // TODO: В listing вставить код
                Template.endDoc;
        writeReport(res);

    }
}