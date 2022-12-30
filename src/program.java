import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


import static javax.swing.JOptionPane.showMessageDialog;

public class program extends JFrame implements ActionListener, KeyListener {

    // Declaration des trois cases dans un tableau de JTextField (Ca va nous servir plus tard)
    JTextField[] cases = new JTextField[3];

    static int numberClick=0;
    JLabel state;

    JLabel result;
    program(){
        //Declaration des différents composants (Nous avons placé un "Header" et un "Content"
        JPanel header = new JPanel();
        header.setBackground(Color.white);
        header.setBounds(0,0,541,117);
        this.add(header);

        JPanel content = new JPanel();
        content.setBackground(new Color(102,204,255));
        content.setBounds(0,117,541,357);
        content.setLayout(null);
        this.add(content);


        JLabel title1 = new JLabel();
        title1.setText("Certifié Meilleur Comparateur Année 2022");
        title1.setVerticalTextPosition(JLabel.BOTTOM);
        title1.setHorizontalTextPosition(JLabel.CENTER);
        title1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
        header.add(title1);

        JLabel title2 = new JLabel();
        title2.setText("par MOHAMED BELDI & AMINE DIDEN");
        title2.setVerticalTextPosition(JLabel.BOTTOM);
        title2.setHorizontalTextPosition(JLabel.CENTER);
        title2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
        header.add(title2);

        cases[0] = new JTextField();
        cases[0].setBounds(20,130,130,120);
        cases[0].setFont(new java.awt.Font("SansSerif", Font.PLAIN, 75));
        cases[0].setHorizontalAlignment(JTextField.CENTER);
        cases[0].addKeyListener(this);
        content.add(cases[0]);

        cases[0].setDocument(new FixedSizeDocument(1));

        cases[1] = new JTextField();
        cases[1].setBounds(200,130,130,120);
        cases[1].setFont(new java.awt.Font("SansSerif", Font.PLAIN, 75));
        cases[1].setHorizontalAlignment(JTextField.CENTER);
        cases[1].addKeyListener(this);

        content.add(cases[1]);

        cases[1].setDocument(new FixedSizeDocument(1));


        cases[2] = new JTextField();
        cases[2].setBounds(380,130,130,120);
        cases[2].setFont(new java.awt.Font("SansSerif", Font.PLAIN, 75));
        cases[2].setHorizontalAlignment(JTextField.CENTER);

        content.add(cases[2]);

        cases[2].setDocument(new FixedSizeDocument(1));


        JButton input = new JButton("Les dés sont jetés, rien ne va plus !");
        input.setBounds(13,270,500,30);
        input.setBackground(Color.white);
        input.addActionListener(this);
        content.add(input);

        state = new JLabel();
        state.setText("N ° ");
        state.setBounds(13, 315, 500, 30);
        state.setFont(new java.awt.Font("SegoeUI", Font.BOLD, 36));
        content.add(state);

        result = new JLabel();
        result.setText("NOT EQUAL");
        result.setBounds(13, 360, 500, 30);
        result.setFont(new java.awt.Font("SegoeUI", Font.BOLD, 36));
        content.add(result);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(541,474);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("COMPARATEUR - By MOHAMED BELDI & DIDEN AMINE");



    }



    public static boolean isValid(String str) {
        return str.length() == 1 && Character.isDigit(str.charAt(0));

    }

    public static String generatedNumber() {
        int num = (int) (Math.random() * 1000);
        return String.format("%03d", num);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Fonction de vérification
        String A = cases[0].getText();
        String B = cases[1].getText();
        String C = cases[2].getText();
        String R = result.getText();
        String S = state.getText();
        String numString = generatedNumber();
        System.out.println(R);
        if(!(isValid(A) && isValid(B) && isValid(C) )) {
            showMessageDialog(null, "INVALID INPUT (S'il vous plait "
                    + "mettez UN SEUL nombre"
                    + " à chaque case)");
        }
        else {
            result.setText("N: "+numString);
            if((A + B + C).equals(numString)){
                state.setText("EQUAL");
            }
            else {
                state.setText("NOT EQUAL");
            }
        }
    }



    @Override
    public void keyTyped(KeyEvent e) {
        JTextField textField = (JTextField) e.getSource();
        if (isValid(textField.getText())) {
            int currentIndex = Arrays.asList(cases).indexOf(textField);
            cases[(currentIndex + 1) % cases.length].requestFocusInWindow();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

