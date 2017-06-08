package tetes;

import bilioteca2.pkg0.Aluno;
import dao.AlunoDAO;
import java.util.HashMap;

public class TestaAluno
{
  public static void main(String[] args)
  {
    AlunoDAO salvaAluno = new AlunoDAO();
    HashMap valor = new HashMap();
    
    ///////////////////////////////////  CADASTRA ALUNO 1  ///////////////////////////////////////
    Aluno aluno1 = new Aluno("Zeus", "TADS", "1987");
    valor.put(aluno1.getMatricula(), aluno1);
    salvaAluno.Gravar_aluno(valor); 
    ///////////////////////////////////  CADASTRA ALUNO 2  ///////////////////////////////////////
    Aluno aluno2 = new Aluno("Zec", "Eletrônica", "1997");
    valor.put(aluno2.getMatricula(), aluno2);
    salvaAluno.Gravar_aluno(valor); 
    ///////////////////////////////////  CADASTRA ALUNO 3  ///////////////////////////////////////
    Aluno aluno3 = new Aluno("Ivon", "Projetos", "1898");
    valor.put(aluno3.getMatricula(), aluno3);
    salvaAluno.Gravar_aluno(valor);    
  }
}
