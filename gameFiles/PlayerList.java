package gameFiles;
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
            System.out.println("------CHOOSE WHAT ATTRIBUTE TO EDIT------");
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
            op = scan.next().charAt(0);
            if(op != '0') edit(op, index);
        }
        while(op != '0');
    }

    private void edit(char op, int index){
        boolean x = false;
        do{
            switch(op){
                case '1':
                    System.out.println("Current Name: " + pList[index - 1].getPlayerName());
                    System.out.print("Set new Player Name: ");
                    pList[index - 1].setPlayerName(scan.next());
                    return;
                case '2':
                    System.out.println("Current midrange rating: " + pList[index - 1].getMidRange());
                    System.out.print("Set new midrange: ");
                    pList[index - 1].setMidRange(scan.nextInt());
                    return;
                case '3':
                    System.out.println("Current Three Point rating: " + pList[index - 1].getThreePoint());
                    System.out.println("Set new Three point");
                    pList[index - 1].setThreePoint(scan.nextInt());
                    return;
                case '4':
                    System.out.println("Current Dunk rating: " + pList[index - 1].getDunk());
                    System.out.println("Set new Dunk");
                    pList[index - 1].setDunk(scan.nextInt());
                    return;      
                case '5':
                    System.out.println("Current Lay Up rating: " + pList[index - 1].getLayUp());
                    System.out.println("Set new Lay up");
                    pList[index - 1].setLayUp(scan.nextInt());
                    return;      
                case '6':
                    System.out.println("Current Steal rating: " + pList[index - 1].getSteal());
                    System.out.println("Set new steal");
                    pList[index - 1].setSteal(scan.nextInt());
                    return;      
                case '7':
                    System.out.println("Current Rebound rating: " + pList[index - 1].getRebound());
                    System.out.println("Set new rebound");
                    pList[index - 1].setRebound(scan.nextInt());
                    return;      
                case '8':
                    System.out.println("Current Contest rating: " + pList[index - 1].getContest());
                    System.out.println("Set new Contest");
                    pList[index - 1].setContest(scan.nextInt());
                    return;      
                case '0':
                    return;
                default:
                    x = true;
            }
        }
        while(x == true);
        return;
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

    public boolean removAllPlayers(){
        if(counter == 0){
            System.out.println("No Players to remove");
            return false;
        }
        counter = 0;
        System.out.println("All players removed");
        return true;
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
            System.out.print("[" + (i + 1) + "]" + " " + pList[i].getPlayerName() + " ");
            pList[i].showPlayerOverall();
        }
    }

    
}
