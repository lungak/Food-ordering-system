import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class FoodOrderingSystem_4253243 {
    private static final String USER_INFO_FILE = "C:\\Users\\User\\IdeaProjects\\Sprint 3\\SelfMadeGUI\\src\\user_info";

    public static void main(String[] args) {
        // Create a main panel to hold both login and signup panels
        JPanel mainPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Login panel
        JPanel login = new JPanel(new GridLayout(5, 5));
        JTextField email = new JTextField(1);
        JPasswordField password = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Not yet registered?");
        login.add(new JLabel("Email Address"));
        login.add(email);
        login.add(new JLabel("Password"));
        login.add(password);
        login.add(new JLabel(""));
        login.add(loginButton);
        login.add(registerButton);

        // Signup panel
        JPanel signup = new JPanel(new GridLayout(6, 2));
        JTextField title = new JTextField(15);
        JTextField firstName = new JTextField(15);
        JTextField lastName = new JTextField(15);
        JTextField email2 = new JTextField(15);
        JPasswordField password2 = new JPasswordField(15);
        JButton signupButton = new JButton("Signup");
        signup.add(new JLabel("Title"));
        signup.add(title);
        signup.add(new JLabel("First Name"));
        signup.add(firstName);
        signup.add(new JLabel("Last Name"));
        signup.add(lastName);
        signup.add(new JLabel("Email Address"));
        signup.add(email2);
        signup.add(new JLabel("Password"));
        signup.add(password2);
        signup.add(new JLabel(""));
        signup.add(signupButton);

        // Add login and signup panels to the main panel
        mainPanel.add(login, "LOGIN");
        mainPanel.add(signup, "SIGNUP");

        // Basic setup of the JFrame
        JFrame myframe = new JFrame();
        myframe.setTitle("Food Ordering System");
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setResizable(false);
        myframe.setSize(500, 500);
        myframe.setVisible(true);
        myframe.add(mainPanel);

        // Designing of frame
        myframe.getContentPane().setBackground(Color.WHITE);

        // Register Button Click Handling
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the signup panel when the register button is clicked
                cardLayout.show(mainPanel, "SIGNUP");
            }
        });

        // Login Click Handling
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailAdd = email.getText();
                char[] passwordAdd = password.getPassword();
                // Implement login logic here
            }
        });

        // Sign up click handling
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleAdd = title.getText();
                String firstname = firstName.getText();
                String lastname = lastName.getText();
                String email2Add = email2.getText();
                char[] password2Add = password2.getPassword();
                // Implement signup logic here
                storeUserInfo(titleAdd, firstname, lastname, email2Add, Arrays.toString(password2Add));
            }
        });
    }
        //This nethod will store the user info in a file with the variable named USER_INFO_FILE which was initialised in the begining
    private static void storeUserInfo(String titleAdd, String firstname, String lastname, String email2Add, String passwordAdd) {
        String userinfo = titleAdd + "," + firstname + "," + lastname + "," + email2Add + "," + passwordAdd + "\n";

        //This will write the user info in a file named user_info
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_INFO_FILE, true))) {
            writer.write(userinfo);

            //Catch any possible errors
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
