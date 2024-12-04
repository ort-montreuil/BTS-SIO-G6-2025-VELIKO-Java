module sio.velikojava {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires javafx.web;
    requires java.sql;
    requires spring.security.crypto;


    opens sio.velikojava to javafx.fxml;
    exports sio.velikojava;
    exports sio.velikojava.Controller;
    opens sio.velikojava.Controller to javafx.fxml;
}