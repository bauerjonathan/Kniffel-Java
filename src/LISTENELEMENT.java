public abstract class LISTENELEMENT
{
    public abstract KNOTEN SortiertEinfuegen(DATENELEMENT dn);
    public abstract KNOTEN HintenEinfuegen(DATENELEMENT d);
    public abstract KNOTEN EinfuegenVor(DATENELEMENT d, DATENELEMENT dv);
    public abstract void NachfolgerSetzen(KNOTEN k);
    public abstract LISTENELEMENT NachfolgerGeben();
    public abstract DATENELEMENT Datenelementgeben();
    public abstract void InfoAusgeben();
    public abstract DATENELEMENT Suchen( String s);
    public abstract int RestlaengeGeben();
    public abstract DATENELEMENT EndeGeben(DATENELEMENT d);
    public abstract LISTENELEMENT EndeEntfernen(DATENELEMENT d);
    public abstract LISTENELEMENT KnotenEntfernen(DATENELEMENT k);
}
