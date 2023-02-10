/**
 * KnotenEntfernen(Datenelement k)
 */
public class LISTE
{
    private LISTENELEMENT anfang;

    public LISTE()
    {

        anfang = new ABSCHLUSS();

    }
    public String AnfangAusgeben()
    {
        return anfang.Datenelementgeben().InfoAusgeben();
    }

    /**
     * Einzufügende Daten -->d
     */
    public void HintenEinfuegen(DATENELEMENT k)
    {
        anfang = anfang.HintenEinfuegen(k);
    }

    /**
     * Einzufügende Daten -->d
     * Gewünschter Nachfolger --> dv
     */
    public void EinfuegenVor(DATENELEMENT k, DATENELEMENT dv)
    {
        anfang = anfang.EinfuegenVor(k, dv);
    }

    /**
     * Einzufügende Daten -->d
     */
    public void VorneEinfuegen(DATENELEMENT k)
    {
        KNOTEN m;
        m = new KNOTEN(k, anfang);
        anfang = m;
    }

    /**
     * Einzufügende Daten -->k
     */
    public void SortiertEinfuegen(DATENELEMENT k)
    {
        anfang=anfang.SortiertEinfuegen(k);
    }

    public void KnotenEntfernen(DATENELEMENT k)
    {
        anfang.KnotenEntfernen(k);
    }

    /**
     * s --> Gesuchter Wert
     */
    public DATENELEMENT Suchen(String s)
    {
        return anfang.Suchen(s);
    }

    public DATENELEMENT AnfangEntfernen()
    {
        LISTENELEMENT p;
        p=anfang;
        anfang=anfang.NachfolgerGeben();
        return p.Datenelementgeben();
    }

    public DATENELEMENT EndeEntfernen()
    {
        DATENELEMENT m=anfang.EndeGeben(null);
        anfang=anfang.EndeEntfernen(m);
        return m;
    }

    public void InfoAusgeben()
    {
        System.out.println("Liste:");
        anfang.InfoAusgeben();
    }

    public int LaengeGeben()
    {
        return anfang.RestlaengeGeben();
    }
}
