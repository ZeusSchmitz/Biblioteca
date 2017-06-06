package migracao;

import dao.bin.LivroDAO;

public class MigraCSVparaBIN
{
  public static void main(String[] args)
  {
    LivroDAO salva = new LivroDAO();
    salva.importa_livros();    
    System.out.println("Migração de CSV para BIN realizada");
  }    
}
