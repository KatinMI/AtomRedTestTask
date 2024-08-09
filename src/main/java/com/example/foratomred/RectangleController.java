package com.example.foratomred;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class RectangleController {
    @FXML
    private TextField yInputField;
    @FXML
    private TextField xInputField;
    @FXML
    private Label yViewLabel;
    @FXML
    private Label xViewLabel;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Pane paneWithRectangle;
    private Alert alert;
    private double x,y;

    public RectangleController() {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка ввода данных");
    }

    @FXML
    private void changeRectanglePositionWithMouse(MouseEvent mouseEvent) {
        if(isWithinX(mouseEvent.getX() - x) && isWithinY(mouseEvent.getY() - y)) {
            rectangle.setX(mouseEvent.getX() - x);
            xViewLabel.setText(String.valueOf(Math.round(rectangle.getX())));
            rectangle.setY(mouseEvent.getY() - y);
            yViewLabel.setText(String.valueOf(Math.round(rectangle.getY())));

        }
    }
    @FXML
    private void beforeDraggingRectangle(MouseEvent mouseEvent) {
        rectangle.setCursor(Cursor.CLOSED_HAND);
        x = Math.floor(mouseEvent.getSceneX()) - rectangle.getX();
        y = Math.floor(mouseEvent.getSceneY()) - rectangle.getY();
    }
    @FXML
    private void afterDraggingRectangle(MouseEvent mouseEvent) {
        rectangle.setCursor(Cursor.OPEN_HAND);
    }
    @FXML
    private void changeRectanglePositionByY(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
           if (isNumber(yInputField.getText()) && isWithinY(Double.parseDouble(yInputField.getText()))) {
               rectangle.setY(Double.parseDouble(yInputField.getText()));
               yViewLabel.setText(removeExtraZeros(yInputField.getText()));
           } else {
               yInputField.clear();
               alert.setHeaderText("Вы ввели неправильные данные в поле Y");
               alert.setContentText("Введите целое число в диапозоне от 0 до " + (int)Math.floor((paneWithRectangle.getHeight() - rectangle.getHeight())));
               alert.showAndWait();
           }
        }
    }
    @FXML
    private void changeRectanglePositionByX(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            if (isNumber(xInputField.getText()) && isWithinX(Double.parseDouble(xInputField.getText()))) {
                rectangle.setX(Double.parseDouble(xInputField.getText()));
                xViewLabel.setText(removeExtraZeros(xInputField.getText()));
            } else {
                xInputField.clear();
                alert.setHeaderText("Вы ввели неправильные данные в поле X");
                alert.setContentText("Введите целое число в диапозоне от 0 до " + (int)Math.floor((paneWithRectangle.getWidth() - rectangle.getWidth())));
                alert.showAndWait();
            }
        }
    }
    private boolean isNumber(String text){
        return text.matches("\\d{1,4}");
    }
    private boolean isWithinX(double x){
        return x >= 0 && x + rectangle.getWidth() <= paneWithRectangle.getWidth();
    }
    private boolean isWithinY(double y){
        return y >= 0 && y + rectangle.getHeight() <= paneWithRectangle.getHeight();
    }
    private String removeExtraZeros(String text){
        String zero = text.replaceAll("^0*","");
        return zero.isEmpty() ? "0" : zero;
    }

}
