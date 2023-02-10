import java. sql. *;
public class DBQuery
{
    //Treiber für MySQL
    private String treiber = "com.mysql.jdbc.Driver";
    private String pfad = "jdbc:mysql://localhost/statistik";
    private String user = "root";//java
    private String pWort = "root";//javajavajava123
    private boolean verbindung = false;
    private Connection conn;
    private LISTE speicher;
    private int[] punk = new int[10];

    public static void main(String[] args) {
        new DBQuery();
    }

    public DBQuery()
    {
        try
        {
            Class.forName(treiber);
        }
        catch(Exception e)
        {
            System.out.println("Start_Fehler beim Laden des Treibers"+ e);
            System.exit(-1);
        }

        try
        {
            conn = DriverManager.getConnection(pfad, user, pWort);
            verbindung =true;
            System.out.println("Verbindung:"+verbindung);
        }
        catch(Exception e)
        {
            System.out.println("Start_Fehler bei Datenbankzugriff"+ e);
            System.exit(-1);
        }
        SpielerIDGeben("Spieler1");
    }

    public void Schliessen()
    {
        try
        {
            conn. close();
            verbindung = false;
            System.out.println("Verbindung:"+verbindung);
        }
        catch(Exception e)
        {
            System.out.println("Fehler beim Beenden der Datenbankverbindung"+ e);
        }
    }

        public void TopListeerstellen()
    {
        ResultSet sqlResult;
        Statement stmt;

        try
        {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery("SELECT name, punkte FROM spieler, punkte WHERE spieler.ID=punkte.ID Order by Punkte");
            sqlResult.afterLast();
            sqlResult.previous();
            sqlResult.beforeFirst();
            int i = 0;

            while (i<10)
            {
                speicher.HintenEinfuegen(new SpSpieler(sqlResult. getString ("name") + " " + sqlResult. getString ("Name")));
                punk[i]= Integer.parseInt(sqlResult. getString (2) + " " + sqlResult. getInt ("punkte"));
                i=i++;
            }
            sqlResult. close ();

            stmt.close();

        }
        catch(Exception e)
        {
            System.out.println("TopSpielerHolen: Fehler bei SQL Abfrage" + e);

        }

    }

    public void PunkteEintragen(int id,int punkte)
    {
        Statement stmt;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO punkte (ID, punkte) "+ " VALUES("+ id +","+ punkte+");");
            System.out.println(stmt);
        }
        catch(Exception e)
        {
            System.out.println("PunkteEintragen: Fehler bei SQL Abfrage"+ e);
        }
    }

    public int SpielerIDGeben(String name)
    {
        Statement stmt;
        ResultSet sqlResult;

        try {
            stmt = conn.createStatement();
            sqlResult = stmt.executeQuery("SELECT id FROM spieler WHERE spieler.name='"+name+"';");
            System.out.println(sqlResult.getInt(1));
            return sqlResult.getInt(1);
        }
        catch(Exception e)
        {
            System.out.println("IDAusgabe: Fehler bei SQL Abfrage"+ e);
            return 0;
        }
    }

    public void NamenAbgleich(String name)
    {
        Statement stmt;
        if( SpielerIDGeben(name)==0)
        {
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO spieler (name) VALUES('"+ name+"');");
                System.out.println("Willkomen "+name);

            }
            catch(Exception e)
            {
                System.out.println("Einfügen Spieler : Fehler bei SQL Abfrage"+ e);
            }
        }
        else
            System.out.println("Willkommen zurück "+name);
    }

    public String speicher1Geben() {
        String s = speicher.AnfangAusgeben();
        speicher. AnfangEntfernen();
        return s;
    }
    public int PunkteGeben(int e){
        return punk[e];
    }
}