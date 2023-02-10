import java.awt.*;

public class Menu {

    public void tick() {

    }

    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.setFont(new Font("Font1", Font.BOLD, 50));
        g.drawString("Kniffel", Game.width / 2 - 75, 100);


        g.setFont(new Font("Font1", Font.BOLD, 36));
        //New Game Button
        g.setColor(Color.GRAY);
        g.fillRect(Game.width / 2 - 150, Game.height / 2 - 300, 300, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(Game.width / 2 - 150, Game.height / 2 - 300, 300, 80);
        g.setColor(Color.BLACK);
        g.drawString("New Game",Game.width / 2 - 95, Game.height / 2 - 250);


        //Regeln Button
        g.setColor(Color.GRAY);
        g.fillRect(Game.width / 2 - 150, Game.height / 2 - 100, 300, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(Game.width / 2 - 150, Game.height / 2 - 100, 300, 80);
        g.setColor(Color.BLACK);
        g.drawString("Regeln",Game.width / 2 - 65, Game.height / 2 - 50);

        //Statistik Button
        g.setColor(Color.GRAY);
        g.fillRect(Game.width / 2 - 150, Game.height / 2 + 100, 300, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(Game.width / 2 - 150, Game.height / 2 + 100, 300, 80);
        g.setColor(Color.BLACK);
        g.drawString("Statistik",Game.width / 2 - 65, Game.height / 2 + 150);

        //Exit Button
        g.setColor(Color.GRAY);
        g.fillRect(Game.width / 2 - 150, Game.height / 2 + 300, 300, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(Game.width / 2 - 150, Game.height / 2 + 300, 300, 80);
        g.setColor(Color.BLACK);
        g.drawString("Exit",Game.width / 2 - 40, Game.height / 2 + 350);
    }
}
