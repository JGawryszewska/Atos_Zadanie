import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        JFrame jFrame1 = new JFrame("Currency Exchange Calculator");
        ExchangeRateApp app = new ExchangeRateApp(jFrame1);
        jFrame1.add(app);
        jFrame1.setContentPane(app.getPanel1());

        jFrame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame1.pack();
        jFrame1.setSize(800, 800);
        jFrame1.setVisible(true);


    }
}
