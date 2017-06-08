package bilioteca2.pkg0;

import dao.xml.LivroDAO;

public class TestaBiblioteca
{

  public static void main(String[] args)
  {
    LivroDAO livro = new LivroDAO();
    Biblioteca biblioteca = new Biblioteca();
//    livro.verifica_livro(97453545, 3, "Karin"); //Introdução à administração
    biblioteca.devolverEmprestimo(97453545);
    
    
  }
  
}
