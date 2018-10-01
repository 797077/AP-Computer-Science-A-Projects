
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
                ballBot.setHeading((ballBot.getHeading()+45)%360);
            }
        }
    }

    public static void activityTwo(){
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entrancePoint = new TGPoint(0, 0);
        BallRunner ballRunner = new BallRunner();
        BallBot[] ballBotArray = new BallBot[10];
        int freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
        while(true){
            while(freeIndex != ballBotArray.length){
                int randomHeading = (int)(Math.random()*360);
                ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, randomHeading, (int)(Math.random()*30));
                freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
            }
            for(int i = 0; i<ballBotArray.length; i++){
                if(ballBotArray[i].canMoveForward(ballWorld)){
                    ballBotArray[i].moveForward();
                }else{
                    ballBotArray[i].setHeading((int)(Math.random()*360));
                }
            }
        }
    }

    public static void activityThree(){
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entrancePoint = new TGPoint(0, 0);
        BallRunner ballRunner = new BallRunner();
        BallBot[] ballBotArray = new BallBot[10];
        int freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
        ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), 25);
        while(true){
            if(freeIndex != ballBotArray.length){
                freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
                if(ballRunner.entranceClear(ballBotArray, entrancePoint)){
                    int randomHeading = (int)(Math.random()*360);
                    ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, randomHeading, 25);
                }
            }
            for(int i = 0; i<freeIndex; i++){
                if(ballBotArray[i].canMoveForward(ballWorld)){
                    ballBotArray[i].moveForward();
                }else{
                    ballBotArray[i].setHeading((int)(Math.random()*360));
                }
            }
        }
    }

    public static void activityFour(){
        BallWorld ballWorld = new BallWorld(500, 500);
        TGPoint entrancePoint = new TGPoint(0, 0);
        BallRunner ballRunner = new BallRunner();
        BallBot[] ballBotArray = new BallBot[10];
        int freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
        ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), 25);
        while(true){
            if(freeIndex != ballBotArray.length){
                freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
                if(ballRunner.entranceClear(ballBotArray, entrancePoint)){
                    int randomHeading = (int)(Math.random()*360);
                    ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, randomHeading, 25);
                }
            }
            for(int i = 0; i<freeIndex; i++){
                if(ballBotArray[i].canMoveForward(ballWorld)){
                    BallBot otherBallBot = ballRunner.ballBotToBounceOff(ballBotArray[i], ballBotArray);
                    if(otherBallBot==null){
                        ballBotArray[i].moveForward();
                    }else{
                        ballBotArray[i].setHeading((int)(Math.random()*360));
                        otherBallBot.setHeading((int)(Math.random()*360));
                    }
                }else{
                    ballBotArray[i].setHeading((int)(Math.random()*360));
                }
            }
        }
    }
    
    public static void activityFive(){
        BallWorld ballWorld = new BallWorld(500, 500);
        TGPoint entrancePoint = new TGPoint(0, 0);
        BallRunner ballRunner = new BallRunner();
        BallBot[] ballBotArray = new BallBot[10];
        int freeIndex = 0;
        while(true){
            if(freeIndex != ballBotArray.length){
                freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
                int randomRadius = (int)(Math.random()*60)+20;
                if(ballRunner.entranceClearActivityFive(ballBotArray, entrancePoint, randomRadius)){
                    int randomHeading = (int)(Math.random()*360);
                    ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, randomHeading, randomRadius);
                    ballBotArray[freeIndex].setColor((int)(Math.random()*30)+5);
                    ballBotArray[freeIndex].setPixelsPerSecond((int)(Math.random()*130)+20);
                }
            }
            for(int i = 0; i<freeIndex; i++){
                if(ballBotArray[i].canMoveForward(ballWorld)){
                    BallBot otherBallBot = ballRunner.ballBotToBounceOff(ballBotArray[i], ballBotArray);
                    if(otherBallBot==null){
                        ballBotArray[i].moveForward();
                    }else{
                        ballBotArray[i].setHeading((int)(Math.random()*360));
                        otherBallBot.setHeading((int)(Math.random()*360));
                    }
                }else{
                    ballBotArray[i].setHeading((int)(Math.random()*360));
                }
            }
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

    public double distanceBetweenPoints(TGPoint point1, TGPoint point2){
        double difX = point1.x-point2.x;
        double difY = point1.y-point2.y;
        return Math.sqrt((difX*difX) + (difY*difY));
    }

    public boolean entranceClear(BallBot[] ballBotArray, TGPoint entrancePoint){
        for(int i = 0; i<ballBotArray.length; i++){
            if(ballBotArray[i] != null){
                if(distanceBetweenPoints(entrancePoint, ballBotArray[i].getPoint())<2*ballBotArray[i].getRadius()){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean entranceClearActivityFive(BallBot[] ballBotArray, TGPoint entrancePoint, int randomRadius){
        for(int i = 0; i<ballBotArray.length; i++){
            if(ballBotArray[i] != null){
                if(distanceBetweenPoints(entrancePoint, ballBotArray[i].getPoint())<ballBotArray[i].getRadius()+randomRadius){
                    return false;
                }
            }
        }
        return true;
    }

    public BallBot ballBotToBounceOff(BallBot ballBot, BallBot[] ballBotArray){
        TGPoint firstPoint = ballBot.getPoint();
        TGPoint nextPoint = ballBot.forwardPoint();
        for(int i = 0; i<ballBotArray.length; i++){
            BallBot otherBallBot = ballBotArray[i];
            if(otherBallBot!=null){
                if(otherBallBot.getPoint()!=nextPoint & otherBallBot != ballBot){
                    double currentDistance = distanceBetweenPoints(firstPoint, otherBallBot.getPoint());
                    double nextDistance = distanceBetweenPoints(nextPoint, otherBallBot.getPoint());
                    if(currentDistance<=ballBot.getRadius()+otherBallBot.getRadius() & nextDistance<=currentDistance){
                        return otherBallBot;
                    }
                }
            }
        }
        return null;
    }
}
