package windows;

import javax.swing.*;

public class SimpleWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(500, 500);

        JButton button = new JButton("Click Me");
        frame.add(button);
        button.addActionListener(e -> {
            System.out.println("Clicked ");
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
