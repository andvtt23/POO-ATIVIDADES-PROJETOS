import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame {
    
    private JTextField weightField;
    private JTextField heightField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public IMCCalculator() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel weightLabel = new JLabel("Peso (Kg):");
        weightLabel.setBounds(10, 20, 80, 25);
        add(weightLabel);

        weightField = new JTextField();
        weightField.setBounds(100, 20, 165, 25);
        add(weightField);

        JLabel heightLabel = new JLabel("Altura (Cm):");
        heightLabel.setBounds(10, 50, 80, 25);
        add(heightLabel);

        heightField = new JTextField();
        heightField.setBounds(100, 50, 165, 25);
        add(heightField);

        calculateButton = new JButton("Calcular IMC");
        calculateButton.setBounds(10, 80, 255, 25);
        add(calculateButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(10, 110, 255, 25);
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateIMC();
            }
        });
    }

    private void calculateIMC() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100; // Convertendo cm para m
            double imc = weight / (height * height);
            String classification = classifyIMC(imc);
            resultLabel.setText(String.format("IMC: %.2f - %s", imc, classification));
        } catch (NumberFormatException e) {
            resultLabel.setText("Por favor, insira valores válidos.");
        }
    }

    private String classifyIMC(double imc) {
        if (imc < 17) return "Muito abaixo do peso";
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 25) return "Peso normal";
        if (imc < 30) return "Acima do peso";
        if (imc < 35) return "Obesidade I";
        if (imc < 40) return "Obesidade II (severa)";
        return "Obesidade III (mórbida)";
    }

    public static void main(String[] args) {
        IMCCalculator app = new IMCCalculator();
        app.setVisible(true);
    }
}
