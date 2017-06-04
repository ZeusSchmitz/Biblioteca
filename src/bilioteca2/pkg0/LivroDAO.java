package bilioteca2.pkg0;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class LivroDAO
{
  HashMap<Integer, Livro> importLivro = new HashMap<>();
  XmlDao convXml = new XmlDao();

  public void importa_livros()
  {

    try
    {
      Scanner file = new Scanner(new File("C:\\GereciaBilioteca\\final-livros-linux.csv"),"UTF-8");
      while (file.hasNextLine())
      {
        String linha = file.nextLine();
        Livro l = new Livro();
        String[] colunas = linha.split("\\|");
        try
        {
          l.setCodigoDeBarras(Integer.parseInt(colunas[0]));
          l.setIdLivro(Integer.parseInt(colunas[1]));
          l.setExemplar(Integer.parseInt(colunas[2]));
          l.setDataAquisicaoExemplar(colunas[3]);
          l.setDataCadastroSistema(colunas[4]);
          l.setClassificacao(colunas[5]);
          l.setAreaConhecimento(colunas[6]);
          l.setAutor(colunas[7]);
          l.setTitulo(colunas[8]);
          l.setAno(colunas[9]);
          l.setIsbn(colunas[10]);
          l.setEditora(colunas[11]);
          l.setPaginas(Integer.parseInt(colunas[12]));
          importLivro.put(l.getCodigoDeBarras(), l);
/*          System.out.println("Valor do código: " + l.getCodigoDeBarras() +
                             " | Número exemplar: "+ l.getExemplar() +
                             " | Data aquisição: "+ l.getDataAquisicaoExemplar() +
                             " | Data cadastro: "+ l.getDataCadastroSistema());*/

        } catch (Exception e)
        {
          System.out.println("Linha com erro");
        }

      }
    } catch (Exception e)
        
    {
      e.printStackTrace();
    }

  }

}
