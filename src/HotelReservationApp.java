import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;

public class HotelReservationApp {

    String appName;

    HotelReservationApp(String name){
        appName = name;
        startApp();
    }

    void startApp (){

        // Create Frame, size, layout, widows closer
        JFrame appFrame = new JFrame(appName + " Hotel Reservation APP");
        appFrame.setSize(500, 800);
        appFrame.setLayout(new GridLayout(5, 1));
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Hotel Arrays
        String[] hotels = {"Fraser Suites", "Nordic Hotel", "Transcorp Hilton", "Sheraton Hotel", "The Envoy Hotel"};

        // Create buttons and add them to frame using for loop
        for (int i = 0; i < hotels.length; i++) {
            JButton hotelButton = new JButton(hotels[i]);
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

        appFrame.setVisible(true);
    }

    void bedCountPage(String hotelName){
        // Create Frame, size, layout, widows closer
        JFrame appFrame = new JFrame(appName + " Hotel Reservation APP");
        appFrame.setSize(500, 800);

        for (int i = 1; i < 6; i++) {
            JButton bedCountButton = new JButton(""+i);
            appFrame.add(bedCountButton);

            bedCountButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String message = "You reserved " + bedCountButton.getText() + " room(s) at " + hotelName;

                    try {
                        FileWriter file = new FileWriter("hotel reservation.txt");
                        file.write(message); // write to file
                        file.close();
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }

                    appFrame.setVisible(false);
                }
            });
        }

        appFrame.setLayout(new GridLayout(3, 2));
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }
}
