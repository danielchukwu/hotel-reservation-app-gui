import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;

public class HotelReservationApp {

    String appName;

    String user_name;
    String user_phone_number;
    String user_payment_type;

    HotelReservationApp(String name){  // Constructor
        appName = name;
        startApp();

    }

    void startApp() {
        // Create Frame, size
        JFrame appFrame = new JFrame(appName + " Hotel Reservation APP");
        appFrame.setSize(500, 800);

        // create labels
        JLabel nameLabel = new JLabel("Enter Name: ");
        JLabel phone_numberLabel = new JLabel("Enter Phone Number: ");
        JLabel payment_typeLabel = new JLabel("Enter Payment Type: ");

        // create text fields
        JTextField name = new JTextField();
        JTextField phone_number = new JTextField();
        JTextField payment_type = new JTextField();

        // Add labels and buttons to frame
        appFrame.add(nameLabel);
        appFrame.add(name);
        appFrame.add(phone_numberLabel);
        appFrame.add(phone_number);
        appFrame.add(payment_typeLabel);
        appFrame.add(payment_type);

        // create and add button
        JButton sumbit = new JButton("Submit");
        appFrame.add(sumbit);

        // add action listener on submit button
        sumbit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appFrame.setVisible(false);

                user_name = name.getText();
                user_phone_number = phone_number.getText();
                user_payment_type = payment_type.getText();

                pickHotel();
            }
        });

        // Set layout, default close operation and visibility
        appFrame.setLayout(new GridLayout(4, 2));
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }

    void pickHotel (){

        // Create Frame, size
        JFrame appFrame = new JFrame(appName + " Hotel Reservation APP");
        appFrame.setSize(500, 800);

        // Hotel Arrays
        String[] hotels = {"Fraser Suites", "Nordic Hotel", "Transcorp Hilton", "Sheraton Hotel", "The Envoy Hotel"};
                       //        0                 1                  2                 3                 4

        // Create buttons and add them to frame using for loop
        for (int i = 0; i < hotels.length; i++) {
            JButton hotelButton = new JButton(hotels[i]); // hotels[0] = Fraser Suites
            System.out.println(hotels[i]);
            appFrame.add(hotelButton);

            hotelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String hotelName = hotelButton.getText();
                    appFrame.setVisible(false);

                    // open next page
                    bedCountPage(hotelName);
                }
            });
        }

        // Set layout, default close operation and visibility
        appFrame.setLayout(new GridLayout(5, 1));
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }

    void bedCountPage(String hotelName){
        // Create Frame, size,
        JFrame appFrame = new JFrame(appName + " Hotel Reservation APP");
        appFrame.setSize(500, 800);

        String[] roomTypes = {"single room", "suite", "presidential suite"};

        for (int i = 0; i < roomTypes.length; i++) {
            JButton roomButton = new JButton(roomTypes[i]);
            appFrame.add(roomButton);

            roomButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String userInfoMessage = "Name: " + user_name + "\nPhone Number: " + user_phone_number + " \nPayment Type: " + user_payment_type + "\n\n";
                    String message = "You reserved " + roomButton.getText() + " room(s) at " + hotelName;
                    try {
                        FileWriter file = new FileWriter("hotel reservation.txt");
                        file.append(userInfoMessage); // write to file
                        file.append(message); // write to file
                        file.close();
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }

                    appFrame.setVisible(false);
                }
            });
        }

        // Set layout, default close operation and visibility
        appFrame.setLayout(new GridLayout(3, 2));
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }
}
