package br.senai.sp.jandira.arrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

	public boolean escrever(String caminho, String conteudo) {

		// executa uma ação
		try {

			FileWriter arquivo = new FileWriter(caminho);
			PrintWriter gravarArquivo = new PrintWriter(arquivo);

			gravarArquivo.append(conteudo);
			gravarArquivo.close();

			return true;

			// exibe o erro se o try não executar
		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());
			return false;
		}
	}

	public String ler(String caminho) {

		String conteudo = "";

		try {
			// abre o arquivo
			FileReader arquivo = new FileReader(caminho);
			// armazena o conteúdo do arquivo em memótia
			BufferedReader conteudoArquivo = new BufferedReader(arquivo);

			// Recupera os dados do arquivo
			try {
				String linha = "";
				linha = conteudoArquivo.readLine();
				while (linha != null) {

					// conteudo + linha;
					conteudo += linha + "\n";
					linha = conteudoArquivo.readLine();

				}
				conteudoArquivo.close();
				return conteudo;
			} catch (IOException e) {
				System.out.println("ERRO: " + e.getMessage());
				return "";
			}

		} catch (FileNotFoundException e) {
			System.out.println("ERRO: " + e.getMessage());
			return "";
		}
	}

}
