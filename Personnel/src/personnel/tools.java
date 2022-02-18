package personnel;

public class tools
{
    public boolean verif_date(String args){//verifie si cela correspond bien au valeur d'une date.
        String[] date = args.split("-");

        if (Integer.parseInt(date[1]) < 12 && Integer.parseInt(date[2]) < 31)
            return true;
        return false;
    }
    public boolean verif_nbr(char c) {//verifie s'il ce n'est que des chiffre
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
    public boolean verif_forma(String args) {
        int i = 0;

        for (; i < 4 && verif_nbr(args.charAt(i)); i++);//année
        if (i == 4 && args.charAt(i) == '-') {
            for (i++; i < 7 && verif_nbr(args.charAt(i)); i++);//mois
            if (i == 7 && args.charAt(i) == '-') {
                for (i++; i < 10 && verif_nbr(args.charAt(i)); i++);//jour
            }
        }
        if (i == 10 && verif_date(args))
            return true;
        return false;
    }
}