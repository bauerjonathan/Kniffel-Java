import javax.swing.*;
import java.awt.*;


public class Window extends Canvas {

    public Window(int width, int height, String title, Game game) {

        JFrame window = new JFrame(title);


        window.setPreferredSize(new Dimension(width, height));
        window.setMaximumSize(new Dimension(width, height));
        window.setMinimumSize(new Dimension(width, height));

        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.add(game);
        window.setVisible(true);

        game.running = true;
    }
}
