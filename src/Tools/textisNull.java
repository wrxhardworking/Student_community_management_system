package Tools;

import javax.swing.*;

public class textisNull {
    public static boolean isNull(JTextField jTextField)
    {
        if(jTextField.getText().length()==0)
            return true;
            else return false;
    }
}
