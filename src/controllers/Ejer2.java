package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import conexionBD.ConexionDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Ejer2 {

	@FXML
	private ToggleGroup Grupo1;

	@FXML
	private RadioButton InformePC;

	@FXML
	private RadioButton informeP;

	@FXML
	private RadioButton informePS;

	@FXML
	private Button botonLanzar;
	@FXML
	private Button btnSalir;
	@FXML
	private TextField fieldNombreUsuario;

	@FXML
	void initialize() {
		InformePC.setToggleGroup(Grupo1);
		informeP.setToggleGroup(Grupo1);
		informePS.setToggleGroup(Grupo1);

		Grupo1.getSelectedToggle();
	}

	@FXML
	void abrir(ActionEvent event) {
		Connection connection = null;

		try {
			String url = "jdbc:mysql://localhost:3306/agenda";
			String user = "javauser";
			String password = "Javajava0";

			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String filePath = "";
		if (InformePC.isSelected()) {
			filePath = "Agenda2.jasper";
		}
		if (informeP.isSelected()) {
			filePath = "Agenda1.jasper";
		}
		if (informePS.isSelected()) {
			filePath = "Agenda33.jasper";
		}

		try {
			System.out.println(getClass().getResource("/" + filePath));
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/" + filePath));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, connection);
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}

	}
	
	void salir(ActionEvent event) {
		((Stage)((Node)event.getSource()).getScene().getWindow()).close();
	}

}
