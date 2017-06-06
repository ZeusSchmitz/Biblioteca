package bilioteca2.pkg0;

import dao.xml.LivroDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Bilioteca20
{

  public static void main(String[] args)
  {
    //Emprestimo emprestimo = new Emprestimo();
//    Livro livro = new Livro(1, 1, 2, "12", "12", "zec", "zec", "zec", "zec", "zec", "12", 0, "zec", 0);
//    LivroDAO salvaLivro = new LivroDAO();
//    ArrayList<Livro> livros = salvaLivro.carregarLivros("C:\\Users\\User\\Documents\\NetBeansProjects\\GerenciaBiblioteca\\GereciaBilioteca\\04-final-livros.csv");
//    livros.add(livro);
//    XmlDao xmlDao = new XmlDao();
//    xmlDao.saveAllLivrosXML(livro);
//    System.out.println(livro);
    
/*    Aluno aluno = new Aluno();
    Aluno aluno2 = new Aluno();
    Aluno aluno3 = new Aluno();
    HashMap valor = new HashMap();
    AlunoDAO salvaAluno = new AlunoDAO();
    EmprestimoDAO salvaEmpre = new EmprestimoDAO();

    aluno.setNome("Zeus");
    aluno.setCurso("TADS");
    aluno.setEndereco("Bonifácio");
    aluno.setTelefone("999");
    aluno.setMatricula("1987");
    valor.put(aluno.getMatricula(), aluno);
    salvaAluno.Gravar_aluno(valor); 
    
    aluno2.setNome("Ivon");
    aluno2.setCurso("TADS");
    aluno2.setEndereco("Bonifácio");
    aluno2.setTelefone("999");
    aluno2.setMatricula("1895");
    valor.put(aluno2.getMatricula(), aluno2);
    salvaAluno.Gravar_aluno(valor); 

    aluno3.setNome("Zec");
    aluno3.setCurso("TADS");
    aluno3.setEndereco("Bonifácio");
    aluno3.setTelefone("999");
    aluno3.setMatricula("1997");
    valor.put(aluno3.getMatricula(), aluno3);
    salvaAluno.Gravar_aluno(valor);
    
    
    Emprestimo empres2 = new Emprestimo();
    Emprestimo empres3 = new Emprestimo();
    
    empres.setCodigoBarras(97453551);
    empres.setExemplar(9);
    valor.put(empres.getCodigoBarras(), empres);
    salvaEmpre.Gravar_Emprestimo(valor);
    
    empres2.setCodigoBarras(97453550);
    empres2.setExemplar(8);
    valor.put(empres2.getCodigoBarras(), empres2);
    salvaEmpre.Gravar_Emprestimo(valor);
    
    empres3.setCodigoBarras(97500927);
    empres3.setExemplar(1);
    valor.put(empres3.getCodigoBarras(), empres3);
    salvaEmpre.Gravar_Emprestimo(valor);*/

    Emprestimo empres = new Emprestimo();
    System.out.println(empres.verifica_aluno("1895"));
    System.out.println(empres.verifica_livro(97453551)); //Introdução à administração
    
    
  }
  
}
