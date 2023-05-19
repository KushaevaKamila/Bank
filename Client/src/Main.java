import gui.CardWindow;
import gui.LogWindow;
import gui.MainWindow;
import gui.RegWindow;

public class Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        RegWindow regWindow = new RegWindow();
        regWindow.setVisible(true);
        LogWindow logWindow = new LogWindow();
        logWindow.setVisible(true);
        CardWindow cardWindow = new CardWindow();
        cardWindow.setVisible(true);
    }
}
