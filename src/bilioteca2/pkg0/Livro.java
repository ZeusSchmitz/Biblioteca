package bilioteca2.pkg0;

import java.io.Serializable;

public class Livro implements Serializable
{
  private int codigoDeBarras;
  private int idLivro;
  private int exemplar;
  private String dataAquisicaoExemplar;
  private String dataCadastroSistema;
  private String dadosLivro;
  private String Classificacao;
  private String areaConhecimento;
  private String autor;
  private String titulo;
  private String ano;
  private String isbn;
  private String editora;
  private int paginas;

  public Livro()
  {
  }

  public Livro(int codigoDeBarras, int idLivro, int exemplar, String dataAquisicaoExemplar, String dataCadastroSistema, String dadosLivro, String Classificacao, String areaConhecimento, String autor, String titulo, String ano, String isbn, String editora, int paginas)
  {
    this.codigoDeBarras = codigoDeBarras;
    this.idLivro = idLivro;
    this.exemplar = exemplar;
    this.dataAquisicaoExemplar = dataAquisicaoExemplar;
    this.dataCadastroSistema = dataCadastroSistema;
    this.dadosLivro = dadosLivro;
    this.Classificacao = Classificacao;
    this.areaConhecimento = areaConhecimento;
    this.autor = autor;
    this.titulo = titulo;
    this.ano = ano;
    this.isbn = isbn;
    this.editora = editora;
    this.paginas = paginas;
  }
  
  @Override
  public String toString()
  {
    return "Livro código de barras= "+ codigoDeBarras +
            ", id livro= "+ idLivro + 
            ", data aquisição exemplar= "+ dataAquisicaoExemplar + 
            ", data cadastro sistema= "+ dataCadastroSistema + 
            ", dados livro= "+ dadosLivro + 
            ", classificação= "+ Classificacao + 
            ", area conhecimento= "+ areaConhecimento + 
            ", autor= "+ autor + 
            ", titulo= "+ titulo + 
            ", ano= "+ ano + 
            ", isbn=" + isbn + 
            ", editora=" + editora + 
            ", numeroPaginas=" + paginas;
  }

  public int getCodigoDeBarras()
  {
    return codigoDeBarras;
  }

  public void setCodigoDeBarras(int codigoDeBarras)
  {
    this.codigoDeBarras = codigoDeBarras;
  }

  public int getIdLivro()
  {
    return idLivro;
  }

  public void setIdLivro(int idLivro)
  {
    this.idLivro = idLivro;
  }

  public int getExemplar()
  {
    return exemplar;
  }

  public void setExemplar(int exemplar)
  {
    this.exemplar = exemplar;
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

  public String getDadosLivro()
  {
    return dadosLivro;
  }

  public void setDadosLivro(String dadosLivro)
  {
    this.dadosLivro = dadosLivro;
  }

  public String getClassificacao()
  {
    return Classificacao;
  }

  public void setClassificacao(String Classificacao)
  {
    this.Classificacao = Classificacao;
  }

  public String getAreaConhecimento()
  {
    return areaConhecimento;
  }

  public void setAreaConhecimento(String areaConhecimento)
  {
    this.areaConhecimento = areaConhecimento;
  }

  public String getAutor()
  {
    return autor;
  }

  public void setAutor(String autor)
  {
    this.autor = autor;
  }

  public String getTitulo()
  {
    return titulo;
  }

  public void setTitulo(String titulo)
  {
    this.titulo = titulo;
  }

  public String getAno()
  {
    return ano;
  }

  public void setAno(String ano)
  {
    this.ano = ano;
  }

  public String getIsbn()
  {
    return isbn;
  }

  public void setIsbn(String isbn)
  {
    this.isbn = isbn;
  }

  public String getEditora()
  {
    return editora;
  }

  public void setEditora(String editora)
  {
    this.editora = editora;
  }

  public int getPaginas()
  {
    return paginas;
  }

  public void setPaginas(int paginas)
  {
    this.paginas = paginas;
  }
}
