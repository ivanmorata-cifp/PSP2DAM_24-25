package Tema0;

public class Calculadora {
    private double op1, op2;

    public double getOp1() {
        return op1;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public double getOp2() {
        return op2;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }

    public double suma(){
        return op1+op2;
    }

    public double resta(){
        return op1-op2;
    }

    public double multiplicacion(){
        return op1*op2;
    }

    public double division(){
        return op1/op2;
    }

    public double resto(){
        return op1%op2;
    }

    public void mostrarOp1(){
        System.out.println(op1);
    }

    public void mostrarOp2(){
        System.out.println(op2);
    }

    public double raizOp1(){
        return Math.sqrt(op1);
    }

    public double raizOp2(){
        return Math.sqrt(op2);
    }

    public double potencia(){
        double resultado = op1;
        for(int i=0; i<op2; i++){
            resultado*=op1;
        }
        return resultado;
    }
}
