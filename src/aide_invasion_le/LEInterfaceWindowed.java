package aide_invasion_le;

import java.io.IOException;
import java.util.ArrayList;

public class LEInterfaceWindowed implements ILEInterface {
	public static final String INVASION_TYPE_PONCT = "ponct";
	public static final String INVASION_TYPE_PERM = "perm";
	public static final String INVASION_TYPE_PERI = "peri";
	public static final String INVASION_TYPE_AUTO = "auto";

	private String pseudo = "";
	private String server = "";

	public LEInterfaceWindowed(String pseudo, String server) {
		this.pseudo = pseudo;
		this.server = server;
	}

	@Override
	public void open(String server, int port, String pseudo, String password) {
		System.out.println("LEInterfaceNet open does nothing");
	}

	@Override
	public void close() {
		System.out.println("LEInterfaceNet close does nothing");
	}

	public void addInvasion(String invasionType, int xPos, int yPos, int mapId, String monsterType, int monsterNumber)
	{
		String command = new String("&inv " + invasionType + " " + xPos + " " + yPos + " " + mapId + " " + monsterType + " " + monsterNumber);
		String windowName ="(" + pseudo + " sur " + server + ") Landes Eternelles";
		this.sendCommandToLE(command, windowName);
	}

	public void clearInvasion(String invasionType, int mapId)
	{
		String command = "&clear_inv " + invasionType +" " + mapId;
		String windowName ="(" + pseudo + " sur " + server + ") Landes Eternelles";
		this.sendCommandToLE(command, windowName);
	}

	public ArrayList<String[]> checkInvasion() {
		return new ArrayList<String[]>();
	}
	
	public void commandoAjouter(int xPos, int yPos, int mapId, int commandoType, int commandoGroup)
	{
		String command = new String("&comdo_script_ajouter " + mapId + " " + xPos + " " + yPos + " " + commandoType + " " + commandoGroup);
		String windowName ="(" + pseudo + " sur " + server + ") Landes Eternelles";
		this.sendCommandToLE(command, windowName);
	}
	
	public void commandoGo(int xPos, int yPos, int mapId, int commandoType, int commandoGroup)
	{
		String command = new String("&comdo_script_go " + mapId + " " + xPos + " " + yPos + " " + commandoType + " " + commandoGroup);
		String windowName ="(" + pseudo + " sur " + server + ") Landes Eternelles";
		this.sendCommandToLE(command, windowName);
	}
	
	public void commandoFree (int mapId, int commandoType, int commandoGroup)
	{
		String command = new String("&commando_free " + mapId + " " + commandoType + " " + commandoGroup);
		String windowName ="(" + pseudo + " sur " + server + ") Landes Eternelles";
		this.sendCommandToLE(command, windowName);
	}
	
	public void commandoStop(int mapId, int commandoType, int commandoGroup)
	{
		String command = new String("&commando_stop " + mapId + " " + commandoType + " " + commandoGroup);
		String windowName ="(" + pseudo + " sur " + server + ") Landes Eternelles";
		this.sendCommandToLE(command, windowName);
	}

	public void sendMessage(String str, int order) {
		System.out.println("LEInterfaceNet sendMsg does nothing");
	}

	public void clearResCheckOrder() {
		System.out.println("LEInterfaceNet clearResCheckOrder does nothing");
	}
	
	private void sendCommandToLE(String command, String windowName)
	{
		System.out.println(windowName + " - " + command);
		try {
			if (System.getProperty("os.name").startsWith("Windows"))
				Runtime.getRuntime().exec("wscript scripts\\focusApp.vbs \"" + windowName + "\" \"" + command + "\" \"Gestionnaire Invasion\"");
			else if (System.getProperty("os.name").startsWith("Linux"))
				Runtime.getRuntime().exec(new String[]{"scripts/focusApp.sh", windowName, command});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
