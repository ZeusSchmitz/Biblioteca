package dao;

import bilioteca2.pkg0.Emprestimo;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

public class EmprestimoDAO
{
  public void Gravar_Emprestimo(HashMap<Integer, Emprestimo> lista)
  {
    FileOutputStream acessa_arquivo = null;
    try
    {
      acessa_arquivo = new FileOutputStream("C:\\GereciaBilioteca\\Emprestimos.xml");
      BufferedOutputStream pegar_arquivo = new BufferedOutputStream(acessa_arquivo);
      try (XMLEncoder gravar_xml = new XMLEncoder(pegar_arquivo))
      {
        gravar_xml.writeObject(lista);
      }
      System.out.println("foi");

    } catch (FileNotFoundException ex)
    {
      System.out.println("Erro ao gravar: " + ex.getMessage());
    }
  }

  public HashMap<Integer, Emprestimo> Ler_Emprestimo()
  {
    HashMap<Integer, Emprestimo> alunos_map = new HashMap<>(); //Integer, Emprestimo
    FileInputStream acessa_arquivo;
    try
    {
      acessa_arquivo = new FileInputStream("C:\\GereciaBilioteca\\Emprestimos.xml");
      BufferedInputStream pegar_arquivo = new BufferedInputStream(acessa_arquivo);
      XMLDecoder ler_XML = new XMLDecoder(pegar_arquivo);
      alunos_map = (HashMap<Integer, Emprestimo>) ler_XML.readObject();
    } catch (FileNotFoundException ex)
    {
      System.out.println("Erro ao ler: " + ex.getMessage());
    }
    return alunos_map;

  }
  
}
