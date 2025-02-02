module com.amirtaylor.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.amirtaylor.tictactoe to javafx.fxml;
    exports com.amirtaylor.tictactoe;
}
