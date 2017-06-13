package dao.bin;

import bilioteca2.pkg0.Livro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class LivroDAO
{

  public void importa_livros() throws FileNotFoundException
  {
    HashMap<Integer, Livro> importLivro = new HashMap<>();
    Scanner file = new Scanner(new File("C:\\GereciaBilioteca\\final-livros-linux.csv"), "UTF-8");
    while (file.hasNextLine())
    {
      String linha = file.nextLine();
      String[] colunas = linha.split("\\|");
      try
      {
        Livro l = new Livro(Integer.parseInt(colunas[0]), Integer.parseInt(colunas[1]), Integer.parseInt(colunas[2]),
                colunas[3], colunas[4], colunas[5], colunas[6], colunas[7], colunas[8], colunas[9], colunas[10],
                colunas[11], Integer.parseInt(colunas[12]));
        importLivro.put(l.getCodigoDeBarras(), l);
      } catch (Exception e)
      {
        System.out.println("Linha com erro");
      }

    }
  }

  public void saveAllLivrosBIN(HashMap<Integer, Livro> livros)
  {
    FileOutputStream fout = null;
    try
    {
      fout = new FileOutputStream("C:\\GereciaBilioteca\\04-final-livros.ser");

      ObjectOutputStream oos = new ObjectOutputStream(fout);
      oos.writeObject(livros);
    } catch (Exception ex)
    {
      System.out.println("Erro: " + ex.getMessage());
    }
  }

  public HashMap<String, Livro> lerBIN()
  {
    ObjectInputStream ios = null;
    HashMap<String, Livro> livros = new HashMap();
    try
    {
      ios = new ObjectInputStream(new FileInputStream("C:\\GereciaBilioteca\\04-final-livros.ser"));
      while ((livros = (HashMap<String, Livro>) ios.readObject()) != null)
      {
        System.out.println("lendo dados...");
      }
    } catch (Exception e)
    {

      System.out.println("erro ao ler");
    }
    finally
    {
      try
      {
        ios.close();
      } catch (Exception ex)
      {
        System.out.println("nao consegui fechar");
      }
    }
    return livros;
  }
}
