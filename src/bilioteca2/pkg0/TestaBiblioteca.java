package bilioteca2.pkg0;

import dao.xml.LivroDAO;
import dao.AlunoDAO;
import dao.EmprestimoDAO;
import excecoes.DaoDataException;

public class TestaBiblioteca
{

  public static void main(String[] args)
  {
    LivroDAO livroDao = new LivroDAO();
    Biblioteca biblioteca = new Biblioteca();
    AlunoDAO alunoDao = new AlunoDAO();
    EmprestimoDAO emprestimo = new EmprestimoDAO();

    System.out.println("Busca aluno cadastrado");
    try
    {
      Aluno aluno = alunoDao.buscaAluno("1987");
      System.out.println(aluno);
    } catch (DaoDataException error)
    {
      System.out.println(error.getMessage());
    }

    System.out.println("---------------------------");

    System.out.println("Chama erro aluno não cadastrado");
    try
    {
      Aluno aluno = alunoDao.buscaAluno("1897");
      System.out.println(aluno);
    } catch (DaoDataException error)
    {
      System.out.println(error.getMessage());
    }

    System.out.println("----------------------");
    System.out.println("Efetua emprestimo 100%");
    try
    {
      Aluno aluno = alunoDao.buscaAluno("1987");
      Livro livro = livroDao.buscaLivroCodigo(97453551);
      emprestimo.verificaEmprestimo(livro, aluno);
    } 
    catch (DaoDataException error)
    {
      System.out.println(error.getMessage());
    }

    System.out.println("---------------------------------");
    System.out.println("Chama erro de livro já emprestado");
    try
    {
      Aluno aluno = alunoDao.buscaAluno("1987");
      Livro livro = livroDao.buscaLivroCodigo(97453551);
      emprestimo.verificaEmprestimo(livro, aluno);
    } 
    catch (DaoDataException error)
    {
      System.out.println(error.getMessage());
    }

    System.out.println("--------------------------------------------------------");
    System.out.println("Chama erro de Aluno não cadastrado ao efetuar emprestimo");
    try
    {
      Aluno aluno = alunoDao.buscaAluno("1897");
      Livro livro = livroDao.buscaLivroCodigo(974535513);
      emprestimo.verificaEmprestimo(livro, aluno);
    } 
    catch (DaoDataException error)
    {
      System.out.println(error.getMessage());
    }

    System.out.println("-------------------------------------------------------------------");
    System.out.println("Chama erro de Livro não cadastrado no sistema ao efetuar emprestimo");
    try
    {
      Aluno aluno = alunoDao.buscaAluno("1987");
      Livro livro = livroDao.buscaLivroCodigo(974535513);
      emprestimo.verificaEmprestimo(livro, aluno);
    } 
    catch (DaoDataException error)
    {
      System.out.println(error.getMessage());
    }

    System.out.println("-------------------------");
    System.out.println("Efetua Devolução de livro");
    try
    {
      biblioteca.devolverEmprestimo(97453551);    
    } catch (DaoDataException error)
    {
      System.out.println(error.getMessage());
    }

    System.out.println("-------------------------");
    System.out.println("Chama erro de Emprestimo inexistente");
    try
    {
      biblioteca.devolverEmprestimo(97453551);    
    } catch (DaoDataException error)
    {
      System.out.println(error.getMessage());
    }
  }
}
