package dao;

import bilioteca2.pkg0.Aluno;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Set;

public class AlunoDAO
{
  public String verifica_aluno(String matricula)
  {
    HashMap<String, Aluno> aluno_map = Ler_Aluno();
    Set<String> chaves = aluno_map.keySet();
    String resultado;
    
    boolean existeMatr = chaves.contains(matricula);

    if(existeMatr)
    {
      resultado =  "Aluno: " + aluno_map.get(matricula).getNome() + " | Matricula: " + aluno_map.get(matricula).getMatricula();
    }
    else
    {
      resultado = "Aluno não cadastrado";
    }
    return resultado;
  }

  public void Gravar_aluno(HashMap<String, Aluno> lista)
  {
    FileOutputStream acessa_arquivo = null;
    try
    {
      acessa_arquivo = new FileOutputStream("C:\\GereciaBilioteca\\Alunos.xml");
      BufferedOutputStream pegar_arquivo = new BufferedOutputStream(acessa_arquivo);
      XMLEncoder gravar_xml = new XMLEncoder(pegar_arquivo);
      gravar_xml.writeObject(lista);
      gravar_xml.close();
      System.out.println("Cadastrado com sucesso");

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
      acessa_arquivo = new FileInputStream("C:\\GereciaBilioteca\\Alunos.xml");
      BufferedInputStream pegar_arquivo = new BufferedInputStream(acessa_arquivo);
      XMLDecoder ler_XML = new XMLDecoder(pegar_arquivo);
      alunos_map = (HashMap<String, Aluno>) ler_XML.readObject();
    } catch (FileNotFoundException ex)
    {
      System.out.println("Erro ao ler: " + ex.getMessage());
    }
    return alunos_map;
  }
}
