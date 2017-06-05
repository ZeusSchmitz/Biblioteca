package bilioteca2.pkg0;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

public class XmlDao
{

  public void saveAllLivrosXML(HashMap<Integer, Livro> livros)
  {
    HashMap<Integer, Livro> livroImportado = livros;
    FileOutputStream fout = null;
    try
    {
      fout = new FileOutputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\GerenciaBiblioteca\\GereciaBilioteca\\04-final-livros.xml");
      BufferedOutputStream bos = new BufferedOutputStream(fout);
      try (XMLEncoder xmlEncoder = new XMLEncoder(bos))
      {
        xmlEncoder.writeObject(livroImportado);
        xmlEncoder.close();
      }
    } catch (Exception ex)
    {
      System.out.println("Erro: " + ex.getMessage());
    }
  }

  public HashMap<String, Livro> loadAll()
  {
    HashMap<String, Livro> livros = new HashMap();
    try
    {
      FileInputStream fis = new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\GerenciaBiblioteca\\GereciaBilioteca\\04-final-livros.xml");
      BufferedInputStream bis = new BufferedInputStream(fis);
      XMLDecoder xmlDecoder = new XMLDecoder(bis);
      livros = (HashMap<String, Livro>) xmlDecoder.readObject();
    } catch (Exception e)
    {
      System.out.println("erro ao ler");
    }
    return livros;
  }
}
