import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WinScreen {

    //Referenzen
    private Kniffel kniffel;
    private Namen namen;
    private BufferedImage img;

    public WinScreen(Kniffel kniffel, Namen namen) {
        this.kniffel = kniffel;
        this.namen = namen;

        //Laden des würfel.png bildes
        img = null;
        try {
            //Bitte Pfad anpassen
            img = ImageIO.read(new File("./src\\würfel.png"));
            System.out.println("Hip-Js86");

        } catch (IOException e) {
            System.out.println("Failed to load Image.");
        }
    }

    public void tick() {

    }

    public void render(Graphics g, DBQuery daten) {

        //Zeichnen des Bildes
        g.drawImage(img, Game.width / 2 - 220, 500, null);

        g.setFont(new Font("Font1", Font.PLAIN, 60));
        g.setColor(Color.BLACK);
        g.drawString(namen.Ausgeben1() + ": " + kniffel.einsSpielerEndwert, 80, 300);
        g.drawString(namen.Ausgeben2() + ": " + kniffel.zweiSpielerEndwert, 80, 370);

        //Spieler 1 hat gewonnen
        if(kniffel.einsSpielerEndwert > kniffel.zweiSpielerEndwert) {

            g.setFont(new Font("Font1", Font.PLAIN, 70));
            g.drawString(namen.Ausgeben1() + " hat gewonnen!", Game.width / 2 - 350, 120);
        }

        //Gleichstand
        if(kniffel.einsSpielerEndwert == kniffel.zweiSpielerEndwert){

            g.setFont(new Font("Font1", Font.PLAIN, 70));
            g.drawString("Gleichstand!", Game.width / 2 - 200, 120);
        }

        //Spieler 2 hat gewonnen
        if(kniffel.einsSpielerEndwert < kniffel.zweiSpielerEndwert){

            g.setFont(new Font("Font1", Font.PLAIN, 70));
            g.drawString(namen.Ausgeben2() + " hat gewonnen!", Game.width / 2 - 350, 120);
        }
        //daten.PunkteEintragen(daten.SpielerIDGeben(namen.Ausgeben1()), kniffel.einsSpielerEndwert);
        //daten.PunkteEintragen(daten.SpielerIDGeben(namen.Ausgeben2()), kniffel.zweiSpielerEndwert);

        //Back Button
        g.setColor(Color.GRAY);
        g.fillRect(450, 750, 300, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(450, 750, 300, 80);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Font1", Font.BOLD, 36));
        g.drawString("Back", 550, 800);
    }
}