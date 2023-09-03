import java.util.Scanner;
import gameFiles.*;
public class Main {
    static BlacktopOnes game;
    static PlayerList list = new PlayerList();
    static Scanner scan = new Scanner(System.in);

    //main method
    public static void main(String[] args){
        System.out.println("BLACKTOP 1v1 GAME");
        System.out.println("made by: YANDER\n\n");
        showMainMenu();
        // System.out.println(list.getPlayer(1).getOverall());
        return;
    }
    
    //static methods
    static void showMainMenu(){
        char option;
        do{
            System.out.println("\n-----------MAIN MENU-----------   ");
            System.out.println("[1] Create a new game");
            System.out.println("[2] Create a player");
            System.out.println("[3] Remove a player");
            System.out.println("[4] Edit a player ----- (in development)");
            System.out.println("[X] Exit <-\n");
            System.out.print("option > ");
            option = scan.nextLine().toUpperCase().charAt(0);
            switch(option){
                case '1':
                    if(createGameMenu()){
                        showSubMenuCreateGame();
                    }
                    break;
                case '2': 
                    playerCreate();
                    break;
                case '3':
                    playerRemover();
                    break;
                case '4':
                    editPlayer();
                    break;
                case 'X':
                    System.out.println("\n\nBye :< ....");
                    return;
            }
        }
        while(option != 'X');
    }

    static void showSubMenuCreateGame(){
        char option;
        do{
            System.out.println("\n-----------CREATE A NEW GAME-----------");
            System.out.println("[1] Start 1v1");
            System.out.println("[X] back\n");
            System.out.print("option > ");
            option = scan.nextLine().toUpperCase().charAt(0);
            switch(option){
                case '1':
                    if(pickPlayers()){
                        startGame();
                    }            
                    return;
                case 'X':
                    return;
            }
        }
        while(option != 'X');
    }

    static boolean createGameMenu(){
        game = new BlacktopOnes();
        if(list.getCount() < game.getMAX()){
            System.out.println("Not enough Players");
            System.out.println("Choose option [2] to create a player");
            return false;
        }
        return true;
        
    }
    
    static boolean pickPlayers(){        
        String option;
        System.out.println("\n");
        list.displayList();
        System.out.println("[0] Back <-");
        while(game.gameIsSet() == false){
            System.out.print("\nCHOOSE PLAYER_" + (game.getPlayerCount() + 1) + " (1 - " + list.getCount() + ") : ");
            System.out.println("Type the number only");
            option = scan.nextLine();
            if(option.equals("0")) return false;
            int op = Integer.parseInt(option);
            game.setupGame(list.pickPlayer(op));
            System.out.println("PLAYER " + (game.getPlayerCount()) +  " is " + list.getPlayer(op).getPlayerName());
        }
        return true;
    }

    static void playerCreate(){
        if(list.getCount() >= list.getMAX()) return;
        System.out.println("\n-----------PLAYER CREATION-----------");
        System.out.print  ("      Player Name: ");
        list.createPlayer(scan.nextLine());
        System.out.println("      Player created\n");
    }

    static void startGame(){
        System.out.println("Game is starting...");
        game.startNewGame();
        game.showHightlights();
        char option;
        do{
            System.out.print("Press 'X' to go back: ");
            System.out.print("option > ");
            option = scan.nextLine().toUpperCase().charAt(0);
        }while(option != 'X');
        return;
    }

    static void playerRemover(){
        String name;
        do{
            list.displayList();
            if(list.getCount() == 0) return;
            System.out.println("[0] Back <-");
            System.out.print("Type the name of the player you want to remove: ");
            name = scan.nextLine();
            if(name.equals("0")) return;
        }while(list.removePlayer(name) == false);
    }

    static void editPlayer(){
        String option;
        System.out.println("\n ----------- EDIT PLAYERS ------------");
        list.displayList();
        if(list.getCount() == 0) return;
        System.out.println("[0] Back <-");
        option = scan.nextLine();
        if(option.equals("0")) return;
        int op = Integer.parseInt(option);
        if(op < 1 || op > 8) return;
        list.playerEditor( op );
    }
}