import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrameMain extends JFrame {
    private JPanel panel1;
    private JButton loadButton;
    private JButton saveButton;
    private JButton button1;
    private JTextField textField1;
    private JTextArea textArea;
    private JButton button2;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    public FrameMain() {
        this.setTitle("Sort");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textArea.getText();
                String answer = Logic.withStundartRealis(text);
                textField1.setText(answer.toString());
            }
        });  button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textArea.getText();
                String[] words = text.split(" ");
                MyMap<String, Integer> mymap = new MyMap<>();
                mymap = AbbreviationCounterSelf.abbreviationsself(words);
                Map<String, Integer> abbreviations = new HashMap<>();
                for (MyMap.Entry<String, Integer> entry : mymap.entrySet()) {
                    abbreviations.put(entry.getKey(), entry.getValue());
                }
                textField1.setText(abbreviations.toString());

            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooserOpen.showOpenDialog(panel1);

                File file = fileChooserOpen.getSelectedFile();
                try {
                    Scanner scanner = new Scanner(file);
                    String n = scanner.nextLine();
                    textArea.setText(n);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooserSave.showSaveDialog(panel1);

                File file = fileChooserSave.getSelectedFile();
                try {
                    FileWriter fw = new FileWriter(file);
                    String text = textField1.getText();
                    fw.write(text);
                    fw.close();
                } catch (IOException e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }


}
