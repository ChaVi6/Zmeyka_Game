import javax.swing.*;

public class InsaneLevelWindow extends JFrame {

    public InsaneLevelWindow(){
        setTitle("Zmeyka");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(HardLevel.SIZE + 30,HardLevel.SIZE + 60);
        setLocation(500, 150);
        add(new InsaneLevel());
        setResizable(false);
        setVisible(true);
    }

}