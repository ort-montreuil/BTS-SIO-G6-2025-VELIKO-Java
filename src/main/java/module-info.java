module sio.velikojava {
    requires javafx.controls;
    requires javafx.fxml;


    opens sio.velikojava to javafx.fxml;
    exports sio.velikojava;
}