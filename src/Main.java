import javax.swing.*;
import java.awt.*;

public class Main {

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("single-channel queuing model");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Calculations calc = new Calculations();

        JLabel lambdaLbl = new JLabel("λ:");
        JTextField lambda = new JTextField(20);

        JLabel muLbl = new JLabel("μ:");
        JTextField mu = new JTextField(20);

        JButton calculateBtn = new JButton("calculate");

        JLabel L = new JLabel();
        JLabel W = new JLabel();

        JPanel optPanel = new JPanel();
        BoxLayout optLayout = new BoxLayout(optPanel,BoxLayout.Y_AXIS);
        optPanel.setLayout(optLayout);
        optPanel.add(L);
        optPanel.add(W);



        calculateBtn.addActionListener(e->{
            calc.setLambda(Float.parseFloat(lambda.getText()));
            calc.setMu(Float.parseFloat(mu.getText()));
            L.setText("L = "+Float.toString(calc.L()));
            W.setText("W = "+Float.toString(calc.W()));
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(lambdaLbl);
        panel.add(lambda);
        panel.add(muLbl);
        panel.add(mu);
        panel.add(calculateBtn);

        frame.setLayout(new BorderLayout());
        frame.add(panel,BorderLayout.NORTH);
        frame.add(optPanel,BorderLayout.CENTER);
        frame.setSize(580,300);
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