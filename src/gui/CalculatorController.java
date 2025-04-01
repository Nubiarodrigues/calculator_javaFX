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
	public void handleButtonAction(ActionEvent event) {
		// verifica qual botão foi pressionado
		Button sourceButton = (Button) event.getSource();
		String buttonText = sourceButton.getText();

		// Se o valor atual for 0, ele substitui pelo valor do bt pressionado
		if (txtEntryAndExit.getText().equals("0")) {
			txtEntryAndExit.setText(buttonText);
		} else {
			// Se não, coloca futuros valores a direita
			txtEntryAndExit.appendText(buttonText);
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
	}

}
