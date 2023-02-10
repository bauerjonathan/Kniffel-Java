
public class ABSCHLUSS extends LISTENELEMENT
{
    public ABSCHLUSS()
    {

    }

    public LISTENELEMENT NachfolgerGeben()
    {
        return this;
    }

    public void InfoAusgeben()
    {
        System.out.println("Ende");
    }

    public DATENELEMENT Suchen( String s)
    {
        return null;
    }

    public int RestlaengeGeben()
    {
        return 0;
    }

    public KNOTEN EinfuegenVor(DATENELEMENT d, DATENELEMENT dv)
    {
        KNOTEN kn;
        kn= new KNOTEN(d, this);
        return kn;
    }

    public KNOTEN SortiertEinfuegen(DATENELEMENT dn)
    {
        KNOTEN kn;
        kn= new KNOTEN(dn, this);
        return kn;
    }

    public LISTENELEMENT KnotenEntfernen(DATENELEMENT d)
    {
        return this;
    }

    public LISTENELEMENT EndeEntfernen(DATENELEMENT d)
    {
        return this;
    }

    public DATENELEMENT EndeGeben(DATENELEMENT d)
    {
        return d;
    }

    public DATENELEMENT Datenelementgeben()
    {
        return null;
    }

    public void NachfolgerSetzen(KNOTEN k)
    {

    }

    public KNOTEN HintenEinfuegen(DATENELEMENT d)
    {
        KNOTEN kn;
        kn= new KNOTEN(d, this);
        return kn;
    }
}
