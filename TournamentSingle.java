public class TournamentSingle {
    private BlacktopOnes tourna;
    private Player players[];
    private Player finals[];
    private final static int MAX_PLAYERS = 4;
    private int count;
    private String details;

    public TournamentSingle(){ 
        tourna = new BlacktopOnes();
        players = new Player[MAX_PLAYERS];
        finals = new Player[MAX_PLAYERS/2];
        count = 0;
        details = "";
    }

    public void startTournament(){
        if(count == MAX_PLAYERS){
            detailAdd("tournament started");
            int i = 0, j = 0, l = 0;;
            while(i < MAX_PLAYERS/2){
                detailAdd(players[j].getPlayerName() + " VS. " + players[j+1].getPlayerName());
                finals[i] = tourna.startNewGame(players[j], players[j+1]);
                detailAdd(tourna.getGameDetails());
                detailAdd(finals[i].getPlayerName() + " ADVANCES!");
                detailAdd("------------------------------------------------");
                i++;
                j+=2;
            }
            startFinals();
        }
        else{
            detailAdd("tournament failed not enough players");
        }
    }

    private void startFinals(){
        detailAdd("FINALS --> " + finals[0].getPlayerName() + " VS. " + finals[1].getPlayerName());
        Player winner = tourna.startNewGame(finals[0], finals[1]);
        detailAdd(tourna.getGameDetails());
        displayParticipants();
        detailAdd("The winner of the tournament is " + winner.getPlayerName().toUpperCase());
    }

    // settings players
    public boolean add(Player p){
        if(count < MAX_PLAYERS){
            count++;
            players[count - 1] = p;
            return true;
        }
        else{
            detailAdd("tournament full");
            return false;
        }
    }

    // remove player
    public boolean remove(String name){
        int i = findPlayer(name);
        //if player is not found return false;
        if(i == -1){
            return false;
        }
        else{
            //if player index is at the last position
            if(i == count - 1){
                count--;
                return true;
            }
            else{
                //algorithm to transfer position (j + 1) to j
                for(int j = i; j < count - 1; j++){
                    players[j] = players[j + 1];
                }
                count--;
                return true;
            }
        }
    }

    //find index of a player through name
    private int findPlayer(String name){
        for(int i = 0; i < count; i++){
            if(players[i].getPlayerName().toLowerCase().equals(name.toLowerCase())){
                return i;
            }
        }
        return -1;
    }

    // displayers
    public void displayParticipants(){
        detailAdd("Participants of the Tournament");
        for(int i = 0; i < count; i++){
            detailAdd("[" + (i + 1) + "]" + players[i].getPlayerName());
        }
    }

    public void showTournamentHighlights(){
        System.out.println(details);
    }

    //detail adder
    private void detailAdd(String message){
        StringBuilder sb = new StringBuilder(details);
        sb.append(message).append("\n");
        details = sb.toString();
    }
}
