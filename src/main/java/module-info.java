module hust.soict.cybersec.cookhandbook {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires com.h2database;
    requires java.desktop;

    opens hust.soict.cybersec.cookhandbook to javafx.fxml;
    opens hust.soict.cybersec.cookhandbook.controller to javafx.fxml;

    exports hust.soict.cybersec.cookhandbook;
}