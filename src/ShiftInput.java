import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/*
This code allows to create an extra window for the input of desired shift in Caesar cipher
 */
public class ShiftInput implements ActionListener {
    JButton submit;
    int shift;
    JFrame frame;
    JTextField shiftInput;
    JPanel winTitle;
    JLabel text;
    public ShiftInput() {


        frame = new JFrame();
        //set up the frame for the menu
        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        frame.setLayout(layout);
        frame.setSize(530, 600);
        frame.setTitle("Encryption Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);


        winTitle = new JPanel();
        winTitle.setBackground(new Color(15, 255, 80));
        winTitle.setPreferredSize(new Dimension(540, 50));
        winTitle.setBounds(0, 0, 256, 256);
        frame.add(winTitle, BorderLayout.NORTH);
        JLabel empty = new JLabel("");
        empty.setPreferredSize(new Dimension(540, 50));
        frame.add(empty);
        //create a winTitle label

        JLabel winLabel = new JLabel("Caesar Cipher");
        winLabel.setFont(new Font("Franchise", Font.BOLD, 40));
        winTitle.add(winLabel);
        text = new JLabel("Input the shift:");
        text.setFont(new Font("Arial", Font.BOLD, 14));
        text.setForeground(new Color(15, 255, 80));

        frame.add(text);
        shiftInput = new JTextField();
        shiftInput.setSelectedTextColor(Color.black);
        shiftInput.setCaretColor(Color.white);
        shiftInput.setSelectionColor(new Color(15, 255, 80));
        frame.add(shiftInput);
        shiftInput.setFont(new Font("Arial", Font.BOLD, 14));
        shiftInput.setPreferredSize(new Dimension(256, 50));
        shiftInput.setBackground(Color.black);
        shiftInput.setForeground(new Color(15, 255, 80));
        shiftInput.setBorder(null);
        shiftInput.setHorizontalAlignment(SwingConstants.CENTER);

        submit = new JButton("Encrypt");
        submit.setPreferredSize(new Dimension(120, 50));
        submit.addActionListener(this);
        submit.setBackground(new Color(15, 255, 80));
        submit.setFont(new Font("American Captain", Font.PLAIN, 15));
        frame.add(submit);
        frame.setVisible(true);
        shiftInput.requestFocus();
        shiftInput.selectAll();
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==submit){
            frame.dispose();
            String a = "0123456789";
            if (shiftInput.getText().isEmpty()){
                System.err.println("Error: Invalid input. Please try again");
                System.exit(1);
            }
            for (int i=0; i<shiftInput.getText().length();i++) {
                    if (a.indexOf(shiftInput.getText().charAt(i))==-1){
                        System.err.println("Error: Invalid input. Please try again");
                        System.exit(1);
                    }
            }
            shift=Integer.parseInt(shiftInput.getText());



            StdDraw.frame.setVisible(true);

            //add delay for the animation
            java.util.Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    StdDraw.frame.dispose();
                    StdDraw.frame.setVisible(false);

                    JFrame window = new JFrame();
                    //set up the frame for the menu
                    window = new JFrame();
                    FlowLayout layout = new FlowLayout();
                    layout.setVgap(0);
                    layout.setHgap(0);
                    window.setLayout(layout);
                    window.setSize(530, 600);
                    window.setTitle("Encryption Program");
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setResizable(false);
                    window.getContentPane().setBackground(Color.black);


                    JPanel winTitle = new JPanel();
                    winTitle.setBackground(new Color(15, 255, 80));
                    winTitle.setPreferredSize(new Dimension(540, 50));
                    winTitle.setBounds(0, 0, 256, 256);
                    window.add(winTitle, BorderLayout.NORTH);

                    //create a winTitle label

                    JLabel winLabel = new JLabel("Caesar Cipher");
                    winLabel.setFont(new Font("Franchise", Font.BOLD, 40));
                    winTitle.add(winLabel);
                    Caesar a = new Caesar(GUI.textbox.getText());

                    JLabel empty = new JLabel("");
                    empty.setPreferredSize(new Dimension(540, 50));
                    window.add(empty);
                    //output result

                    JLabel ciphertext = new JLabel("The ciphertext is:  " + a.encrypt(shift));
                    ciphertext.setForeground(new Color(15, 255, 80));
                    ciphertext.setFont(new Font("Arial", Font.BOLD, 14));
                    JLabel plaintext = new JLabel("The message was:  " + a.decrypt());
                    plaintext.setPreferredSize(new Dimension(540, 50));
                    plaintext.setHorizontalAlignment(SwingConstants.CENTER);
                    plaintext.setForeground(new Color(15, 255, 80));
                    plaintext.setFont(new Font("Arial", Font.BOLD, 14));
                    window.add(plaintext);
                    window.add(ciphertext);
                    JLabel image = new JLabel("");
                    ImageIcon icon = new ImageIcon("security.png");
                    image.setIcon(icon);
                    image.setPreferredSize(new Dimension(200, 200));
                    JPanel imagePanel = new JPanel();
                    imagePanel.setPreferredSize(new Dimension(512, 400));
                    imagePanel.setBackground(Color.black);

                    image.setHorizontalAlignment(SwingConstants.CENTER);
                    imagePanel.add(image);
                    window.add(imagePanel, BorderLayout.SOUTH);


                    window.setVisible(true);

                }
            };
            long delay = 3000L;
            timer.schedule(task, delay);

        }
    }
}
