package patterns.structural.facade;

public record DriveFacade(Engine engine, Transmission transmission, GasPedal gasPedal) {

    public void drive() {
        engine.start();
        transmission.pick();
        gasPedal.press();
    }

    public void stop() {
        gasPedal.release();
        transmission.cancel();
        engine.stop();
    }

}