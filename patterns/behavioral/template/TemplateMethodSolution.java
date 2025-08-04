package patterns.behavioral.template;

public class TemplateMethodSolution {

    public static void main(String[] args){
        var cityCarBuilder = new CityCarBuilder();
        var sportCarBuilder = new SportCarBuilder();

        cityCarBuilder.build();
        System.out.println();
        sportCarBuilder.build();
    }

}