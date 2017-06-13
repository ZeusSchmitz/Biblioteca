package migracao;

import dao.xml.LivroDAO;
import java.io.FileNotFoundException;

public class MigraCSVparaXML
{
  public static void main(String[] args) throws FileNotFoundException
  {
    LivroDAO salva = new LivroDAO();
    salva.importa_livros();    
    System.out.println("Migração de CSV para XML realizada");
  }
}
