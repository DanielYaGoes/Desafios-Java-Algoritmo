package Exercicio02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManipucaoArquivos {

    public static void main(String[] args) throws IOException{

        Path input= Paths.get("src/main/resources/exercicio2/input.txt");
        Path output = Paths.get("src/main/resources/exercicio2/output.txt");

        try (Stream<String> linhas = Files.lines(input)){
            List<String> linhasNaoVazias = linhas.filter(linha -> !linha.trim().isEmpty()).collect(Collectors.toList());

            Files.write(output,linhasNaoVazias);
        }
    }
}
