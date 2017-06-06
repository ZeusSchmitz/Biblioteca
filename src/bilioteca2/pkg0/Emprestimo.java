package bilioteca2.pkg0;

import dao.xml.LivroDAO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Emprestimo
{

  AlunoDAO p = new AlunoDAO();
//  LivroDAO l = new LivroDAO();
  Aluno aluno = new Aluno();

  public String verifica_aluno(String matricula)
  {

    HashMap<String, Aluno> aluno_map = p.Ler_Aluno();
    Set<String> chaves = aluno_map.keySet();

    boolean existeMatr = chaves.containsAll(chaves);

    System.out.println((existeMatr == true)? "Aluno cadastrado: " + aluno_map.get(matricula).getNome():"Aluno não cadastrado");
    
    return aluno_map.get(matricula).getNome();
  }

  public Livro verifica_livro()
  {
    return null;
  }
}
