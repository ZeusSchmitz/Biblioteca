package bilioteca2.pkg0;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

public class AlunoDAO
{

  public void Gravar_aluno(HashMap<String, Aluno> lista)
  {
    FileOutputStream acessa_arquivo = null;
    try
    {
      acessa_arquivo = new FileOutputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\GerenciaBiblioteca\\GereciaBilioteca\\Alunos.xml");
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

  public HashMap<String, Aluno> Ler_Aluno()
  {
    HashMap<String, Aluno> alunos_map = new HashMap<String, Aluno>();
    FileInputStream acessa_arquivo;
    try
    {
      acessa_arquivo = new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\GerenciaBiblioteca\\GereciaBilioteca\\Alunos.xml");
      BufferedInputStream pegar_arquivo = new BufferedInputStream(acessa_arquivo);
      XMLDecoder ler_XML = new XMLDecoder(pegar_arquivo);
      alunos_map = (HashMap<String, Aluno>) ler_XML.readObject();
      //System.out.println("foi: ");
    } catch (FileNotFoundException ex)
    {
      System.out.println("Erro ao ler: " + ex.getMessage());
    }
    return alunos_map;

  }
}
