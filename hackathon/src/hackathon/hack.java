//Keli Chen

package hackathon;

import processing.core.*;
import java.util.Scanner;

public class hack extends PApplet {

	public static void main(String[] args) {
		PApplet.main("hackathon.hack");
	}

	int screen = 0;
	PFont font1, font2;

	public void settings() {
		size(1200, 800);
		font1 = loadFont("BG-150.vlw");
		font2 = loadFont("ag-60.vlw");
	}

	public void draw() {
		if (screen == 0) {
			background();
			mainMenu();
		} else if (screen == 1) {
			background();
			instructions();
		} else if (screen == 2) {
			background();
			exitApp();
		} else if (screen == 3) {
			background();
			analyze();
		}
	}

	public void background() {
		background(148, 212, 255);
		noStroke();
	}

	public void mainMenu() {
		fill(0);
		textFont(font1);
		textSize(120);
		text("Adnalyzer", 245, 250);

		strokeWeight(5);
		stroke(0, 63, 121);
		fill(203, 236, 255);
		rectMode(CORNERS);
		rect(450, 350, 750, 440, 15);
		fill(157, 224, 255);
		rect(475, 470, 725, 550, 12);
		rect(475, 575, 725, 655, 12);

		if (mouseX > 475 && mouseX < 725 && mouseY > 470 && mouseY < 550) {
			fill(103, 194, 227);
			rect(475, 470, 725, 550, 12);
		} else if (mouseX > 475 && mouseX < 725 && mouseY > 575 && mouseY < 655) {
			fill(103, 194, 227);
			rect(475, 575, 725, 655, 12);
		} else if (mouseX > 450 && mouseX < 750 && mouseY > 350 && mouseY < 440) {
			fill(144, 209, 234);
			rect(450, 350, 750, 440, 15);
		}

		fill(0);
		textFont(font1);
		textSize(55);
		text("1.Start", 483, 413);
		textSize(28);
		text("2.Instructions", 486, 518);
		text("3.Exit", 552, 623);
	}

	public void instructions() {
		textFont(font2);
		strokeWeight(10);
		stroke(0, 65, 121);
		rectMode(CORNERS);
		fill(203, 239, 255);
		rect(150, 200, 1055, 630, 20);
		fill(0);
		textSize(35);
		text("This program will analyze the mood of your advertisment and what kind of emotions it will invoke in your audience.\n\n"
				+ "Instructions: \n" + "1. Upload the advertisment you want to analyze into the \"images\" folder. \n"
				+ "2.Enter key input to start, and follow instructions.", 185, 230, 1025, 700);

		strokeWeight(10);
		stroke(0, 65, 121);
		fill(203, 239, 255);
		rect(430, 70, 770, 160, 15);
		fill(0);
		textSize(60);
		text("How to Use", 496, 137);

		textSize(40);
		strokeWeight(7);
		stroke(0, 65, 121);
		fill(188, 232, 255);
		rect(850, 675, 1110, 745, 15);

		if (mouseX > 850 && mouseX < 1110 && mouseY > 675 && mouseY < 745) {
			fill(132, 205, 242);
			rect(850, 675, 1110, 745, 15);
		}
		fill(0);
		text("1.Main Menu", 911, 726);
	}

	public void analyze() {

		textFont(font2);
		strokeWeight(10);
		stroke(0, 63, 121);
		rectMode(CORNERS);
		fill(203, 239, 255);
		rect(250, 150, 950, 590, 20);
		fill(0);
		textSize(40);
		text("Please enter the filename, including the file extension, of the ad you wish to be analyzed:", 295, 230,
				920, 510);
		strokeWeight(5);
		stroke(0, 63, 121);
		fill(203, 236, 255);
		rect(350, 370, 850, 440, 15);
	}

	public void exitApp() {
		textFont(font2);
		strokeWeight(10);
		stroke(0, 63, 121);
		rectMode(CORNERS);
		fill(203, 239, 255);
		rect(250, 150, 950, 590, 20);
		fill(0);
		textSize(55);
		text("Are you sure you want to leave?", 325, 250);

		strokeWeight(7);
		fill(160, 223, 255);
		rect(325, 340, 560, 490, 20);
		rect(640, 340, 875, 490, 20);

		if (mouseX > 325 && mouseX < 560 && mouseY > 340 && mouseY < 490) {
			fill(130, 198, 234);
			rect(325, 340, 560, 490, 20);
		} else if (mouseX > 640 && mouseX < 875 && mouseY > 340 && mouseY < 490) {
			fill(130, 198, 234);
			rect(640, 340, 875, 490, 20);
		}

		fill(0);
		textSize(50);
		text("1.Return to Main Menu", 355, 365, 550, 540);
		text("2.Exit", 716, 432);
	}

	public void keyPressed() {
		if (screen == 0) { // main menu
			if (key == '2') {
				screen = 1; // instructions
			} else if (key == '3') {
				screen = 2; // exit screen
			} else if (key == '1') {
				screen = 3; // start
			}

		} else if (screen == 1) { // instructions
			if (key == '1') {
				screen = 0; // main menu
			}

		} else if (screen == 2) { // exit
			if (key == '1') {
				screen = 0; // main menu
			} else if (key == '2') {
				exit();
			}
		} 
	}

}
