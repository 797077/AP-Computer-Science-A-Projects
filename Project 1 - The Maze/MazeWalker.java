
/**
 * Project 1 - Maze Walker
 *
 * @author (Grace Jau)
 * @version (830)
 */
public class MazeWalker
{
    // instance variables - replace the example below with your own
    
    public MazeWalker(int difficultyIndex)
    {
        
    }

    public static void run(){
        Maze maze = new Maze(3);
        MazeWalker mazeWalker = new MazeWalker(3);
        mazeWalker.walkMaze(maze, maze.getMazeBot());
    }
    
    public void walkMaze(Maze maze, MazeBot mazeBot){
        
        while(mazeBot.didNotReachGoal()){
            for(int i=4; i>0; i-=1){
                mazeBot.turnLeft();
                if(mazeBot.canMoveForward()){
                    mazeBot.moveForward();
                    if(mazeBot.getBreadCrumbObject() == "0"){
                        mazeBot.turnLeft();
                        mazeBot.turnLeft();
                        mazeBot.moveForward();
                        mazeBot.turnLeft();
                        mazeBot.turnLeft();
                    }else{
                        i = 0;
                        mazeBot.setBreadCrumbObject("0");
                    }
                }else{
                    mazeBot.turnLeft();
                    mazeBot.turnLeft();
                }
                if(mazeBot.didReachGoal()){
                    mazeBot.signalSuccess();
                    return;
                }
            }
            for(int w=4; w>0; w-=1){
                mazeBot.turnLeft();
                if(mazeBot.canMoveForward()){
                    w = 0;
                    mazeBot.moveForward();
                    mazeBot.setBreadCrumbObject("5");
                }else{
                    mazeBot.turnLeft();
                    mazeBot.turnLeft();
                }
                if(mazeBot.didReachGoal()){
                    mazeBot.signalSuccess();
                    return;
                }
            }
        }
    }
}
