package aide_invasion_le;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;

import javax.swing.JFrame;

public class Window  extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ILEInterface leInterface;
	private TabbedPaneClosable tabbedPane;
	private TabGame game;
	
    public Window() {
		JFrame fenetre = new JFrame();
	    fenetre.setTitle("Gestionnaire Invasion");
	    fenetre.setLocationRelativeTo(null); // Center window
	    //fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	        	if(leInterface != null)
	        		leInterface.close();
	            System.exit(0);
	          }
	        });
	    
        tabbedPane = new TabbedPaneClosable();
        tabbedPane.setUI(new Tabbed());
        TabMain mainTab = new TabMain(this);
        tabbedPane.addTab("Main Tab", mainTab);
        tabbedPane.selectLast();
        
        game = new TabGame(new LEInterfaceNet("test_interf", "azerty", "jeu.landes-eternelles.com", 3001));
        tabbedPane.addTab("Game Tab", game);
        
        requestFocus();
        
        this.add(tabbedPane);
        this.setSize(700, 800);
        this.setVisible(true);
    }

	public void openMapTab(ILEInterface leInterface, Path mapPath, int mapId, int mapSize) {
		TabMap mapTab = new TabMap(leInterface, mapPath, mapSize, mapId);
		tabbedPane.addTab(mapPath.getFileName().toString(), mapTab);
		tabbedPane.selectLast();
	}
	
	public void updateLEInterface(ILEInterface leInterface) {
		this.leInterface = leInterface;
		for (TabMap tabMap : this.tabbedPane.getTabMaps()) {
			tabMap.setLEIinterface(leInterface);
		}
	}
}
