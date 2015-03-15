package aide_invasion_le;

import java.util.ArrayList;

public interface ILEInterface {
	public void open(String server, int port, String pseudo, String password);

	public void close();

	public void addInvasion(String invasionType, int xPos, int yPos, int mapId,
			String monsterType, int monsterNumber);

	public void clearInvasion(String invasionType, int mapId);

	public void commandoAjouter(int xPos, int yPos, int mapId,
			int commandoType, int commandoGroup);

	public void commandoGo(int xPos, int yPos, int mapId, int commandoType,
			int commandoGroup);

	public void commandoFree(int mapId, int commandoType, int commandoGroup);

	public void commandoStop(int mapId, int commandoType, int commandoGroup);
	
	public void sendRawText(String message);
	
	public ArrayList<String[]> checkInvasion();
	
	public void clear_res_check_order();
}