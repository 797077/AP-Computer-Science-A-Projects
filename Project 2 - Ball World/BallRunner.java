
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
        //declare and initialize BallWorld, TGPoints, and BallBot
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint tgPoint = new TGPoint(0, 0);
        BallBot ballBot = new BallBot(ballWorld, tgPoint, 0.0, 25);
        //run method
        while(true){
            //check if can move forward
            if(ballBot.canMoveForward(ballWorld)){
                ballBot.moveForward();
            }else{
                //rotate by 45 degrees
                ballBot.setHeading((ballBot.getHeading()+45)%360);
            }
        }
    }

    public static void activityTwo(){
        //declare and initialize BallWorld, TGPoints, and BallBot
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entrancePoint = new TGPoint(0, 0);
        BallRunner ballRunner = new BallRunner();
        //create array of ballBots and find index where array is null
        BallBot[] ballBotArray = new BallBot[10];
        int freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
        //run method
        while(true){
            //load ballBotArray with new BallBots
            while(freeIndex != ballBotArray.length){
                int randomHeading = (int)(Math.random()*360);
                ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, randomHeading, (int)(Math.random()*30));
                freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
            }
            for(int i = 0; i<ballBotArray.length; i++){
                //how BallBots move
                if(ballBotArray[i].canMoveForward(ballWorld)){
                    ballBotArray[i].moveForward();
                }else{
                    ballBotArray[i].setHeading((int)(Math.random()*360));
                }
            }
        }
    }

    public static void activityThree(){
        //declare and initialize BallWorld, TGPoints, and BallBot
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entrancePoint = new TGPoint(0, 0);
        BallRunner ballRunner = new BallRunner();
        //create array of ballBots and find index where array is null
        BallBot[] ballBotArray = new BallBot[10];
        int freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
        ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), 25);
        //run method
        while(true){
            //check if ballBotArray is full of BallBots
            if(freeIndex != ballBotArray.length){
                //find where ballBotArray is null
                freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
                //check if entrancePoint of BallBots is clear
                if(ballRunner.entranceClear(ballBotArray, entrancePoint)){
                    //creates a BallBot in ballBotArray at freeIndex
                    int randomHeading = (int)(Math.random()*360);
                    ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, randomHeading, 25);
                }
            }
            //how BallBots that have been created will run
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
        //declare and initialize BallWorld, TGPoints, and BallBot
        BallWorld ballWorld = new BallWorld(500, 500);
        TGPoint entrancePoint = new TGPoint(0, 0);
        BallRunner ballRunner = new BallRunner();
        //create array of ballBots and find index where array is null
        BallBot[] ballBotArray = new BallBot[10];
        int freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
        ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), 25);
        //run method
        while(true){
            //check if ballBotArray is full of BallBots
            if(freeIndex != ballBotArray.length){
                //find where ballBotArray is null
                freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
                //check if entrancePoint of BallBots is clear
                if(ballRunner.entranceClear(ballBotArray, entrancePoint)){
                    //creates a BallBot in ballBotArray at freeIndex
                    int randomHeading = (int)(Math.random()*360);
                    ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, randomHeading, 25);
                }
            }
            //how BallBots that have been created will run
            for(int i = 0; i<freeIndex; i++){
                //if a BallBot can move forward
                if(ballBotArray[i].canMoveForward(ballWorld)){
                    //if the BallBot is about to run into another BallBot, returns other BallBot
                    BallBot otherBallBot = ballRunner.ballBotToBounceOff(ballBotArray[i], ballBotArray);
                    //if not about to run into another BallBot
                    if(otherBallBot==null){
                        ballBotArray[i].moveForward();
                    }else{
                        //if about to run into another BallBot, change direction
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
        //declare and initialize BallWorld, TGPoints, and BallBot
        BallWorld ballWorld = new BallWorld(500, 500);
        TGPoint entrancePoint = new TGPoint(0, 0);
        BallRunner ballRunner = new BallRunner();
        //create array of ballBots and find index where array is null
        BallBot[] ballBotArray = new BallBot[10];
        int freeIndex = 0;
        //run method
        while(true){
            //check if ballBotArray is already full of BallBots
            if(freeIndex != ballBotArray.length){
                //declare the radius of and index where the next BallBot will be created
                freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
                int randomRadius = (int)(Math.random()*60)+20;
                //checks if the entrancePoint where the new BallBot will be created is clear
                if(ballRunner.entranceClearActivityFive(ballBotArray, entrancePoint, randomRadius)){
                    //creates a BallBot in ballBotArray at freeIndex
                    int randomHeading = (int)(Math.random()*360);
                    ballBotArray[freeIndex] = new BallBot(ballWorld, entrancePoint, randomHeading, randomRadius);
                    //sets color and speed of the new BallBot
                    ballBotArray[freeIndex].setColor((int)(Math.random()*30)+5);
                    ballBotArray[freeIndex].setPixelsPerSecond((int)(Math.random()*150)+20);
                }
            }
            //how BallBots that have been created will run
            for(int i = 0; i<freeIndex; i++){
                if(ballBotArray[i].canMoveForward(ballWorld)){
                    //if the BallBot is about to run into another BallBot, returns other BallBot
                    BallBot otherBallBot = ballRunner.ballBotToBounceOff(ballBotArray[i], ballBotArray);
                    //if not about to run into another BallBot
                    if(otherBallBot==null){
                        ballBotArray[i].moveForward();
                    }else{
                        //if about to run into another BallBot, change direction
                        ballBotArray[i].setHeading((int)(Math.random()*360));
                        otherBallBot.setHeading((int)(Math.random()*360));
                    }
                }else{
                    //changes direction if the BallBot is about to run into a wall and cannot move forward
                    ballBotArray[i].setHeading((int)(Math.random()*360));
                }
            }
        }
    }

    public int findFreeBallBotIndex(BallBot[] ballBotArray){
        //traverse the array
        for(int i = 0; i<ballBotArray.length; i++){
            //if there is an empty spot in ballBotArray, return index of that spot
            if(ballBotArray[i]==null){
                return i;
            }
        }
        //the array is full, so returns array length
        return ballBotArray.length;
    }

    public double distanceBetweenPoints(TGPoint point1, TGPoint point2){
        //returns distance between two points
        double difX = point1.x-point2.x;
        double difY = point1.y-point2.y;
        return Math.sqrt((difX*difX) + (difY*difY));
    }

    public boolean entranceClear(BallBot[] ballBotArray, TGPoint entrancePoint){
        //traverse the array
        for(int i = 0; i<ballBotArray.length; i++){
            //checks if there is a BallBot existing at that index in array
            if(ballBotArray[i] != null){
                //checks if there are no BallBots overlapping where the a BallBot would be created at entrancePoint
                if(distanceBetweenPoints(entrancePoint, ballBotArray[i].getPoint())<2*ballBotArray[i].getRadius()){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean entranceClearActivityFive(BallBot[] ballBotArray, TGPoint entrancePoint, int randomRadius){
        //same as method entranceClear, except it accounts for BallBots with different radii
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
        //find ballBot current TGPoint position and its next TGPoint position
        TGPoint firstPoint = ballBot.getPoint();
        TGPoint nextPoint = ballBot.forwardPoint();
        //traverse the array
        for(int i = 0; i<ballBotArray.length; i++){
            BallBot otherBallBot = ballBotArray[i];
            //checks if there is a BallBot existing in array at that index
            if(otherBallBot!=null){
                //checks if otherballBot is not ballBot
                if(otherBallBot.getPoint()!=nextPoint & otherBallBot != ballBot){
                    //finding current and next distances between otherBallBot and ballBot
                    double currentDistance = distanceBetweenPoints(firstPoint, otherBallBot.getPoint());
                    double nextDistance = distanceBetweenPoints(nextPoint, otherBallBot.getPoint());
                    //if otherBallBot and ballBot will crash into each other, return otherBallBot
                    if(currentDistance<=ballBot.getRadius()+otherBallBot.getRadius() & nextDistance<=currentDistance){
                        return otherBallBot;
                    }
                }
            }
        }
        //no BallBot is about to crash into ballBot
        return null;
    }
}
