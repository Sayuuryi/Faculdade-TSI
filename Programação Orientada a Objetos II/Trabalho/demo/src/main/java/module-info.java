module projeto.java {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens projeto.java to javafx.fxml;
    exports projeto.java;
}