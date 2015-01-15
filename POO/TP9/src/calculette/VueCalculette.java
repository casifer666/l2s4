package calculette;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

/**
 * Permet de visualiser à l'écran tout objet implémentant l'interface
 * Calculette.
 * 
 * @see calculette.Calculette
 */
public class VueCalculette {

    private Calculette calc; // l'objet calculette associe
    private TextField text; // ecran de la vue calculette

    /**
     * Crée une nouvelle VueCalculette en lui associant une Calculette
     * 
     * @param c
     *            une calculette
     */
    public VueCalculette(Calculette c) {
        this.calc = c;
    }

    /** Affiche à l'écran cette VueCalculette */
    public void lancer(String s) {

        GridLayout g14 = new GridLayout(1, 4);
        GridLayout g41 = new GridLayout(4, 1);

        // le panel centre va contenir les colonnes de chiffres et le panel droit
        Panel centre = new Panel();
        centre.setLayout(g14);
        // ce dernier contenant les touches + et =
        Panel droit = new Panel();
        droit.setLayout(new GridLayout(2, 1));
        // le panel compose reunit les panels centre et haut
        Panel compose = new Panel();
        compose.setLayout(new BorderLayout());
        // ce dernier contenant les touches Raz, / , * et -
        Panel haut = new Panel();
        haut.setLayout(g14);

        // 1ere colonne de chiffres : 7 , 4 , 1 et 0
        Panel chiffres = new Panel();
        chiffres.setLayout(g41);
        chiffres.add(new BoutonCalculette(" 7 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(7);
            }
        }));
        chiffres.add(new BoutonCalculette(" 4 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(4);
            }
        }));
        chiffres.add(new BoutonCalculette(" 1 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(1);
            }
        }));
        chiffres.add(new BoutonCalculette(" 0 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(0);
            }
        }));
        centre.add(chiffres);
        // 2eme colonne de chiffres : 8 , 5 et 2
        chiffres = new Panel();
        chiffres.setLayout(g41);
        chiffres.add(new BoutonCalculette(" 8 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(8);
            }
        }));
        chiffres.add(new BoutonCalculette(" 5 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(5);
            }
        }));
        chiffres.add(new BoutonCalculette(" 2 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(2);
            }
        }));
        centre.add(chiffres);
        // 3eme colonne de chiffres : 9 , 6 et 3 plus la touche Del
        chiffres = new Panel();
        chiffres.setLayout(g41);
        chiffres.add(new BoutonCalculette(" 9 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(9);
            }
        }));
        chiffres.add(new BoutonCalculette(" 6 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(6);
            }
        }));
        chiffres.add(new BoutonCalculette(" 3 ", new Action() {
            protected void process() {
                calc.enfoncerChiffre(3);
            }
        }));
        chiffres.add(new BoutonCalculette("Del", new Action() {
            protected void process() {
                calc.enfoncerDel();
            }
        }));
        centre.add(chiffres);

        // les "grandes" touches + et =
        droit.add(new BoutonCalculette(" + ", new Action() {
            protected void process() {
                calc.enfoncerPlus();
            }
        }));
        droit.add(new BoutonCalculette(" = ", new Action() {
            protected void process() {
                calc.enfoncerEgal();
            }
        }));
        centre.add(droit);

        // les touches du haut Raz, / * et -
        haut.add(new BoutonCalculette("CC ", new Action() {
            protected void process() {
                calc.enfoncerRaz();
            }
        }));
        haut.add(new BoutonCalculette(" / ", new Action() {
            protected void process() {
                calc.enfoncerDiv();
            }
        }));
        haut.add(new BoutonCalculette(" x ", new Action() {
            protected void process() {
                calc.enfoncerMult();
            }
        }));
        haut.add(new BoutonCalculette(" - ", new Action() {
            protected void process() {
                calc.enfoncerMoins();
            }
        }));

        // organisation finale dans compose
        compose.add(BorderLayout.NORTH, haut);
        compose.add(BorderLayout.CENTER, centre);

        text = new TextField(Integer.toString(calc.getValeurCourante()));
        text.setEditable(false);

        Frame f = new Frame(s);
        f.addWindowListener(new Quitteur());
        f.add(BorderLayout.NORTH, text);
        f.add(BorderLayout.CENTER, compose);
        f.pack();
        f.setLocation(50, 50);
        f.setVisible(true);
    }

    // toute action sur la vue doit mettre a jour l'affichage
    // de la valeur
    abstract private class Action implements ActionListener {
        abstract protected void process();

        public void actionPerformed(ActionEvent e) {
            process();
            text.setText(Integer.toString(calc.getValeurCourante()));
        }
    }

    private class Quitteur extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    // (factorisation de code)
    private class BoutonCalculette extends Button {
        BoutonCalculette(String nom, ActionListener action) {
            super(nom);
            addActionListener(action);
        }
    }
}
