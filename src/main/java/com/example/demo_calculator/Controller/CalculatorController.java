package com.example.demo_calculator.Controller;
import AllClasses.Context;
import AllClasses.GetCorrectClassForOperation;
import AllClasses.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private Context calculatorRef;
    private int result;
    @GetMapping("/init")
    public boolean initCalculator(@RequestParam int num1, @RequestParam int num2, @RequestParam String operation) {
        try{
            calculatorRef=this.getOperation(operation);
        }
        catch(Exception e){
            return false;
        }
        calculatorRef.performOperation(num1, num2);
        result=calculatorRef.getResult();
        return true;
    }
    @GetMapping("/add")
    public int add(@RequestParam int num1) {
        try{
            calculatorRef=this.getOperation("add");
        }
        catch(Exception e){
            return -1;
        }
        calculatorRef.performOperation(result, num1);
        return result=calculatorRef.getResult();
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int num1) {
        try{
            calculatorRef=this.getOperation("product");
        }
        catch(Exception e){
            return -1;
        }
        calculatorRef.performOperation(result, num1);
        return result=calculatorRef.getResult();
    }

    @GetMapping("/divide")
    public int division(@RequestParam int num1) {
        try{
            calculatorRef=this.getOperation("division");
        }
        catch(Exception e){
            return -1;
        }
        calculatorRef.performOperation(result, num1);
        return result=calculatorRef.getResult();
    }
    @GetMapping("/minus")
    public int subtract(@RequestParam int num1) {
        try{
            calculatorRef=this.getOperation("minus");
        }
        catch(Exception e){
            return -1;
        }
        calculatorRef.performOperation(result, num1);
        return result=calculatorRef.getResult();
    }
    private Context getOperation(String op) throws Exception{
        Operation o=GetCorrectClassForOperation.getClassForOperation(op);
        if(o==null){
            throw new Exception("Operation not supported");
        }
        return new Context(o);
    }
    CalculatorController(){
        this.calculatorRef=new Context(null);
    }
}
