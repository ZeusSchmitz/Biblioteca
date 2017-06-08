package dao.xml;

import bilioteca2.pkg0.Livro;
import dao.EmprestimoDAO;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LivroDAO
{
  public void verifica_livro(int codigoBarras, int exemplar, String nomeAluno)
  {
    HashMap<Integer, Livro> livro_map = lerLivros();
    Set<Integer> chaves = livro_map.keySet();
    EmprestimoDAO empDao = new EmprestimoDAO();
    
    boolean existeLivro = chaves.contains(codigoBarras);
    
    if(existeLivro)
    {
      empDao.verificaEmprestimo(codigoBarras, exemplar, nomeAluno);
    }
    else
    {
      System.out.println("Livro não cadástrado");
    }
  }
  
  public void importa_livros()
  {
    HashMap<Integer, Livro> importLivro = new HashMap<>();
    try
    {
      Scanner file = new Scanner(new File("C:\\GereciaBilioteca\\final-livros-linux.csv"), "UTF-8");
      while (file.hasNextLine())
      {
        String linha = file.nextLine();
        String[] colunas = linha.split("\\|");
        try
        { 
          Livro l2 = new Livro(Integer.parseInt(colunas[0]), Integer.parseInt(colunas[1]), Integer.parseInt(colunas[2]),
                  colunas[3], colunas[4], colunas[5], colunas[6], colunas[7], colunas[8], colunas[9], colunas[10],
                  colunas[11], Integer.parseInt(colunas[12]));
          importLivro.put(l2.getCodigoDeBarras(), l2);
        } catch (Exception e)
        {
          System.out.println("Linha com erro");
        }

      }
      saveAllLivrosXML(importLivro);
    } catch (Exception e)

    {
      e.printStackTrace();
    }

  }

  public void saveAllLivrosXML(HashMap<Integer, Livro> livros)
  {
    HashMap<Integer, Livro> livroImportado = livros;
    FileOutputStream fout = null;
    try
    {
      fout = new FileOutputStream("C:\\GereciaBilioteca\\04-final-livros.xml");
      BufferedOutputStream bos = new BufferedOutputStream(fout);
      try (XMLEncoder xmlEncoder = new XMLEncoder(bos))
      {
        xmlEncoder.writeObject(livroImportado);
        xmlEncoder.close();
      }
    } catch (Exception ex)
    {
      System.out.println("Erro: " + ex.getMessage());
    }
  }

  public HashMap<Integer, Livro> lerLivros()
  {
    HashMap<Integer, Livro> livros = new HashMap();
    try
    {
      FileInputStream fis = new FileInputStream("C:\\GereciaBilioteca\\04-final-livros.xml");
      BufferedInputStream bis = new BufferedInputStream(fis);
      XMLDecoder xmlDecoder = new XMLDecoder(bis);
      livros = (HashMap<Integer, Livro>) xmlDecoder.readObject();
    } catch (Exception e)
    {
      System.out.println("Erro ao ler");
    }
    return livros;
  }

}
