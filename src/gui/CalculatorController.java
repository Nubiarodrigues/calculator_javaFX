package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController implements Initializable {

	@FXML
	private TextField txtEntryAndExit;

	@FXML
	private Button btSeven;

	@FXML
	private Button btFor;

	@FXML
	private Button btOne;

	@FXML
	private Button btZero;

	@FXML
	private Button btEight;

	@FXML
	private Button btFive;

	@FXML
	private Button btTwo;

	@FXML
	private Button btClear;

	@FXML
	private Button btNine;

	@FXML
	private Button btSix;

	@FXML
	private Button btThree;

	@FXML
	private Button btEqual;

	@FXML
	private Button btDivision;

	@FXML
	private Button btMultiplication;

	@FXML
	private Button btSubtraction;

	@FXML
	private Button btSum;

	@FXML
	private Button btExponentiation;

	@FXML
	private Button btPercentage;

	@FXML
	private Button btComma;

	@FXML
	private Button btX;

	private Double num1 = 0.0;

	private String operator = "";

	private void handleNumberInput(String buttonText) {
		if (txtEntryAndExit.getText().equals("0")) { 
			txtEntryAndExit.setText(buttonText); 
		} else {
			txtEntryAndExit.appendText(buttonText); 
		}
	}

	private void handleOperatorInput(String operator) {
	    String input = txtEntryAndExit.getText().replace(',', '.'); 
	    try {
	        num1 = Double.parseDouble(input);  
	        this.operator = operator;  
	        txtEntryAndExit.setText("0");  
	    } catch (NumberFormatException e) {
	        System.out.println("Erro de formatação de número: " + input);
	    }
	}


	@FXML
	private void handleEquals() {
		double num2 = Double.parseDouble(txtEntryAndExit.getText());
		double result = 0;

		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "**":
			if (num1 != 0 && num2 != 0) {
				result = Math.pow(num1, num2); 
			} else {
				txtEntryAndExit.setText("Erro");
			}
			break;
		case "%":
			 result = (num1 * num2) / 100.0;
			break;
		case "/":
			if (num2 != 0) {
				result = num1 / num2;
			} else {
				txtEntryAndExit.setText("Erro");
				return;
			}
			break;
		}

		txtEntryAndExit.setText(String.valueOf(result)); 
		num1 = result;
	}

	@FXML
	private void handleComma() {
		String currentText = txtEntryAndExit.getText();
		if (!currentText.contains(",")) { 
			txtEntryAndExit.setText(currentText + ",");
		}
	}

	@FXML
	private void handleDeleteOne() {
		String currentText = txtEntryAndExit.getText();
		if (currentText.length() > 0) {
			txtEntryAndExit.setText(currentText.substring(0, currentText.length() - 1));
		}

	}

	// limpar tela
	@FXML
	private void handleClear() {
		txtEntryAndExit.setText("0");
		num1 = 0.0;
		operator = "";
	}

	@FXML
	public void handleButtonAction(ActionEvent event) {
		Button sourceButton = (Button) event.getSource();
		String buttonText = sourceButton.getText();

		if (buttonText.matches("[0-9]")) {
			handleNumberInput(buttonText);
		} else if (buttonText.matches("[+\\-*/,]")) {
			handleOperatorInput(buttonText);
		} else if (buttonText.equals("**")) {
			handleOperatorInput("**");
		} else if (buttonText.equals("%")) {
			handleOperatorInput("%");
		} else if (buttonText.equals("=")) {
			handleEquals();
		} else if (buttonText.equals("C")) {
			handleClear();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		txtEntryAndExit.setText("0");

		// Listener (ouvinte) que detecta a mudança no TextField
		txtEntryAndExit.textProperty().addListener((observable, oldValeu, newValue) -> {
			if (newValue.isEmpty()) {
				txtEntryAndExit.setText("0");
			}
		});

		// detecta pressionamento das teclas
		txtEntryAndExit.setOnKeyPressed(event -> {
			switch (event.getCode()) {
			case DIGIT0, NUMPAD0 -> handleNumberInput("0");
			case DIGIT1, NUMPAD1 -> handleNumberInput("1");
			case DIGIT2, NUMPAD2 -> handleNumberInput("2");
			case DIGIT3, NUMPAD3 -> handleNumberInput("3");
			case DIGIT4, NUMPAD4 -> handleNumberInput("4");
			case DIGIT5, NUMPAD5 -> handleNumberInput("5");
			case DIGIT6, NUMPAD6 -> handleNumberInput("6");
			case DIGIT7, NUMPAD7 -> handleNumberInput("7");
			case DIGIT8, NUMPAD8 -> handleNumberInput("8");
			case DIGIT9, NUMPAD9 -> handleNumberInput("9");
			case ADD -> handleOperatorInput("+");
			case SUBTRACT -> handleOperatorInput("-");
			case MULTIPLY -> handleOperatorInput("*");
			case DIVIDE -> handleOperatorInput("/");
			case ENTER, EQUALS -> handleEquals();
			case BACK_SPACE, DELETE -> handleClear();
			case COMMA -> handleComma();
			}
		});

	}
}
