

import com.sun.security.auth.module.JndiLoginModule;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

/*
This code creates a user interface that connects all the pieces of the program together
 */
public class GUI implements ActionListener {

    JButton rsa;
    JButton sub;
    JButton caesar;
    ImageIcon image;
    JLabel text0;
    JLabel text1;
    JLabel text2;
    JLabel text3;
    JPanel title;
    JFrame frame;
    JPanel textPanel;
    public static JTextField textbox;
    JLabel titleLabel;
    JPanel buttonPanel;
    JLabel icon;



    public GUI(){


        //set up the frame for the menu
        frame = new JFrame();
        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        frame.setLayout(layout);
        frame.setSize(530,600);
        StdDraw.frame.setVisible(true);
        frame.setTitle("Encryption Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);


        //create text for the first page
        text0 = new JLabel("");
        text1 = new JLabel("Welcome. This is an Encryption program.");
        text2 = new JLabel("It uses three different ciphers to encrypt your message");
        text3 = new JLabel("Type the message below and select what cipher you want to use");


        //add a title
        title =new JPanel();
        title.setBackground(new Color(15,255,80));
        title.setPreferredSize(new Dimension(540, 50));
        title.setBounds(0,0,256,256);
        frame.add(title, BorderLayout.NORTH);

        //create a title label
        titleLabel = new JLabel("Cryptography Program");
        titleLabel.setFont(new Font("Franchise", Font.BOLD, 40));
        title.add(titleLabel);

        //create new panel in the middle to hold the text
        textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());
        textPanel.setBackground(Color.black);
        textPanel.setPreferredSize(new Dimension(512, 400));
        //add text to the panel
        text0.setPreferredSize(new Dimension(512,50));
        textPanel.add(text0);
        textPanel.add(text1);
        textPanel.add(text2);
        textPanel.add(text3);






        //add them to the menu
        frame.add(textPanel, BorderLayout.CENTER);



        //set the color and font
        text1.setForeground(new Color(15,255,80));
        text2.setForeground(new Color(15,255,80));
        text3.setForeground(new Color(15,255,80));
        text1.setFont(new Font("Arial", Font.BOLD, 14));
        text2.setFont(new Font("Arial", Font.BOLD, 14));
        text3.setFont(new Font("Arial", Font.BOLD, 14));



        //add buttons
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(512, 400));
        buttonPanel.setBackground(Color.black);

        rsa = new JButton("RSA");
        rsa.setPreferredSize(new Dimension(120,50));
        rsa.addActionListener(this);
        rsa.setBackground(new Color(15,255,80));
        rsa.setFont(new Font("American Captain", Font.PLAIN, 15));
        caesar = new JButton("Caesar");
        caesar.setPreferredSize(new Dimension(120,50));
        caesar.addActionListener(this);
        caesar.setBackground(new Color(15,255,80));
        caesar.setFont(new Font("American Captain", Font.PLAIN, 15));
        sub = new JButton("Substitution");
        sub.setPreferredSize(new Dimension(120,50));
        sub.addActionListener(this);
        sub.setBackground(new Color(15,255,80));
        sub.setFont(new Font("American Captain", Font.PLAIN, 15));
        buttonPanel.add(rsa);
        buttonPanel.add(caesar);
        buttonPanel.add(sub);

        //make a textbox to enter the message to be encrypted
        textbox = new JTextField("Type your message here:");
        textbox.setFont(new Font("Arial", Font.BOLD, 14));
        textbox.setPreferredSize(new Dimension(256, 50));
        textbox.setBackground(Color.black);
        textbox.setForeground(new Color(15,255,80));
        textbox.setBorder(null);
        buttonPanel.add(textbox);
        textbox.setHorizontalAlignment(SwingConstants.CENTER);


        //add an icon
        image = new ImageIcon("./assets/binary-code.png");
        icon = new JLabel("");
        icon.setPreferredSize(new Dimension(300,150));
        icon.setIcon(image);
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(icon);
        textPanel.add(buttonPanel, BorderLayout.SOUTH);






        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        textbox.setSelectedTextColor(Color.black);
        textbox.setCaretColor(Color.white);
        textbox.setSelectionColor(new Color(15,255,80));
        textbox.requestFocus();
        textbox.selectAll();
        Animation.runAnimation();




    }




    public void actionPerformed(ActionEvent e){


        if (e.getSource()==rsa){

            frame.dispose();
            StdDraw.frame.setVisible(true);
            //add delay for the animation
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {

                    StdDraw.frame.dispose();
                    JFrame window=new JFrame();
                    //set up the frame for the menu
                    window = new JFrame();
                    FlowLayout layout = new FlowLayout();
                    layout.setVgap(0);
                    layout.setHgap(0);
                    window.setLayout(layout);
                    window.setSize(530,600);
                    window.setTitle("Encryption Program");
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setResizable(false);
                    window.getContentPane().setBackground(Color.black);


                    JPanel winTitle = new JPanel();
                    winTitle.setBackground(new Color(15,255,80));
                    winTitle.setPreferredSize(new Dimension(540, 50));
                    winTitle.setBounds(0,0,256,256);
                    window.add(winTitle, BorderLayout.NORTH);

                    //create a winTitle label

                    JLabel winLabel = new JLabel("RSA Cipher");
                    winLabel.setFont(new Font("Franchise", Font.BOLD, 40));
                    winTitle.add(winLabel);

                    RSA a = new RSA(textbox.getText());
                    a.encrypt();

                    JLabel empty = new JLabel("");
                    empty.setPreferredSize(new Dimension(540,50));
                    window.add(empty);
                    //output result
                    JLabel plaintext = new JLabel("The message was:  " + a.decrypt());
                    plaintext.setPreferredSize(new Dimension(540, 50));
                    plaintext.setHorizontalAlignment(SwingConstants.CENTER);
                    plaintext.setForeground(new Color(15,255,80));
                    plaintext.setFont(new Font("Arial", Font.BOLD, 14));
                    window.add(plaintext);
                    JLabel ciphertext = new JLabel("The ciphertext is:  " + a.encrypt());
                    ciphertext.setForeground(new Color(15,255,80));
                    ciphertext.setFont(new Font("Arial", Font.BOLD, 14));
                    window.add(ciphertext);
                    JLabel key = new JLabel(a.publicKeytoString());
                    key.setPreferredSize(new Dimension(540, 50));
                    key.setHorizontalAlignment(SwingConstants.CENTER);
                    key.setForeground(new Color(15,255,80));
                    key.setFont(new Font("Arial", Font.BOLD, 14));
                    window.add(key);
                    JLabel image = new JLabel("");
                    ImageIcon icon = new ImageIcon("./assets/security.png");
                    image.setIcon(icon);
                    image.setPreferredSize(new Dimension(200,200));
                    JPanel imagePanel = new JPanel();
                    imagePanel.setPreferredSize(new Dimension(512, 400));
                    imagePanel.setBackground(Color.black);

                    image.setHorizontalAlignment(SwingConstants.CENTER);
                    imagePanel.add(image);
                    window.add(imagePanel, BorderLayout.SOUTH);


                    window.setVisible(true);
                }
            };
            long delay=3000L;
            timer.schedule(task,delay);

            RSA plaintext = new RSA(textbox.getText());
            String ciphertext= plaintext.encrypt();


            StdDraw.setPenColor(15,255,80);
            StdDraw.text(30,30,"The encrypted message is: " +ciphertext);
            StdDraw.text(30, 33, plaintext.toString());



        } else if (e.getSource()==caesar) {
            //use another class to make a new window to input shift value
            frame.dispose();
            new ShiftInput();




        } else if (e.getSource()==sub) {
            frame.dispose();
            StdDraw.frame.setVisible(true);

            //add delay for the animation
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    StdDraw.frame.dispose();

                    JFrame window=new JFrame();
                    //set up the frame for the menu
                    window = new JFrame();
                    FlowLayout layout = new FlowLayout();
                    layout.setVgap(0);
                    layout.setHgap(0);
                    window.setLayout(layout);
                    window.setSize(530,600);
                    window.setTitle("Encryption Program");
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setResizable(false);
                    window.getContentPane().setBackground(Color.black);


                    JPanel winTitle = new JPanel();
                    winTitle.setBackground(new Color(15,255,80));
                    winTitle.setPreferredSize(new Dimension(540, 50));
                    winTitle.setBounds(0,0,256,256);
                    window.add(winTitle, BorderLayout.NORTH);

                    //create a winTitle label

                    JLabel winLabel = new JLabel("Substitution Cipher");
                    winLabel.setFont(new Font("Franchise", Font.BOLD, 40));
                    winTitle.add(winLabel);
                    Substitution a = new Substitution(textbox.getText());
                    a.encrypt();

                    JLabel empty = new JLabel("");
                    empty.setPreferredSize(new Dimension(540,50));
                    window.add(empty);
                    //output result
                    JLabel plaintext = new JLabel("The message was:  " + a.decrypt());
                    plaintext.setPreferredSize(new Dimension(540, 50));
                    plaintext.setHorizontalAlignment(SwingConstants.CENTER);
                    plaintext.setForeground(new Color(15,255,80));
                    plaintext.setFont(new Font("Arial", Font.BOLD, 14));
                    window.add(plaintext);
                    JLabel ciphertext = new JLabel("The ciphertext is:  " + a.encrypt());
                    ciphertext.setForeground(new Color(15,255,80));
                    ciphertext.setFont(new Font("Arial", Font.BOLD, 14));
                    window.add(ciphertext);
                    JLabel image = new JLabel("");
                    ImageIcon icon = new ImageIcon("./assets/security.png");
                    image.setIcon(icon);
                    image.setPreferredSize(new Dimension(200,200));
                    JPanel imagePanel = new JPanel();
                    imagePanel.setPreferredSize(new Dimension(512, 400));
                    imagePanel.setBackground(Color.black);

                    image.setHorizontalAlignment(SwingConstants.CENTER);
                    imagePanel.add(image);
                    window.add(imagePanel, BorderLayout.SOUTH);


                    window.setVisible(true);



                }
            };
            long delay=3000L;
            timer.schedule(task,delay);



        }
    }



}
