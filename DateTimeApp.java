import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;

public class DateTimeApp {
    public static void main(String[] args) {
        JFrame f = new JFrame("Date Time Demo");
        JLabel label = new JLabel("Click the button to show date & time");
        JButton button = new JButton("Show Date & Time");

        label.setBounds(40, 50, 300, 30);
        button.setBounds(80, 100, 180, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText(LocalDateTime.now().toString());
            }
        });

        f.add(label);
        f.add(button);
        f.setSize(350, 200);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}