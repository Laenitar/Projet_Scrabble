package main;

import javafx.scene.control.Label;

public class Label2 extends Label{
		
	boolean fixe;
	
	public Label2(){
		fixe=false;
	}
	
	public void setFixe(boolean fixe){
		this.fixe=fixe;
	}
	
	public boolean getFixe(){
		return fixe;
	}
	
	@Override
	public String toString(){
		return this.getText()+"  "+fixe;
	}
}
