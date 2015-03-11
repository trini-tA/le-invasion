package aide_invasion_le;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class fenetre  extends JFrame implements MouseListener {

	/**
	 * 
	 */
	JLabel image;
	
	//Mobs Ligne 1
	private static final long serialVersionUID = 1L;
	private static final Color Color = null;
	private static JPanel pan = new JPanel();
	private static JButton boutonMonstre1 = new JButton("Cr�ature 1");
	private static JButton boutonMonstre2 = new JButton("Cr�ature 2");
	private static JButton boutonMonstre3 = new JButton("Cr�ature 3");
	private static JButton boutonMonstre4 = new JButton("Cr�ature 4");
	private static JButton boutonMonstre5 = new JButton("Cr�ature 5");
	private TextField tm1 = new TextField("lapin_brun",10);
	private TextField tm2 = new TextField("lapin_blanc",10); 
	private TextField tm3 = new TextField("rat",10); 
	private TextField tm4 = new TextField("farfadet",10); 
	private TextField tm5 = new TextField("lutin",10); 
	
	//Mobs Ligne 2
	private static JButton boutonMonstre6 = new JButton("Cr�ature 6");
	private static JButton boutonMonstre7 = new JButton("Cr�ature 7");
	private static JButton boutonMonstre8 = new JButton("Cr�ature 8");
	private static JButton boutonMonstre9 = new JButton("Cr�ature 9");
	private static JButton boutonMonstre10 = new JButton("Cr�ature10");
	private TextField tm6 = new TextField("squelette",10);
	private TextField tm7 = new TextField("squelette_faible",10); 
	private TextField tm8 = new TextField("squelette_brille",10); 
	private TextField tm9 = new TextField("squelette_boum",10); 
	private TextField tm10 = new TextField("squelette_horreur",10); 
	
	//Nombres
	Dimension taille_nb = new Dimension(57,26);
	private static JButton nbMonstre1 = new JButton("1");
	private static JButton nbMonstre5 = new JButton("5");
	private static JButton nbMonstre10 = new JButton("10");
	private static JButton nbMonstre15 = new JButton("15");
	private static JButton nbMonstre20 = new JButton("20");
	private static JButton nbMonstre30 = new JButton("30");
	private static JButton nbMonstre50 = new JButton("50");
	private static JButton nbMonstre100 = new JButton("100");
	
	//Gauche de l'image
	JLabel pseudo = new JLabel("Pseudo");
	private TextField zonePseudo = new TextField("",10); 
	JLabel serveur = new JLabel("Serveur");
	String[] items = {"main", "test"};
	JComboBox zoneServeur = new JComboBox(items); 
	JLabel carte = new JLabel("Num Carte");
	private TextField zoneCarte = new TextField("1",10);
	JLabel clear = new JLabel("Clear");
	private static JButton clearPonct = new JButton("Ponct");
	private static JButton clearPerm = new JButton("Perm");
	private static JButton clearPeri = new JButton("Peri");
	private static JButton clearAuto = new JButton("Auto");
	JLabel imageAf = new JLabel("Image");
	private static JButton choixImage = new JButton("...");
	
	private int taille_carte_affiche = 400;
	private int taille_carte = 384;
	
	private String nom_fenetre ="(Burno sur main) Landes Eternelles";
	private String type_inva = "ponct";
	private String type_mob = "rat";
	private int nb_monstres = 1;
	
	public fenetre() {
		// TODO Auto-generated constructor stub
		JFrame fenetre = creer_fenetre();
	}
	
	JFrame creer_fenetre()
	{
		
		JFrame fenetre = new JFrame();
		//D�finit un titre pour notre fen�tre
	    fenetre.setTitle("Gestionnaire Invasion");
	    //D�finit sa taille : 400 pixels de large et 100 pixels de haut
	    fenetre.setSize(600, 800);
	    //Nous demandons maintenant � notre objet de se positionner au centre
	    fenetre.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel ligne1 = new JPanel();
	    ligne1.add(tm1);
	    ligne1.add(tm2);
	    ligne1.add(tm3);
	    ligne1.add(tm4);
	    ligne1.add(tm5);
	    
	    JPanel ligne2 = new JPanel();
	    ligne2.add(boutonMonstre1);
	    boutonMonstre1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
            	type_mob = tm1.getText(); active_button_mob(boutonMonstre1); }});  
	    ligne2.add(boutonMonstre2);
	    boutonMonstre2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	type_mob = tm2.getText(); active_button_mob(boutonMonstre2); }});
	    ligne2.add(boutonMonstre3);
	    boutonMonstre3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	type_mob = tm3.getText(); active_button_mob(boutonMonstre3); }});
	    ligne2.add(boutonMonstre4);
	    boutonMonstre4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	type_mob = tm4.getText(); active_button_mob(boutonMonstre4); }});
	    ligne2.add(boutonMonstre5);
	    boutonMonstre5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	type_mob = tm5.getText(); active_button_mob(boutonMonstre5); }});
	    
	    JPanel ligne3 = new JPanel();
	    ligne3.add(tm6);
	    ligne3.add(tm7);
	    ligne3.add(tm8);
	    ligne3.add(tm9);
	    ligne3.add(tm10);
	    
	    JPanel ligne4 = new JPanel();
	    ligne4.add(boutonMonstre6);
	    boutonMonstre6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	type_mob = tm6.getText(); active_button_mob(boutonMonstre6); }});  
	    ligne4.add(boutonMonstre7);
	    boutonMonstre7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	type_mob = tm7.getText(); active_button_mob(boutonMonstre7); }});  
	    ligne4.add(boutonMonstre8);
	    boutonMonstre8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	type_mob = tm8.getText(); active_button_mob(boutonMonstre8); }});  
	    ligne4.add(boutonMonstre9);
	    boutonMonstre9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	type_mob = tm9.getText(); active_button_mob(boutonMonstre9); }});  
	    ligne4.add(boutonMonstre10);
	    boutonMonstre10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	type_mob = tm10.getText(); active_button_mob(boutonMonstre10); }});  
	    
	    JPanel ligne5 = new JPanel();
		nbMonstre1.setPreferredSize(taille_nb);
		nbMonstre5.setPreferredSize(taille_nb);
		nbMonstre10.setPreferredSize(taille_nb);
		nbMonstre15.setPreferredSize(taille_nb);
		nbMonstre20.setPreferredSize(taille_nb);
		nbMonstre30.setPreferredSize(taille_nb);
		nbMonstre50.setPreferredSize(taille_nb);
		nbMonstre100.setPreferredSize(taille_nb);
		ligne5.add(nbMonstre1);
		nbMonstre1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
           	nb_monstres = 1; active_button_nb(nbMonstre1); }});  
		ligne5.add(nbMonstre5);
		nbMonstre5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            nb_monstres = 5; active_button_nb(nbMonstre5); }});  
		ligne5.add(nbMonstre10);
		nbMonstre10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            nb_monstres = 10; active_button_nb(nbMonstre10); }});  
		ligne5.add(nbMonstre15);
		nbMonstre15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            nb_monstres = 15; active_button_nb(nbMonstre15); }});  
		ligne5.add(nbMonstre20);
		nbMonstre20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            nb_monstres = 20; active_button_nb(nbMonstre20); }});  
		ligne5.add(nbMonstre30);
		nbMonstre30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            nb_monstres = 30; active_button_nb(nbMonstre30); }});  
		ligne5.add(nbMonstre50);
		nbMonstre50.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            nb_monstres = 50; active_button_nb(nbMonstre50); }});  
		ligne5.add(nbMonstre100);
		nbMonstre100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            nb_monstres = 100; active_button_nb(nbMonstre100); }});  

	    
	    JPanel ligneImage = new JPanel();
	    
	    //ligneImage.setLayout(new GridLayout(1, 2));
	    
	    
	    JPanel ligneImageG = new JPanel();
	    
	    ligneImageG.setLayout(new GridLayout(15, 1));
		ligneImageG.add(pseudo);
		ligneImageG.add(zonePseudo);
		ligneImageG.add(serveur);
		ligneImageG.add(zoneServeur);
		ligneImageG.add(carte);
		ligneImageG.add(zoneCarte);
		ligneImageG.add(clear);
		ligneImageG.add(clearPonct);
		ligneImageG.add(clearPerm);
		ligneImageG.add(clearPeri);
		ligneImageG.add(clearAuto);
		ligneImageG.add(imageAf);
		choixImage.setPreferredSize(taille_nb);
		ligneImageG.add(choixImage);
		
		//Clear
		clearPonct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	String param = new String("&clear_inv ponct " + Integer.parseInt(zoneCarte.getText()));
        		System.out.println(param);
        		nom_fenetre ="(" + zonePseudo.getText() + " sur " + zoneServeur.getSelectedItem() + ") Landes Eternelles";
        		try {
        			Runtime.getRuntime().exec("wscript scripts\\focusApp.vbs \"" + nom_fenetre + "\" \"" + param + "\" \"Gestionnaire Invasion\"");
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		} }});  
		clearPerm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	String param = new String("&clear_inv perm " + Integer.parseInt(zoneCarte.getText()));
        		System.out.println(param);
        		nom_fenetre ="(" + zonePseudo.getText() + " sur " + zoneServeur.getSelectedItem() + ") Landes Eternelles";
        		try {
        			Runtime.getRuntime().exec("wscript scripts\\focusApp.vbs \"" + nom_fenetre + "\" \"" + param + "\" \"Gestionnaire Invasion\"");
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		} }});  
		clearPeri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	String param = new String("&clear_inv peri " + Integer.parseInt(zoneCarte.getText()));
        		System.out.println(param);
        		nom_fenetre ="(" + zonePseudo.getText() + " sur " + zoneServeur.getSelectedItem() + ") Landes Eternelles";
        		try {
        			Runtime.getRuntime().exec("wscript scripts\\focusApp.vbs \"" + nom_fenetre + "\" \"" + param + "\" \"Gestionnaire Invasion\"");
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		} }});  
		clearAuto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	String param = new String("&clear_inv auto " + Integer.parseInt(zoneCarte.getText()));
        		System.out.println(param);
        		nom_fenetre ="(" + zonePseudo.getText() + " sur " + zoneServeur.getSelectedItem() + ") Landes Eternelles";
        		try {
        			Runtime.getRuntime().exec("wscript scripts\\focusApp.vbs \"" + nom_fenetre + "\" \"" + param + "\" \"Gestionnaire Invasion\"");
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		} }});  
	    
	    
	    
	    JPanel ligneImageD = new JPanel();
	    
	    ImageIcon carteIc = new ImageIcon( "images/vide.jpg");
	    Image zoom = scaleImage(carteIc.getImage(), taille_carte_affiche);//taille en pixels
	    Icon iconScaled = new ImageIcon(zoom);
	    image = new JLabel(iconScaled);
	    //pan.setLayout(new BorderLayout, CENTER);
	    image.addMouseListener(this);
	    ligneImageD.add(image);
	    
		//Choix Image
		choixImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
        		JFileChooser dialogue = new JFileChooser(new File(".\\images"));
        		File fichier2;
        		
        		if (dialogue.showOpenDialog(null)== 
        		    JFileChooser.APPROVE_OPTION) {
        		    fichier2 = dialogue.getSelectedFile();
        		    System.out.println(dialogue.getName(fichier2));
        		    ImageIcon carteIc = new ImageIcon( "images/" + dialogue.getName(fichier2));
        		    Image zoom = scaleImage(carteIc.getImage(), taille_carte_affiche);//taille en pixels
        		    Icon iconScaled = new ImageIcon(zoom);
        		    image.setIcon(iconScaled);
        		    choixImage.setText(dialogue.getName(fichier2));
        		} }});  
	    
	    ligneImage.add(ligneImageG);
	    ligneImage.add(ligneImageD);

	    pan.add(ligne1);
	    pan.add(ligne2);
	    pan.add(ligne3);
	    pan.add(ligne4);
	    pan.add(ligne5);
	    pan.add(ligneImage);
	    fenetre.setContentPane(pan);
	    
	    //Et enfin, la rendre visible        
	    fenetre.setVisible(true);
	    
	    return fenetre;
	}
	
	//avec une taille en pixels (=hauteur si portrait, largeur si paysage):
	static Image scaleImage(Image source, int size) {
	    int width = source.getWidth(null);
	    int height = source.getHeight(null);
	    double f = 0;
	    if (width < height) {//portrait
	        f = (double) height / (double) width;
	        width = (int) (size / f);
	        height = size;
	    } else {//paysage
	        f = (double) width / (double) height;
	        width = size;
	        height = (int) (size / f);
	    }
	    return scaleImage(source, width, height);
	}
	
	static Image scaleImage(Image source, int width, int height) {
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) img.getGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(source, 0, 0, width, height, null);
	    g.dispose();
	    return img;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int pos_carte_x = (int)(e.getPoint().getX())*taille_carte/taille_carte_affiche;
		int pos_carte_y = taille_carte-((int)(e.getPoint().getY())*taille_carte/taille_carte_affiche);
		String param = new String("&inv " + type_inva + " " + pos_carte_x + " " + pos_carte_y + " " + Integer.parseInt(zoneCarte.getText()) + " " + type_mob + " " + nb_monstres);
		System.out.println(param);
		nom_fenetre ="(" + zonePseudo.getText() + " sur " + zoneServeur.getSelectedItem() + ") Landes Eternelles";
		System.out.println(nom_fenetre);
		try {
			Runtime.getRuntime().exec("wscript scripts\\focusApp.vbs \"" + nom_fenetre + "\" \"" + param + "\" \"Gestionnaire Invasion\"");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void active_button_mob (JButton b)
	{
		passive_button(boutonMonstre1);
		passive_button(boutonMonstre2);
		passive_button(boutonMonstre3);
		passive_button(boutonMonstre4);
		passive_button(boutonMonstre5);
		passive_button(boutonMonstre6);
		passive_button(boutonMonstre7);
		passive_button(boutonMonstre8);
		passive_button(boutonMonstre8);
		passive_button(boutonMonstre9);
		passive_button(boutonMonstre10);
		
		active_button(b);
	}
	private void active_button_nb(JButton b)
	{
		passive_button(nbMonstre1);
		passive_button(nbMonstre5);
		passive_button(nbMonstre10);
		passive_button(nbMonstre15);
		passive_button(nbMonstre20);
		passive_button(nbMonstre30);
		passive_button(nbMonstre50);
		passive_button(nbMonstre100);
		
		active_button(b);
	}
	private void active_button (JButton b)
	{
	    b.setBackground(Color.blue);
	    b.setForeground(Color.white);
	}
	private void passive_button (JButton b)
	{
	    b.setBackground(null);
	    b.setForeground(null);
	}
	
	
}
