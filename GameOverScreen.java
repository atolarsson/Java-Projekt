import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JPanel {

    private JLabel messageLabel;
    private JButton restartButton;
    private JButton exitButton;

    public GameOverScreen() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Message label
        messageLabel = new JLabel("Game Over", SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(messageLabel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.setOpaque(false);

        // Restart button
        restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle restart action
                // For example, restart the game
                // You need to implement the logic to restart the game
            }
        });
        buttonPanel.add(restartButton);

        // Exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle exit action
                // For example, close the game window
                // You need to implement the logic to exit the game
            }
        });
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
