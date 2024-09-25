import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Circulo extends JFrame {
    private JTextField radioField;
    private JTextField xField;
    private JTextField yField;

    public Circulo() {
        setTitle("Dibujar Círculo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel radioLabel = new JLabel("Radio:");
        panel.add(radioLabel);

        radioField = new JTextField();
        panel.add(radioField);

        JLabel xLabel = new JLabel("Coordenada X:");
        panel.add(xLabel);

        xField = new JTextField();
        panel.add(xField);

        JLabel yLabel = new JLabel("Coordenada Y:");
        panel.add(yLabel);

        yField = new JTextField();
        panel.add(yField);

        JButton llenoButton = new JButton("Dibujar Círculo Lleno");
        llenoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dibujarCirculo(true);
            }
        });
        panel.add(llenoButton);

        JButton vacioButton = new JButton("Dibujar Círculo Vacío");
        vacioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dibujarCirculo(false);
            }
        });
        panel.add(vacioButton);

        add(panel);
        setVisible(true);
    }

    private void dibujarCirculo(boolean lleno) {
        try {
            int radio = Integer.parseInt(radioField.getText());
            int x = Integer.parseInt(xField.getText());
            int y = Integer.parseInt(yField.getText());

            JPanel dibujoPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (lleno) {
                        g.setColor(Color.BLUE);
                        g.fillOval(x - radio, y - radio, radio * 2, radio * 2);
                    } else {
                        g.setColor(Color.RED);
                        g.drawOval(x - radio, y - radio, radio * 2, radio * 2);
                    }
                }
            };

            JFrame dibujoFrame = new JFrame();
            dibujoFrame.setTitle("Círculo");
            dibujoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dibujoFrame.setSize(400, 400);
            dibujoFrame.setLocationRelativeTo(null);
            dibujoFrame.add(dibujoPanel);
            dibujoFrame.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese números enteros válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Circulo();
            }
        });
    }
}
