package dao.xml;

import bilioteca2.pkg0.Livro;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
      fout = new FileOutputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\GerenciaBiblioteca\\GereciaBilioteca\\04-final-livros.xml");
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
      FileInputStream fis = new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\GerenciaBiblioteca\\GereciaBilioteca\\04-final-livros.xml");
      BufferedInputStream bis = new BufferedInputStream(fis);
      XMLDecoder xmlDecoder = new XMLDecoder(bis);
      livros = (HashMap<Integer, Livro>) xmlDecoder.readObject();
    } catch (Exception e)
    {
      System.out.println("erro ao ler");
    }
    return livros;
  }

}
