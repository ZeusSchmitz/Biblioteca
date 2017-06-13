package excecoes;

public class DaoDataException extends Exception
{

  public DaoDataException()
  {
  }

  public DaoDataException(String mensagem)
  {
    super(mensagem);
  }
}
