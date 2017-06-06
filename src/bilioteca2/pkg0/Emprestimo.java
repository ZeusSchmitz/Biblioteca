package bilioteca2.pkg0;

import java.util.HashMap;
import java.util.Set;
import dao.xml.LivroDAO;

public class Emprestimo
{
  private int codigoBarras;
  private int exemplar;

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

  public String verifica_aluno(String matricula)
  {

    HashMap<String, Aluno> aluno_map = p.Ler_Aluno();
    Set<String> chaves = aluno_map.keySet();

    boolean existeMatr = chaves.contains(matricula);

    System.out.println((existeMatr == true)? "Aluno cadastrado: " + aluno_map.get(matricula).getNome():"Aluno não cadastrado");
    
    return aluno_map.get(matricula).getNome();
  }

  public String verifica_livro(int nomeLivro)
  {
    HashMap<Integer, Livro> livro_map = l.loadAll();
    Set<Integer> chaves = livro_map.keySet();
    
    boolean existeLivro = chaves.contains(nomeLivro);
    
    System.out.println((existeLivro == true)? "Título: " + livro_map.get(nomeLivro).getTitulo() + " - Exemplar:" + livro_map.get(nomeLivro).getExemplar():"Não está cadastrado");
    
    return livro_map.get(nomeLivro).getTitulo();
  }
}
