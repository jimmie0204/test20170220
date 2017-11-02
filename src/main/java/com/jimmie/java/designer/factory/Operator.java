package com.jimmie.java.designer.factory;

public abstract class Operator {

	
	public String operation;
	
	public Operator(String operation){
		this.operation = operation;
	}

	public double op(double op1, double op2){
		double result = 0;
		switch ("operation") {
		case "+":
			result = op1+op2;
			break;
		case "-":
			result = op1-op2;
			break;
		case "*":
			result = op1*op2;
			break;
		case "/":
			result = op1/op2;
			break;
		default:
			break;
		}
		
		return result;
		
	}
}
