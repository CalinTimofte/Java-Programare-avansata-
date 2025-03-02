package UAIC.Info.Programare.Avansata.lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)

    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        setLayout(new GridLayout(1, 4));

        //add all the buttons

        //configurare listeners
        saveBtn.addActionListener(this::save);
    }

    private void save(ActionEvent e){
        try{
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}
