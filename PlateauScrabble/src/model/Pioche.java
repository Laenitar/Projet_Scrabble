package model;

import java.util.*;



public class Pioche  {

	private Stack<Piece> stack;

	public Pioche() {

		this.stack = new Stack<Piece>();
		this.ajout(9, "A", 1);
		this.ajout(2, "B", 3);
		this.ajout(2, "C", 3);
		this.ajout(3, "D", 2);
		this.ajout(15, "E", 1);
		this.ajout(2, "F", 4);
		this.ajout(2, "G", 2);
		this.ajout(2, "H", 4);
		this.ajout(8, "I", 1);
		this.ajout(1, "J", 8);
		this.ajout(1, "K", 10);
		this.ajout(5, "L", 1);
		this.ajout(3, "M", 2);
		this.ajout(6, "N", 1);
		this.ajout(6, "O", 1);
		this.ajout(2, "P", 3);
		this.ajout(1, "Q", 8);
		this.ajout(6, "R", 1);
		this.ajout(6, "S", 1);
		this.ajout(6, "T", 1);
		this.ajout(6, "U", 1);
		this.ajout(2, "V", 4);
		this.ajout(1, "W", 10);
		this.ajout(1, "X", 10);
		this.ajout(1, "Y", 10);
		this.ajout(1, "Z", 10);
		this.ajout(2, "*", 0);
		Collections.shuffle(stack);
	}

	private void ajout(int a, String b, int c) {

		if (c == ' ') {

			for (int i = 0; i < a; i++) {
				this.stack.push(new Piece(b, c, true));

			}

		} else {

			for (int i = 0; i < a; i++) {
				this.stack.push(new Piece(b, c, false));
			}
		}
	}

	public void affiche() {
		for (int i = stack.size()-1; i > 0; i--) {
			System.out.println("La lettre " + stack.get(i).getLettre() + " vaut " + stack.get(i).getPoint());
		}
		
	}

	public boolean getStackVoid() {
		return stack.isEmpty();
	}

	public Stack<Piece> getStack(){
		return this.stack;
	}
	
	public int findScore(String s){
		for (int i = stack.size()-1; i > 0; i--) {
			if(stack.get(i).getLettre().equals(s))
				return stack.get(i).getPoint();
		}
		return 0;
	}

	

}