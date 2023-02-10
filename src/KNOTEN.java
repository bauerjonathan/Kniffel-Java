public class KNOTEN extends LISTENELEMENT
{
    private LISTENELEMENT nachfolger;
    private DATENELEMENT daten;

    /**
     * d ist das zugehörige Datenelement
     */
    public KNOTEN(DATENELEMENT d, LISTENELEMENT k)
    {
        daten=d;
        nachfolger=k;
    }

    public KNOTEN SortiertEinfuegen(DATENELEMENT dn)
    {
        if(daten.IstKleinerAls(dn)<0)
        {
            nachfolger=nachfolger.SortiertEinfuegen(dn);
            return this;
        }
        KNOTEN kn;
        kn= new KNOTEN(dn, this);
        return kn;

    }

    public KNOTEN HintenEinfuegen(DATENELEMENT d)
    {
        nachfolger=nachfolger.HintenEinfuegen(d);
        return this;
    }

    public KNOTEN EinfuegenVor(DATENELEMENT d, DATENELEMENT dv)
    {
        if(!daten.equals(dv))
        {
            nachfolger=nachfolger.EinfuegenVor(d, dv);
            return this;
        }
        KNOTEN kn;
        kn= new KNOTEN(d, this);
        return kn;
    }

    public void NachfolgerSetzen(KNOTEN k)
    {
        nachfolger=k;
    }

    public LISTENELEMENT NachfolgerGeben()
    {
        return nachfolger;
    }

    public DATENELEMENT Datenelementgeben()
    {
        return daten;
    }

    public void InfoAusgeben()
    {
        System.out.println(daten.Name());
        nachfolger.InfoAusgeben();
    }

    public DATENELEMENT Suchen( String s)
    {
        if (daten.SchluesselIstGleich(s))
        {
            return daten;
        }
        return nachfolger.Suchen(s);
    }

    public int RestlaengeGeben()
    {
        return nachfolger.RestlaengeGeben()+1;
    }

    public DATENELEMENT EndeGeben(DATENELEMENT d)
    {
        return nachfolger.EndeGeben(Datenelementgeben());
    }

    public LISTENELEMENT EndeEntfernen(DATENELEMENT d)
    {

        if(daten.equals(d))
        {
            return nachfolger;
        }
        nachfolger=nachfolger.EndeEntfernen(d);
        return this;
    }

    public LISTENELEMENT KnotenEntfernen(DATENELEMENT k)
    {
        if(!(daten.equals(k)))
        {
            nachfolger=nachfolger.KnotenEntfernen(k);
            return this;
        }
        return NachfolgerGeben();
    }
}
