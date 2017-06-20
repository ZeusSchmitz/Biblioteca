package bilioteca2.pkg0;

import dao.EmprestimoDAO;
import excecoes.DaoDataException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Biblioteca
{
  EmprestimoDAO empDao = new EmprestimoDAO();

  public void efetuaEmprestimo(Livro codigoBarras, Aluno nomeAluno)
  {
    Emprestimo emp = new Emprestimo();
    Date data = new Date();
    HashMap<Integer, Emprestimo> empr_map = empDao.Ler_Emprestimo(); 
    SimpleDateFormat fomatador = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = Calendar.getInstance();
    cal.setTime(data);
    cal.add(cal.DAY_OF_MONTH, + 10);

    emp.setCodigoBarras(codigoBarras);
    emp.setNomeAluno(nomeAluno);
    emp.setDiaEmpr(fomatador.format(data));
    emp.setDiaEntrg(fomatador.format(cal.getTime()));
    empr_map.put(emp.getCodigoBarras().getCodigoDeBarras(), emp);
    empDao.Gravar_Emprestimo(empr_map);
  }
  
  public void devolverEmprestimo(int codigoBarras) throws excecoes.DaoDataException
  {
    HashMap<Integer, Emprestimo> empr_map = empDao.Ler_Emprestimo();
    
    if(empr_map.containsKey(codigoBarras))
    {
      empr_map.remove(codigoBarras);
      empDao.Gravar_Emprestimo(empr_map);
      System.out.println("Devolução concluída"); 
    }
    else
    {
      throw new DaoDataException("Emprestimo inexistente"); 
    }
  }
}
