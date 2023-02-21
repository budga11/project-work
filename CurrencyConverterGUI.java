import java.awt.event.*;
import javax.swing.*;

public class CurrencyConverterGUI   {

    static JTextField inputField;
    static JComboBox currencyOptions;
    static JLabel resultLabel;
    static JButton convertButton;

    public CurrencyConverterGUI() {
        JFrame currency = new JFrame("Currency Converter");
        currency.setSize(500, 500);
        currency.setLayout(null);

        inputField = new JTextField();
        inputField.setBounds(50, 50, 100, 30);

        currency.add(inputField);

        String[] currencyList = {"USD", "EUR", "GBP", "INR", "AUD"};
        currencyOptions = new JComboBox(currencyList);
        currencyOptions.setBounds(200, 50, 100, 30);
        currency.add(currencyOptions);

        convertButton = new JButton("Convert");
        convertButton.setBounds(350, 50, 100, 30);
        currency.add(convertButton);

        resultLabel = new JLabel();
        resultLabel.setBounds(200, 100, 100, 30);
        currency.add(resultLabel);

        currency.setVisible(true);

        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String input = inputField.getText();
                double inputAmount = Double.parseDouble(input);

                String selectedCurrency = (String) currencyOptions.getSelectedItem();

                double result = 0.0;
                if (selectedCurrency.equals("USD")) {
                    result = inputAmount * 1.0;
                } else if (selectedCurrency.equals("EUR")) {
                    result = inputAmount * 0.9;
                } else if (selectedCurrency.equals("GBP")) {
                    result = inputAmount * 0.8;
                } else if (selectedCurrency.equals("INR")) {
                    result = inputAmount * 75.0;
                } else if (selectedCurrency.equals("AUD")) {
                    result = inputAmount * 1.5;
                }
                String resultLabel1 = String.valueOf(result);

                resultLabel.setText(resultLabel1);
            }
        };
        convertButton.addActionListener(ac);
    }

    public static void main(String[] args) {
        CurrencyConverterGUI c=new CurrencyConverterGUI();

    }
}