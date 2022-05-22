import javax.swing.*;

public class EasyLevelWindow extends JFrame {

    public EasyLevelWindow(){
        setTitle("Zmeyka");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(GameField.SIZE + 30,GameField.SIZE + 60);
        setLocation(500, 150);
        add(new EasyLevel());
        setResizable(false);
        setVisible(true);
    }

}