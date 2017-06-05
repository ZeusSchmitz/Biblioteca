package bilioteca2.pkg0;

import java.io.Serializable;

public class Exemplar implements Serializable
{

  private int codigoDeBarras;
  private int numeroExemplar;
  private String dataAquisicaoExemplar;
  private String dataCadastroSistema;

  public Exemplar(int codigoDeBarras, int numeroExemplar, String dataAquisicaoExemplar, String dataCadastroSistema)
  {
    this.codigoDeBarras = codigoDeBarras;
    this.numeroExemplar = numeroExemplar;
    this.dataAquisicaoExemplar = dataAquisicaoExemplar;
    this.dataCadastroSistema = dataCadastroSistema;
  }

  Exemplar()
  {
    
  }

    @Override
    public String toString() {
        return "Exemplar{" + "codBarras=" + codigoDeBarras + ", numeroExemplar=" + numeroExemplar + ", dataAquisicaoExemplar=" + dataAquisicaoExemplar + ", dataCadastroSistema=" + dataCadastroSistema + '}';
    }

    public int getCodigoDeBarras()
  {
    return codigoDeBarras;
  }

  public void setCodigoDeBarras(int codigoDeBarras)
  {
    this.codigoDeBarras = codigoDeBarras;
  }

  public int getNumeroExemplar()
  {
    return numeroExemplar;
  }

  public void setNumeroExemplar(int numeroExemplar)
  {
    this.numeroExemplar = numeroExemplar;
  }

  public String getDataAquisicaoExemplar()
  {
    return dataAquisicaoExemplar;
  }

  public void setDataAquisicaoExemplar(String dataAquisicaoExemplar)
  {
    this.dataAquisicaoExemplar = dataAquisicaoExemplar;
  }

  public String getDataCadastroSistema()
  {
    return dataCadastroSistema;
  }

  public void setDataCadastroSistema(String dataCadastroSistema)
  {
    this.dataCadastroSistema = dataCadastroSistema;
  }

  
}
