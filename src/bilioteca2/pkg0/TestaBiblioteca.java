package bilioteca2.pkg0;

import dao.xml.LivroDAO;
import dao.AlunoDAO;
import excecoes.DaoDataException;

public class TestaBiblioteca
{

  public static void main(String[] args) throws DaoDataException
  {
    LivroDAO livro = new LivroDAO();
    Biblioteca biblioteca = new Biblioteca();
    AlunoDAO alunoDao = new AlunoDAO();
    Aluno aluno = alunoDao.buscaAluno("1897");
    
    System.out.println(aluno);
//    livro.verifica_livro(new Livro(97493655, 309817, 2, "30/01/2016", "28/09/2016", "530.8", "Oi", "Cara", "UHUU", "28/09/2016", "1234", "SeiNao", 0), new Aluno("Zeus", "TADS", "1987")); //Introdução à administração
//    biblioteca.devolverEmprestimo(97453545);    
  }
}
