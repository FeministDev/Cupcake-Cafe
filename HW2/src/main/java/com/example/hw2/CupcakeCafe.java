package com.example.hw2;
//Long list of imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;
import java.time.DayOfWeek;
import java.util.Calendar;
public class CupcakeCafe extends Application {

    TextField Cofield = new TextField();

    TextField DSField = new TextField();

    TextField ICField = new TextField();

    TextField MacField = new TextField();

    Button button;

    private Statement stmt;

    public static void main(String[] args) {

        launch(args);

    }

    @Override

    public void start(Stage primaryStage) {

        initializeDB();

        primaryStage.setTitle("Order Screen");

//buttons

        button = new Button();

        button.setText("Place Order");

        button.setTranslateX(-150);

        button.setTranslateY(300);

        button.setScaleX(1.5);

        button.setScaleY(1.5);

        button.setStyle("-fx-border-color: pink;");

//text

        Text title = new Text();

        title.setText("Cupcake Cafe");

        title.setTranslateY(-250);

        title.setFont(Font.font("Segue", FontWeight.BOLD, FontPosture.REGULAR, 35)
        );

        title.setFill(Color.LIGHTPINK.darker()
        );

        Text dailySpecial = new Text();

        dailySpecial.setText("Daily Special $3.00");

//dailySpecial.setTranslateX(0);

        dailySpecial.setTranslateY(-150);

        dailySpecial.setScaleX(1.25);

        dailySpecial.setScaleY(1.25);

        Text IceCream = new Text();

        IceCream.setText("Chirin-Chirin Ice Cream $2.50");

        IceCream.setTranslateX(0);

        IceCream.setTranslateY(-70);

        IceCream.setScaleX(1.25);

        IceCream.setScaleY(1.25);

        Text Macar = new Text();

        Macar.setText("Cute Macarons $1.00");

        Macar.setTranslateX(0);

        Macar.setTranslateY(25);

        Macar.setScaleX(1.25);

        Macar.setScaleY(1.25);

        Text Coffee = new Text();

        Coffee.setText("Marshmallow Coffee <3 $1.00");

        Coffee.setTranslateX(0);

        Coffee.setTranslateY(120);

        Coffee.setScaleX(1.25);

        Coffee.setScaleY(1.25);

//images

//Determine daily special (strawberryCup)

        ImageView strawberryCup = new ImageView();//(new Image("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App ProgramJava\\JavaFX\\HW2\\src\\Images\\strawberryCupcake.jpg"));

        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if (day == 1) {

            strawberryCup = new ImageView("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\Images\\ strawberryCupcake.jpg");

        }

        if (day == 2) {

            strawberryCup = new ImageView("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\Images\\ blueberryCupcake.jpg");

        }

        if (day == 3) {

            strawberryCup = new ImageView("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\Images\\ FlowerCupcake.jpg");

        }

        if (day == 4) {

            strawberryCup = new ImageView("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\Images\\ ChocCupcake.jpg");

        }

        if (day == 5) {

            strawberryCup = new ImageView("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\Images\\ lemonCupcake.jpg");

        }

        if (day == 6) {

            strawberryCup = new ImageView("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\Images\\ CherryCupcake.jpg");

        }

        if (day == 7) {

            strawberryCup = new ImageView("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\Images\\ ReeceCupcake.jpg");

        }

        strawberryCup.setFitHeight(100);

        strawberryCup.setFitWidth(100);

        strawberryCup.setTranslateX(-150);

        strawberryCup.setTranslateY(-150);

        StackPane layout = new StackPane();

//image for Ice cream

        ImageView Icream = new ImageView(new Image("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\Images\\ChirinChirinIceCream.jpg"));

        Icream.setFitHeight(80);

        Icream.setFitWidth(80);

        Icream.setTranslateY(-70);

        Icream.setTranslateX(160);

//image for macarons

        ImageView Macarons = new ImageView(new Image("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\ src\\Images\\Macarons.jpg"));

        Macarons.setFitHeight(80);

        Macarons.setFitWidth(80);

        Macarons.setTranslateY(25);

        Macarons.setTranslateX(160);

//image for coffee

        ImageView Coff = new ImageView(new Image("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\ Images\\MarshmallowCoffee.jpg"));

        Coff.setFitHeight(80);

        Coff.setFitWidth(80);

        Coff.setTranslateY(120);

        Coff.setTranslateX(160);

//cat gif!

        ImageView CatGif = new ImageView(new Image("C:\\Users\\rente\\Documents\\Spring2023_Coursework\\Adv App Program Java\\JavaFX\\HW2\\src\\Images\\Cat2.gif"));

        CatGif.setFitHeight(80);

        CatGif.setFitWidth(80);

        CatGif.setTranslateY(230);

        CatGif.setTranslateX(-150);

//textfields

//TextField DSField = new TextField();

        DSField.prefWidth(100);

        DSField.prefHeight(50);

        DSField.setMinWidth(Region.USE_PREF_SIZE);

        DSField.setMaxWidth(Region.USE_PREF_SIZE);

        DSField.setPrefColumnCount(1);

        DSField.setTranslateY(-150);

        DSField.setTranslateX(150);

//TextField ICField = new TextField();

        ICField.prefHeight(50);

        ICField.prefWidth(100);

        ICField.setMinWidth(Region.USE_PREF_SIZE);

        ICField.setMaxWidth(Region.USE_PREF_SIZE);

        ICField.setPrefColumnCount(1);

        ICField.setTranslateY(-70);

        ICField.setTranslateX(-112);

//TextField MacField = new TextField();

        MacField.prefHeight(50);

        MacField.prefWidth(100);

        MacField.setMinWidth(Region.USE_PREF_SIZE);

        MacField.setMaxWidth(Region.USE_PREF_SIZE);

        MacField.setPrefColumnCount(1);

        MacField.setTranslateY(25);

        MacField.setTranslateX(-112);

// TextField Cofield = new TextField();

        Cofield.prefHeight(50);

        Cofield.prefWidth(100);

        Cofield.setMinWidth(Region.USE_PREF_SIZE);

        Cofield.setMaxWidth(Region.USE_PREF_SIZE);

        Cofield.setPrefColumnCount(1);

        Cofield.setTranslateY(120);

        Cofield.setTranslateX(-112);
/*

EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

public void handle(ActionEvent e) {

button.setText(" Order Placed!
");

double numDS = Double.parseDouble(DSField.getText());

double numIC = Double.parseDouble(ICField.getText());

double numMac = Double.parseDouble(MacField.getText());

double numCof = Double.parseDouble(Cofield.getText());

double total = (numDS * 3) + (numIC * 2.50) + (numMac) + (numCof);

Text Summary = new Text();

Summary.setText((int) numDS + " Daily Special\n" + (int) numIC + " Chirin-Chirin Ice Cream\n" + (int) numMac + " Macarons\n" +
(int) numCof + " Marshmallow Coffee");

Summary.setTranslateX(50);

Summary.setTranslateY(50);

Text Display = new Text();

Display.setText("TOTAL: $" + total);

Display.setTranslateY(100);

Display.setTranslateX(50);

Display.setScaleY(1.25);

Display.setScaleX(1.25);

GridPane gridPane = new GridPane();

gridPane.getChildren().add(Display);

gridPane.getChildren().add(Summary);

Scene scene = new Scene(gridPane, 600, 400);

Stage stage = new Stage();

stage.setTitle("Order Summary");

stage.setScene(scene);

stage.show();

}

};
 */

// when button is pressed

//button.setOnAction(event);

        button.setOnAction(e -> placeOrder()
        );

//calling text and buttons

        layout.getChildren()
                .add(button);

        layout.getChildren()
                .add(title);

        layout.getChildren()
                .add(dailySpecial);

        layout.getChildren()
                .add(strawberryCup);

        layout.getChildren()
                .add(DSField);

        layout.getChildren()
                .add(ICField);

        layout.getChildren()
                .add(IceCream);

        layout.getChildren()
                .add(Icream);

        layout.getChildren()
                .add(MacField);

        layout.getChildren()
                .add(Macar);

        layout.getChildren()
                .add(Macarons);

        layout.getChildren()
                .add(Cofield);

        layout.getChildren()
                .add(Coffee);

        layout.getChildren()
                .add(Coff);

        layout.getChildren()
                .add(CatGif);

        layout.setStyle("-fx-background-color: transparent;");

        Scene scene = new Scene(layout, 500, 650, Color.valueOf("FFD9E5")
        );

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private void initializeDB() {

        try {

// Load the JDBC driver

            Class.forName("com.mysql.cj.jdbc.Driver");

//Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("Driver loaded");

// Establish a connection

            Connection connection = DriverManager.getConnection

                    ("jdbc:mysql://localhost/restaurant", "root", "root");

//("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",

//"scott", "tiger");

            System.out.println("Database connected");

// Create a statement

            stmt = connection.createStatement();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    private void placeOrder() {

        try {

            int DsQty = Integer.parseInt(DSField.getText()
            );

            int IcQty = Integer.parseInt(ICField.getText()
            );

            int MacQty= Integer.parseInt(MacField.getText()
            );

            int CofQty = Integer.parseInt(Cofield.getText()
            );

            int id = 0;

            stmt.executeUpdate("INSERT INTO orders (id, item1_qty, item2_qty, item3_qty, item4_qty ) "

                    +"VALUES ("+ id + "," + DsQty + ", " + IcQty + ", " + MacQty + ","+ CofQty +")");

            button.setText(" Order Placed!");

            double numDS = Double.parseDouble(DSField.getText()
            );

            double numIC = Double.parseDouble(ICField.getText()
            );

            double numMac = Double.parseDouble(MacField.getText()
            );

            double numCof = Double.parseDouble(Cofield.getText()
            );

            double total = (numDS * 3) + (numIC * 2.50) + (numMac) + (numCof);

            Text Summary = new Text();

            Summary.setText(
                    (int) numDS + " Daily Special\n" + (int) numIC + " Chirin-Chirin Ice Cream\n" + (int) numMac + " Macarons\n" + (int
                            ) numCof + " Marshmallow Coffee");

            Summary.setTranslateX(50);

            Summary.setTranslateY(50);

            Text Display = new Text();

            Display.setText("TOTAL: $" + total);

            Display.setTranslateY(100);

            Display.setTranslateX(50);

            Display.setScaleY(1.25);

            Display.setScaleX(1.25);

            GridPane gridPane = new GridPane();

            gridPane.getChildren()
                    .add(Display);

            gridPane.getChildren()
                    .add(Summary);

            Scene scene = new Scene(gridPane, 600, 400);

            Stage stage = new Stage();

            stage.setTitle("Order Summary");

            stage.setScene(scene);

            stage.show();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @Override

    public void stop() throws Exception {

        super.stop();

// Close the database connection

        try {

            if (stmt != null) {

                stmt.close();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
}

