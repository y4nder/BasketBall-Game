import java.util.Scanner;
public class Main {
    static BlacktopOnes game;
    static PlayerList list = new PlayerList();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){

        // list.createPlayer("leander");
        // list.createPlayer("harden");
        // list.displayList();

        // while( game1.gameIsSet() == false ){
        //     System.out.print("Pick a Player");
        //     game1.setupGame(list.pickPlayer(scan.nextInt()));
        // }
        // game1.showParticipants();
        // game1.startNewGame();
        // game1.showHightlights();
        showMainMenu();
        char option = scan.nextLine().charAt(0);
        switch(option){
            case '1':
                break;

            case '2': 
                break;

            case 'X':
                break;
        }


    }
    
    static void showMainMenu(){
        System.out.println("[1] Create a game");
        System.out.println("[2] Create a player");
        System.out.println("[X] Exit");
    }

    static void showSubMenuCreateGame(){
        System.out.println("[1] Start Game");
        System.out.println("[X] back");
    }

    static void createGameMenu(){
        if(list.getCount() != game.getPlayerCount()){
            System.out.println("Not enough Players");
            return;
        }
        game = new BlacktopOnes();
    }
    
    static void pickPlayers(){        
        while(game.gameIsSet() == false){
            System.out.print("Pick a Player: ");
            game.setupGame(list.pickPlayer(scan.nextInt()));
        }
    }
}