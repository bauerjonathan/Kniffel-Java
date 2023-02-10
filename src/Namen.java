import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Namen {

    private JFrame jFrame;
    private JTextField tf1Name;
    private JTextField tf2Name;
    private JButton enter;

    public String name1;
    public String name2;

    //Ist der Frame gerade visible?
    public boolean isopen = true;

    public Namen() {

        jFrame = new JFrame();
        JPanel panel = new JPanel();
        jFrame.setTitle("Spielereingabe");
        jFrame.setSize(300, 200);
        jFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        jFrame.setLocation(100,100);

        //JButton
        enter = new JButton("Enter");

        //JLabels
        JLabel label1 = new JLabel("Ihr Name");
        JLabel label2 = new JLabel("Ihr Name");

        // Textfeld wird erstellt
        // Text und Spaltenanzahl werden dabei direkt gesetzt
        tf1Name = new JTextField("Spieler1", 15);
        tf2Name = new JTextField("Spieler2", 15);

        // Textfelder werden dem Panel hinzugefügt
        panel.add(label1);
        panel.add(tf1Name);
        panel.add(label2);
        panel.add(tf2Name);
        panel.add(enter);

        //Actionlistener auf dem Button
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Zwischenwerte der Textfields um später auf die Methode ".length" zugreifen zu können
                String zwischenwert1 = tf1Name.getText();
                String zwischenwert2 = tf2Name.getText();

                //Man kann nur namen mit weniger als 9 Buchstaben eingeben
                if(zwischenwert1.length() < 9 && zwischenwert2.length() < 9) {
                    name1 = zwischenwert1;
                    name2 = zwischenwert2;
                    jFrame.setVisible(false);
                    //Nach dem klicken ist der Jframe nicht mehr visible
                    isopen = false;
                }
            }
        });

        jFrame.add(panel);
        jFrame.setVisible(true);
    }



    public String Ausgeben1() {
        //Ausgeben des 1. Textfields
        return name1;
    }

    public String Ausgeben2() {
        //Ausgeben des 1. Textfields
        return name2;
    }

    public void NeuOeffnen() {
        isopen = true;
        jFrame.setVisible(true);
    }
}