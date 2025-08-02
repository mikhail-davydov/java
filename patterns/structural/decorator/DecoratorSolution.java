package patterns.structural.decorator;

public class DecoratorSolution {

    public static void main(String[] args){
        var mercedes = new Mercedes();
        var spoilerMercedes = new SpoilerDecorator(mercedes);
        var stickersSpoilerMercedes = new StickersDecorator(spoilerMercedes);

        System.out.println(mercedes);
        System.out.println(spoilerMercedes);
        System.out.println(stickersSpoilerMercedes);
    }

}