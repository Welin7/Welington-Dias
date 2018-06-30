/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SqlConection;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModeloGrid extends AbstractTableModel {
  
   private ArrayList linhas = null;
   private String[] colunas = null;
   
   public ModeloGrid(ArrayList lin, String[] col)
     {
       setLinhas(lin);
       setColunas(col);
     }
    
   public ArrayList getLinhas(){
       return linhas;
   }
   public void setLinhas(ArrayList dados){
       linhas = dados;
   }
   public String[] getColunas(){
       return colunas;
   }
   public void setColunas(String[] nomes){
       colunas = nomes;
   }
   public int getColumnCount(){
       return colunas.length;
   }
   public int getRowCount(){
       return linhas.size();
   }
   public String getColumnName(int numeroColunas){
       return colunas[numeroColunas];
   }
   
   public void removeRow(int linha){
    this.linhas.remove(linha);
    this.fireTableRowsDeleted(linha, linha);
}
   
   public Object getValueAt(int numeroLinhas, int numeroColunas){
       Object[] linha = (Object[])getLinhas().get(numeroLinhas);
       return linha[numeroColunas];
   }
}
