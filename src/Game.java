import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Game extends Canvas{

    public static final int width = 1200, height = (width / 12 * 9) + 50;
    public boolean running = false;

    private Kniffel kniffel;
    private Menu menu;
    private Regeln regeln;
    private Statistik statistik;
    private WinScreen winScreen;
    private Namen namen;
    private BufferedImage background;
    public DBQuery daten;

    public State gamestate;

    public Game() {

        new Window(width, height, "Kniffel", this);

        namen = new Namen();
        kniffel = new Kniffel(this, this.namen);
        menu = new Menu();
        regeln = new Regeln();
        statistik = new Statistik();
        winScreen = new WinScreen(this.kniffel, this.namen);

        this.addMouseListener(new KeyInput(this, this.kniffel, this.regeln, this.namen));

        gamestate = State.Menu;

        background = null;
        try {
            //Bitte Pfad anpassen
            background = ImageIO.read(new File("./src\\hintergrund.png"));
            System.out.println("Hip-Js86");

        } catch (IOException e) {
            System.out.println("Failed to load Image.");
        }

        while(running) {
            tick();
            render();
        }
    }

    private void tick() {

        if(gamestate == State.Menu) {
            menu.tick();
        }

        if(gamestate == State.Kniffel) {
            kniffel.tick();
        }

        if(gamestate == State.Regeln) {
            regeln.tick();
        }

        if(gamestate == State.Statistik) {
            statistik.tick();
        }

        if(gamestate == State.WinScreen) {
            winScreen.tick();
        }
    }

    private void render() {

        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        //Hintergrundbild zeichnen
        g.drawImage(background, 0, 0, null);

        if(gamestate == State.Menu) {
            menu.render(g);
        }

        if(gamestate == State.Kniffel) {
            kniffel.render(g);
        }

        if(gamestate == State.Regeln) {
            regeln.render(g);
        }

        if(gamestate == State.Statistik) {
            statistik.render(g, daten);
        }

        if(gamestate == State.WinScreen) {
            winScreen.render(g, daten);
        }

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }
}
