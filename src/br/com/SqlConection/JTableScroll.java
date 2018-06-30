package br.com.SqlConection;
import javax.swing.JTable;
import javax.swing.JViewport;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.Collection;
import java.util.TreeSet;
import java.util.Set;
import java.util.Comparator;
import javax.swing.JOptionPane;


public class JTableScroll {
    
    public void first(JTable table)            
    {
        int pos = 0;
        selectAndScroll(table, pos);
    }
    public void next(JTable table)
    {
        int pos = table.getSelectedRow()+1;
        selectAndScroll(table, pos);
    }    
    public void previous(JTable table)
    {
        int pos = table.getSelectedRow()-1;
        selectAndScroll(table, pos);
    } 
    public void last(JTable table)
    {
        int pos = table.getRowCount()+1;
        selectAndScroll(table, pos);
    }    
    
    public void selectAndScroll(JTable table, int rowIndex)  
    {  
        table.getSelectionModel().setSelectionInterval(rowIndex, rowIndex);  
        scrollToVisible(table, rowIndex);  
    }    
    public Collection<Integer> getReverseSelectedRows(JTable table)  
    {  
        Set<Integer> rows = new TreeSet<Integer>(new Comparator<Integer>()  
        {  
            public int compare(Integer o1, Integer o2)  
            {  
                return o2.compareTo(o1);  
            }  
        });  
        for (int r : table.getSelectedRows())  
            rows.add(r);  
        return rows;  
    }    
    private void scrollToVisible(JTable table, int rowIndex)  
    {  
        scrollToVisible(table, rowIndex, 0);  
    }  
    private void scrollToVisible(JTable table, int rowIndex, int vColIndex)  
    {  
        if (!(table.getParent() instanceof JViewport))  
            return;  
        setViewPortPosition((JViewport) table.getParent(), table.getCellRect(rowIndex, vColIndex, true));  
    }  
    private void setViewPortPosition(JViewport viewport, Rectangle position)  
    {  
        // The location of the viewport relative to the object  
        Point pt = viewport.getViewPosition();  
        // Translate the cell location so that it is relative  
        // to the view, assuming the northwest corner of the  
        // view is (0,0)  
        position.setLocation(position.x - pt.x, position.y - pt.y);  
        // Scroll the area into view  
        viewport.scrollRectToVisible(position);  
    }
}
