/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.cinemabo.modelBO;

/**
 *
 * @author Krystian
 */
public class SeatShow {
    private int rowNumber;
    private int columnNumber;
    private boolean reserved;

    public SeatShow()
    {
        
    }
    public SeatShow(int row,int column, boolean isReserved)
    {
        this.rowNumber=row;
        this.columnNumber = column;
        this.reserved = isReserved;
    }
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int row) {
        this.rowNumber = row;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int column) {
        this.columnNumber = column;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean isReseved) {
        this.reserved = isReseved;
    }
}
