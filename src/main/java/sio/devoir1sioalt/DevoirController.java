package sio.devoir1sioalt;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ResourceBundle;

public class DevoirController implements Initializable {

    @FXML
    private Button btnExo1;
    @FXML
    private AnchorPane apExo1;
    @FXML
    private AnchorPane apExo2;
    @FXML
    private AnchorPane apExo3;
    @FXML
    private Button btnExo2;
    @FXML
    private Slider sldNbLignes;
    @FXML
    private TextArea txtTriangle;
    @FXML
    private Button btnExo3;
    @FXML
    private Button btnDessiner;
    @FXML
    private TextField txtNbJours;
    @FXML
    private TextField txtNbEleves;
    @FXML
    private TextField txtCoutGlobal;
    @FXML
    private Button btnCalculer;
    @FXML
    private Button btnJouer;
    @FXML
    private TextArea txtResultatsTirages;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        apExo1.toFront();
    }

    @FXML
    public void btnExosMenuClicked(Event event)
    {
        if(event.getSource() == btnExo1)
        {
            apExo1.toFront();
        }
        else if(event.getSource() == btnExo2)
        {
            apExo2.toFront();
        }
        else
        {
            apExo3.toFront();;
        }
    }

    // Exercice n°1
    @FXML
    public void btnCalculerClicked(Event event)
    {
        // A vous de jouer
        if (txtNbEleves.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("");
            alert.setContentText("Veuillez saisir le nombre d'élève");
            alert.showAndWait();
        } else if (txtNbJours.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("");
            alert.setContentText("Veuillez saisir le nombre de jour");
            alert.showAndWait();
        }
        else {
            int nbEleve = Integer.parseInt(txtNbEleves.getText());
            int jour = Integer.parseInt(txtNbJours.getText());
            double prix=0;

            prix+=3.50*jour;
            prix+=3.50*nbEleve;

            if (nbEleve<=25){
                prix+=nbEleve*67.30;
            }
            else {
                prix += nbEleve*61;
            }

            if (nbEleve<=30){
                prix+=4.75*jour;
                prix+=4.75*nbEleve;
            } else if (nbEleve>31 && nbEleve<35) {
                prix+=4*jour;
                prix+=4*nbEleve;
            }
            else if (nbEleve>35){
                prix+=3.50*jour;
                prix+=3.50*nbEleve;
            }

            txtCoutGlobal.setText(prix+" €");
        }
    }

    // Exercice n°2
    @FXML
    public void btnDessinerClicked(Event event)
    {
        // A vous de jouer
        txtTriangle.setText("");
        for (int i = 1; i<=sldNbLignes.getValue();i++){
            for (int j = 1; j<+sldNbLignes.getValue()-i;j++){
                txtTriangle.setText(txtTriangle.getText()+"1 ");
            }
            txtTriangle.setText(txtTriangle.getText()+"\n");
        }
    }

    // Exercice n°3
    @FXML
    public void btnJouerClicked(Event event)
    {
        // A vous de jouer
        txtResultatsTirages.setText("");
        int nbPtsJoueur=0;
        int nbPtsOrdi=0;

        while (nbPtsJoueur<=30 && nbPtsOrdi<=30) {
            int de1J = (int) (1 + Math.random() * 6);
            int de2J = (int) (1 + Math.random() * 6);
            int de1O = (int) (1 + Math.random() * 6);
            int de2O = (int) (1 + Math.random() * 6);

            if (de1J == 6 && de1J == de2J) {
                nbPtsJoueur += 25;
            } else if (de1J == 3 && de1J == de2J) {
                nbPtsJoueur = 0;
            } else if (de1J == de2J) {
                nbPtsJoueur += 5;
            }

            if (de1O == 6 && de1O == de2O) {
                nbPtsOrdi += 25;
            } else if (de1O == 3 && de1O == de2O) {
                nbPtsOrdi = 0;
            } else if (de1O == de2O) {
                nbPtsOrdi += 5;
            }
            txtResultatsTirages.appendText("nbJoueur 1 = " + de1J + " nbJoueur 2 =" + de2J + " points joueur = " + nbPtsJoueur + "\nnbOrdi 1 =" + de1O + " nbOrdi 2 =" + de2O + " points ordi = " + nbPtsOrdi + "\n");
            if (nbPtsJoueur > nbPtsOrdi) {
                txtResultatsTirages.appendText("\n\nJoueur a gagné");
            } else if (nbPtsOrdi > nbPtsJoueur) {
                txtResultatsTirages.appendText("\n\nL'ordi a gagné");
            }
        }
    }
    }