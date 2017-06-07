package bilioteca2.pkg0;

import java.util.HashMap;
import java.util.Set;
import dao.xml.LivroDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo
{
  private int codigoBarras;
  private int exemplar;
  private String nomeAluno;
  private String diaEmpr;
  private String diaEntrg;

  public String getNomeAluno()
  {
    return nomeAluno;
  }

  public void setNomeAluno(String nomeAluno)
  {
    this.nomeAluno = nomeAluno;
  }

  public String getDiaEmpr()
  {
    return diaEmpr;
  }

  public void setDiaEmpr(String diaEmpr)
  {
    this.diaEmpr = diaEmpr;
  }

  public String getDiaEntrg()
  {
    return diaEntrg;
  }

  public void setDiaEntrg(String diaEntrg)
  {
    this.diaEntrg = diaEntrg;
  }

  public Emprestimo()
  {
  }

  public Emprestimo(int codigoBarras, int exemplar)
  {
    this.codigoBarras = codigoBarras;
    this.exemplar = exemplar;
  }

  public int getCodigoBarras()
  {
    return codigoBarras;
  }

  public void setCodigoBarras(int codigoBarras)
  {
    this.codigoBarras = codigoBarras;
  }

  public int getExemplar()
  {
    return exemplar;
  }

  public void setExemplar(int exemplar)
  {
    this.exemplar = exemplar;
  }
  
  AlunoDAO p = new AlunoDAO();
  LivroDAO l = new LivroDAO();
  Aluno aluno = new Aluno();
  EmprestimoDAO e = new EmprestimoDAO();

  public String verifica_aluno(String matricula)
  {

    HashMap<String, Aluno> aluno_map = p.Ler_Aluno();
    Set<String> chaves = aluno_map.keySet();
    String resultado;
    
    boolean existeMatr = chaves.contains(matricula);

    if(existeMatr)
    {
      resultado =  "Aluno: " + aluno_map.get(matricula).getNome() + " | Matricula: " + aluno_map.get(matricula).getMatricula();
    }
    else
    {
      resultado = "Aluno não cadastrado";
    }
    return resultado;
  }

  public void verifica_livro(int codigoBarras, int exemplar, String nomeAluno)
  {
    HashMap<Integer, Livro> livro_map = l.lerLivros();
    Set<Integer> chaves = livro_map.keySet();
    
    boolean existeLivro = chaves.contains(codigoBarras);
    
    if(existeLivro)
    {
      verificaEmprestimo(codigoBarras, exemplar, nomeAluno);
    }
    else
    {
      System.out.println("Livro não cadástrado");
    }
//    existeLivro == true ? verificaEmprestimo(codigoBarras, exemplar);: ; //"Título: " + livro_map.get(codigoBarras).getTitulo() + " - Exemplar:" + livro_map.get(codigoBarras).getExemplar()
    
 //   return livro_map.get(codigoBarras).getTitulo();
  }
  
  public String verificaEmprestimo(int codigoBarras, int exemplar, String nomeAluno)
  {
    String resultado = null;
    HashMap<Integer, Emprestimo> empr_map = e.Ler_Emprestimo();
    Set<Integer> chavesEmpr = empr_map.keySet();
    
    boolean codPedido = chavesEmpr.contains(codigoBarras);
    
    if(codPedido)
    {
      resultado = "Livro emprestado no momento";
    }
    else
    {
      efetuaEmprestimo(codigoBarras, exemplar, nomeAluno);
    }
    return resultado;
  }

  private void efetuaEmprestimo(int codigoBarras, int exemplar, String nomeAluno)
  {
    EmprestimoDAO salvarEmpr = new EmprestimoDAO();
    Emprestimo emp = new Emprestimo();
    Date data = new Date();
    HashMap<Integer, Emprestimo> empr_map = e.Ler_Emprestimo(); 
    SimpleDateFormat fomatador = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = Calendar.getInstance();
    cal.setTime(data);
    cal.add(cal.DAY_OF_MONTH, + 10);

    emp.setCodigoBarras(codigoBarras);
    emp.setExemplar(exemplar);
    emp.setNomeAluno(nomeAluno);
    emp.setDiaEmpr(fomatador.format(data));
    emp.setDiaEntrg(fomatador.format(cal.getTime()));
    empr_map.put(emp.getCodigoBarras(), emp);
    salvarEmpr.Gravar_Emprestimo(empr_map);
  }
}
