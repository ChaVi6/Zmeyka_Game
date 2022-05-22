import javax.swing.*;

public class HardLevelWindow extends JFrame {

    public HardLevelWindow(){
        setTitle("Zmeyka");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(GameField.SIZE + 30,GameField.SIZE + 60);
        setLocation(500, 150);
        add(new HardLevel());
        setResizable(false);
        setVisible(true);
    }

}