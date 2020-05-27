import javax.swing.*;
import java.awt.*;

public class Main {

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("single-channel queuing model");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lambdaLbl = new JLabel("mean # of arrivals:");
        JTextField lambda = new JTextField(10);

        JLabel muLbl = new JLabel("mean # of served:");
        JTextField mu = new JTextField(10);

        JLabel csLbl = new JLabel("service cost per day:");
        JTextField cs = new JTextField(10);

        JLabel cwLbl = new JLabel("waiting cost per day:");
        JTextField cw = new JTextField(10);

        JTextArea area = new JTextArea(50,50);
        area.setEditable(false);

        JButton calculateBtn = new JButton("calculate");

        calculateBtn.addActionListener(e->{
            try{
                float m =Float.parseFloat(mu.getText());
                float l =Float.parseFloat(lambda.getText());
                float c =Float.parseFloat(cs.getText());
                float w =Float.parseFloat(cw.getText());
                if(m>0 && l>0 && c>0 && w>0){
                    if(m>l) {
                        Calculations calc = new Calculations();
                        calc.setLambda(Float.parseFloat(lambda.getText()));
                        calc.setMu(Float.parseFloat(mu.getText()));
                        calc.setCs(Float.parseFloat(cs.getText()));
                        calc.setCw(Float.parseFloat(cw.getText()));
                        area.setText(
                                "   1- average number of costumers in the system = " + calc.L() +
                                        "\n   2- average time a customer spends in the system = " + calc.W() +
                                        "\n   3- average number of costumers in the queue = " + calc.Lq() +
                                        "\n   4- average time a customer spends in the queue = " + calc.Wq() +
                                        "\n   5- probability the service facility is being used = " + calc.P() +
                                        "\n   6- the probability no one is in the system = " + calc.P0() +
                                        "\n   7-The probability that the number of customers in the system is greater than k"
                        );
                        float arr[] = new float[8];
                        calc.Pk(arr);
                        for (int i = 0; i < 8; i++) {
                            area.setText(area.getText() + "\n" + "\tk = " + i + "\t p = " + arr[i]);
                        }
                        area.setText(
                                area.getText() +
                                        "\n   8- total waiting cost (q) = " + calc.TWCq() +
                                        "\n   9- total cost = " + calc.TC()
                        );
                    } else {
                        JOptionPane.showMessageDialog(null, "number of served must be greater than number of arrivals!",
                                "ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Enter Valid positive numbers!",
                            "ERROR!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException |NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Enter Valid positive numbers",
                        "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel lpanel = new JPanel();
        lpanel.setLayout(new FlowLayout());
        lpanel.add(lambdaLbl);
        lpanel.add(lambda);
        lpanel.add(muLbl);
        lpanel.add(mu);

        JPanel rpanel = new JPanel();
        rpanel.setLayout(new FlowLayout());
        rpanel.add(csLbl);
        rpanel.add(cs);
        rpanel.add(cwLbl);
        rpanel.add(cw);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.add(calculateBtn);

        JScrollPane scrollPane = new JScrollPane(area);

        JPanel mainPanel = new JPanel();
        BoxLayout layout=new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
        mainPanel.setLayout(layout);

        mainPanel.add(lpanel);
        mainPanel.add(rpanel);
        mainPanel.add(panel3);
        mainPanel.add(scrollPane);

        frame.add(mainPanel);
        frame.setSize(500,450);
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