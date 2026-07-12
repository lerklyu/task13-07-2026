package task2;

public class Worker {

    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public void start() {
        for (int i = 0; i < 10; i++) {
            callback.onDone("Task " + (i+1) + " is done");
        }
    }
}
