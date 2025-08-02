package patterns.structural.composite;

public class CompositeSolution {

    public static void main(String[] args){

        var folder = new Folder("root");
        folder.add(new File("file-1"));
        folder.add(new File("file-2"));
        folder.add(new File("file-3"));

        folder.operation();
    }

}