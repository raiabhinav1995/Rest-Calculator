package AllClasses;

public class GetCorrectClassForOperation {

    public static Operation getClassForOperation(String ch){
        return switch (ch) {
            case "add" -> new AdditionOperation();
            case "minus" -> new SubstractionOperation();
            case "product" -> new MultiplyOperation();
            case "division" -> new DivisionOperation();
            default -> null;
        };
    }
}
