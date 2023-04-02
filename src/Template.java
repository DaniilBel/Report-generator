public class Template {
    public static StringBuilder template = new StringBuilder("""
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
                        
            \\section{Introduction}
                        
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.
                        
            \\section{Methods}
                        
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.
                        
            \\subsection{Experimental Design}
                        
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.
                        
            \\subsection{Data Analysis}
                        
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.
                        
            \\section{Results}
                        
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.
                        
            \\subsection{Figure Example}
                        
            Figure~\\ref{fig:example} shows an example of a figure.
                        
            \\begin{figure}[h]
              \\centering
              \\includegraphics[width=0.5\\textwidth]{example-image-a}
              \\caption{Example of a figure}
              \\label{fig:example}
            \\end{figure}
                        
            \\section{Discussion}
                        
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.
                        
            \\section{Conclusion}
                        
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.
                        
            \\bibliography{references} % Specifies the bibliography file
            \\bibliographystyle{ieeetr} % Specifies the
                        
            \\end{document}
            """);


}
