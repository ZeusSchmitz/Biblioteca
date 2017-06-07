package bilioteca2.pkg0;

import dao.xml.LivroDAO;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Bilioteca20
{

  public static void main(String[] args)
  {
    Date data = new Date();
    SimpleDateFormat fomatador = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = Calendar.getInstance();
    //Emprestimo emprestimo = new Emprestimo();
//    Livro livro = new Livro(1, 1, 2, "12", "12", "zec", "zec", "zec", "zec", "zec", "12", 0, "zec", 0);
//    LivroDAO salvaLivro = new LivroDAO();
//    ArrayList<Livro> livros = salvaLivro.carregarLivros("C:\\Users\\User\\Documents\\NetBeansProjects\\GerenciaBiblioteca\\GereciaBilioteca\\04-final-livros.csv");
//    livros.add(livro);
//    XmlDao xmlDao = new XmlDao();
//    xmlDao.saveAllLivrosXML(livro);
//    System.out.println(livro);
    
    Aluno aluno = new Aluno();
    Aluno aluno2 = new Aluno();
    Aluno aluno3 = new Aluno();
    HashMap valor = new HashMap();
    AlunoDAO salvaAluno = new AlunoDAO();
    EmprestimoDAO salvaEmpre = new EmprestimoDAO();

/*    aluno.setNome("Zeus");
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
    
    cal.setTime(data);
    cal.add(cal.DAY_OF_MONTH, + 10);
    Emprestimo empres = new Emprestimo();
    Emprestimo empres2 = new Emprestimo();
    Emprestimo empres3 = new Emprestimo();
    
    empres.setCodigoBarras(97453551);
    empres.setExemplar(9);
    empres.setNomeAluno("Zeus");
    empres.setDiaEmpr(fomatador.format(data));
    empres.setDiaEntrg(fomatador.format(cal.getTime()));
    valor.put(empres.getCodigoBarras(), empres);
    salvaEmpre.Gravar_Emprestimo(valor);
    
    empres2.setCodigoBarras(97453550);
    empres2.setExemplar(8);
    empres2.setNomeAluno("Zec");
    empres2.setDiaEmpr(fomatador.format(data)); 
    empres2.setDiaEntrg(fomatador.format(cal.getTime()));
    valor.put(empres2.getCodigoBarras(), empres2);
    salvaEmpre.Gravar_Emprestimo(valor);
    
    empres3.setCodigoBarras(97500927);
    empres3.setExemplar(1);
    empres3.setNomeAluno("Ivon");
    empres3.setDiaEmpr(fomatador.format(data));
    empres3.setDiaEntrg(fomatador.format(cal.getTime()));
    valor.put(empres3.getCodigoBarras(), empres3);
    salvaEmpre.Gravar_Emprestimo(valor);*/

    Emprestimo empres = new Emprestimo();
    System.out.println(empres.verifica_aluno("1895"));
    empres.verifica_livro(97453543, 1, "Schmitz"); //Introdução à administração
    
    
  }
  
}
