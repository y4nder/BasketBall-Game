package gameFiles;
import java.util.Random;
public class Player {
    private static int Default_VAL = 60;
    private static Random ran = new Random();
    private String playerName;
    private String detailedActions;
    private int score;
    private int overall;

    //offense
    private int midRange;
    private int threePoint;
    private int dunk;
    private int layUp;

    //defense
    private int steal;
    private boolean hasBall;
    private int rebound;
    private int contest;

    public Player(String name){
        playerName = name;
        midRange = Default_VAL;
        threePoint = Default_VAL;
        dunk = Default_VAL;
        layUp = Default_VAL;
        steal = Default_VAL; 
        rebound = Default_VAL;
        contest = Default_VAL;
        overall = (midRange + threePoint + dunk + layUp + steal + rebound + contest) / 7;
        hasBall = false;
        detailedActions = "";
        score =  0;
    }

    public Player(){
        playerName = "";
        midRange = Default_VAL;
        threePoint = Default_VAL;
        dunk = Default_VAL;
        layUp = Default_VAL;
        steal = Default_VAL; 
        rebound = Default_VAL;
        contest = Default_VAL;
        hasBall = false;
        detailedActions = "";
        score =  0;
    }

    //setters
    public void setPlayerName(String name){ playerName = name;}
    public void setMidRange(int mid){ midRange = mid; updateOVR(); }
    public void setDunk(int dunk){ this.dunk = dunk; updateOVR(); }
    public void setLayUp(int layUp){ this.layUp = layUp; updateOVR(); }
    public void setThreePoint(int three){ threePoint = three; updateOVR(); }
    public void setSteal(int stl){ steal = stl; updateOVR();}
    public void setRebound(int reb){ rebound = reb; updateOVR(); }
    public void setContest(int contest){ this.contest = contest; updateOVR(); }

    public void setHasBall(boolean ball){ hasBall = ball; }
    public void setScore(int num){ score = num; }
    public void addScore(int num){ score += num; }
    public void resetDetail(){ detailedActions = ""; }

    //overall updater
    public void updateOVR(){
        overall = (midRange + threePoint + dunk + layUp + steal + rebound + contest) / 7;
    }

    //getters
    public String getPlayerName(){ return playerName; }
    public int getStealRt(){ return steal; }
    public int getContest() { return contest; }
    public int getMidRange(){ return midRange; }
    public int getThreePoint(){ return threePoint; }
    public int getDunk(){ return dunk; }
    public int getLayUp(){ return layUp; }
    public int getSteal(){ return steal; }
    public int getRebound(){ return rebound; }

    public boolean getHasBall(){ return hasBall; }
    public String getActionDetails(){ return detailedActions; }
    public int getScore(){ return score; }
    public int getOverall(){ return overall; }

    //displayers
    private void detailBuilder(String message){ detailedActions += message; }
    public void showActions(){ System.out.println(detailedActions); }
    public void showScore(){ System.out.println(score); }

    //offense 
    public int chooseOffense(Player p2){
        resetDetail();
        switch(getRandomOff()){
            case 1: return chooseShot(p2);
            case 2: 
                detailBuilder(getPlayerName() + " drove to the basket\n");
                return chooseLayOrDunk(p2);
        }
        return 0;
    }

    
    //defense


    private int chooseShot(Player p2){
        int cont = 0;
        switch(getRandomShot()){
            case 1: 
                detailBuilder(getPlayerName() + " attempts a midrange shot\n");
                return midrangeShot(p2, cont);
            case 2:
                detailBuilder(getPlayerName() + " attempts a three-point shot\n");
                return threePoint(p2, cont);
        }
        return 0;
    }

    private int chooseLayOrDunk(Player p2){
        int cont = 0;
        switch(getRandomShot()){
            case 1: 
                detailBuilder(getPlayerName() + " attempts a lay Up\n");
                return layUpBall(p2, cont);
            case 2:
                detailBuilder(getPlayerName() + " attempts a Dunk\n");
                return dunkBall(p2, cont);
        }
        return 0;
    }

    //shooting

    public interface ShotStrategy {
        int shoot(Player p2, String shotType,int points);
    }

    public class MadeShotStrategy implements ShotStrategy {
        public int shoot(Player p2, String shotType, int points) {
            detailBuilder(getPlayerName() + " " + shotType + " went in");
            gainPossession(p2);
            return points;
        }
    }

    public class MissedShotStrategy implements ShotStrategy {
        public int shoot(Player p2, String shotType, int points) {
            detailBuilder(getPlayerName() + " missed.\n");
            reboundBall(p2);
            return 0;
        }
    }

    //shooting mechanic
    private int shoot(Player p2, String shotType, int rating, int cntstRate, int points){ 
        int contestRating;
        if(cntstRate != 0)
            contestRating = cntstRate;
        else contestRating = 0;

        ShotStrategy strategy;
        if((getPct() - ( rating - (contestRating * 0.2) ) ) < 0){
            strategy = new MadeShotStrategy();
        }
        else {
            strategy = new MissedShotStrategy();
        }
        return strategy.shoot(p2, shotType,points);
    }

    //shot types
    private int midrangeShot(Player p2, int cont){
        return shoot(p2, "midrange shot", midRange, cont, 2);
    }

    private int threePoint(Player p2, int cont){
        return shoot(p2, "three-point shot",threePoint, cont, 3);
    }

    private int layUpBall(Player p2, int cont){
        return shoot(p2, "lay up", layUp, cont, 2);
    }

    private int dunkBall(Player p2, int cont){
        return shoot(p2, "Dunk", layUp, cont, 2);
    }

    //rebound
    public boolean reboundBall(Player p2){
        if((getPct() - rebound) < 0){
            detailBuilder(getPlayerName() + " rebounds the ball");
            gainPossessionDef(p2);
            return true;
        }
        else {
            detailBuilder(p2.getPlayerName() + " got the ball back");
            return false;
        }
    }

    public interface DefStrategy {
        int defend(Player p2, int defStrat, int points);
    }

    public class Fouled implements DefStrategy {
        public int defend(Player p2, int defStrat, int points){
            detailBuilder(p2.getPlayerName() + " fouled " + getPlayerName());
            return 0;
        }
    }

    public class stealBall2 implements DefStrategy {
        public int defend(Player p2, int defStrat, int points){
            detailBuilder(p2.getPlayerName() + " stole the ball");
            gainPossessionDef(p2);
            return 0;
        }
    }

    public int defend(Player p2, int defStrat, int points){
        DefStrategy strat;
        if( (getPct()  - (defStrat * 0.5) * 0.2) < 0){
            strat = new Fouled();
        }
        else{
            if((getPct() - (defStrat * 0.2)) < 0){
                strat = new stealBall2();
                gainPossessionDef(p2);
            }
            else{
                return 0;
            }
        }
        
        return strat.defend(p2, defStrat, points);
    }

    public int trySteal(Player p2, int stl){
        return defend(p2, steal, 0);
    }

    //steal 
    public boolean stealBall(Player p2){
        resetDetail();
        double pct = getPct();
        if( (pct -= (steal * 0.5) * 0.2) < 0){
            detailBuilder(getPlayerName() + " reach-in foul");
            return true;
        }
        else{
            if((pct -= steal * 0.2) < 0){
                detailBuilder(getPlayerName() + " stole the ball!");
                gainPossessionDef(p2);
                return true;
            }
            else return false;
        }
    }

    //block 

    //possession methods
    private void gainPossessionDef(Player p2){
        setHasBall(true);
        p2.setHasBall(false);
    }

    private void gainPossession(Player p2){   
        setHasBall(false);
        p2.setHasBall(true);
    }
    //random generators
    private int getRandomOff(){
        return ran.nextInt(2) + 1;
    }

    private int getRandomShot(){
        return ran.nextInt(2) + 1;
    }

    public double getPct(){
        return Math.random()*100;
    }

    public void showPlayerInfo(){
        System.out.println("\n-----" + getPlayerName() + " 's attributes-----");
        System.out.println("name: " + getPlayerName());
        System.out.println("midrange: " + getMidRange());
        System.out.println("three point: " + getThreePoint());
        System.out.println("Dunk: " + getDunk());
        System.out.println("Lay Up: " + getLayUp());
        System.out.println("Steal: " + getSteal());
        System.out.println("Rebound: " + getRebound());
        System.out.println("Contest: " + getContest());
    }

    public void showPlayerOverall(){
        System.out.print("--- OVR " + getOverall() + "\n");
    }
}
