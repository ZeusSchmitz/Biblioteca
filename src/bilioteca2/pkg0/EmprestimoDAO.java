package bilioteca2.pkg0;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

public class EmprestimoDAO
{
  public void Gravar_Emprestimo(HashMap<String, Emprestimo> lista)
  {
    FileOutputStream acessa_arquivo = null;
    try
    {
      acessa_arquivo = new FileOutputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\GerenciaBiblioteca\\GereciaBilioteca\\Emprestimos.xml");
      BufferedOutputStream pegar_arquivo = new BufferedOutputStream(acessa_arquivo);
      XMLEncoder gravar_xml = new XMLEncoder(pegar_arquivo);
      gravar_xml.writeObject(lista);
      gravar_xml.close();
      System.out.println("foi");

    } catch (FileNotFoundException ex)
    {
      System.out.println("Erro ao gravar: " + ex.getMessage());
    }
  }
}
