module LanzadorDeFormularios {
	requires javafx.controls;
	requires java.sql;
	requires jasperreports;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.web;
	requires javafx.swing;
	requires javafx.media;
	requires javafx.graphics;
	requires javafx.base;
	
	opens aplicacion to javafx.graphics, javafx.fxml;
	opens controllers to javafx.graphics, javafx.fxml;
	
}
