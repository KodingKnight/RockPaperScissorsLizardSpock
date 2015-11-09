package edu.clarkson.bruskajp.ee363.rpsls.display;

public class CommandLineDisplayer<T> implements Displayer<T>{

	@Override
	public void display(T token) {
		System.out.println(token);
	}
	
}
