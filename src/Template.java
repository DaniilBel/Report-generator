public class Template {

    public static String startDoc = """
            \\documentclass{article}
                        
            % Packages
            \\usepackage{graphicx} % For including figures
            \\usepackage{amsmath} % For typesetting math equations
            \\usepackage{color} % For adding color
            \\usepackage{cite} % For creating a bibliography
            \\usepackage[russian]{babel}
            \\usepackage{longtable}
                        
            % Document settings
            \\setlength{\\parindent}{0pt} % No indentation for paragraphs
            \\linespread{1.25} % 1.25 line spacing
                        
            % Title and author information
            \\title{Отчёт 1}
            \\author{Беляев Даниил}
                        
            \\date{}
            \\begin{document}
                        
            \\maketitle % Generates the title page
            
            """;

    public static String introduction = """
            \\section{Введение}
                        
            Модуль Юнга $E = 210e9$ Па
            
            Коэффициент Пуассона $\\mu$ = 0.3
            
            """;

    public static String geometryModel = """
            \\section{Геометрия}
            
            Геометрическая модель.
            
            %s
            
            \\newpage
            
            """;

    public static String modelWithBorderCond = """
            \\subsection{Граничные условия}

            %s
            
            \\newpage
            
            """;

    public static String results = """
            \\section{Результ}
                        
            %s
            
            %c
            
            \\begin{center}
                \\begin{longtable}{|p{1cm}|p{1cm}|}
                \\caption{...}\\\\
                \\hline
                $\\phi$ & 0 \\\\
                \\hline
                - & 5.1037 \\\\\s
                \\hline \s
                \\end{longtable}
            \\end{center}
            
            \\newpage
            
            """;

    public static String listing = """
            \\section{Листинг}
            
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
                \\\\includegraphics[width=0.9\\\\textwidth]{%s}
                \\\\caption{
                \\\\label{fig:%s}
                }
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
                pic = pic.replace("BMP", "png");
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
            pic = pic.replace("BMP", "png");
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
            pic = pic.replace("BMP", "png");
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
