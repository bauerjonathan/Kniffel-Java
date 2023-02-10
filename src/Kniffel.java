import java.awt.*;
import java.util.Random;

public class Kniffel {

    private Game game;
    private Namen namen;

    public int[] würfel = new int[5];
    public boolean[] würfelCheck = new boolean[5];

    public Random random;
    public int würfelcount = 0;
    public int SpielerAmZug = 1;

    //Kategorie Werte Spieler 1
    private int einsWertEiner;
    private int einsWertZweier;
    private int einsWertDreier;
    private int einsWertVierer;
    private int einsWertFünfer;
    private int einsWertSechser;
    private int einsWertDreierPasch;
    private int einsWertViererPasch;
    private int einsWertFullHouse;
    private int einsWertKleineStraße;
    private int einsWertGroßeStraße;
    private int einsWertKniffel;
    private int einsWertChance;

    //Kategorie Werte Spieler 2
    private int zweiWertEiner;
    private int zweiWertZweier;
    private int zweiWertDreier;
    private int zweiWertVierer;
    private int zweiWertFünfer;
    private int zweiWertSechser;
    private int zweiWertDreierPasch;
    private int zweiWertViererPasch;
    private int zweiWertFullHouse;
    private int zweiWertKleineStraße;
    private int zweiWertGroßeStraße;
    private int zweiWertKniffel;
    private int zweiWertChance;

    //Schlussendliche Punktzahl
    int einsSpielerEndwert;
    int zweiSpielerEndwert;

    //Boolean Array ob bereits Werte eingetragen sind
    public boolean[] schonEingetragen = new boolean[26];

    public Kniffel(Game game, Namen namen) {

        this.game = game;
        this.namen = namen;

        this.random = new Random();

        for (int i = 0; i < 5; i++) {
            this.würfel[i] = 0;
        }

        for (int i = 0; i < 5; i++) {
            würfelCheck[i] = true;
        }

        for (int i = 0; i < 26; i++) {
            schonEingetragen[i] = false;
        }
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Font1", Font.BOLD, 50));
        g.drawString("Kniffel", Game.width / 2 - 75, 90);

        g.setFont(new Font("Font2", Font.BOLD, 36));

        //Auswerten Button
        g.setColor(Color.GRAY);
        g.fillRect(50, Game.height - 150, 300, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(50, Game.height - 150, 300, 80);
        g.setColor(Color.BLACK);
        g.drawString("Auswerten", 100, Game.height - 100);

        //Re-Roll Button
        g.setColor(Color.GRAY);
        g.fillRect(50, 50, 300, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(50, 50, 300, 80);
        g.setColor(Color.BLACK);
        g.drawString("Würfeln", 120, 100);

        //Tabelle
        g.setColor(Color.GRAY);
        g.fillRect(Game.width / 2 - 100, 110, 600, 700);
        g.setColor(Color.WHITE.darker());
        g.drawRect(Game.width / 2 - 100, 110, 600, 700);
        g.drawRect(Game.width / 2 - 100, 110, 300, 700);
        g.drawRect(Game.width / 2 - 100 + 300, 110, 150, 700);
        g.drawRect(Game.width / 2 - 100 + 450, 110, 150, 700);



        g.setFont(new Font("Font3", Font.BOLD, 30));
        g.drawString("Kategorie", Game.width / 2 - 20, 145);
        g.drawString(namen.Ausgeben1(), Game.width / 2 - 50 + 260, 145);
        g.drawString(namen.Ausgeben2(), Game.width / 2 - 50 + 410, 145);

        //Spieler am Zug
        g.setColor(Color.BLACK);
        if(SpielerAmZug == 1) {
            g.drawString("Spieler: " + namen.Ausgeben1(), 245, 645);
        } else {
            g.drawString("Spieler: " + namen.Ausgeben2(), 245, 645);
        }
        g.setColor(Color.WHITE.darker());

        //WürfelCount
        if (würfelcount < 3) {
            g.setColor(Color.BLACK);
            g.drawString("Gewürfelt: " + würfelcount, 245, 680);
            g.setColor(Color.WHITE.darker());
        } else {
            g.setColor(Color.RED);
            g.drawString("Gewürfelt: " + würfelcount, 245, 680);
            g.setColor(Color.WHITE.darker());
        }
        //Separieren der Tabelle
        g.drawLine(Game.width / 2 - 100, 160, Game.width / 2 - 100 + 600, 160);
        g.drawLine(Game.width / 2 - 100, 210, Game.width / 2 - 100 + 600, 210);
        g.drawLine(Game.width / 2 - 100, 260, Game.width / 2 - 100 + 600, 260);
        g.drawLine(Game.width / 2 - 100, 310, Game.width / 2 - 100 + 600, 310);
        g.drawLine(Game.width / 2 - 100, 360, Game.width / 2 - 100 + 600, 360);
        g.drawLine(Game.width / 2 - 100, 410, Game.width / 2 - 100 + 600, 410);
        g.drawLine(Game.width / 2 - 100, 460, Game.width / 2 - 100 + 600, 460);
        g.drawLine(Game.width / 2 - 100, 510, Game.width / 2 - 100 + 600, 510);
        g.drawLine(Game.width / 2 - 100, 560, Game.width / 2 - 100 + 600, 560);
        g.drawLine(Game.width / 2 - 100, 610, Game.width / 2 - 100 + 600, 610);
        g.drawLine(Game.width / 2 - 100, 660, Game.width / 2 - 100 + 600, 660);
        g.drawLine(Game.width / 2 - 100, 710, Game.width / 2 - 100 + 600, 710);
        g.drawLine(Game.width / 2 - 100, 760, Game.width / 2 - 100 + 600, 760);
        g.drawLine(Game.width / 2 - 100, 810, Game.width / 2 - 100 + 600, 810);

        //Würfel 1 Button
        g.setColor(Color.GRAY);
        g.fillRect(80, 200, 80, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(80, 200, 80, 80);
        g.drawString("" + würfel[0], 110, 250);

        //Würfel 2 Button
        g.setColor(Color.GRAY);
        g.fillRect(80, 300, 80, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(80, 300, 80, 80);
        g.drawString("" + würfel[1], 110, 350);

        //Würfel 3 Button
        g.setColor(Color.GRAY);
        g.fillRect(80, 400, 80, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(80, 400, 80, 80);
        g.drawString("" + würfel[2], 110, 450);

        //Würfel 4 Button
        g.setColor(Color.GRAY);
        g.fillRect(80, 500, 80, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(80, 500, 80, 80);
        g.drawString("" + würfel[3], 110, 550);

        //Würfel 5 Button
        g.setColor(Color.GRAY);
        g.fillRect(80, 600, 80, 80);
        g.setColor(Color.WHITE.darker());
        g.drawRect(80, 600, 80, 80);
        g.drawString("" + würfel[4], 110, 650);

        //Würfel 1 Checkbox
        g.setColor(Color.GRAY);
        g.fillRect(180, 200, 40, 40);
        g.setColor(Color.WHITE.darker());
        g.drawRect(180, 200, 40, 40);
        if (würfelCheck[0] == true) {
            g.setColor(Color.GREEN);
            g.drawString("Y", 190, 230);
        } else {
            g.setColor(Color.RED);
            g.drawString("N", 190, 230);
        }

        //Würfel 2 Checkbox
        g.setColor(Color.GRAY);
        g.fillRect(180, 300, 40, 40);
        g.setColor(Color.WHITE.darker());
        g.drawRect(180, 300, 40, 40);
        if (würfelCheck[1] == true) {
            g.setColor(Color.GREEN);
            g.drawString("Y", 190, 330);
        } else {
            g.setColor(Color.RED);
            g.drawString("N", 190, 330);
        }

        //Würfel 3 Checkbox
        g.setColor(Color.GRAY);
        g.fillRect(180, 400, 40, 40);
        g.setColor(Color.WHITE.darker());
        g.drawRect(180, 400, 40, 40);
        if (würfelCheck[2] == true) {
            g.setColor(Color.GREEN);
            g.drawString("Y", 190, 430);
        } else {
            g.setColor(Color.RED);
            g.drawString("N", 190, 430);
        }

        //Würfel 4 Checkbox
        g.setColor(Color.GRAY);
        g.fillRect(180, 500, 40, 40);
        g.setColor(Color.WHITE.darker());
        g.drawRect(180, 500, 40, 40);
        if (würfelCheck[3] == true) {
            g.setColor(Color.GREEN);
            g.drawString("Y", 190, 530);
        } else {
            g.setColor(Color.RED);
            g.drawString("N", 190, 530);
        }

        //Würfel 5 Checkbox
        g.setColor(Color.GRAY);
        g.fillRect(180, 600, 40, 40);
        g.setColor(Color.WHITE.darker());
        g.drawRect(180, 600, 40, 40);
        if (würfelCheck[4] == true) {
            g.setColor(Color.GREEN);
            g.drawString("Y", 190, 630);
        } else {
            g.setColor(Color.RED);
            g.drawString("N", 190, 630);
        }

        //Kategorien
        g.setColor(Color.WHITE.darker());
        g.drawString("Nur 1er", Game.width / 2 - 90, 195);
        g.drawString("Nur 2er", Game.width / 2 - 90, 245);
        g.drawString("Nur 3er", Game.width / 2 - 90, 295);
        g.drawString("Nur 4er", Game.width / 2 - 90, 345);
        g.drawString("Nur 5er", Game.width / 2 - 90, 395);
        g.drawString("Nur 6er", Game.width / 2 - 90, 445);
        g.drawString("Dreier Pasch", Game.width / 2 - 90, 495);
        g.drawString("ViererPasch", Game.width / 2 - 90, 545);
        g.drawString("Full-House", Game.width / 2 - 90, 595);
        g.drawString("Kleine Straße", Game.width / 2 - 90, 645);
        g.drawString("Große Straße", Game.width / 2 - 90, 695);
        g.drawString("Kniffel", Game.width / 2 - 90, 745);
        g.drawString("Chance", Game.width / 2 - 90, 795);


        WerteZeichnen(g);
    }

    public void WerteZeichnen(Graphics g) {

        g.setColor(Color.WHITE.darker());

        //Spieler 1 Werte
        if (schonEingetragen[0] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertEiner, Game.width / 2 + 210, 195);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertEiner, Game.width / 2 + 210, 195);
        }

        if (schonEingetragen[1] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertZweier, Game.width / 2 + 210, 245);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertZweier, Game.width / 2 + 210, 245);
        }

        if (schonEingetragen[2] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertDreier, Game.width / 2 + 210, 295);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertDreier, Game.width / 2 + 210, 295);
        }

        if (schonEingetragen[3] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertVierer, Game.width / 2 + 210, 345);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertVierer, Game.width / 2 + 210, 345);
        }

        if (schonEingetragen[4] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertFünfer, Game.width / 2 + 210, 395);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertFünfer, Game.width / 2 + 210, 395);
        }

        if (schonEingetragen[5] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertSechser, Game.width / 2 + 210, 445);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertSechser, Game.width / 2 + 210, 445);
        }

        if (schonEingetragen[6] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertDreierPasch, Game.width / 2 + 210, 495);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertDreierPasch, Game.width / 2 + 210, 495);
        }

        if (schonEingetragen[7] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertViererPasch, Game.width / 2 + 210, 545);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertViererPasch, Game.width / 2 + 210, 545);
        }

        if (schonEingetragen[8] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertFullHouse, Game.width / 2 + 210, 595);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertFullHouse, Game.width / 2 + 210, 595);
        }

        if (schonEingetragen[9] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertKleineStraße, Game.width / 2 + 210, 645);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertKleineStraße, Game.width / 2 + 210, 645);
        }

        if (schonEingetragen[10] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertGroßeStraße, Game.width / 2 + 210, 695);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertGroßeStraße, Game.width / 2 + 210, 695);
        }

        if (schonEingetragen[11] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertKniffel, Game.width / 2 + 210, 745);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertKniffel, Game.width / 2 + 210, 745);
        }
        if (schonEingetragen[12] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.einsWertChance, Game.width / 2 + 210, 795);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.einsWertChance, Game.width / 2 + 210, 795);
        }


        //Spieler 2 Werte
        if (schonEingetragen[13] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertEiner, Game.width / 2 + 360, 195);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertEiner, Game.width / 2 + 360, 195);
        }

        if (schonEingetragen[14] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertZweier, Game.width / 2 + 360, 245);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertZweier, Game.width / 2 + 360, 245);
        }

        if (schonEingetragen[15] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertDreier, Game.width / 2 + 360, 295);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertDreier, Game.width / 2 + 360, 295);
        }

        if (schonEingetragen[16] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertVierer, Game.width / 2 + 360, 345);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertVierer, Game.width / 2 + 360, 345);
        }

        if (schonEingetragen[17] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertFünfer, Game.width / 2 + 360, 395);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertFünfer, Game.width / 2 + 360, 395);
        }

        if (schonEingetragen[18] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertSechser, Game.width / 2 + 360, 445);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertSechser, Game.width / 2 + 360, 445);
        }

        if (schonEingetragen[19] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertDreierPasch, Game.width / 2 + 360, 495);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertDreierPasch, Game.width / 2 + 360, 495);
        }

        if (schonEingetragen[20] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertViererPasch, Game.width / 2 + 360, 545);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertViererPasch, Game.width / 2 + 360, 545);
        }

        if (schonEingetragen[21] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertFullHouse, Game.width / 2 + 360, 595);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertFullHouse, Game.width / 2 + 360, 595);
        }

        if (schonEingetragen[22] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertKleineStraße, Game.width / 2 + 360, 645);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertKleineStraße, Game.width / 2 + 360, 645);
        }

        if (schonEingetragen[23] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertGroßeStraße, Game.width / 2 + 360, 695);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertGroßeStraße, Game.width / 2 + 360, 695);
        }

        if (schonEingetragen[24] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertKniffel, Game.width / 2 + 360, 745);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertKniffel, Game.width / 2 + 360, 745);
        }
        if (schonEingetragen[25] == true) {
            g.setColor(Color.BLACK);
            g.drawString("" + this.zweiWertChance, Game.width / 2 + 360, 795);
            g.setColor(Color.WHITE.darker());
        } else {
            g.drawString("" + this.zweiWertChance, Game.width / 2 + 360, 795);
        }
    }

    public void neuWürfeln() {

        if (würfelcount < 3) {

            if (würfelCheck[0] == true) {
                int zwischenwert = random.nextInt(7);
                if (zwischenwert == 0) {
                    zwischenwert = 1;
                }
                würfel[0] = zwischenwert;
            }

            if (würfelCheck[1] == true) {
                int zwischenwert = random.nextInt(7);
                if (zwischenwert == 0) {
                    zwischenwert = 1;
                }
                würfel[1] = zwischenwert;
            }

            if (würfelCheck[2] == true) {
                int zwischenwert = random.nextInt(7);
                if (zwischenwert == 0) {
                    zwischenwert = 1;
                }
                würfel[2] = zwischenwert;
            }

            if (würfelCheck[3] == true) {
                int zwischenwert = random.nextInt(7);
                if (zwischenwert == 0) {
                    zwischenwert = 1;
                }
                würfel[3] = zwischenwert;
            }

            if (würfelCheck[4] == true) {
                int zwischenwert = random.nextInt(7);
                if (zwischenwert == 0) {
                    zwischenwert = 1;
                }
                würfel[4] = zwischenwert;
            }

            würfelcount++;
        }
    }

    public void EinsWürfelEintragen(int Kategorie) {
        if (Kategorie == 1) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 1) {
                    this.einsWertEiner++;
                }
            }
        }

        if (Kategorie == 2) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 2) {
                    this.einsWertZweier++;
                }
            }
            this.einsWertZweier = einsWertZweier * 2;
        }

        if (Kategorie == 3) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 3) {
                    this.einsWertDreier++;
                }
            }
            this.einsWertDreier = einsWertDreier * 3;
        }

        if (Kategorie == 4) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 4) {
                    this.einsWertVierer++;
                }
            }
            this.einsWertVierer = einsWertVierer * 4;
        }

        if (Kategorie == 5) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 5) {
                    this.einsWertFünfer++;
                }
            }
            this.einsWertFünfer = einsWertFünfer * 5;
        }

        if (Kategorie == 6) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 6) {
                    this.einsWertSechser++;
                }
            }
            this.einsWertSechser = einsWertSechser * 6;
        }

        if (Kategorie == 7) {
            //Dreier Pasch
            int gleichzahlcountEins = 0;
            int gleichzahlcountZwei = 0;
            int gleichzahlcountDrei = 0;
            int gleichzahlcountVier = 0;
            int gleichzahlcountFünf = 0;
            int gleichzahlcountSechs = 0;

            for (int i = 0; i < 5; i++) {
                if (würfel[i] == 1) {
                    gleichzahlcountEins++;
                }
                if(würfel[i] == 2) {
                    gleichzahlcountZwei++;
                }
                if(würfel[i] == 3) {
                    gleichzahlcountDrei++;
                }
                if(würfel[i] == 4) {
                    gleichzahlcountVier++;
                }
                if(würfel[i] == 5) {
                    gleichzahlcountFünf++;
                }
                if(würfel[i] == 6) {
                    gleichzahlcountSechs++;
                }
            }
                if(gleichzahlcountEins >= 3) {
                    System.out.println("Dreiereinserpasch");
                    this.einsWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
                }
                if(gleichzahlcountZwei >= 3) {
                    System.out.println("Dreierzweierpasch");
                    this.einsWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
                }
                if(gleichzahlcountDrei >= 3) {
                    System.out.println("Dreierdreierpasch");
                    this.einsWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
                }
                if(gleichzahlcountVier >= 3) {
                    System.out.println("Dreierviererpasch");
                    this.einsWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
                }
                if(gleichzahlcountFünf >= 3) {
                    System.out.println("Dreierfünferpasch");
                    this.einsWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
                }
                if(gleichzahlcountSechs >= 3) {
                    System.out.println("Dreiersechserpasch");
                    this.einsWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
                }
        }

        if (Kategorie == 8) {
            //Vierer Pasch
            int gleichzahlcountEins = 0;
            int gleichzahlcountZwei = 0;
            int gleichzahlcountDrei = 0;
            int gleichzahlcountVier = 0;
            int gleichzahlcountFünf = 0;
            int gleichzahlcountSechs = 0;

            for (int i = 0; i < 5; i++) {
                if (würfel[i] == 1) {
                    gleichzahlcountEins++;
                }
                if(würfel[i] == 2) {
                    gleichzahlcountZwei++;
                }
                if(würfel[i] == 3) {
                    gleichzahlcountDrei++;
                }
                if(würfel[i] == 4) {
                    gleichzahlcountVier++;
                }
                if(würfel[i] == 5) {
                    gleichzahlcountFünf++;
                }
                if(würfel[i] == 6) {
                    gleichzahlcountSechs++;
                }
            }
            if(gleichzahlcountEins >= 4) {
                System.out.println("Dreiereinserpasch");
                this.einsWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountZwei >= 4) {
                System.out.println("Dreierzweierpasch");
                this.einsWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountDrei >= 4) {
                System.out.println("Dreierdreierpasch");
                this.einsWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountVier >= 4) {
                System.out.println("Dreierviererpasch");
                this.einsWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountFünf >= 4) {
                System.out.println("Dreierfünferpasch");
                this.einsWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountSechs >= 4) {
                System.out.println("Dreiersechserpasch");
                this.einsWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
        }

        if (Kategorie == 9) {
            //Fullhouse
            int[] Augenzahlen = new int[6];
            int AnzahlUnterschiedAugenzahl = 0;

            for(int i = 0; i < 5; i++) {
                int augenzahl = würfel[i];
                Augenzahlen[augenzahl - 1]++;

                if(Augenzahlen[augenzahl - 1] == 1) {
                    AnzahlUnterschiedAugenzahl++;
                }
            }

            if(AnzahlUnterschiedAugenzahl == 2) {
                for(int i = 0; i < 5; i++) {
                    if(Augenzahlen[i] == 2 || Augenzahlen[i] == 3) {
                        this.einsWertFullHouse = 25;
                        break;
                    }
                }
            }
        }

        if (Kategorie == 10) {
            //Kleine Straße
            boolean IstEinsDabei = false;
            boolean IstZweiDabei = false;
            boolean IstDreiDabei = false;
            boolean IstVierDabei = false;
            boolean IstFünfDabei = false;
            boolean IstSechsDabei = false;

            for (int i = 0; i < 5; i++) {
                if(würfel[i] == 1) {
                    IstEinsDabei = true;
                    System.out.println(IstEinsDabei);
                }
                if(würfel[i] == 2) {
                    IstZweiDabei = true;
                }
                if(würfel[i] == 3) {
                    IstDreiDabei = true;
                }
                if(würfel[i] == 4) {
                    IstVierDabei = true;
                }
                if(würfel[i] == 5) {
                    IstFünfDabei = true;
                }
                if(würfel[i] == 6) {
                    IstSechsDabei = true;
                }
            }
            if((IstEinsDabei && IstZweiDabei && IstDreiDabei && IstVierDabei) || (IstZweiDabei && IstDreiDabei && IstVierDabei && IstFünfDabei) || (IstDreiDabei && IstVierDabei && IstFünfDabei && IstSechsDabei)) {
                this.einsWertKleineStraße = 30;
                System.out.println("Kleine Straße!");
            }
        }

        if (Kategorie == 11) {
            //Große Straße
            boolean IstEinsDabei = false;
            boolean IstZweiDabei = false;
            boolean IstDreiDabei = false;
            boolean IstVierDabei = false;
            boolean IstFünfDabei = false;
            boolean IstSechsDabei = false;

                for (int i = 0; i < 5; i++) {
                    if(würfel[i] == 1) {
                        IstEinsDabei = true;
                        System.out.println(IstEinsDabei);
                    }
                    if(würfel[i] == 2) {
                        IstZweiDabei = true;
                    }
                    if(würfel[i] == 3) {
                        IstDreiDabei = true;
                    }
                    if(würfel[i] == 4) {
                        IstVierDabei = true;
                    }
                    if(würfel[i] == 5) {
                        IstFünfDabei = true;
                    }
                    if(würfel[i] == 6) {
                        IstSechsDabei = true;
                    }
                }
                if((IstEinsDabei && IstZweiDabei && IstDreiDabei && IstVierDabei && IstFünfDabei) || (IstZweiDabei && IstDreiDabei && IstVierDabei && IstFünfDabei && IstSechsDabei)) {
                    this.einsWertGroßeStraße = 40;
                    System.out.println("Große Straße!");
                }
        }

        if (Kategorie == 12) {
            //Kniffel
            if(     würfel[0] == 1 && würfel[1] == 1 && würfel[2] == 1 && würfel[3] == 1 && würfel[4] == 1 ||
                    würfel[0] == 2 && würfel[1] == 2 && würfel[2] == 2 && würfel[3] == 2 && würfel[4] == 2 ||
                    würfel[0] == 3 && würfel[1] == 3 && würfel[2] == 3 && würfel[3] == 3 && würfel[4] == 3 ||
                    würfel[0] == 4 && würfel[1] == 4 && würfel[2] == 4 && würfel[3] == 4 && würfel[4] == 4 ||
                    würfel[0] == 5 && würfel[1] == 5 && würfel[2] == 5 && würfel[3] == 5 && würfel[4] == 5 ||
                    würfel[0] == 6 && würfel[1] == 6 && würfel[2] == 6 && würfel[3] == 6 && würfel[4] == 6
                    ) {
                this.einsWertKniffel = 50;
            }
        }

        if (Kategorie == 13) {
            //Chance
            this.einsWertChance = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
        }

    }

    public void ZweiWürfelEintragen(int Kategorie) {
        if (Kategorie == 1) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 1) {
                    this.zweiWertEiner++;
                }
            }
        }

        if (Kategorie == 2) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 2) {
                    this.zweiWertZweier++;
                }
            }
            this.zweiWertZweier = zweiWertZweier * 2;
        }

        if (Kategorie == 3) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 3) {
                    this.zweiWertDreier++;
                }
            }
            this.zweiWertDreier = zweiWertDreier * 3;
        }

        if (Kategorie == 4) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 4) {
                    this.zweiWertVierer++;
                }
            }
            this.zweiWertVierer = zweiWertVierer * 4;
        }

        if (Kategorie == 5) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 5) {
                    this.zweiWertFünfer++;
                }
            }
            this.zweiWertFünfer = zweiWertFünfer * 5;
        }

        if (Kategorie == 6) {
            for (int i = 0; i < 5; i++) {
                if (this.würfel[i] == 6) {
                    this.zweiWertSechser++;
                }
            }
            this.zweiWertSechser = zweiWertSechser * 6;
        }

        if (Kategorie == 7) {
            //Dreier Pasch
            int gleichzahlcountEins = 0;
            int gleichzahlcountZwei = 0;
            int gleichzahlcountDrei = 0;
            int gleichzahlcountVier = 0;
            int gleichzahlcountFünf = 0;
            int gleichzahlcountSechs = 0;

            for (int i = 0; i < 5; i++) {
                if (würfel[i] == 1) {
                    gleichzahlcountEins++;
                }
                if(würfel[i] == 2) {
                    gleichzahlcountZwei++;
                }
                if(würfel[i] == 3) {
                    gleichzahlcountDrei++;
                }
                if(würfel[i] == 4) {
                    gleichzahlcountVier++;
                }
                if(würfel[i] == 5) {
                    gleichzahlcountFünf++;
                }
                if(würfel[i] == 6) {
                    gleichzahlcountSechs++;
                }
            }
            if(gleichzahlcountEins >= 3) {
                System.out.println("Dreiereinserpasch");
                this.zweiWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountZwei >= 3) {
                System.out.println("Dreierzweierpasch");
                this.zweiWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountDrei >= 3) {
                System.out.println("Dreierdreierpasch");
                this.zweiWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountVier >= 3) {
                System.out.println("Dreierviererpasch");
                this.zweiWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountFünf >= 3) {
                System.out.println("Dreierfünferpasch");
                this.zweiWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountSechs >= 3) {
                System.out.println("Dreiersechserpasch");
                this.zweiWertDreierPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
        }

        if (Kategorie == 8) {
            //Vierer Pasch
            int gleichzahlcountEins = 0;
            int gleichzahlcountZwei = 0;
            int gleichzahlcountDrei = 0;
            int gleichzahlcountVier = 0;
            int gleichzahlcountFünf = 0;
            int gleichzahlcountSechs = 0;

            for (int i = 0; i < 5; i++) {
                if (würfel[i] == 1) {
                    gleichzahlcountEins++;
                }
                if(würfel[i] == 2) {
                    gleichzahlcountZwei++;
                }
                if(würfel[i] == 3) {
                    gleichzahlcountDrei++;
                }
                if(würfel[i] == 4) {
                    gleichzahlcountVier++;
                }
                if(würfel[i] == 5) {
                    gleichzahlcountFünf++;
                }
                if(würfel[i] == 6) {
                    gleichzahlcountSechs++;
                }
            }
            if(gleichzahlcountEins >= 4) {
                System.out.println("Viereinserpasch");
                this.zweiWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountZwei >= 4) {
                System.out.println("Vierzweierpasch");
                this.zweiWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountDrei >= 4) {
                System.out.println("Vierdreierpasch");
                this.zweiWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountVier >= 4) {
                System.out.println("Vierviererpasch");
                this.zweiWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountFünf >= 4) {
                System.out.println("Vierfünferpasch");
                this.zweiWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
            if(gleichzahlcountSechs >= 4) {
                System.out.println("Viersechserpasch");
                this.zweiWertViererPasch = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
            }
        }

        if (Kategorie == 9) {
            //Fullhouse
            int[] Augenzahlen = new int[6];
            int AnzahlUnterschiedAugenzahl = 0;

            for(int i = 0; i < 5; i++) {
                int augenzahl = würfel[i];
                Augenzahlen[augenzahl - 1]++;

                if(Augenzahlen[augenzahl - 1] == 1) {
                    AnzahlUnterschiedAugenzahl++;
                }
            }

            if(AnzahlUnterschiedAugenzahl == 2) {
                for(int i = 0; i < 5; i++) {
                    if(Augenzahlen[i] == 2 || Augenzahlen[i] == 3) {
                        this.zweiWertFullHouse = 25;
                        break;
                    }
                }
            }
        }

        if (Kategorie == 10) {
            //Kleine Straße
            boolean IstEinsDabei = false;
            boolean IstZweiDabei = false;
            boolean IstDreiDabei = false;
            boolean IstVierDabei = false;
            boolean IstFünfDabei = false;
            boolean IstSechsDabei = false;

            for (int i = 0; i < 5; i++) {
                if(würfel[i] == 1) {
                    IstEinsDabei = true;
                    System.out.println(IstEinsDabei);
                }
                if(würfel[i] == 2) {
                    IstZweiDabei = true;
                }
                if(würfel[i] == 3) {
                    IstDreiDabei = true;
                }
                if(würfel[i] == 4) {
                    IstVierDabei = true;
                }
                if(würfel[i] == 5) {
                    IstFünfDabei = true;
                }
                if(würfel[i] == 6) {
                    IstSechsDabei = true;
                }
            }
            if((IstEinsDabei && IstZweiDabei && IstDreiDabei && IstVierDabei) || (IstZweiDabei && IstDreiDabei && IstVierDabei && IstFünfDabei) || (IstDreiDabei && IstVierDabei && IstFünfDabei && IstSechsDabei)) {
                this.zweiWertKleineStraße = 30;
                System.out.println("Kleine Straße!");
            }
        }

        if (Kategorie == 11) {
            //Große Straße
            boolean IstEinsDabei = false;
            boolean IstZweiDabei = false;
            boolean IstDreiDabei = false;
            boolean IstVierDabei = false;
            boolean IstFünfDabei = false;
            boolean IstSechsDabei = false;

            for (int i = 0; i < 5; i++) {
                if(würfel[i] == 1) {
                    IstEinsDabei = true;
                    System.out.println(IstEinsDabei);
                }
                if(würfel[i] == 2) {
                    IstZweiDabei = true;
                }
                if(würfel[i] == 3) {
                    IstDreiDabei = true;
                }
                if(würfel[i] == 4) {
                    IstVierDabei = true;
                }
                if(würfel[i] == 5) {
                    IstFünfDabei = true;
                }
                if(würfel[i] == 6) {
                    IstSechsDabei = true;
                }
            }
            if((IstEinsDabei && IstZweiDabei && IstDreiDabei && IstVierDabei && IstFünfDabei) || (IstZweiDabei && IstDreiDabei && IstVierDabei && IstFünfDabei && IstSechsDabei)) {
                this.zweiWertGroßeStraße = 40;
            }
        }

        if (Kategorie == 12) {
            //Kniffel
            if(     würfel[0] == 1 && würfel[1] == 1 && würfel[2] == 1 && würfel[3] == 1 && würfel[4] == 1 ||
                    würfel[0] == 2 && würfel[1] == 2 && würfel[2] == 2 && würfel[3] == 2 && würfel[4] == 2 ||
                    würfel[0] == 3 && würfel[1] == 3 && würfel[2] == 3 && würfel[3] == 3 && würfel[4] == 3 ||
                    würfel[0] == 4 && würfel[1] == 4 && würfel[2] == 4 && würfel[3] == 4 && würfel[4] == 4 ||
                    würfel[0] == 5 && würfel[1] == 5 && würfel[2] == 5 && würfel[3] == 5 && würfel[4] == 5 ||
                    würfel[0] == 6 && würfel[1] == 6 && würfel[2] == 6 && würfel[3] == 6 && würfel[4] == 6
                    ) {
                this.zweiWertKniffel = 50;
            }
        }

        if (Kategorie == 13) {
            //Chance
            this.zweiWertChance = würfel[0] + würfel[1] + würfel[2] + würfel[3] + würfel[4];
        }
    }



    public void NächsterSpieler() {
        if(this.SpielerAmZug == 1) {
            this.SpielerAmZug = 2;
        } else {
            this.SpielerAmZug = 1;
        }
    }

    public void WürfelZurücksetzen() {
        for(int i = 0; i < 5; i++) {
            würfel[i] = 0;
            würfelCheck[i] = true;
        }
        würfelcount = 0;
    }

    public void Auswerten() {
        System.out.println("Auswerten");


        int einsSpielerZwischenwert;
        int zweiSpielerZwischenwert;

        einsSpielerZwischenwert = this.einsWertEiner + this.einsWertZweier + this.einsWertDreier + this.einsWertVierer + this.einsWertFünfer + this.einsWertSechser;
        zweiSpielerZwischenwert = this.zweiWertEiner + this.zweiWertZweier + this.zweiWertDreier + this.zweiWertVierer + this.zweiWertFünfer + this.zweiWertSechser;
        einsSpielerEndwert=einsSpielerZwischenwert;
        zweiSpielerEndwert=zweiSpielerZwischenwert;

        einsSpielerEndwert=einsSpielerEndwert+einsWertChance+einsWertKniffel+einsWertGroßeStraße+einsWertKleineStraße+einsWertFullHouse+einsWertViererPasch+einsWertDreierPasch;
        zweiSpielerEndwert=zweiSpielerEndwert+zweiWertChance+zweiWertKniffel+zweiWertGroßeStraße+zweiWertKleineStraße+zweiWertFullHouse+zweiWertViererPasch+zweiWertDreierPasch;

        game.gamestate = State.WinScreen;
    }

    public void neuesSpiel() {

        for (int i = 0; i < 5; i++) {
            würfel[i] = 0;
            würfelCheck[i] = true;
        }

        this.würfelcount = 0;
        this.SpielerAmZug = 1;

        //Kategorie Werte Spieler 1
        einsWertEiner = 0;
        einsWertZweier = 0;
        einsWertDreier = 0;
        einsWertVierer = 0;
        einsWertFünfer = 0;
        einsWertSechser = 0;
        einsWertDreierPasch = 0;
        einsWertViererPasch = 0;
        einsWertFullHouse = 0;
        einsWertKleineStraße = 0;
        einsWertGroßeStraße = 0;
        einsWertKniffel = 0;
        einsWertChance = 0;

        //Kategorie Werte Spieler 2
        zweiWertEiner = 0;
        zweiWertZweier = 0;
        zweiWertDreier = 0;
        zweiWertVierer = 0;
        zweiWertFünfer = 0;
        zweiWertSechser = 0;
        zweiWertDreierPasch = 0;
        zweiWertViererPasch = 0;
        zweiWertFullHouse = 0;
        zweiWertKleineStraße = 0;
        zweiWertGroßeStraße = 0;
        zweiWertKniffel = 0;
        zweiWertChance = 0;

        //Spieler Endwerte
        einsSpielerEndwert = 0;
        zweiSpielerEndwert = 0;

        //Boolean Array ob bereits Werte eingetragen sind
        for (int i = 0; i < 26; i++) {
            schonEingetragen[i] = false;
        }
    }
}