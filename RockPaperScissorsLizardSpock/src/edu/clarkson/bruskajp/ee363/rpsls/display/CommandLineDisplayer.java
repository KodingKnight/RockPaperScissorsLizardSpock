package edu.clarkson.bruskajp.ee363.rpsls.display;

public class CommandLineDisplayer<T> implements Displayer<T>{

	/**
	   * Displays a token on the console.
	   * @param token A token to be displayed to the console.
	*/ 
	@Override
	public void display(T token) {
		System.out.println(token);
	}
	
}
