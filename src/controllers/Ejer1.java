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

public class Ejer1 {

	@FXML
	void Lanza(ActionEvent event) {
		Connection connection = null;

		try {
			String url = "jdbc:mysql://localhost:3306/paises";
			String user = "javauser";
			String password = "Javajava0";

			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {

			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Coffee.jasper"));
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
