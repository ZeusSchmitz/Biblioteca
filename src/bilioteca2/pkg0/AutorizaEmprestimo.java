package bilioteca2.pkg0;

import dao.EmprestimoDAO;
import dao.AlunoDAO;
import dao.xml.LivroDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class AutorizaEmprestimo
{
  AlunoDAO alunoDao = new AlunoDAO();
  LivroDAO livroDao = new LivroDAO();
  Aluno aluno = new Aluno();
  EmprestimoDAO empDao = new EmprestimoDAO();

  public String verifica_aluno(String matricula)
  {

    HashMap<String, Aluno> aluno_map = alunoDao.Ler_Aluno();
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
    HashMap<Integer, Livro> livro_map = livroDao.lerLivros();
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
  }
  
  public void verificaEmprestimo(int codigoBarras, int exemplar, String nomeAluno)
  {
    HashMap<Integer, Emprestimo> empr_map = empDao.Ler_Emprestimo();
    Set<Integer> chavesEmpr = empr_map.keySet();
    
    boolean codPedido = chavesEmpr.contains(codigoBarras);
    
    if(codPedido)
    {
      System.out.println("Exemplar indisponivel no momento"); 
    }
    else
    {
      efetuaEmprestimo(codigoBarras, exemplar, nomeAluno);
      System.out.println("Emprestimo efetuado com sucesso"); 
    }
  }

  private void efetuaEmprestimo(int codigoBarras, int exemplar, String nomeAluno)
  {
    Emprestimo emp = new Emprestimo();
    Date data = new Date();
    HashMap<Integer, Emprestimo> empr_map = empDao.Ler_Emprestimo(); 
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
    empDao.Gravar_Emprestimo(empr_map);
  }
  
  public void devolverEmprestimo(int codigoBarras)
  {
    HashMap<Integer, Emprestimo> empr_map = empDao.Ler_Emprestimo();
    Set<Integer> chavesEmpr = empr_map.keySet();
    
    boolean codPedido = chavesEmpr.contains(codigoBarras);
    
    if(codPedido)
    {
      empr_map.remove(codigoBarras);
      empDao.Gravar_Emprestimo(empr_map);
      System.out.println("Devolução concluída"); 
    }
    else
    {
      System.out.println("Emprestimo inexistente"); 
    }
  }
}
