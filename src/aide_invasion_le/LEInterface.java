package aide_invasion_le;

import java.io.IOException;

public class LEInterface {
	public static final String INVASION_TYPE_PONCT = "ponct";
	public static final String INVASION_TYPE_PERM = "perm";
	public static final String INVASION_TYPE_PERI = "peri";
	public static final String INVASION_TYPE_AUTO = "auto";

	private String pseudo = "Burno";
	private String server = "test";

	public void addInvasion(String invasionType, int xPos, int yPos, int mapId, String monsterType, int monsterNumber)
	{
		String command = new String("&inv " + invasionType + " " + xPos + " " + yPos + " " + mapId + " " + monsterType + " " + monsterNumber);
		String windowName ="(" + pseudo + " sur " + server + ") Landes Eternelles";
		System.out.println(windowName + " - " + command);
	}

	public void clearInvasion(String invasionType, int mapId)
	{
		String command = "&clear_inv " + invasionType +" " + mapId;
		String windowName ="(" + pseudo + " sur " + server + ") Landes Eternelles";
		System.out.println(windowName + " - " + command);
		try {
			Runtime.getRuntime().exec("wscript scripts\\focusApp.vbs \"" + windowName + "\" \"" + command + "\" \"Gestionnaire Invasion\"");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}