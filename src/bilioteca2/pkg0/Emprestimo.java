package bilioteca2.pkg0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Emprestimo
{

  AlunosDAO p = new AlunosDAO();
  LivroDAO l = new LivroDAO();
  Alunos aluno = new Alunos();

//  private Alunos aluno = null;
//  private Livro libro = null;

  public Alunos verifica_aluno(int matricula)
  {

    HashMap<String, Alunos> aluno_map = p.Ler_Aluno();
    Set<String> chaves = aluno_map.keySet();

    for (Iterator<String> iterator = chaves.iterator(); iterator.hasNext();)
    {
      String chave = iterator.next();
      if (matricula == Integer.parseInt(chave))
      {
        System.out.println("Aluno cadastrado");
      }
      else
      {
        System.out.println("Aluno não cadastrado");
      }
    }
    return aluno;
  }

  public Livro verifica_livro()
  {
    return null;
  }
}
