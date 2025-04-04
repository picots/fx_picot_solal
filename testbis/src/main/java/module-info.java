module iut.gon.testbis {
    requires javafx.controls;
    requires javafx.fxml;

    opens iut.gon.testbis to javafx.fxml;
    exports iut.gon.testbis;
}
