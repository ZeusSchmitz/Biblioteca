package bilioteca2.pkg0;

public class Emprestimo
{
  private int codigoBarras;
  private int exemplar;
  private String nomeAluno;
  private String diaEmpr;
  private String diaEntrg;

  public Emprestimo(int codigoBarras, int exemplar, String nomeAluno, String diaEmpr, String diaEntrg)
  {
    this.codigoBarras = codigoBarras;
    this.exemplar = exemplar;
    this.nomeAluno = nomeAluno;
    this.diaEmpr = diaEmpr;
    this.diaEntrg = diaEntrg;
  }

  public String getNomeAluno()
  {
    return nomeAluno;
  }

  public void setNomeAluno(String nomeAluno)
  {
    this.nomeAluno = nomeAluno;
  }

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
}
