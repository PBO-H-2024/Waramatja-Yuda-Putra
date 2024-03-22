/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import javax.swing.*;

/**
 *
 * @author ARDA PUTRA
 */
public class GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel nimLabel;
    private JTextField nimField;
    private JLabel writingExamLabel;
    private JTextField writingExamField;
    private JLabel codingTestLabel;
    private JTextField codingTestField;
    private JLabel interviewTestLabel;
    private JTextField interviewTestField;
    private JButton calculateButton;
    private JTextArea resultArea;

    public GUI() {
        frame = new JFrame("PT. OOP");
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);
        nameField = new JTextField(20);
        nameField.setBounds(150, 20, 165, 25);
        panel.add(nameField);

        nimLabel = new JLabel("NIM:");
        nimLabel.setBounds(10, 50, 80, 25);
        panel.add(nimLabel);
        nimField = new JTextField(10);
        nimField.setBounds(150, 50, 165, 25);
        panel.add(nimField);

        writingExamLabel = new JLabel("Writing Exam Score:");
        writingExamLabel.setBounds(10, 80, 150, 25);
        panel.add(writingExamLabel);
        writingExamField = new JTextField(5);
        writingExamField.setBounds(150, 80, 105, 25);
        panel.add(writingExamField);

        codingTestLabel = new JLabel("Coding Test Score:");
        codingTestLabel.setBounds(10, 110, 150, 25);
        panel.add(codingTestLabel);
        codingTestField = new JTextField(5);
        codingTestField.setBounds(150, 110, 105, 25);
        panel.add(codingTestField);

        interviewTestLabel = new JLabel("Interview Test Score:");
        interviewTestLabel.setBounds(10, 140, 150, 25);
        panel.add(interviewTestLabel);
        interviewTestField = new JTextField(5);
        interviewTestField.setBounds(150, 140, 105, 25);
        panel.add(interviewTestField);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(100, 170, 100, 25);
        panel.add(calculateButton);

        resultArea = new JTextArea(10, 30);
        resultArea.setBounds(10, 200, 315, 200);
        panel.add(resultArea);

        calculateButton.addActionListener(e -> {
            String name = nameField.getText();
            String nim = nimField.getText();
            double writingExamScore = Double.parseDouble(writingExamField.getText());
            double codingTestScore = Double.parseDouble(codingTestField.getText());
            double interviewTestScore = Double.parseDouble(interviewTestField.getText());

            double androidWritingWeight = 0.2;
            double androidCodingWeight = 0.5;
            double androidInterviewWeight = 0.3;
            double webWritingWeight = 0.4;
            double webCodingWeight = 0.35;
            double webInterviewWeight = 0.25;

            double androidFinalScore = (writingExamScore * androidWritingWeight + codingTestScore * androidCodingWeight + interviewTestScore * androidInterviewWeight);
            double webFinalScore = (writingExamScore * webWritingWeight + codingTestScore * webCodingWeight + interviewTestScore * webInterviewWeight);

            String resultText;
            if (androidFinalScore >= 85) {
                resultText = "Congratulations! You are ACCEPTED as an Android Developer Intern.";
            } else {
                resultText = "Sorry, you are NOT ACCEPTED as an Android Developer Intern.";
            }
            resultText += "\nAndroid Developer Final Score: " + androidFinalScore;

            if (webFinalScore >= 85) {
                resultText += "\n\nCongratulations! You are ACCEPTED as a Web Developer Intern.";
            } else {
                resultText += "\n\nSorry, you are NOT ACCEPTED as a Web Developer Intern.";
            }
            resultText += "\nWeb Developer Final Score: " + webFinalScore;

            resultArea.setText(resultText);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 450);
        frame.setVisible(true);
    }
}
