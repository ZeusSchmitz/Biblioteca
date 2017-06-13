package bilioteca2.pkg0;

public class Aluno
{
  private String nome, curso, matricula;

  public Aluno(String nome, String curso, String matricula)
  {
    this.nome = nome;
    this.curso = curso;
    this.matricula = matricula;
  }

  public Aluno()
  {
  }

  public String getNome()
  {
    return nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public String getCurso()
  {
    return curso;
  }

  public void setCurso(String curso)
  {
    this.curso = curso;
  }

  public String getMatricula()
  {
    return matricula;
  }

  public void setMatricula(String matricula)
  {
    this.matricula = matricula;
  }

  @Override
  public String toString()
  {
    return "Aluno: " + nome + ", Curso: " + curso + ", Matricula: " + matricula;
  }
}
