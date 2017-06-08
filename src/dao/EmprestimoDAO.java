package dao;

import bilioteca2.pkg0.Biblioteca;
import bilioteca2.pkg0.Emprestimo;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Set;

public class EmprestimoDAO
{
  public void verificaEmprestimo(int codigoBarras, int exemplar, String nomeAluno)
  {
    HashMap<Integer, Emprestimo> empr_map = Ler_Emprestimo();
    Set<Integer> chavesEmpr = empr_map.keySet();
    Biblioteca biblioteca = new Biblioteca();
    
    boolean codPedido = chavesEmpr.contains(codigoBarras);
    
    if(codPedido)
    {
      System.out.println("Exemplar indisponivel no momento"); 
    }
    else
    {
      biblioteca.efetuaEmprestimo(codigoBarras, exemplar, nomeAluno);
      System.out.println("Emprestimo efetuado com sucesso"); 
    }
  }
  
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
      System.out.println("Cadastrado com sucesso");

    } catch (FileNotFoundException ex)
    {
      System.out.println("Erro ao gravar: " + ex.getMessage());
    }
  }

  public HashMap<Integer, Emprestimo> Ler_Emprestimo()
  {
    HashMap<Integer, Emprestimo> alunos_map = new HashMap<>(); 
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
