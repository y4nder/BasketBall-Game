public class BlacktopOnes {
    private int MAX_SCORE;
    private String gameDetails;
    private Player[] p;
    private int MAX;
    private int counter;
    private boolean gameSet;

    public BlacktopOnes(){
        MAX_SCORE = 11;
        gameDetails = "";
        MAX = 2;
        p = new Player[MAX];
        counter = 0;
        gameSet = false;
    }

    public BlacktopOnes(int max){
        MAX_SCORE = max;
        gameDetails = "";
        MAX = 2;
        p = new Player[MAX];
        counter = 0;
        gameSet = false;
    }

    public String getGameDetails(){
        return gameDetails;
    }

    public boolean setupGame(Player player){      
        counter++;

        if(counter > 1){ //check for duplicates
            if(checkDuplicate(player)){
                System.out.println("Player already added");
                counter--;
                return false;
            }
        }

        if(counter == MAX){
            setGame(true); //game is good to go
        }

        p[counter - 1] = player;
        return true;
    }

    private boolean checkDuplicate(Player player){
        if(player.getPlayerName().equals(p[0].getPlayerName())){
            return true;
        }
        return false;
    }

    private void setGame(boolean x) {
        gameSet = x;
    }

    public boolean gameIsSet(){
        return gameSet;
    }

    public int getPlayerCount(){ return counter; }

    public Player startNewGame(){
        System.out.println("playing..");
        gameDetails = "";
        p[0].setScore(0);
        p[1].setScore(0);
        p[0].setHasBall(true);

        while (p[0].getScore() < MAX_SCORE && p[1].getScore() < MAX_SCORE) {
            if (p[0].getHasBall()) {
                ballPossession(p[0], p[1]);
            }
            else{
                ballPossession(p[1], p[0]);
            }
        }

        return determineWinner(p);
    }

    private void ballPossession(Player p1, Player p2){
        while(p1.getHasBall()){
            if(p1.getScore() >= MAX_SCORE){ 
                return;
            }
            detailAdd("\n" + p[0].getPlayerName() + " has possession.");
            if (p1.stealBall(p2)) {
                detailAdd(p1.getActionDetails());
                return;
            }
            int score = p1.chooseOffense(p2);
            detailAdd(p1.getActionDetails());
            if (score != 0) {
                p1.addScore(score);
                detailAdd(p1.getPlayerName() + " gained " + score + "pts");
                detailAdd("\n      CURRENT SCORES ");
                showPlayerScores(p);
            }
        }
    }

    private Player determineWinner(Player p[]) {
        if (p[0].getScore() > p[1].getScore()) {
            // System.out.println(p[0].getPlayerName() + " won the 1v1");
            detailAdd(p[0].getPlayerName() + " winner");
            return p[0];
        } else {
            // System.out.println(p[1].getPlayerName() + " won the 1v1");
            detailAdd(p[1].getPlayerName() + " winner");
            return p[1];
        }
    }


    private void detailAdd(String message){
        StringBuilder sb = new StringBuilder(gameDetails);
        sb.append(message).append("\n");
        gameDetails = sb.toString();
    }

    private void showPlayerScores(Player p[]){
        if(p[0].getScore() > p[1].getScore()){
            detailAdd("       " + p[0].getPlayerName().toUpperCase() + ": " + p[0].getScore() );
            detailAdd("       " + p[1].getPlayerName().toUpperCase() + ": " + p[1].getScore() );
        }
        else{
            detailAdd("       " + p[1].getPlayerName().toUpperCase() + ": " + p[1].getScore() );
            detailAdd("       " + p[0].getPlayerName().toUpperCase() + ": " + p[0].getScore() );
        }
    }

    //displayers
    public void showHightlights(){
        System.out.println("SHOWING WHAT HAPPENED DURING THE GAME..");
        System.out.println(gameDetails);
    }

    public void showParticipants(){
        for(int i = 0;i < counter; i++){
            System.out.println(p[i].getPlayerName());
        }
    }
}
