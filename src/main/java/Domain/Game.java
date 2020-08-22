package Domain;

public abstract class Game {

    public void play() {
        initializeGame();
        winOrLose();
        while(!isEnd()) {
            reInitailizeGame();
            winOrLose();
        }
    }

    public abstract boolean join(String name);
    public abstract boolean leave(String name);

    protected abstract void initializeGame();
    protected abstract void winOrLose();
    protected abstract boolean isEnd();
    protected abstract void reInitailizeGame();

}
