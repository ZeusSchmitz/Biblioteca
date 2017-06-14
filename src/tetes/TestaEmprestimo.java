package tetes;

import bilioteca2.pkg0.Aluno;
import bilioteca2.pkg0.Emprestimo;
import dao.EmprestimoDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import bilioteca2.pkg0.Livro;
import dao.AlunoDAO;
import dao.xml.LivroDAO;
import excecoes.DaoDataException;


public class TestaEmprestimo
{
  public static void main(String[] args) throws DaoDataException
  {
    Date data = new Date();
    SimpleDateFormat fomatador = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = Calendar.getInstance();
    HashMap valor = new HashMap();
    EmprestimoDAO salvaEmpre = new EmprestimoDAO();
    LivroDAO livroDao = new LivroDAO();
    AlunoDAO alunoDao = new AlunoDAO();
    Aluno aluno1 = alunoDao.buscaAluno("1987");
    Aluno aluno2 = alunoDao.buscaAluno("1997");
    Aluno aluno3 = alunoDao.buscaAluno("1898");
    Livro livro = livroDao.buscaLivroCodigo(97453551);
    Livro livro2 = livroDao.buscaLivroCodigo(97453550);
    Livro livro3 = livroDao.buscaLivroCodigo(97500927);
    cal.setTime(data); //Pega a data do PC
    cal.add(cal.DAY_OF_MONTH, + 10); //Add a data atual +10, que é o prazo de entrega
    
    ///////////////////////////////////  EMPRESTIMO 1  ///////////////////////////////////////
    Emprestimo empres1 = new Emprestimo(livro, aluno1, fomatador.format(data), fomatador.format(cal.getTime()));
    valor.put(empres1.getCodigoBarras(), empres1);
    salvaEmpre.Gravar_Emprestimo(valor);
    ///////////////////////////////////  EMPRESTIMO 2  ///////////////////////////////////////
    Emprestimo empres2 = new Emprestimo(livro2, aluno2, fomatador.format(data), fomatador.format(cal.getTime()));
    valor.put(empres2.getCodigoBarras(), empres2);
    salvaEmpre.Gravar_Emprestimo(valor);
    ///////////////////////////////////  EMPRESTIMO 3  ///////////////////////////////////////
    Emprestimo empres3 = new Emprestimo(livro3, aluno3, fomatador.format(data), fomatador.format(cal.getTime()));
    valor.put(empres3.getCodigoBarras(), empres3);
    salvaEmpre.Gravar_Emprestimo(valor);
  } 
}
