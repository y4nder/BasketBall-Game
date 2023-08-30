import java.util.Scanner;
public class PlayerList {
    static Scanner scan = new Scanner(System.in);
    private Player[] pList;
    private int MAX;
    private int counter;
    
    public PlayerList(){
        MAX = 5;
        pList = new Player[MAX];
        counter = 0;
        
    }

    public int getCount(){ return counter; }
    public int getMAX(){ return MAX; }


    public boolean createPlayer(String name){
        if(counter >= 5){
            System.out.println("player count is full!");
            return false;
        }
        else{
            counter++;
            pList[counter - 1] = new Player(name);
            return true;
        }
    }

    public boolean createPlayer(){
        if(counter >= 5){
            System.out.println("player count is full!");
            return false;
        }
        counter++;
        modifyPlayer();
        return true;
    }

    public void modifyPlayer(){
        

        pList[counter - 1] = new Player();

        System.out.print("Enter player name: ");
        pList[counter - 1].setPlayerName(scan.nextLine());

        System.out.println("Player Created!");
    }

    public Player pickPlayer(int index){
        if(counter == 0){
            return null;
        }
        else if(index < 1 || index > counter){
            return null;
        }
        else{
            return pList[index - 1];           
        }
    }

    public void displayList(){
        if(counter == 0){
            System.out.println("no players to display");
            return;
        }
        System.out.println("Player list");
        for(int i = 0; i < counter; i++){
            System.out.println("[" + (i + 1) + "]" + " " + pList[i].getPlayerName());
        }
    }
}
