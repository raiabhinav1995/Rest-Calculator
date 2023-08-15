package AllClasses;

public class Context {
    private final Operation operation;
    private int result;
    public Context(Operation op){
        operation=op;
    }
    public void performOperation(int a, int b){
      result=this.operation.performOperation(a, b);
    }

    public int getResult() {
        return result;
    }
}
