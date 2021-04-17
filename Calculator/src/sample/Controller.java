package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Controller {

    public Label lblDisplay;
    public float storeAdd;
    public float totalAdd;
    public float storeSubtract;
    public float totalSubtract;
    public float storeMultiply;
    public float totalMultiply = 1;
    public float storeDivide;
    public float totalDivide = 1;

    ArrayList<Float> listPlus = new ArrayList<>();
    ArrayList<Float> listSubtract = new ArrayList<>();
    ArrayList<Float> listMultiply = new ArrayList<>();
    ArrayList<Float> listDivide = new ArrayList<>();

    public void addNumber(String number) {
        if (lblDisplay.getText().equals("0")) {
            String display = number;
            lblDisplay.setText(display);
        } else if (lblDisplay.getText().length() == 9) {
            lblDisplay = lblDisplay;
        } else {
            String display = lblDisplay.getText();
            lblDisplay.setText(display + number);
        }
    }

    public void addOne(ActionEvent actionEvent) {
        addNumber("1");
    }

    public void addTwo(ActionEvent actionEvent) {
        addNumber("2");
    }

    public void addThree(ActionEvent actionEvent) {
        addNumber("3");
    }

    public void addFour(ActionEvent actionEvent) {
        addNumber("4");
    }

    public void addFive(ActionEvent actionEvent) {
        addNumber("5");
    }

    public void addSix(ActionEvent actionEvent) {
        addNumber("6");
    }

    public void addSeven(ActionEvent actionEvent) {
        addNumber("7");
    }

    public void addEight(ActionEvent actionEvent) {
        addNumber("8");
    }

    public void addNine(ActionEvent actionEvent) {
        addNumber("9");
    }

    public void addZero(ActionEvent actionEvent) {
        addNumber("0");
    }

    public void addDecimal(ActionEvent actionEvent) {
        lblDisplay.setText(lblDisplay.getText() + ".");
    }

    public void plus(ActionEvent actionEvent) {
        storeAdd = Float.parseFloat(lblDisplay.getText());
        listPlus.add(storeAdd);
        System.out.println(storeAdd);
        lblDisplay.setText("0");
    }

    public void subtract(ActionEvent actionEvent) {
        storeSubtract = Float.parseFloat(lblDisplay.getText());
        listSubtract.add(storeSubtract);
        System.out.println(storeSubtract);
        totalSubtract = totalSubtract + storeSubtract;
        lblDisplay.setText("0");
    }

    public void multiply(ActionEvent actionEvent) {
        storeMultiply = Float.parseFloat(lblDisplay.getText());
        listMultiply.add(storeMultiply);
        System.out.println(storeMultiply);
        lblDisplay.setText("0");
    }

    public void divide(ActionEvent actionEvent) {
        storeDivide = Float.parseFloat(lblDisplay.getText());
        listDivide.add(storeDivide);
        System.out.println(storeDivide);
        totalDivide = totalDivide * storeDivide;
        lblDisplay.setText("0");
    }

    public void equals(ActionEvent actionEvent) {

        //adding
        if (listSubtract.size() == 0 && listMultiply.size() == 0 && listDivide.size() == 0) {
            storeAdd = Float.parseFloat(lblDisplay.getText());
            listPlus.add(storeAdd);
            System.out.println(storeAdd);
            for (int i = 0; i < listPlus.size(); i++) {
                totalAdd = totalAdd + listPlus.get(i);
            }
            String finalDisplay = Float.toString(totalAdd);
            if (finalDisplay.charAt(finalDisplay.length() - 1) == '0' &&
                    (finalDisplay.charAt(finalDisplay.length() - 2) == '.')) {
                System.out.println(finalDisplay);
                finalDisplay = finalDisplay.replace(".0", "");
            }
            lblDisplay.setText(finalDisplay);
            System.out.println("=" + finalDisplay);
        }

        //subtracting
        if (listPlus.size() == 0 && listMultiply.size() == 0 && listDivide.size() == 0) {
            storeSubtract = Float.parseFloat(lblDisplay.getText());
            listSubtract.add(storeSubtract);
            System.out.println(storeSubtract);
            totalSubtract = totalSubtract + storeSubtract;
            System.out.println(totalSubtract);
            for (int i = 1; i < listSubtract.size(); i++) {
                totalSubtract = totalSubtract - (listSubtract.get(i) * 2);
            }
            String finalDisplay = Float.toString(totalSubtract);
            if (finalDisplay.charAt(finalDisplay.length() - 1) == '0' &&
                    (finalDisplay.charAt(finalDisplay.length() - 2) == '.')) {
                System.out.println(finalDisplay);
                finalDisplay = finalDisplay.replace(".0", "");
            }
            lblDisplay.setText(finalDisplay);
            System.out.println("=" + finalDisplay);
        }

        //multiplying
        if (listPlus.size() == 0 && listSubtract.size() == 0 && listDivide.size() == 0) {
            storeMultiply = Float.parseFloat(lblDisplay.getText());
            listMultiply.add(storeMultiply);
            System.out.println(storeMultiply);
            for (int i = 0; i < listMultiply.size(); i++) {
                totalMultiply = totalMultiply * listMultiply.get(i);
            }
            String finalDisplay = Float.toString(totalMultiply);
            if (finalDisplay.charAt(finalDisplay.length() - 1) == '0' &&
                    (finalDisplay.charAt(finalDisplay.length() - 2) == '.')) {
                System.out.println(finalDisplay);
                finalDisplay = finalDisplay.replace(".0", "");
            }
            lblDisplay.setText(finalDisplay);
            System.out.println("=" + finalDisplay);
        }

        //dividing
        if (listPlus.size() == 0 && listSubtract.size() == 0 && listMultiply.size() == 0) {
            storeDivide = Float.parseFloat(lblDisplay.getText());
            listDivide.add(storeDivide);
            totalDivide = totalDivide * storeDivide;
            System.out.println(storeDivide);
            if ((listDivide.contains(Float.valueOf("0.0")) || listDivide.contains('0')) &&
                    (listDivide.indexOf(Float.valueOf("0.0")) > 0 || listDivide.indexOf('0') > 0)) {
                lblDisplay.setText("Error");
                System.out.println("Error");
            } else {
                for (int i = 1; i < listDivide.size(); i++) {
                    totalDivide = totalDivide / listDivide.get(i);
                    totalDivide = totalDivide / listDivide.get(i);
                }
                String finalDisplay = Float.toString(totalDivide);
                if (finalDisplay.charAt(finalDisplay.length() - 1) == '0' &&
                        (finalDisplay.charAt(finalDisplay.length() - 2) == '.')) {
                    finalDisplay = finalDisplay.replace(".0", "");
                }
                lblDisplay.setText(finalDisplay);
                System.out.println("=" + finalDisplay);
            }
        }

        totalAdd = 0;
        totalSubtract = 0;
        totalMultiply = 1;
        totalDivide = 1;

        listPlus.add(totalAdd);
        for (int i = listPlus.size(); i > 0; i--) {
            listPlus.remove(listPlus.remove(0));
            if (listPlus.size() == 0) {
                break;
            }
        }
        listSubtract.add(totalSubtract);
        for (int i = listSubtract.size(); i > 0; i--) {
            listSubtract.remove(listSubtract.remove(0));
            if (listSubtract.size() == 0) {
                break;
            }
        }
        listMultiply.add(totalMultiply);
        for (int i = listMultiply.size(); i > 0; i--) {
            listMultiply.remove(listMultiply.remove(0));
            if (listMultiply.size() == 0) {
                break;
            }
        }
        listDivide.add(totalDivide);
        for (int i = listDivide.size(); i > 0; i--) {
            listDivide.remove(listDivide.remove(0));
            if (listDivide.size() == 0) {
                break;
            }
        }
    }

    public void clear(ActionEvent actionEvent) {
        lblDisplay.setText("0");
        storeAdd = 0;
        totalAdd = 0;
        storeSubtract = 0;
        totalSubtract = 0;
        storeMultiply = 0;
        totalMultiply = 1;
        storeDivide = 0;
        totalDivide = 1;

        //clearing arrays
        for (int i = listPlus.size(); i > 0; i--) {
            listPlus.remove(storeAdd);
        }
        for (int i = listSubtract.size(); i > 0; i--) {
            listSubtract.remove(storeSubtract);
        }
        for (int i = listMultiply.size(); i > 0; i--) {
            listMultiply.remove(storeMultiply);
        }
        for (int i = listDivide.size(); i > 0; i--) {
            listDivide.remove(storeDivide);
        }

 

    }
}

