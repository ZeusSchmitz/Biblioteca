package tetes;

import bilioteca2.pkg0.Emprestimo;
import dao.EmprestimoDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TestaEmprestimo
{
  public static void main(String[] args)
  {
    Date data = new Date();
    SimpleDateFormat fomatador = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = Calendar.getInstance();
    HashMap valor = new HashMap();
    EmprestimoDAO salvaEmpre = new EmprestimoDAO();
    cal.setTime(data); //Pega a data do PC
    cal.add(cal.DAY_OF_MONTH, + 10); //Add a data atual +10, que é o prazo de entrega

    ///////////////////////////////////  EMPRESTIMO 1  ///////////////////////////////////////
    Emprestimo empres1 = new Emprestimo(97453551, 9, "Zeus", fomatador.format(data), fomatador.format(cal.getTime()));
    valor.put(empres1.getCodigoBarras(), empres1);
    salvaEmpre.Gravar_Emprestimo(valor);
    ///////////////////////////////////  EMPRESTIMO 2  ///////////////////////////////////////
    Emprestimo empres2 = new Emprestimo(97453550, 8, "Zec", fomatador.format(data), fomatador.format(cal.getTime()));
    valor.put(empres2.getCodigoBarras(), empres2);
    salvaEmpre.Gravar_Emprestimo(valor);
    ///////////////////////////////////  EMPRESTIMO 3  ///////////////////////////////////////
    Emprestimo empres3 = new Emprestimo(97500927, 1, "Ivon", fomatador.format(data), fomatador.format(cal.getTime()));
    valor.put(empres3.getCodigoBarras(), empres3);
    salvaEmpre.Gravar_Emprestimo(valor);
  } 
}
