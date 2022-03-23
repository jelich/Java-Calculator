import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame implements ActionListener {

    Label label1, label2, label3, label4;
    TextField text1, text2, text3;
    Button btn1, btn2, btn3, btn4, btn5;
    TextArea displayText;

    Calculator() {
        Frame f = new Frame();
        f.setBackground(Color.DARK_GRAY);

        label1 = new Label("First Number");
        label2 = new Label("Second Number");
        label3 = new Label("Result");
        label4 = new Label("All rights reserved");
        label1.setBounds(20, 50, 100, 20);
        label2.setBounds(20, 80, 100, 20);
        label3.setBounds(20, 110, 100, 20);
        label4.setBounds(270, 360, 180, 20);
        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        label4.setForeground(Color.WHITE);

        text1 = new TextField(10);
        text2 = new TextField(10);
        text3 = new TextField(10);
        text1.setBounds(140, 50, 230, 20);
        text2.setBounds(140, 80, 230, 20);
        text3.setBounds(140, 110, 230, 20);

        displayText = new TextArea("", 10, 20, displayText.SCROLLBARS_VERTICAL_ONLY);
        displayText.setBounds(20, 220, 350, 80);


        btn1 = new Button("Add");
        btn2 = new Button("Subtract");
        btn3 = new Button("Multiply");
        btn4 = new Button("Division");
        btn5 = new Button("Reset");
        btn1.setBounds(20, 140, 80, 20);
        btn2.setBounds(110, 140, 80, 20);
        btn3.setBounds(200, 140, 80, 20);
        btn4.setBounds(290, 140, 80, 20);
        btn5.setBounds(110, 170, 170, 20);
        btn1.setBackground(Color.GRAY);
        btn2.setBackground(Color.GRAY);
        btn3.setBackground(Color.GRAY);
        btn4.setBackground(Color.GRAY);
        btn5.setBackground(Color.GRAY);

        f.add(label1);
        f.add(text1);
        f.add(label2);
        f.add(text2);
        f.add(label3);
        f.add(text3);
        f.add(btn1);
        f.add(btn2);
        f.add(btn3);
        f.add(btn4);
        f.add(btn5);
        f.add(displayText);
        f.add(label4);

        f.setLayout(null);
        f.setSize(400, 400);
        f.setTitle("Calculator by Darko Jelic");
        f.setResizable(false);
        f.setLocation(400, 200);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Integer x = 0, y = 0, z = 0;
        try {
            x = Integer.parseInt(text1.getText());
        } catch (NumberFormatException e) {
            text1.setText("Invalid input");
        }
        try {
            y = Integer.parseInt(text2.getText());
        } catch (NumberFormatException e) {
            text2.setText("Invalid input");
        }
        if (ae.getSource() == btn1) {
            z = x + y;
            text3.setText(String.valueOf(z));
            displayText.setText("Your result is " + x + " + " + y + " " + " = " + z);
        }
        if (ae.getSource() == btn2) {
            z = x - y;
            text3.setText(String.valueOf(z));
            displayText.setText("Your result is " + x + " - " + y + " " + " = " + z);
        }
        if (ae.getSource() == btn3) {
            z = x * y;
            text3.setText(String.valueOf(z));
            displayText.setText("Your result is " + x + " * " + y + " " + " = " + z);
        }
        if (ae.getSource() == btn4) {
            try {
                z = x / y;
                text3.setText(String.valueOf(z));
                displayText.setText("Your result is " + x + " / " + y + " " + " = " + z);
            } catch (ArithmeticException e) {
                displayText.setText("Division by zero not allowed");
            }
        }
        if (ae.getSource() == btn5) {
            text1.setText("");
            text2.setText("");
            text3.setText("");
            displayText.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}





















