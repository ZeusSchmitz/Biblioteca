package migracao;

import dao.xml.LivroDAO;

public class MigraCSVparaXML
{
  public static void main(String[] args)
  {
    LivroDAO salva = new LivroDAO();
    salva.importa_livros();    
    System.out.println("Migração de CSV para XML realizada");
  }
}
