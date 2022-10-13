public class CalculatorModel {
    Polynomial creeazaPolinom(String text)
    {
        text=pregatestePolinom(text);
        Polynomial pol = new Polynomial();
        for (String val: text.split("\\+")) {
            int k=val.indexOf("x");
            int ok=0;
            if(k==-1) k=val.indexOf("X");
            Monomial mon = new Monomial(Integer.parseInt(val.substring(k+2)),Float.parseFloat(val.substring(0,k-1)));
            for (Monomial ver: pol.polinom) {
                if(mon.getGrad()==ver.getGrad())
                {
                    mon.setCoeficient(mon.getCoeficient()+ ver.getCoeficient());
                    pol.polinom.set(pol.polinom.indexOf(ver),mon);
                    ok=1;
                }
            }
            if(ok==0)
                pol.polinom.add(mon);
        }
        return pol;
    }

    Polynomial adunare(Polynomial polinom1, Polynomial polinom2)
    {
        Polynomial rezultat = polinom1;
        for (Monomial val:polinom2.polinom) {
            int ok=0;
            for (Monomial val2:rezultat.polinom) {
                if(val.getGrad()==val2.getGrad())
                {
                    int poz=rezultat.polinom.indexOf(val2);
                    float coef = val.getCoeficient()+ val2.getCoeficient();
                    int grad = val.getGrad();
                    Monomial newMonom = new Monomial(grad,coef);
                    rezultat.polinom.set(poz,newMonom);
                    ok = 1;
                }
            }
            if(ok==0)
                rezultat.polinom.add(val);
        }
        return rezultat;
    }

    Polynomial scadere(Polynomial polinom1, Polynomial polinom2)
    {
        Polynomial rezultat = polinom1;
        for (Monomial val:polinom2.polinom) {
            int ok=0;
            for (Monomial val2:rezultat.polinom) {
                if(val.getGrad()==val2.getGrad())
                {
                    int poz=rezultat.polinom.indexOf(val2);
                    float coef = val2.getCoeficient() - val.getCoeficient();
                    int grad = val.getGrad();
                    Monomial newMonom = new Monomial(grad,coef);
                    rezultat.polinom.set(poz,newMonom);
                    ok = 1;
                }
            }
            if(ok==0)
            {
                val.setCoeficient(val.getCoeficient()*-1);
                rezultat.polinom.add(val);
            }
        }
        return rezultat;
    }

    Polynomial derivare(Polynomial polinom1)
    {
        Polynomial rezultat = new Polynomial();
        for (Monomial val: polinom1.polinom) {
            if(val.getGrad()!=0)
            {
                Monomial newMonom = new Monomial(val.getGrad()-1,val.getGrad() * val.getCoeficient());
                rezultat.polinom.add(newMonom);
            }
        }
        return rezultat;
    }

    Polynomial integrare(Polynomial polinom1)
    {
        Polynomial rezultat = new Polynomial();
        for(Monomial val: polinom1.polinom){
            Monomial newMonom = new Monomial(val.getGrad()+1, val.getCoeficient()/ (val.getGrad()+1));
            rezultat.polinom.add(newMonom);
        }
        return rezultat;
    }

    Polynomial inmultire(Polynomial polinom1, Polynomial polinom2)
    {
        Polynomial rezultat = new Polynomial();
        for (Monomial val:polinom1.polinom) {
            Polynomial temporar = new Polynomial();
            for (Monomial val2: polinom2.polinom) {
                Monomial newMonom = new Monomial(val.getGrad()+ val2.getGrad(),
                        val.getCoeficient()* val2.getCoeficient());
                temporar.polinom.add(newMonom);
            }
            rezultat=adunare(rezultat,temporar);
        }
        return rezultat;
    }

    String pregatestePolinom(String text)
    {
        StringBuilder text2 = new StringBuilder(text);
        if(text2.charAt(0)=='-')
            text2.insert(0,"0*x^0");
        for (int i=0;i<text2.length();i++) {
            if(text2.charAt(i)=='-')
                text2.insert(i++,"+");
        }
        return text2.toString();
    }

    String spargePolinom(Polynomial polinom1)
    {
        String text="";
        for (Monomial val: polinom1.polinom) {
                if(val.getCoeficient()!=0) {
                    if (text != "") {
                        text = text.concat(" + ");
                    }
                    if (val.getCoeficient() != 1) {
                        text = text.concat(String.valueOf(val.getCoeficient()));
                    }
                    if(val.getGrad()>0)
                    {
                        if(val.getCoeficient()!=1)
                        {
                            text = text.concat("*");
                        }
                    text = text.concat("x");
                    text = text.concat("^");
                    text = text.concat(String.valueOf(val.getGrad()));
                    }
                }
        }
        return text;
    }
    Polynomial ordoneazaDescrescator(Polynomial polinom1)
    {
        Polynomial polinom2 = new Polynomial();
        while(!polinom1.polinom.isEmpty()) {
            Monomial monom = polinom1.getMonom(0);
            for (Monomial val : polinom1.polinom) {
                if (val.getGrad() > monom.getGrad())
                    monom = val;
            }
            polinom1.polinom.remove(polinom1.polinom.indexOf(monom));
            polinom2.addMonom(monom);
        }
        return polinom2;
    }

    Polynomial ordoneazaCrescator(Polynomial polinom1)
    {
        Polynomial polinom2 = new Polynomial();
        while(!polinom1.polinom.isEmpty()) {
            Monomial monom = new Monomial(99999999,99999999);
            for (Monomial val : polinom1.polinom) {
                if (val.getGrad() < monom.getGrad())
                    monom = val;
            }
            polinom1.polinom.remove(polinom1.polinom.indexOf(monom));
            polinom2.addMonom(monom);
        }
        return polinom2;
    }
    RezultatImpartire impartire(Polynomial polinom1, Polynomial polinom2)
    {
        Polynomial rezultat = new Polynomial();
        polinom1=ordoneazaDescrescator(polinom1);
        polinom2=ordoneazaDescrescator(polinom2);
        while(polinom1.getMonom(0).getGrad()>=polinom2.getMonom(0).getGrad())
        {
            if(polinom1.getMonom(0).getCoeficient()==0)
                polinom1.polinom.remove(0);
            if((polinom1.getMonom(0).getGrad()-polinom2.getMonom(0).getGrad())>=0)
            {
                Monomial newMonom = new Monomial(polinom1.getMonom(0).getGrad() - polinom2.getMonom(0).getGrad(), polinom1.getMonom(0).getCoeficient() / polinom2.getMonom(0).getCoeficient());
                rezultat.polinom.add(newMonom);
                Polynomial temp = new Polynomial();
                temp.addMonom(newMonom);
                Polynomial scazator = inmultire(temp, polinom2);
                polinom1 = scadere(polinom1, scazator);
            }
        }
        RezultatImpartire rez = new RezultatImpartire(rezultat,polinom1);
        return rez;
    }
}

//1*x^1+2*x^2+3*x^3
//3*x^3+2*x^2+4*x^4

//1*x^3-2*x^2+6*x^1-5*x^0
//1*x^2-1*x^0