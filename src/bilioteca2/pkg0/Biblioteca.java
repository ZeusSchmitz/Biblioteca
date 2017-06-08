package bilioteca2.pkg0;

import dao.EmprestimoDAO;
import dao.AlunoDAO;
import dao.xml.LivroDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Biblioteca
{
  EmprestimoDAO empDao = new EmprestimoDAO();

  public void efetuaEmprestimo(int codigoBarras, int exemplar, String nomeAluno)
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
