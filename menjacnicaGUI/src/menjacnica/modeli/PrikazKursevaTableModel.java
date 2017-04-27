package menjacnica.modeli;

import javax.swing.table.AbstractTableModel;

public class PrikazKursevaTableModel extends AbstractTableModel {

	private String[] kolone = { "Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv" };

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
}
