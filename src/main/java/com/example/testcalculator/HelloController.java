package com.example.testcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    private StringBuilder informationOnScreen;

    public HelloController(){
        informationOnScreen = new StringBuilder();
    }

    @FXML
    private Label outputScreen;
    @FXML
    private Button remButton;
    @FXML
    private Button clrButton;
    @FXML
    private Button eqlButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;
    @FXML
    private Button zeroButton;
    @FXML
    private Button plusButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button imButton;
    @FXML
    private Button divButton;
    @FXML
    private Button degButton;
    @FXML
    private Button leftBrackButton;
    @FXML
    private Button righBrackButton;

    @FXML
    public void removeFromScreen(){
        int size = informationOnScreen.length();
        if(size >=1) informationOnScreen.delete(size-1,size);
        outputScreen.setText(informationOnScreen.toString());
    }

    @FXML
    public void doMath(){
        informationOnScreen = new StringBuilder(CalculatorBrains.calculate(informationOnScreen.toString()));
        outputScreen.setText(informationOnScreen.toString());
    }

    @FXML
    public void clearScreen(){
        outputScreen.setText("");
        informationOnScreen.delete(0,informationOnScreen.length());
    }

    public void initialize() {
        oneButton.setOnAction(e -> addToScreen(oneButton));
        twoButton.setOnAction(e -> addToScreen(twoButton));
        threeButton.setOnAction(e -> addToScreen(threeButton));
        fourButton.setOnAction(e -> addToScreen(fourButton));
        fiveButton.setOnAction(e -> addToScreen(fiveButton));
        sixButton.setOnAction(e -> addToScreen(sixButton));
        sevenButton.setOnAction(e -> addToScreen(sevenButton));
        eightButton.setOnAction(e -> addToScreen(eightButton));
        nineButton.setOnAction(e -> addToScreen(nineButton));
        leftBrackButton.setOnAction(e -> addToScreen(leftBrackButton));
        righBrackButton.setOnAction(e -> addToScreen(righBrackButton));
        zeroButton.setOnAction(e -> addToScreen(zeroButton));
        plusButton.setOnAction(e -> addToScreen(plusButton));
        minusButton.setOnAction(e -> addToScreen(minusButton));
        imButton.setOnAction(e -> addToScreen(imButton));
        divButton.setOnAction(e -> addToScreen(divButton));
        degButton.setOnAction(e -> addToScreen(degButton));

    }

    public void addToScreen(Button e){
        if(informationOnScreen.toString().equals("ERROR") | informationOnScreen.toString().equals("0"))
            informationOnScreen.delete(0,informationOnScreen.length());
        informationOnScreen.append(e.getText());
        outputScreen.setText(informationOnScreen.toString());
    }
}