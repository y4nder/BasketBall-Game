import java.util.Scanner;
public class PlayerList {
    static Scanner scan = new Scanner(System.in);
    private Player[] pList;
    private int MAX;
    private int counter;
    
    public PlayerList(){
        //default list
        MAX = 15;
        pList = new Player[MAX];
        pList[0] = new Player("James");
        pList[1] = new Player("Curry");
        pList[2] = new Player("Harden");
        pList[3] = new Player("Bryant");
        pList[4] = new Player("Butler");
        pList[5] = new Player("Antetokounmpo");
        counter = 6;
    }

    public int getCount(){ return counter; }
    public int getMAX(){ return MAX; }
    public Player getPlayer(int index){ return pList[index - 1]; }


    public boolean createPlayer(String name){
        if(counter >= MAX){
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
        if(counter >= MAX){
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

    public void playerEditor(int index){
        char op;
        do{
            System.out.println("\n[1] Player Name");
            System.out.println("[2] midrange");
            System.out.println("[3] three point");
            System.out.println("[4] dunk");
            System.out.println("[5] lay up");
            System.out.println("[6] steal");
            System.out.println("[7] rebound");
            System.out.println("[8] contest");
            System.out.println("[0] back <-\n");
            System.out.print("option > ");
            op = scan.nextLine().charAt(0);
        }
        while(edit(op, index) != '0');
    }

    private char edit(char op, int index){
        switch(op){
            case '1':
                System.out.print("Set new Player Name: ");
                pList[index - 1].setPlayerName(scan.nextLine());
                break;
            case '2':
                System.out.print("Set new midrange: ");
                pList[index - 1].setMidRange(scan.nextInt());
                break;
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '0':
                break;
        }
        return op;
    }

    public boolean removePlayer(String name){
        if(counter == 0) {
            System.out.println("Player list is empty");
            return false;
        }
        for(int i = 0; i < counter; i++){
            if(pList[i].getPlayerName().toUpperCase().equals(name.toUpperCase())){
                remove(i);
                System.out.println(name + " was removed from the list");
                return true;
            }
        }
        System.out.println("No such player.\n\n");
        return false;
    }

    private void remove(int index){
        for(int i = index; i < counter - 1; i++){
            pList[i] = pList[i + 1];
        }
        counter--;
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
