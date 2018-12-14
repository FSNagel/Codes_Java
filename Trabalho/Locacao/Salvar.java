import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Salvar{
	public void registrar(String arquivo, String linha, boolean reescrever){
		String[] ultimoRegistro = {"0"};
		int ultimoId = 1;

		try{
			FileReader arqLeitura = new FileReader(arquivo);
			BufferedReader bufferLeitura = new BufferedReader(arqLeitura);

			while(bufferLeitura.ready()){
				ultimoRegistro = bufferLeitura.readLine().split(";");
			}

			if(ultimoRegistro[0] != "0"){
				ultimoId = Integer.valueOf(ultimoRegistro[0]);
				ultimoId++;
			}

			bufferLeitura.close();
			arqLeitura.close();

		} catch (IOException e){
			System.out.println("O arquivo " + arquivo + " nao foi encontrado, criando o arquivo " + arquivo + "...");
		}

		try{
			System.out.println("\nGravando ...");

			FileWriter arqGravacao;

			if(ultimoId != 1 && reescrever){
				arqGravacao = new FileWriter(arquivo, true);
			} else {
				arqGravacao = new FileWriter(arquivo);
			}

			BufferedWriter buffer = new BufferedWriter(arqGravacao);

			linha = ultimoId + ";" + linha;
			buffer.write(linha);
			buffer.newLine();
			buffer.flush();

			buffer.close();
			arqGravacao.close();
			System.out.println("Gravacao Concluida!\n");
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public String[] consultar(String arquivo){
		String[] arrayDados = new String[50];
		String linha = "0";

		try{
			FileReader arqLeitura = new FileReader(arquivo);
			BufferedReader bufferLeitura = new BufferedReader(arqLeitura);

			for (int i = 0;  bufferLeitura.ready(); i++) {
				linha = bufferLeitura.readLine();
				arrayDados[i] = linha;
			}

			bufferLeitura.close();
			arqLeitura.close();


		} catch(IOException e){
			System.out.println("Nao existem registros ou o arquivo nao foi encontrado!");
		}

		return arrayDados;
	}


	public void atualizar(String arquivo, String linhaAtualizar){
		String[] arrayList = new String[50];
		arrayList = this.consultar(arquivo);
		String[] arrayDados = new String[50];
		String linha;
		int idAtualizar;

		arrayDados  = linhaAtualizar.split(";");
		idAtualizar = Integer.valueOf(arrayDados[0]);

		try{
			System.out.println("\nAtualizando " + arquivo + " ..." );

			FileWriter arqGravacao;

			arqGravacao = new FileWriter(arquivo);

			BufferedWriter buffer = new BufferedWriter(arqGravacao);

			for (int i = 0; arrayList[i] != null; i++) {
				
				arrayDados = arrayList[i].split(";");


				if(Integer.valueOf(arrayDados[0]) == idAtualizar){
					System.out.println("Registro encontrado... Atualizado.");
					linha = linhaAtualizar;
				} else {
					linha = arrayList[i];
				}

				buffer.write(linha);
				buffer.newLine();
				buffer.flush();
			}

			buffer.close();
			arqGravacao.close();
			System.out.println("Gravacao Concluida!\n");
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}