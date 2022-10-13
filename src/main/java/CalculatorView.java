import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

class CalculatorView extends JFrame {

    private JTextField tf_polinom1 = new JTextField(10);
    private JTextField tf_polinom2 = new JTextField(10);
    private JTextField tf_polinom3 = new JTextField(10);
    private JTextField tf_polinom4 = new JTextField(10);
    private JButton button_add = new JButton("+");
    private JButton button_substract = new JButton("-");
    private JButton button_multiply = new JButton("*");
    private JButton button_divide = new JButton("/");
    private JButton button_derivate = new JButton("Deriveaza");
    private JButton button_integrate = new JButton("Integreaza");

    private CalculatorModel m_model;
    CalculatorView(CalculatorModel model)
    {
        m_model = model;

        JPanel panelPolinom1 = new JPanel(new GridLayout(2,1));
        panelPolinom1.add(new JLabel("Polinom 1"));
        panelPolinom1.add(tf_polinom1);

        JPanel panelPolinom2 = new JPanel(new GridLayout(2,1));
        panelPolinom2.add(new JLabel("Polinom 2"));
        panelPolinom2.add(tf_polinom2);

        JPanel panelPolinom3 = new JPanel(new GridLayout(2,1));
        panelPolinom3.add(new JLabel("Rezultat"));
        panelPolinom3.add(tf_polinom3);

        JPanel panelPolinom4 = new JPanel(new GridLayout(2,1));
        panelPolinom4.add(new JLabel("Rest (la impartire)"));
        panelPolinom4.add(tf_polinom4);

        JPanel panelSUS = new JPanel(new GridLayout(1,2));
        button_add.setPreferredSize(new Dimension(100,50));
        button_substract.setPreferredSize(new Dimension(100,50));
        panelSUS.add(button_add);
        panelSUS.add(button_substract);

        JPanel panelMIJLOC = new JPanel(new GridLayout(1,2));
        button_multiply.setPreferredSize(new Dimension(100,50));
        button_divide.setPreferredSize(new Dimension(100,50));
        panelMIJLOC.add(button_multiply);
        panelMIJLOC.add(button_divide);

        JPanel panelJOS = new JPanel(new GridLayout(1,2));
        button_derivate.setPreferredSize(new Dimension(100,50));
        button_integrate.setPreferredSize(new Dimension(100,50));
        panelJOS.add(button_derivate);
        panelJOS.add(button_integrate);

        JPanel butoane = new JPanel(new BorderLayout());
        butoane.add(panelSUS,BorderLayout.NORTH);
        butoane.add(panelMIJLOC,BorderLayout.CENTER);
        butoane.add(panelJOS,BorderLayout.SOUTH);

        JPanel textfielduri = new JPanel(new GridLayout(4,1));
        textfielduri.add(panelPolinom1);
        textfielduri.add(panelPolinom2);
        textfielduri.add(panelPolinom3);
        textfielduri.add(panelPolinom4);
        textfielduri.setBorder(new EmptyBorder(0,0,20,0));

        JPanel content = new JPanel(new BorderLayout());
        content.add(textfielduri,BorderLayout.NORTH);
        content.add(butoane,BorderLayout.SOUTH);
        content.setBorder(new EmptyBorder(20,50,20,50));

        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2,
                dimension.height / 2 - this.getSize().height / 2);

        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    String getPolinom1()
    {
        return tf_polinom1.getText();
    }
    String getPolinom2()
    {
        return tf_polinom2.getText();
    }
    void setRezultat(String rezultat){tf_polinom3.setText(rezultat);}
    void setRest(String rest){tf_polinom4.setText(rest);}
    void addAddListener(ActionListener mal) {
        button_add.addActionListener(mal);
    }
    void addSubstractListener(ActionListener mal){button_substract.addActionListener(mal);}
    void addDerivareListener(ActionListener mal){button_derivate.addActionListener(mal);}
    void addIntegrareListener(ActionListener mal){button_integrate.addActionListener(mal);}
    void addInmultireListener(ActionListener mal){button_multiply.addActionListener(mal);}
    void addImpartireListener(ActionListener mal){button_divide.addActionListener(mal);}
}