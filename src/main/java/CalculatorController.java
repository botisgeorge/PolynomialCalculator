import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel m_model;
    private CalculatorView m_view;

    CalculatorController(CalculatorModel model, CalculatorView view) {
        m_model = model;
        m_view = view;

        view.addAddListener(new AddListener());
        view.addSubstractListener(new SubstractListener());
        view.addDerivareListener(new DerivareListener());
        view.addIntegrareListener(new IntegrareListener());
        view.addInmultireListener(new InmultireListener());
        view.addImpartireListener(new ImpartireListener());
    }
    class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String t_polinom1=m_view.getPolinom1();
            String t_polinom2=m_view.getPolinom2();
            Polynomial polinom1 = m_model.creeazaPolinom(t_polinom1);
            Polynomial polinom2 = m_model.creeazaPolinom(t_polinom2);
            Polynomial rezultat = m_model.adunare(polinom1,polinom2);
            rezultat = m_model.ordoneazaCrescator(rezultat);
            m_view.setRezultat(m_model.spargePolinom(rezultat));
            m_view.setRest("");
        }
    }
    class SubstractListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String t_polinom1 = m_view.getPolinom1();
            String t_polinom2 = m_view.getPolinom2();
            Polynomial polinom1 = m_model.creeazaPolinom(t_polinom1);
            Polynomial polinom2 = m_model.creeazaPolinom(t_polinom2);
            Polynomial rezultat = m_model.scadere(polinom1,polinom2);
            rezultat = m_model.ordoneazaCrescator(rezultat);
            m_view.setRezultat(m_model.spargePolinom(rezultat));
            m_view.setRest("");
        }
    }
    class DerivareListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String t_polinom1 = m_view.getPolinom1();
            Polynomial polinom1 = m_model.creeazaPolinom(t_polinom1);
            Polynomial rezultat = m_model.derivare(polinom1);
            rezultat = m_model.ordoneazaCrescator(rezultat);
            m_view.setRezultat(m_model.spargePolinom(rezultat));
            m_view.setRest("");
        }
    }
    class IntegrareListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String t_polinom1 = m_view.getPolinom1();
            Polynomial polinom1 = m_model.creeazaPolinom(t_polinom1);
            Polynomial rezultat = m_model.integrare(polinom1);
            rezultat = m_model.ordoneazaCrescator(rezultat);
            m_view.setRezultat(m_model.spargePolinom(rezultat));
            m_view.setRest("");
        }
    }
    class InmultireListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String t_polinom1 = m_view.getPolinom1();
            String t_polinom2 = m_view.getPolinom2();
            Polynomial polinom1 = m_model.creeazaPolinom(t_polinom1);
            Polynomial polinom2 = m_model.creeazaPolinom(t_polinom2);
            Polynomial rezultat = m_model.inmultire(polinom1,polinom2);
            rezultat = m_model.ordoneazaCrescator(rezultat);
            m_view.setRezultat(m_model.spargePolinom(rezultat));
            m_view.setRest("");
        }
    }
    class ImpartireListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String t_polinom1 = m_view.getPolinom1();
            String t_polinom2 = m_view.getPolinom2();
            Polynomial polinom1 = m_model.creeazaPolinom(t_polinom1);
            Polynomial polinom2 = m_model.creeazaPolinom(t_polinom2);
            RezultatImpartire rez = m_model.impartire(polinom1,polinom2);
            Polynomial rezultat = rez.getRezultat();
            Polynomial rest = rez.getRest();
            rest=m_model.ordoneazaDescrescator(rest);
            rezultat = m_model.ordoneazaDescrescator(rezultat);
            m_view.setRezultat(m_model.spargePolinom(rezultat));
            m_view.setRest(m_model.spargePolinom(rest));
        }
    }
}
