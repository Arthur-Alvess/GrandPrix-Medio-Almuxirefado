module almurifefado.grandprixmedioalmuxirefado {
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
    requires com.google.gson;

    opens almurifefado.grandprixmedioalmuxirefado to javafx.fxml;
    exports almurifefado.grandprixmedioalmuxirefado;
    exports almurifefado.grandprixmedioalmuxirefado.Controllers;
    opens almurifefado.grandprixmedioalmuxirefado.Controllers to javafx.fxml;
    opens almurifefado.grandprixmedioalmuxirefado.Models to com.google.gson;
    opens almurifefado.grandprixmedioalmuxirefado.Util to com.google.gson;
}