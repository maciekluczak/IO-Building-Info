module pl.put.poznan.transformer.gui.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires org.slf4j;


    opens pl.put.poznan.transformer.gui.app to javafx.fxml;
    opens pl.put.poznan.transformer.models to javafx.base;
    exports pl.put.poznan.transformer.gui.app;
    exports pl.put.poznan.transformer.app;
}
