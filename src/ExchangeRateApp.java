import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ExchangeRateApp extends Canvas {
    private JList exchangeListApp;
    private JPanel panel1;
    private JTextField enteredAmount;
    private JButton check;
    private JLabel Currency;
    private JLabel Amount;
    private JLabel Result;
    private JLabel CURRENCYLabel;
    private static JFrame jframe;
    List<Exchange> exchangeList = ReadXmlDomParser.getExchange();
    Exchange selectedCurrency = exchangeList.get(0);


    public ExchangeRateApp(JFrame frame) throws IOException {


        exchangeListApp.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Exchange exchange = (Exchange) exchangeListApp.getSelectedValue();
                    selectedCurrency = exchange;

                }
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (enteredAmount.getText().isEmpty()){

                        JOptionPane.showMessageDialog(null, "Amount is null.Please enter the amount !");

                    }
                    if (enteredAmount.getText().matches("[a-zA-Z]+")){
                        JOptionPane.showMessageDialog(null, "Amount must not contain letters. Please enter correct amount !");
                    }
                    Result.setText(selectedCurrency.convert(selectedCurrency, enteredAmount.getText()));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        });


    }

    public void createUIComponents() {

        ReadXmlDomParser readXmlDomParser = new ReadXmlDomParser();
        this.exchangeListApp = new JList(readXmlDomParser.getListModel());
        this.exchangeListApp.setCellRenderer(new DefaultListCellRenderer());
        this.exchangeListApp.setVisible(true);

    }

    public JPanel getPanel1() {
        return panel1;
    }
}

