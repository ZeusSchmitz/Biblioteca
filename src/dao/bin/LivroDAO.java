package dao.bin;

import bilioteca2.pkg0.Livro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class LivroDAO
{

  public void importa_livros()
  {
    HashMap<Integer, Livro> importLivro = new HashMap<>();
    try
    {
      Scanner file = new Scanner(new File("C:\\GereciaBilioteca\\final-livros-linux.csv"), "UTF-8");
      while (file.hasNextLine())
      {
        String linha = file.nextLine();
        Livro l = new Livro();
        String[] colunas = linha.split("\\|");
        try
        {
          l.setCodigoDeBarras(Integer.parseInt(colunas[0]));
          l.setIdLivro(Integer.parseInt(colunas[1]));
          l.setExemplar(Integer.parseInt(colunas[2]));
          l.setDataAquisicaoExemplar(colunas[3]);
          l.setDataCadastroSistema(colunas[4]);
          l.setClassificacao(colunas[5]);
          l.setAreaConhecimento(colunas[6]);
          l.setAutor(colunas[7]);
          l.setTitulo(colunas[8]);
          l.setAno(colunas[9]);
          l.setIsbn(colunas[10]);
          l.setEditora(colunas[11]);
          l.setPaginas(Integer.parseInt(colunas[12]));
          importLivro.put(l.getCodigoDeBarras(), l);

        } catch (Exception e)
        {
          System.out.println("Linha com erro");
        }

      }
      saveAllLivrosBIN(importLivro);
    } catch (Exception e)

    {
      e.printStackTrace();
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
