package app;

import javafx.scene.control.*;
import javafx.fxml.FXML;

public class MainController {
  // FXMLから指定するコンポーネント//{{{
  // 計算式表示欄
  @FXML private TextField formulaTextField;
  // 数値入力ボタン//{{{
  @FXML private Button button0;
  @FXML private Button button1;
  @FXML private Button button2;
  @FXML private Button button3;
  @FXML private Button button4;
  @FXML private Button button5;
  @FXML private Button button6;
  @FXML private Button button7;
  @FXML private Button button8;
  @FXML private Button button9;
  //}}}
  // 計算ボタン//{{{
  @FXML private Button calcButton;
  @FXML private Button clearButton;
  //}}}
  // 演算子ボタン//{{{
  @FXML private Button plusButton;
  @FXML private Button minusButton;
  @FXML private Button multButton;
  @FXML private Button divButton;
  //}}}
  //}}}
  @FXML
  private void initialize() {//{{{
    // イベントの登録//{{{
    button0.setOnAction(e -> buttonOnClicked(button0));
    button1.setOnAction(e -> buttonOnClicked(button1));
    button2.setOnAction(e -> buttonOnClicked(button2));
    button3.setOnAction(e -> buttonOnClicked(button3));
    button4.setOnAction(e -> buttonOnClicked(button4));
    button5.setOnAction(e -> buttonOnClicked(button5));
    button6.setOnAction(e -> buttonOnClicked(button6));
    button7.setOnAction(e -> buttonOnClicked(button7));
    button8.setOnAction(e -> buttonOnClicked(button8));
    button9.setOnAction(e -> buttonOnClicked(button9));

    calcButton  .setOnAction(e -> calcButtonOnClicked());
    clearButton .setOnAction(e -> clearButtonOnClicked());
    plusButton  .setOnAction(e -> buttonOnClicked(plusButton));
    minusButton .setOnAction(e -> buttonOnClicked(minusButton));
    multButton  .setOnAction(e -> buttonOnClicked(multButton));
    divButton   .setOnAction(e -> buttonOnClicked(divButton));
    //}}}
  }//}}}

  private void buttonOnClicked(Button button) {//{{{
    String buttonText = button.getText();
    if (   "+".equals(buttonText)
        || "-".equals(buttonText)
        || "*".equals(buttonText)
        || "/".equals(buttonText)
       ) {
      buttonText = String.format(" %s ", buttonText);
       }
    String formulaText = formulaTextField.getText();
    formulaTextField.setText(formulaText + buttonText);
  }//}}}
  private void calcButtonOnClicked() {//{{{
    String formulaText = formulaTextField.getText();
    String[] array = formulaText.split(" ");

    if (2 < array.length) {
      double leftNum = Double.parseDouble(array[0]);
      String operator = array[1];
      int rightNum = Integer.parseInt(array[2]);

      double result = 0;
      switch (operator) {
        case "+": result = leftNum + rightNum; break;
        case "-": result = leftNum - rightNum; break;
        case "*": result = leftNum * rightNum; break;
        case "/": if (rightNum != 0) result = leftNum / rightNum; break;
      }

      formulaTextField.setText("" + result);
    }
  }//}}}
  private void clearButtonOnClicked() {//{{{
    formulaTextField.setText("");
  }//}}}
}
