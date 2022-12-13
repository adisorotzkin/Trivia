import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.Random;

public class ProjectController
{
    myFile file = new myFile();
    String corrAns = "";
    int counter = 0;
    private String word;

    @FXML
    private RadioButton RB1;

    @FXML
    private RadioButton RB2;

    @FXML
    private RadioButton RB3;

    @FXML
    private RadioButton RB4;

    @FXML
    private ToggleGroup ans;

    @FXML
    private Label lblEnd;

    @FXML
    private Label lblQ;

    @FXML
    private Label lblU;

    @FXML
    void OKPressed(ActionEvent event)
    {
        if(((RadioButton)ans.getSelectedToggle()).getText().equals(corrAns))
        {
            counter = counter+10;
            lblU.setText("Right answer");
        }
        else
        {
            counter = counter-5;
            lblU.setText("Wrong answer");
        }
    }

    @FXML
    void endPressed(ActionEvent event)
    {
        lblEnd.setText("Finish Game. The number of points you have earned: "+counter);
    }

    @FXML
    void nextPressed(ActionEvent event)
    {
        file.cleanQst();
        file.cleanCorr();
        lblU.setText("");
        initialize();
    }

    public void initialize()
    {
        ArrayList <String> fileContent = new ArrayList<String>();
        int rand;
        Random r = new Random();
        fileContent = file.myReader();
        int num = file.randQst(fileContent);
        if(num == -1)
        {
            lblEnd.setText("Finish! The number of points you have earned:" + counter);
            return;
        }

        lblQ.setText(file.getIndexQst(num));
        corrAns = file.getIndexCorr(num);
        rand = r.nextInt(4)+1;
        if(rand==1)
        {
            RB1.setText(file.getIndexCorr(num));
            RB2.setText(fileContent.get(num*5+2));
            RB3.setText(fileContent.get(num*5+3));
            RB4.setText(fileContent.get(num*5+4));
        }
        if(rand==2)
        {
            RB2.setText(file.getIndexCorr(num));
            RB1.setText(fileContent.get(num*5+2));
            RB3.setText(fileContent.get(num*5+3));
            RB4.setText(fileContent.get(num*5+4));

        }
        if(rand==3)
        {
            RB3.setText(file.getIndexCorr(num));
            RB2.setText(fileContent.get(num*5+2));
            RB1.setText(fileContent.get(num*5+3));
            RB4.setText(fileContent.get(num*5+4));

        }
        if(rand==4)
        {
            RB4.setText(file.getIndexCorr(num));
            RB2.setText(fileContent.get(num*5+2));
            RB3.setText(fileContent.get(num*5+3));
            RB1.setText(fileContent.get(num*5+4));

        }
    }
}


