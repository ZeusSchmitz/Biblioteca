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
    Aluno aluno = new Aluno();
    HashMap valor = new HashMap();
    AlunoDAO salvaAluno = new AlunoDAO();
    
/*    aluno.setNome("Zeus");
    aluno.setCurso("TADS");
    aluno.setEndereco("Bonifácio");
    aluno.setTelefone("999");
    aluno.setMatricula("1987");
    valor.put(aluno.getMatricula(), aluno);
    salvaAluno.Gravar_aluno(valor); 
    
    aluno.setNome("Ivon");
    aluno.setCurso("TADS");
    aluno.setEndereco("Bonifácio");
    aluno.setTelefone("999");
    aluno.setMatricula("1895");
    valor.put(aluno.getMatricula(), aluno);
    salvaAluno.Gravar_aluno(valor); 

    aluno.setNome("Zec");
    aluno.setCurso("TADS");
    aluno.setEndereco("Bonifácio");
    aluno.setTelefone("999");
    aluno.setMatricula("1997");
    valor.put(aluno.getMatricula(), aluno);
    salvaAluno.Gravar_aluno(valor);*/
    
    Emprestimo empres = new Emprestimo();
    System.out.println(empres.verifica_aluno("1895"));
    
    
  }
  
}
