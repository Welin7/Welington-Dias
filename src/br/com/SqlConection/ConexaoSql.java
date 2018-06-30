
package br.com.SqlConection;

import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;




public class ConexaoSql {
   
    String connectionURL = "jdbc:sqlserver://localhost:1433; "
            + "databaseName = bancodados"; 
    public ResultSet rs;
    public Statement state;
    
public void conectaBanco(){
    
         try{
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
              Connection conn = DriverManager.getConnection(connectionURL, "sa","medsys");
              System.out.println("Conexão Realizada Com Suceso!");
            }catch(SQLException ex){
              System.out.println("SQLException:" + ex.getMessage());
              System.out.println("SQLState:" + ex.getSQLState());
              System.out.println("VerificandoError:" + ex.getErrorCode());
            }catch(Exception e){
              System.out.println("Não Foi Possível Conectar ao Banco de Dados!"+ e);
     }
   }        

public void criaTabela(){
    
    try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
         Connection conn = DriverManager.getConnection(connectionURL, "sa","medsys");
         Statement stmt = conn.createStatement();
         stmt.executeUpdate ("CREATE TABLE MDGlicemica (ID INTEGER IDENTITY(1,1) NOT NULL," +
         "manhajejum VARCHAR(50)," +
         "manhapos VARCHAR(50)," +
         "antesalmoco VARCHAR(50)," +
         "depoisalmoco VARCHAR(50)," +
         "antesjantar VARCHAR(50)," +
         "depoisjantar VARCHAR(50)," +
         "datamedicao DATE)");
         System.out.println("Tabela Criada Com Suceso!");
         conn.close(); //fecha conexao com o banco de dados
         stmt.close();//fecha conexao com o objeto Sql
        }catch(Exception e){
         System.out.println("Não Foi Possível Criar a Tabela no Banco de Dados ou a Tabela já Esta Criada!"+ e);
    }
  }

public void removerTabela(){
    
    try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
         Connection conn = DriverManager.getConnection(connectionURL, "sa","medsys");
         Statement stmt = conn.createStatement();
         stmt.executeUpdate ("DROP TABLE MDGlicemica");
         System.out.println("Tabela Removida Com Suceso!");
         conn.close(); //fecha conexao com o banco de dados
         stmt.close();//fecha conexao com o objeto Sql
        }catch(Exception e){
         System.out.println("Não Foi Possível Remover a Tabela!"+ e);
    }
  }

public void cadastrarDados(String texto1, String texto2, String texto3,String texto4, String texto5, String texto6, String textoData){
    try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
         Connection conn = DriverManager.getConnection(connectionURL, "sa","medsys");
         Statement stmt = conn.createStatement();
         stmt.executeUpdate ("insert into MDGlicemica (manhajejum,manhapos,antesalmoco,depoisalmoco,antesjantar,depoisjantar,datamedicao) values ('"+ texto1 +"','"+ texto2 +"','"+ texto3 +"','"+ texto4 +"','"+ texto5 +"','"+ texto6 +"','"+ textoData +"')");
         System.out.println("Dados Salvos com Suceso!");
         conn.close(); //fecha conexao com o banco de dados
         stmt.close();//fecha conexao com o objeto Sql
        }catch(Exception e){
         System.out.println("Não Foi Possível Arquivar os Dados!"+ e);
    }
    
  }
public void chamaComandoSQL(String sql){
    
    try{
        Connection conn = DriverManager.getConnection(connectionURL, "sa","medsys"); 
        state = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        rs = state.executeQuery(sql);
        System.out.println("Comando Sql Executado com Sucesso!");
         
        }catch(Exception e){
         System.out.println("Não Foi Possível Executar o Comando SQl!"+ e);     
        }

    }

public void geraRelatorio(JasperPrint jasperPrint,Date Inicio,Date Fim){
   
        try {
               Connection conn = DriverManager.getConnection(connectionURL, "sa","medsys");
               String src = "medicão.jasper";
               
               try {
                      jasperPrint = JasperFillManager.fillReport(src, null, conn);              
                   }catch (JRException ex) {
                System.out.println("Error ao passar os Parâmetros para o JasperPrint!"+ ex);
            }
            } catch (SQLException ex) {
              System.out.println("Não Foi Possível Realizar a Conexão!"+ ex);          
        }
         
            JasperViewer view = new JasperViewer(jasperPrint,false); 
            view.setVisible(true);
    }

public void removeRegistro(int index){
    
    String sql;
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        Connection conn = DriverManager.getConnection(connectionURL, "sa","medsys");
        Statement stmt = conn.createStatement();
        sql = "Delete from MDGlicemica where ID = "+index+" ";
        stmt.executeUpdate(sql);
        System.out.println("Registro Excluido com Sucesso!");
         
        }catch(Exception e){
         System.out.println("Não Foi Possível Excluir o Registro Selecionado!"+ e);     
        }

    }

}

