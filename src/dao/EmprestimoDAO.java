package dao;

import bilioteca2.pkg0.Aluno;
import bilioteca2.pkg0.Biblioteca;
import bilioteca2.pkg0.Emprestimo;
import bilioteca2.pkg0.Livro;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import excecoes.DaoDataException;

public class EmprestimoDAO
{
  public void verificaEmprestimo(Livro codigoBarras, Aluno nomeAluno) throws DaoDataException
  {
    HashMap<Integer, Emprestimo> empr_map = Ler_Emprestimo();
    Biblioteca biblioteca = new Biblioteca();
        
    if(empr_map.containsKey(codigoBarras.getCodigoDeBarras()))
    {
      throw new DaoDataException("Exemplar indisponivel no momento"); 
    }
    else
    {
      biblioteca.efetuaEmprestimo(codigoBarras, nomeAluno);
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
