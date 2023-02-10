public class SpSpieler implements DATENELEMENT{

        private String name;

        /**
         * Name: n
         */
        public SpSpieler(String n)
        {
            name=n;
        }

        public String InfoAusgeben()
        {
            return name;
        }

        public String Name()
        {
            return name;
        }

        public int IstKleinerAls(DATENELEMENT dn)
        {
            return name.compareTo(dn.Name());
        }

        public boolean SchluesselIstGleich(String s)
        {
            return name.equals( s);
        }


    }

