package Main;

public abstract class GameThread implements Runnable {
	protected volatile boolean isPaused, isRunning;
    protected String name;
    public GameThread() {
    	
    }
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public void run() {
        isPaused = false;
        isRunning = true;
        while (isRunning) {
            if (isPaused) {
            	try {
					Thread.sleep(150);
					continue;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if(!isRunning)
                break;
            doSomething();
        }
    }

    public abstract void doSomething();

    public void stop() {
        isRunning=false;
        resume();
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }
    public boolean isRunning() {
    	return isRunning;
    }
    public boolean isPaused() {
    	return isPaused;
    }
}
