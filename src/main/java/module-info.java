module sio.velikojava {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires javafx.web;


    opens sio.velikojava to javafx.fxml;
    exports sio.velikojava;
}