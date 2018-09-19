
/**
 * Project 2 - Ball World
 *
 * @author (Grace Jau)
 * @version (914)
 */
public class BallRunner
{
    /**
     * Constructor for objects of class BallRunner
     */
    public BallRunner(){
        
    }
    
    public static void activityOne(){
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint tgPoint = new TGPoint(0, 0);
        BallBot ballBot = new BallBot(ballWorld, tgPoint, 0.0, 25);
        while(true){
            if(ballBot.canMoveForward(ballWorld)){
                ballBot.moveForward();
            }else{
                ballBot.setHeading(ballBot.getHeading()%360+45);
            }
        }
    }
    
    public static void activityTwo(){
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint tgPoint = new TGPoint(0, 0);
        BallBot ballBot = new BallBot(ballWorld, tgPoint, 0.0, 25);
        BallRunner ballRunner = new BallRunner();
        BallBot[] ballBotArray = new BallBot[10];
        while(true){
            
        }
    }
    
    
    public int findFreeBallBotIndex(BallBot[] ballBotArray){
        for(int i = 0; i<ballBotArray.length; i++){
            if(ballBotArray[i]==null){
                return i;
            }
        }
        return ballBotArray.length;
    }
}
