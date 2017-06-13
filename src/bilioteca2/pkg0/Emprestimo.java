package bilioteca2.pkg0;

public class Emprestimo
{
  private Livro codigoBarras;
  private Aluno nomeAluno;
  private String diaEmpr;

  public Emprestimo(Livro codigoBarras, Aluno nomeAluno, String diaEmpr, String diaEntrg)
  {
    this.codigoBarras = codigoBarras;
    this.nomeAluno = nomeAluno;
    this.diaEmpr = diaEmpr;
    this.diaEntrg = diaEntrg;
  }

  public Aluno getNomeAluno()
  {
    return nomeAluno;
  }

  public void setNomeAluno(Aluno nomeAluno)
  {
    this.nomeAluno = nomeAluno;
  }
  
  private String diaEntrg;

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

  public Emprestimo(Livro codigoBarras)
  {
    this.codigoBarras = codigoBarras;
  }

  public Livro getCodigoBarras()
  {
    return codigoBarras;
  }

  public void setCodigoBarras(Livro codigoBarras)
  {
    this.codigoBarras = codigoBarras;
  }
}
