package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;

import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import menjacnica.modeli.PrikazKursevaTableModel;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JPanel panelDesni;
	private JPanel panelSrednji;
	private JPanel panelDonji;
	private JButton btnDodaj;
	private JButton btnObrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JMenuItem mntmAbout;
	private JScrollPane scrollPane;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmObrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;
	private JScrollPane scrollPaneDonji;
	private static JTextArea textArea;
	private static MenjacnicaGUI frame = new MenjacnicaGUI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
					frame.setSize(new Dimension(750, 450));
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							ugasiAplikaciju();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/images.png")));
		setBackground(Color.LIGHT_GRAY);
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelDesni(), BorderLayout.EAST);
		contentPane.add(getPanelSrednji(), BorderLayout.CENTER);
		contentPane.add(getPanelDonji(), BorderLayout.SOUTH);
	}

	public static void dodajKurs(String tekst) {
		textArea.setText(textArea.getText() + tekst + "\n");
	}

	public static void ugasiAplikaciju() {
		int odgovor = JOptionPane.showConfirmDialog(frame, "Da li zelite da izadjete iz programa?", "Zatvaranje",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (odgovor == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String fajl = "";
					try {
						JFileChooser fc = new JFileChooser();
						int odgovor = fc.showOpenDialog(frame);
						if (odgovor == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();
							fajl = file.getAbsolutePath();
							textArea.setText(textArea.getText() + "Ucitan fajl: " + fajl + "\n");
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			mntmOpen.setIcon(new ImageIcon(
					MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String fajl = "";
					try {
						JFileChooser fc = new JFileChooser();
						int odgovor = fc.showSaveDialog(frame);
						if (odgovor == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();
							fajl = file.getAbsolutePath();
							textArea.setText(textArea.getText() + "Sacuvan fajl: " + fajl + "\n");
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			mntmSave.setIcon(
					new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ugasiAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}

	private JPanel getPanelDesni() {
		if (panelDesni == null) {
			panelDesni = new JPanel();
			panelDesni.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelDesni.add(getBtnDodaj());
			panelDesni.setPreferredSize(new Dimension(140, 0));
			panelDesni.add(getBtnObrisiKurs());
			panelDesni.add(getBtnIzvrsiZamenu());
		}
		return panelDesni;
	}

	private JPanel getPanelSrednji() {
		if (panelSrednji == null) {
			panelSrednji = new JPanel();
			panelSrednji.setBackground(Color.WHITE);
			panelSrednji.setLayout(new BorderLayout(0, 0));
			panelSrednji.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panelSrednji;
	}

	private JPanel getPanelDonji() {
		if (panelDonji == null) {
			panelDonji = new JPanel();
			panelDonji.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDonji.setPreferredSize(new Dimension(0, 80));
			panelDonji.setLayout(new BorderLayout(0, 0));
			panelDonji.add(getScrollPane_1_1(), BorderLayout.CENTER);
		}
		return panelDonji;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj kurs");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajKursGUI dodajkurs = new DodajKursGUI();
					dodajkurs.setVisible(true);
					dodajkurs.setLocationRelativeTo(null);
				}
			});
			btnDodaj.setPreferredSize(new Dimension(120, 30));
		}
		return btnDodaj;
	}

	private JButton getBtnObrisiKurs() {
		if (btnObrisiKurs == null) {
			btnObrisiKurs = new JButton("Obrisi kurs");
			btnObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI obrisiKurs = new ObrisiKursGUI();
					obrisiKurs.setVisible(true);
					obrisiKurs.setLocationRelativeTo(null);
				}
			});
			btnObrisiKurs.setPreferredSize(new Dimension(120, 30));
		}
		return btnObrisiKurs;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI izvrsiZamenu = new IzvrsiZamenuGUI();
					izvrsiZamenu.setVisible(true);
					izvrsiZamenu.setLocationRelativeTo(null);
				}
			});
			btnIzvrsiZamenu.setPreferredSize(new Dimension(120, 30));
		}
		return btnIzvrsiZamenu;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frame, "Zovem se Milan Susa i autor sam ovog programa.");
				}
			});
		}
		return mntmAbout;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}

	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setModel(new PrikazKursevaTableModel());
			addPopup(table, getPopupMenu());
		}
		return table;
	}

	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmObrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}

	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajKursGUI dodajkurs = new DodajKursGUI();
					dodajkurs.setVisible(true);
					dodajkurs.setLocationRelativeTo(null);
				}
			});
		}
		return mntmDodajKurs;
	}

	private JMenuItem getMntmObrisiKurs() {
		if (mntmObrisiKurs == null) {
			mntmObrisiKurs = new JMenuItem("Obrisi kurs");
			mntmObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI obrisiKurs = new ObrisiKursGUI();
					obrisiKurs.setVisible(true);
					obrisiKurs.setLocationRelativeTo(null);
				}
			});
		}
		return mntmObrisiKurs;
	}

	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
			mntmIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI izvrsiZamenu = new IzvrsiZamenuGUI();
					izvrsiZamenu.setVisible(true);
					izvrsiZamenu.setLocationRelativeTo(null);
				}
			});
		}
		return mntmIzvrsiZamenu;
	}

	private JScrollPane getScrollPane_1_1() {
		if (scrollPaneDonji == null) {
			scrollPaneDonji = new JScrollPane();
			scrollPaneDonji.setViewportView(getTextArea_1());
		}
		return scrollPaneDonji;
	}

	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}

}
