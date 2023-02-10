import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;

public class Regeln {

    //Wo in den Regeln (Allgemeine / Punkte)
    private int state = 1;

    public void tick() {

    }

    public void setstate(int i) {
        if (state == 1 || state == 2) {
            state = i;
        }
    }
    public int givestate()
    {
        return state;
    }

    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.setFont(new Font("Font1", Font.BOLD, 50));
        g.drawString("Kniffel Spielanleitung", Game.width / 2 - 250, 100);

        if(state == 1) {
            g.setFont(new Font("Font1", Font.BOLD, 24));

            //Regeln Text
            g.drawString("Kniffel ist ein Würfelspiel für 2 Spieler ab 8 Jahren. Ziel des Spiels ist es, durch Würfeln", 50, 200);
            g.drawString("und geschicktes Eintragen die meisten Punkte zu erhalten. ", 50, 227);
            g.setFont(new Font("Font1", Font.BOLD, 26));
            g.drawString("Spielverlauf: ", 50, 227 + 40);
            g.setFont(new Font("Font1", Font.BOLD, 24));
            g.drawString("•  Es wird reihum gewürfelt, wobei jeder Spieler drei Versuche hat. Nach dem ersten Wurf werden ", 50, 227 + 40 + 30);
            g.drawString("    durch Anklicken die Würfel fixiert und mit den Übrigen kann noch zweimal gewürfelt werden.", 50, 227 + 70 + 25);
            g.drawString("•  Nach dem dritten Wurf muss das Ergebnis in die nebenstehende Liste eingetragen werden. ", 50, 227 + 70 + 60);
            g.drawString("•  Wenn kein passendes Feld zur Verfügung steht oder bereits ausgefüllt ist, muss in einem ", 50, 227 + 70 + 60 + 25);
            g.drawString("    beliebigen Feld eine 0 eingetragen werden. ", 50, 227 + 70 + 60 + 50);

            g.drawString("•	  Sobald die Punkte in die Liste eingetragen wurden, ist automatisch der nächste Spieler am Zug.", 50, 227 + 206 );
            g.drawString("•  Das Spiel endet, wenn das letzte Feld jedes Spielers ausgefüllt ist, und man auf", 50, 227 + 206 + 25);
            g.drawString("    „Auswerten“ klickt.", 50, 434 + 50);

            //Eintragen Button
            g.setColor(Color.GRAY);
            g.fillRect(Game.width / 2 +100, Game.height / 2 + 200, 300, 80);
            g.setColor(Color.WHITE.darker());
            g.drawRect(Game.width / 2 + 100, Game.height / 2 + 200, 300, 80);
            g.setColor(Color.BLACK);
            g.drawString("Eintragen der Punkte",Game.width / 2 +130, Game.height / 2 + 250);
        }
        else if(state == 2){
            g.setFont(new Font("Font1", Font.BOLD, 26));

            //Regeln Text
            g.drawString("•  Oberer Teil: ", 50, 200);
            g.setFont(new Font("Font1", Font.BOLD, 24));
            g.drawString("     •  Die Augenzahlen der gleichen Würfel (1-6) zählen. ", 50, 227);
            g.drawString("             Bonus: Bei 63 Punkten oder mehr erhält der Spieler 35 Bonuspunkte",50,253);
            g.setFont(new Font("Font1", Font.BOLD, 26));
            g.drawString("•  Unterer Teil: ", 50, 253 + 40);
            g.setFont(new Font("Font1", Font.BOLD, 24));
            g.drawString("     •  Dreier Pasch: mindestens drei gleiche Zahlen. Alle Augen zählen. ", 50, 253 + 40 + 30);
            g.drawString("     •  Vierer Pasch: mindestens vier gleiche Zahlen. Alle Augen zählen. ", 50, 253 + 70 + 30);
            g.drawString("     •  Full House: Drei gleiche Zahlen und zwei gleiche Zahlen. (25 Punkte)", 50, 253 + 70 + 60);
            g.drawString("     •  Kleine Straße: Vier aufeinanderfolgende Zahlen z.B.1-2-3-4. (30 Punkte)", 50, 253 + 70 + 60 + 30);
            g.drawString("     •  Große Straße: Fünf aufeinanderfolgende Zahlen z.B. 2-3-4-5-6. (40 Punkte)", 50, 253 + 70 + 60 +60);
            g.drawString("     •  Kniffel: Fünf gleiche Zahlen. (50 Punkte)", 50, 253 + 180 + 40);
            g.drawString("     •  Chance: Sobald keines der oberen Felder zum Wurf passt. Alle Augen zählen.", 50, 253 + 210 + 40);

            //Allgemeinses Button
            g.setColor(Color.GRAY);
            g.fillRect(Game.width / 2 +100, Game.height / 2 + 200, 300, 80);
            g.setColor(Color.WHITE.darker());
            g.drawRect(Game.width / 2 + 100, Game.height / 2 + 200, 300, 80);
            g.setColor(Color.BLACK);
            g.drawString("Allgemeines",Game.width / 2 +175, Game.height / 2 + 250);
        }

        //Back Button
        g.setColor(Color.GRAY);
        g.fillRect(Game.width / 2 -400, Game.height / 2 + 200, 300, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(Game.width / 2 - 400, Game.height / 2 + 200, 300, 80);
        g.setColor(Color.BLACK);
        g.drawString("Back",Game.width / 2 - 290, Game.height / 2 + 250);
    }
}
