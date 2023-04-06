public class Template {

    public static String startDoc = """
            \\documentclass{article}
                        
            % Packages
            \\usepackage{graphicx} % For including figures
            \\usepackage{amsmath} % For typesetting math equations
            \\usepackage{color} % For adding color
            \\usepackage{cite} % For creating a bibliography
            \\usepackage[russian]{babel}
                        
            % Document settings
            \\setlength{\\parindent}{0pt} % No indentation for paragraphs
            \\linespread{1.25} % 1.25 line spacing
                        
            % Title and author information
            \\title{Отчёт 1}
            \\author{Беляев Даниил}
                        
            \\begin{document}
                        
            \\maketitle % Generates the title page
            
            """;

    public static String introduction = """
            \\section{Введение}
                        
            Модуль Юнга $E = 10^5$ Па
            
            Коэффициент Пуассона $\\mu$ = 0.3
            
            """;

    public static String geometryModel = """
            \\section{Геометрия}
            
            Геометрическая модель.
            
            %s
            
            """;

    public static String modelWithBorderCond = """
            \\subsection{Граничные условия}

            %s
            
            """;

    public static String results = """
            \\section{Results}
                        
            %s
            
            %c
            
            Тут что-то должно быть
            
            """;

    public static String listing = """
            \\section{Listing}
            
            Код программы:
            
            \\begin{verbatim}
            
            %s
            
            \\end{verbatim}
            
            """;

    public static String endDoc = """
            \\bibliography{references} % Specifies the bibliography file
            \\bibliographystyle{ieeetr} % Specifies the
            
            \\end{document}
            
            """;

    private static String texPicture(String fileName, String tag) {
        return String.format(
                """
                
                \\\\begin{figure}[h]
                \\\\centering
                \\\\includegraphics[width=0.5\\\\textwidth]{%s}
                \\\\label{fig:%s}
                \\\\end{figure}
                
              """, fileName, tag
        );
    }

    // Вставка нескольких изображений в текст
    // На вход поступают изображения, начинающиеся на geom_*.*
    public static void picturesIntoGeomDoc(String[] fileNames) {

        try {
            // geom_tpic.png
            StringBuilder pictures = new StringBuilder();
            for (String fileName : fileNames) {
                String pic = texPicture(fileName, "geomModel");
                pictures.append(pic);
            }

            geometryModel = geometryModel.replaceAll("%s", pictures.toString());
        } catch (Exception e) {
            System.out.println("File not transferred");
            geometryModel = geometryModel.replaceAll("%s", " ");
        }

    }

    // Вставка нескольких изображений в текст
    // На вход поступают изображения, начинающиеся на bc_*.*
    public static void picturesIntoBCDoc(String[] fileNames) {

        // bc_tpic.png
        StringBuilder pictures = new StringBuilder();
        for (String fileName : fileNames) {
            String pic = texPicture(fileName, "boundaryCond");
            pictures.append(pic);
        }

        modelWithBorderCond = modelWithBorderCond.replaceAll("%s", pictures.toString());
    }

    // Вставка нескольких изображений в текст
    // На вход поступают изображения, начинающиеся на res_*.*
    public static void picturesAndDataIntoResultsDoc(String[] fileNames, String data) {

        // res_tpic.png
        StringBuilder pictures = new StringBuilder();
        for (String fileName : fileNames) {
            String pic = texPicture(fileName, "result");
            pictures.append(pic);
        }

        results = results.replaceAll("%s", pictures.toString());
        results = results.replaceAll("%c", data);
    }

    // Вставка кода в текст
    public static void inputCodeIntoDoc(String code) {
        listing = listing.replaceAll("%s", code);
    }
}
