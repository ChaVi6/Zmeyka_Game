import javax.swing.*;

public class MediumLevelWindow extends JFrame {

    public MediumLevelWindow(){
        setTitle("Zmeyka");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(GameField.SIZE + 30,GameField.SIZE + 60);
        setLocation(500, 150);
        add(new MediumLevel());
        setResizable(false);
        setVisible(true);
    }

}