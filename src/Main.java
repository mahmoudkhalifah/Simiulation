import javax.swing.*;
import java.awt.*;

public class Main {

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("single-channel queuing model");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lambdaLbl = new JLabel("λ:");
        JTextField lambda = new JTextField(20);

        JLabel muLbl = new JLabel("μ:");
        JTextField mu = new JTextField(20);

        JButton calculateBtn = new JButton("calculate");

        calculateBtn.addActionListener(e->{
            Calculations calc = new Calculations();
            calc.setLambda(Float.parseFloat(lambda.getText()));
            calc.setMu(Float.parseFloat(mu.getText()));
            System.out.println(calc.L());
            System.out.println(calc.W());
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(lambdaLbl);
        panel.add(lambda);
        panel.add(muLbl);
        panel.add(mu);
        panel.add(calculateBtn);

        frame.setLayout(new BorderLayout());
        frame.add(panel,BorderLayout.CENTER);
        frame.setSize(600,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}