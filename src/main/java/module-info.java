module fi.tuni.monitor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpmime;
    requires swagger.annotations;
    requires jackson.databind.nullable;
    requires org.joda.time;
    requires jsr305;
    requires com.fasterxml.jackson.jakarta.rs.json;
    requires com.sothawo.mapjfx;
    requires org.jfree.chart.fx;
    requires org.jfree.jfreechart;
    requires java.desktop;
    requires java.xml;

    exports fi.tuni.monitor.roadapi.model to com.fasterxml.jackson.databind;
    exports fi.tuni.monitor.data to com.fasterxml.jackson.databind;
    exports fi.tuni.monitor.mainwindow;
    exports fi.tuni.monitor.saveddata;

    opens fi.tuni.monitor.data to com.fasterxml.jackson.databind;

    opens fi.tuni.monitor.mainwindow to javafx.fxml;
    exports fi.tuni.monitor.models to com.fasterxml.jackson.databind;
    opens fi.tuni.monitor.models to com.fasterxml.jackson.databind;
    exports fi.tuni.monitor.controllers;
    opens fi.tuni.monitor.controllers to javafx.fxml;
}