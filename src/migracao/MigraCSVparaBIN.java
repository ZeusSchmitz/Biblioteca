package migracao;

import dao.bin.LivroDAO;
import java.io.FileNotFoundException;

public class MigraCSVparaBIN
{
  public static void main(String[] args) throws FileNotFoundException
  {
    LivroDAO salva = new LivroDAO();
    salva.importa_livros();    
    System.out.println("Migração de CSV para BIN realizada");
  }    
}
