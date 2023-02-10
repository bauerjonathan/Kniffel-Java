import java.awt.*;

public class Statistik {

    public void tick() {

    }

    public void render(Graphics g, DBQuery daten) {

        g.setColor(Color.BLACK);
        g.setFont(new Font("Font1", Font.BOLD, 50));
        g.drawString("Statistik", Game.width / 2 - 95, 100);

        g.setFont(new Font("Font1", Font.BOLD, 36));
        //Regeln Text
        g.drawString("Top 10", Game.width / 2 - 60, 170);

        g.setColor(Color.GRAY);
        g.fillRect(Game.width / 2 -300, 210, 600, 500);
        g.setColor(Color.WHITE.darker());
        g.drawRect(300, 210, 600, 500);
        g.drawLine(600, 210, 600, 710);
        g.drawLine(300, 250, 900, 250);
        daten.TopListeerstellen();


        g.drawString(daten.speicher1Geben(),Game.width / 2 - 200,240+30+8);
        g.drawString(""+daten.PunkteGeben(0),Game.width / 2 +100,240+30+8);
        g.drawString(daten.speicher1Geben(),Game.width / 2 - 200,240+30+8+30+8);
        g.drawString(""+daten.PunkteGeben(1),Game.width / 2 +100,240+30+8+30+8);
        g.drawString(daten.speicher1Geben(),Game.width / 2 - 200,240+30+8+30+8+30+8);
        g.drawString(""+daten.PunkteGeben(2),Game.width / 2 +100,240+30+8+30+8+30+8);
        g.drawString(daten.speicher1Geben(),Game.width / 2 - 200,240+30+8+30+8+8+30+8+30);
        g.drawString(""+daten.PunkteGeben(2),Game.width / 2 +100, 240+30+8+30+8+8+30+8+30);
        g.drawString(daten.speicher1Geben(),Game.width / 2 - 200,240+30+8+30+8+8+30+8+30);
        g.drawString(""+daten.PunkteGeben(2),Game.width / 2 +100, 240+30+8+30+8+8+30+8+30+8+30);
        g.drawString(daten.speicher1Geben(),Game.width / 2 - 200,240+30+8+30+8+8+30+8+30);
        g.drawString(""+daten.PunkteGeben(2),Game.width / 2 +100,240+30+8+30+8+8+30+8+30);
        g.drawString(daten.speicher1Geben(),Game.width / 2 - 200,240+30+8+30+8+8+30+8+30);
        g.drawString(""+daten.PunkteGeben(2),Game.width / 2 +100,240+30+8+30+8+8+30+8+30);
        g.drawString(daten.speicher1Geben(),Game.width / 2 - 200,240+30+8+30+8+8+30+8+30+8+30+8+30+8+30+8+30);
        g.drawString(""+daten.PunkteGeben(2),Game.width / 2 +100,240+30+8+30+8+8+30+8+30+8+30+8+30+8+30+8+30);
        g.drawString(daten.speicher1Geben(),Game.width / 2 - 200,240+30+8+30+8+8+30+8+30+8+30+8+30+8+30+8+30+8+30);
        g.drawString(""+daten.PunkteGeben(2),Game.width / 2 +100,240+30+8+30+8+8+30+8+30+8+30+8+30+8+30+8+30+8+30);
        g.drawString(daten.speicher1Geben(),Game.width / 2 -200,582+30+8);
        g.drawString(""+daten.PunkteGeben(2),Game.width / 2 +100,582+30+8);
        g.drawLine(Game.width / 2 - 300, 250, Game.width/2+300, 250);

        //Text
        g.setFont(new Font("Font1", Font.BOLD, 30));
        g.drawString("Spieler", Game.width / 2 - 200, 240);
        g.drawString("Punkte", Game.width / 2 +100, 240);

        //Back Button
        g.setColor(Color.GRAY);
        g.fillRect(Game.width / 2 - 150, Game.height / 2 + 320, 300, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(Game.width / 2 - 150, Game.height / 2 + 320, 300, 80);
        g.setColor(Color.BLACK);
        g.drawString("Menü",Game.width / 2 - 40, Game.height / 2 + 370);
    }
}
