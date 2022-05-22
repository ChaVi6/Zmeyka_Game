import javax.swing.*;

public class HardLevelWindow extends JFrame {

    public HardLevelWindow(){
        setTitle("Zmeyka");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(MediumLevel.SIZE + 30,MediumLevel.SIZE + 60);
        setLocation(500, 150);
        add(new HardLevel());
        setResizable(false);
        setVisible(true);
    }

}