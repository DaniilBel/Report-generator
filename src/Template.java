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
                        
            Модуль Юнга E = 10^5 Па
            Коэффициент Пуассона $\\mu$ = 0.3
            
            """;

    public static String geometryModel = """
            \\section{Геометрия}
            
            Figure~\\ref{fig:geomModel} Геометрическая модель.
                        
            \\begin{figure}[h]
              \\centering
              \\includegraphics[width=0.5\\textwidth]{tpic.png}
              \\label{fig:geomModel}
            \\end{figure}
            
            """;

    public static String modelWithBorderCond = """
            \\subsection{Boundary conditions}

            Figure~\\ref{fig:loadModel} Геометрическая модель.
                        
            \\begin{figure}[h]
              \\centering
              \\includegraphics[width=0.5\\textwidth]{load_tpic.png}
              \\label{fig:loadModel}
            \\end{figure}
            
            """;

    public static String results = """
            \\section{Results}
                        
            Тут что-то должно быть
            
            """;

    public static String listing = """
            \\section{Listing}
            
            Код программы
            
            """;

    public static String endDoc = """
            \\bibliography{references} % Specifies the bibliography file
            \\bibliographystyle{ieeetr} % Specifies the
            
            \\end{document}
            
            """;
}
