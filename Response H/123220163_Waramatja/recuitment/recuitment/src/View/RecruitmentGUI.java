/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.CandidateController;
import Model.AndroidDeveloper;
import Model.Candidate;
import Model.WebDeveloper;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class RecruitmentGUI extends JFrame {
    private CandidateController candidateController;
    private JTextField nameField;
    private JComboBox<String> pathField;
    private JTextField writingField;
    private JTextField codingField;
    private JTextField interviewField;
    private JTable table;
    private DefaultTableModel tableModel;

    public RecruitmentGUI() {
        candidateController = new CandidateController();

        setTitle("Recruitment System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Name", "Path", "Writing", "Coding", "Interview", "Score", "Status"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    nameField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    pathField.setSelectedItem(tableModel.getValueAt(selectedRow, 1).toString());
                    writingField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    codingField.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    interviewField.setText(tableModel.getValueAt(selectedRow, 4).toString());
                }
            }
        });

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Candidate Information"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(10);
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Path:"), gbc);

        gbc.gridx = 1;
        pathField = new JComboBox<>(new String[]{"Android Developer", "Web Developer"});
        formPanel.add(pathField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Writing Score:"), gbc);

        gbc.gridx = 1;
        writingField = new JTextField(5);
        formPanel.add(writingField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Coding Score:"), gbc);

        gbc.gridx = 1;
        codingField = new JTextField(5);
        formPanel.add(codingField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Interview Score:"), gbc);

        gbc.gridx = 1;
        interviewField = new JTextField(5);
        formPanel.add(interviewField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCandidate();
            }
        });
        buttonPanel.add(addButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCandidate();
            }
        });
        buttonPanel.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCandidate();
            }
        });
        buttonPanel.add(deleteButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        buttonPanel.add(clearButton);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        rightPanel.add(formPanel, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tableScrollPane, rightPanel);
        splitPane.setDividerLocation(400);
        add(splitPane, BorderLayout.CENTER);

        loadCandidates();
    }

    private void addCandidate() {
        String name = nameField.getText();
        String path = (String) pathField.getSelectedItem();
        int writingScore = Integer.parseInt(writingField.getText());
        int codingScore = Integer.parseInt(codingField.getText());
        int interviewScore = Integer.parseInt(interviewField.getText());

        Candidate candidate;
        if (path.equals("Android Developer")) {
            candidate = new AndroidDeveloper(name, writingScore, codingScore, interviewScore);
        } else {
            candidate = new WebDeveloper(name, writingScore, codingScore, interviewScore);
        }

        candidateController.addCandidate(candidate);
        loadCandidates();
        clearFields();
    }

    private void updateCandidate() {
        String name = nameField.getText();
        String path = (String) pathField.getSelectedItem();
        int writingScore = Integer.parseInt(writingField.getText());
        int codingScore = Integer.parseInt(codingField.getText());
        int interviewScore = Integer.parseInt(interviewField.getText());

        Candidate candidate;
        if (path.equals("Android Developer")) {
            candidate = new AndroidDeveloper(name, writingScore, codingScore, interviewScore);
        } else {
            candidate = new WebDeveloper(name, writingScore, codingScore, interviewScore);
        }

        candidateController.updateCandidate(candidate);
        loadCandidates();
        clearFields();
    }

    private void deleteCandidate() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String name = tableModel.getValueAt(selectedRow, 0).toString();
            String path = tableModel.getValueAt(selectedRow, 1).toString();
            candidateController.deleteCandidate(name, path);
            loadCandidates();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a candidate to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        pathField.setSelectedIndex(0);
        writingField.setText("");
        codingField.setText("");
        interviewField.setText("");
    }

    private void loadCandidates() {
        tableModel.setRowCount(0);
        List<Candidate> candidates = candidateController.getAllCandidates();
        for (Candidate candidate : candidates) {
            tableModel.addRow(new Object[]{
                candidate.getName(),
                candidate.getPath(),
                candidate.getWritingScore(),
                candidate.getCodingScore(),
                candidate.getInterviewScore(),
                candidate.getFinalScore(),
                candidate.getStatus()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RecruitmentGUI().setVisible(true);
            }
        });
    }
}
