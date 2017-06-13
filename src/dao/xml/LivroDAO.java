package dao.xml;

import bilioteca2.pkg0.Aluno;
import bilioteca2.pkg0.Livro;
import dao.EmprestimoDAO;
import excecoes.DaoDataException;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LivroDAO
{

  public void verifica_livro(Livro codigoBarras, Aluno nomeAluno) throws DaoDataException
  {
    HashMap<Integer, Livro> livro_map = lerLivros();
//    Set<Integer> chaves = livro_map.keySet();
    EmprestimoDAO empDao = new EmprestimoDAO();

  //  boolean existeLivro = chaves.contains(codigoBarras);

    if (livro_map.containsKey(codigoBarras.getCodigoDeBarras()))
    {
      empDao.verificaEmprestimo(codigoBarras, nomeAluno);
    }
    else
    {
      throw new DaoDataException("Livro não cadástrado");
    }
  }

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
    saveAllLivrosXML(importLivro);
  }

  public void saveAllLivrosXML(HashMap<Integer, Livro> livros) throws FileNotFoundException
  {
    HashMap<Integer, Livro> livroImportado = livros;
    FileOutputStream fout = null;
      fout = new FileOutputStream("C:\\GereciaBilioteca\\04-final-livros.xml");
      BufferedOutputStream bos = new BufferedOutputStream(fout);
      try (XMLEncoder xmlEncoder = new XMLEncoder(bos))
      {
        xmlEncoder.writeObject(livroImportado);
        xmlEncoder.close();
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

  public Livro buscaLivroCodigo(int codigoBarras) throws DaoDataException
  {
    HashMap<Integer, Livro> livro_map = lerLivros();
    if(livro_map.containsKey(codigoBarras))
      return livro_map.get(codigoBarras);
    else
      throw new DaoDataException("Livro não encontrado");
  }
}
