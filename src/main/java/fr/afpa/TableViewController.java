package fr.afpa;

import fr.afpa.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TableViewController {

    @FXML 
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person,String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private TableColumn<Person,String> cityColumn;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField cityField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ObservableList<Person> persons = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        persons.add(new Person("Josh", "Homme", "Joshua Tree"));
        persons.add(new Person("Dave", "Grohl", "Warren"));
        persons.add(new Person("Robert", "Trujillo", "Santa Monica"));

        tableView.setItems(persons);

        //Affichage des cellules de chaque colonne
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstName());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastName());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().getCity());
    }

    //Gestionnaire d'événement
  
    //Methode pour sauvegarder les nouvelles données dans le modéle
    @FXML 
    private void save(ActionEvent event) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String city = cityField.getText();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !city.isEmpty()) {
            Person person = new Person(firstName, lastName, city);
            persons.add(person);
            firstNameField.clear();
            lastNameField.clear();
            cityField.clear();
            
        } else {
            System.out.println("Merci de compléter tous les champs");
        }

    }

    @FXML
    private void cancel(ActionEvent event) {
        firstNameField.clear();
        lastNameField.clear();
        cityField.clear();

    }

    @FXML
    private void delete(ActionEvent event) {
        Person selectedPerson = tableView.getSelectionModel().getSelectedItem();

        if (selectedPerson != null){
            persons.remove(selectedPerson);
            
        } else {
            System.out.println("Veuillez selectionner une personne à supprimer");
        }


    }

        


}