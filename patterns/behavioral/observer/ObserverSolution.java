package patterns.behavioral.observer;

public class ObserverSolution {

    public static void main(String[] args){
        var topic = new Alert();
        topic.attach(new CarSystemConsumer("Mercedes"));
        topic.attach(new CarSystemConsumer("BMW"));
        topic.attach(new CarSystemConsumer("VW"));

        topic.notify("Stop immediately!");
    }

}