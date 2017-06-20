package tetes;

import bilioteca2.pkg0.Livro;
import dao.xml.LivroDAO;
import excecoes.DaoDataException;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class TestaCadastroLivro
{

  public static void main(String[] args) {
    LivroDAO livroDao = new LivroDAO();
    Livro livro = new Livro(97453562, 300198, 11, "24/10/2014", "21/11/2014", "658 M464i Ac.300198", "ADMINISTRAÇÃO GERAL E DE EMPRESAS", "MAXIMIANO, Antonio Cesar Amaru.", "Introdução à administração.", "2011", "9788522466221", "2. ed. rev. atual. São Paulo: Atlas", 333);
      
    try
    {
      livroDao.incluiLivro(livro);      
    }
    catch(FileNotFoundException ex)
    {
      System.out.println("Arquivo não encontrado " + ex.getMessage());
    }
    catch(DaoDataException error)
    {
      System.out.println(error.getMessage());
    }
  }
}
